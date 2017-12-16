package clertonleal.com.weather.viewModel

import android.databinding.BaseObservable
import android.databinding.Bindable
import android.databinding.ObservableBoolean
import android.databinding.ObservableInt
import android.util.Log
import android.view.View
import clertonleal.com.weather.BR
import clertonleal.com.weather.model.City
import clertonleal.com.weather.model.Weather
import clertonleal.com.weather.picker.PickerInput
import clertonleal.com.weather.rest.CityRest
import clertonleal.com.weather.rest.WeatherRest
import clertonleal.com.weather.view.`interface`.HomeView
import io.reactivex.android.schedulers.AndroidSchedulers


class HomeViewModel(val view: HomeView,
                    private val cityRest: CityRest,
                    private val weatherRest: WeatherRest) : BaseObservable() {

    @Bindable
    var selectedCity: City? = City(district = "---", stateAcronym = "---")
    set(value) {
        field = value
        notifyPropertyChanged(BR.selectedCity)
    }

    @Bindable
    var selectedWeather: List<Weather> = arrayListOf()
    set(value) {
        field = value
        notifyPropertyChanged(BR.selectedWeather)
        if (field.isEmpty()) {
            weatherVisibility.set(View.GONE)
            emptyWeatherVisibility.set(View.VISIBLE)
        } else {
            weatherVisibility.set(View.VISIBLE)
            emptyWeatherVisibility.set(View.GONE)
        }

    }

    private var cities: List<City> = arrayListOf()
    var weather: List<Weather> = arrayListOf()
    val loadingVisibility = ObservableInt(View.VISIBLE)
    val weatherVisibility = ObservableInt(View.GONE)
    val emptyWeatherVisibility = ObservableInt(View.VISIBLE)

    fun loadCity() {
        cityRest.getCities()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    cities = it
                    loadingVisibility.set(View.GONE)
                    Log.e("", cities.size.toString())
                }
                        , { error ->
                    Log.e("", error.message)
                })
    }

    fun loadWeather() {
        weatherRest.getWeather()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    weather = it
                    loadingVisibility.set(View.GONE)
                    Log.e("", weather.size.toString())
                }
                        , { error ->
                    Log.e("", error.message)
                })
    }

    fun selectCity() {
        view.openSelectCities(cities)
    }

    fun selectWeather() {
        view.openSelectWeather(weather, selectedWeather)
    }

    fun openDatePicker(input: PickerInput) {
        view.openDatePicker(input)
    }
}
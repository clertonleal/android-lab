package clertonleal.com.weather.viewModel

import android.databinding.*
import android.util.Log
import android.view.View
import clertonleal.com.weather.BR
import clertonleal.com.weather.model.City
import clertonleal.com.weather.model.Weather
import clertonleal.com.weather.service.CityService
import clertonleal.com.weather.service.WeatherService
import clertonleal.com.weather.view.delegate.HomeView


class HomeViewModel(val view: HomeView,
                    private val cityService: CityService,
                    private val weatherService: WeatherService) : BaseObservable() {

    @Bindable
    var selectedCity: City? = City(district = "---", stateAcronym = "---")
    set(value) {
        field = value
        notifyPropertyChanged(BR.selectedCity)
    }

    @Bindable
    var selectedWeather: ArrayList<Weather> = arrayListOf()
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

    var cities: List<City> = arrayListOf()
    var weather: List<Weather> = arrayListOf()
    val loadingVisibility = ObservableInt(View.VISIBLE)
    val errorVisibility = ObservableInt(View.GONE)
    val weatherVisibility = ObservableInt(View.GONE)
    val emptyWeatherVisibility = ObservableInt(View.VISIBLE)
    val numberOfDays = ObservableField<String>()

    fun loadCity() {
        cityService.getCities()
                .subscribe({
                    cities = it
                    loadingVisibility.set(View.GONE)
                }, { error ->
                    Log.e(HomeViewModel::class.java.simpleName, error.message, error)
                    errorVisibility.set(View.VISIBLE)
                    loadingVisibility.set(View.GONE)
                })
    }

    fun loadWeather() {
        weatherService.getWeather()
                .subscribe({
                    weather = it
                    loadingVisibility.set(View.GONE)
                }, { error ->
                    Log.e(HomeViewModel::class.java.simpleName, error.message, error)
                    errorVisibility.set(View.VISIBLE)
                    loadingVisibility.set(View.GONE)
                })
    }

    fun selectCity() {
        view.openSelectCities(cities)
    }

    fun selectWeather() {
        view.openSelectWeather(weather, selectedWeather)
    }

    fun openResults() {
        view.openResult(selectedWeather, numberOfDays.get().toInt(), selectedCity!!)
    }

    fun retryFromError() {
        errorVisibility.set(View.GONE)
        loadingVisibility.set(View.VISIBLE)
        loadCity()
        loadWeather()
    }

}
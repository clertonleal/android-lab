package clertonleal.com.weather.viewModel

import android.databinding.ObservableInt
import android.util.Log
import android.view.View
import clertonleal.com.weather.model.City
import clertonleal.com.weather.model.Weather
import clertonleal.com.weather.model.WeatherData
import clertonleal.com.weather.service.WeatherDataService
import clertonleal.com.weather.util.ResultFilter
import java.util.*


class ResultViewModel(private val weather: ArrayList<Weather>,
                      private val days: Int,
                      private val city: City,
                      private val weatherDataService: WeatherDataService,
                      private val setResultInList: (ArrayList<Pair<WeatherData, WeatherData>>) -> Unit) {

    val loadingVisibility = ObservableInt(View.VISIBLE)
    val emptyVisibility = ObservableInt(View.GONE)
    val errorVisibility = ObservableInt(View.GONE)

    fun loadResults() {
        weatherDataService.getWeatherData(city.id, Calendar.getInstance().get(Calendar.YEAR))
                .subscribe({ weatherResults ->
                    val filteredResults = ResultFilter.filterWeatherResults(weatherResults, weather, days)
                    setResultInList(filteredResults)
                    setListVisibility(filteredResults)
                }, { error ->
                    showErrorView()
                    Log.e(ResultViewModel::class.java.simpleName, error.message, error)
                })
    }

    fun retryFromError() {
        errorVisibility.set(View.GONE)
        emptyVisibility.set(View.GONE)
        loadingVisibility.set(View.VISIBLE)
        loadResults()
    }

    private fun showErrorView() {
        errorVisibility.set(View.VISIBLE)
        loadingVisibility.set(View.GONE)
        emptyVisibility.set(View.GONE)
    }

    private fun setListVisibility(filteredResults: ArrayList<Pair<WeatherData, WeatherData>>) {
        loadingVisibility.set(View.GONE)
        errorVisibility.set(View.GONE)
        if (filteredResults.isEmpty()) {
            emptyVisibility.set(View.VISIBLE)
        }
    }

}
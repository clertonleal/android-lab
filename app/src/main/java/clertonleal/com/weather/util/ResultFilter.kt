package clertonleal.com.weather.util

import clertonleal.com.weather.model.Weather
import clertonleal.com.weather.model.WeatherData
import java.util.ArrayList


object ResultFilter {

    fun filterWeatherResults(results: List<WeatherData>?,
                                     weather: ArrayList<Weather>,
                                     numberOfDays: Int): ArrayList<Pair<WeatherData, WeatherData>> {
        val filteredResults : ArrayList<Pair<WeatherData, WeatherData>> = arrayListOf()

        results?.let {
            if (results.isNotEmpty()) {
                var currentNumberOfMatches = 0
                var initialData: WeatherData? = null

                for ((index, weatherData) in results.withIndex()) {
                    if (dataHasWeather(weatherData, weather)) {
                        currentNumberOfMatches += 1
                        if (initialData == null) {
                            initialData = weatherData
                        }
                    } else {
                        if (currentNumberOfMatches >= numberOfDays) {
                            filteredResults.add(Pair(initialData!!, results[index - 1]))
                        }

                        currentNumberOfMatches = 0
                        initialData = null
                    }
                }
            }
        }

        return filteredResults
    }

    private fun dataHasWeather(weatherData: WeatherData, weather: ArrayList<Weather>) : Boolean {
        return weather.any { it.name == weatherData.weather }
    }

}
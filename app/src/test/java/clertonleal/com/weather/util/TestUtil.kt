package clertonleal.com.weather.util

import android.util.Log
import clertonleal.com.weather.model.City
import clertonleal.com.weather.model.Weather
import clertonleal.com.weather.model.WeatherData
import clertonleal.com.weather.service.CityService
import clertonleal.com.weather.service.WeatherDataService
import clertonleal.com.weather.service.WeatherService
import clertonleal.com.weather.view.delegate.HomeView
import clertonleal.com.weather.viewModel.HomeViewModel
import clertonleal.com.weather.viewModel.ResultViewModel
import com.google.gson.reflect.TypeToken
import com.nhaarman.mockito_kotlin.any
import com.nhaarman.mockito_kotlin.doReturn
import com.nhaarman.mockito_kotlin.mock
import io.reactivex.Single
import java.io.IOException
import java.io.InputStream


object TestUtil {

    fun loadJSONFromRes(fileName: String): String? {
        val classloader = Thread.currentThread().contextClassLoader
        val input = classloader.getResourceAsStream(fileName)
        return loadJSONFromInputStream(input)
    }

    fun getMockCity() : City {
        return City("455821", "Porto Alegre", "Rio Grande do Sul", "RS", "Brazil")
    }

    fun getWeatherMock() : ArrayList<Weather> {
        return arrayListOf(Weather("003", "clear"), Weather("005", "cold"), Weather("027", "partly cloudy"))
    }

    fun getWeatherDataMock() : ArrayList<WeatherData> {
        val gson = GsonProvider.gson()
        val type = object : TypeToken<ArrayList<WeatherData>>() {}.type
        return gson.fromJson<ArrayList<WeatherData>>(TestUtil.loadJSONFromRes("455821.json"), type)
    }

    fun getResultViewModel() : ResultViewModel {
        val weatherDataService = getWeatherDataService()
        return ResultViewModel(getWeatherMock(), 15, getMockCity(), weatherDataService, {})
    }

    fun getHomeViewModel(view: HomeView) : HomeViewModel {
        val cityService = getCityService()
        val weatherRest = getWeatherService()
        return HomeViewModel(view, cityService, weatherRest)
    }

    private fun getWeatherDataService() : WeatherDataService {
        val gson = GsonProvider.gson()
        val type = object : TypeToken<List<WeatherData>>() {}.type
        val list = gson.fromJson<List<WeatherData>>(TestUtil.loadJSONFromRes("455821.json"), type)

        return mock {
            on {getWeatherData(any(), any())} doReturn Single.just(list)
        }
    }

    private fun getCityService() : CityService {
        val gson = GsonProvider.gson()
        val type = object : TypeToken<List<City>>() {}.type
        val cities = gson.fromJson<List<City>>(TestUtil.loadJSONFromRes("cities.json"), type)

        return mock {
            on {getCities()} doReturn Single.just(cities)
        }
    }

    private fun getWeatherService() : WeatherService {
        val gson = GsonProvider.gson()
        val type = object : TypeToken<List<Weather>>() {}.type
        val weather = gson.fromJson<List<Weather>>(TestUtil.loadJSONFromRes("weather.json"), type)

        return mock {
            on {getWeather()} doReturn Single.just(weather)
        }
    }

    private fun loadJSONFromInputStream(input: InputStream): String? {
        var json: String? = null
        try {
            val size = input.available()
            val buffer = ByteArray(size)
            input.read(buffer)
            input.close()
            json = String(buffer)
        } catch (ex: IOException) {
            Log.e("loadJSONFromAsset", ex.message, ex)
        }

        return json
    }

}
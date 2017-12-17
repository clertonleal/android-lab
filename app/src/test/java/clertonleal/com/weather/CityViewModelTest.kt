package clertonleal.com.weather

import android.view.View
import clertonleal.com.weather.model.City
import clertonleal.com.weather.model.Weather
import clertonleal.com.weather.service.CityService
import clertonleal.com.weather.service.WeatherService
import clertonleal.com.weather.util.FileLoader
import clertonleal.com.weather.util.GsonProvider
import clertonleal.com.weather.view.delegate.HomeView
import clertonleal.com.weather.viewModel.HomeViewModel
import com.google.gson.reflect.TypeToken
import io.reactivex.Single
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.*

class CityViewModelTest {

    private var view: HomeView = mock(HomeView::class.java)
    private var homeViewModel: HomeViewModel = getHomeViewModel(view)

    @Before
    fun beforeTest() {
        view = mock(HomeView::class.java)
        homeViewModel = getHomeViewModel(view)
    }

    @Test
    fun onStartTheInitialVisibilityShouldBeOk() {
        assertEquals(homeViewModel.loadingVisibility.get(), View.VISIBLE)
        assertEquals(homeViewModel.errorVisibility.get(), View.GONE)
        assertEquals(homeViewModel.weatherVisibility.get(), View.GONE)
        assertEquals(homeViewModel.emptyWeatherVisibility.get(), View.VISIBLE)
    }

    @Test
    fun onLoadCityLoadingShouldBeGone() {
        homeViewModel.loadCity()
        assertEquals(homeViewModel.loadingVisibility.get(), View.GONE)
    }

    @Test
    fun onLoadCityListShouldBeFilled() {
        homeViewModel.loadCity()
        assertTrue(homeViewModel.cities.isNotEmpty())
    }

    @Test
    fun onLoadWeatherListShouldBeFilled() {
        homeViewModel.loadWeather()
        assertTrue(homeViewModel.weather.isNotEmpty())
    }

    @Test
    fun onClickInSearchResultShouldBeOpened() {
        homeViewModel.openResults()
        verify(view).openResult(any(), any(), any())
    }

    @Test
    fun onClickInCityScreenShouldBeOpened() {
        homeViewModel.selectCity()
        verify(view).openSelectCities(any())
    }

    @Test
    fun onClickInWeatherScreenShouldBeOpened() {
        homeViewModel.selectWeather()
        verify(view).openSelectWeather(any(), any())
    }

    private fun getHomeViewModel(view: HomeView) : HomeViewModel {
        val cityRest = getCityRest()
        val weatherRest = getWeatherRest()
        return HomeViewModel(view, cityRest, weatherRest)
    }

    private fun getCityRest() : CityService {
        val gson = GsonProvider.gson()
        val type = object : TypeToken<List<City>>() {}.type
        val cityRest = mock(CityService::class.java)
        val cities = gson.fromJson<List<City>>(FileLoader.loadJSONFromRes("cities.json"), type)
        `when`(cityRest.getCities()).thenReturn(Single.just(cities))
        return cityRest
    }

    private fun getWeatherRest() : WeatherService {
        val gson = GsonProvider.gson()
        val type = object : TypeToken<List<Weather>>() {}.type
        val weatherRest = mock(WeatherService::class.java)
        val weather = gson.fromJson<List<Weather>>(FileLoader.loadJSONFromRes("weather.json"), type)
        `when`(weatherRest.getWeather()).thenReturn(Single.just(weather))
        return weatherRest
    }
}

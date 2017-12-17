package clertonleal.com.weather

import android.view.View
import clertonleal.com.weather.util.TestUtil
import clertonleal.com.weather.view.delegate.HomeView
import clertonleal.com.weather.viewModel.HomeViewModel
import com.nhaarman.mockito_kotlin.any
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test

class HomeViewModelTest {

    private var view: HomeView = mock()
    private var homeViewModel: HomeViewModel = TestUtil.getHomeViewModel(view)

    @Before
    fun beforeTest() {
        view = mock()
        homeViewModel = TestUtil.getHomeViewModel(view)
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
        homeViewModel.numberOfDays.set("0")
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
}

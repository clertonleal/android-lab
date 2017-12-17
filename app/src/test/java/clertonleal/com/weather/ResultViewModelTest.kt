package clertonleal.com.weather

import android.view.View
import clertonleal.com.weather.model.City
import clertonleal.com.weather.model.Weather
import clertonleal.com.weather.service.CityService
import clertonleal.com.weather.service.WeatherService
import clertonleal.com.weather.util.TestUtil
import clertonleal.com.weather.util.GsonProvider
import clertonleal.com.weather.util.ResultFilter
import clertonleal.com.weather.view.delegate.HomeView
import clertonleal.com.weather.viewModel.HomeViewModel
import clertonleal.com.weather.viewModel.ResultViewModel
import com.google.gson.reflect.TypeToken
import com.nhaarman.mockito_kotlin.any
import com.nhaarman.mockito_kotlin.doReturn
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import io.reactivex.Single
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class ResultViewModelTest {

    private var resultViewModel: ResultViewModel = TestUtil.getResultViewModel()

    @Before
    fun beforeTest() {
        resultViewModel = TestUtil.getResultViewModel()
    }

    @Test
    fun onStartTheInitialVisibilityShouldBeOk() {
        Assert.assertEquals(resultViewModel.loadingVisibility.get(), View.VISIBLE)
        Assert.assertEquals(resultViewModel.errorVisibility.get(), View.GONE)
        Assert.assertEquals(resultViewModel.emptyVisibility.get(), View.GONE)
    }

    @Test
    fun onLoadCityLoadingShouldBeGone() {
        resultViewModel.loadResults()
        Assert.assertEquals(resultViewModel.loadingVisibility.get(), View.GONE)
    }

    @Test
    fun resultFilterShouldReturn3() {
        val result = ResultFilter.filterWeatherResults(TestUtil.getWeatherDataMock(), TestUtil.getWeatherMock(), 15)
        Assert.assertEquals(result.size, 3)
    }

}
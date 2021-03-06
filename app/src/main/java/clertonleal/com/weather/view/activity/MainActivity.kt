package clertonleal.com.weather.view.activity

import android.app.Activity
import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import clertonleal.com.weather.R
import clertonleal.com.weather.WeatherApplication
import clertonleal.com.weather.adapter.WeatherHomeAdapter
import clertonleal.com.weather.databinding.ActivityMainBinding
import clertonleal.com.weather.model.City
import clertonleal.com.weather.model.Weather
import clertonleal.com.weather.service.CityService
import clertonleal.com.weather.service.WeatherService
import clertonleal.com.weather.util.*
import clertonleal.com.weather.view.delegate.HomeView
import clertonleal.com.weather.viewModel.HomeViewModel
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject
import kotlin.collections.ArrayList


class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var cityService: CityService

    @Inject
    lateinit var weatherService: WeatherService

    private var viewModel: HomeViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WeatherApplication.component?.inject(this)
        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        viewModel = HomeViewModel(view, cityService, weatherService)
        binding.viewModel = viewModel
        viewModel?.loadCity()
        viewModel?.loadWeather()
        weatherList.adapter = WeatherHomeAdapter(viewModel?.selectedWeather as ArrayList<Weather>, {
            viewModel?.selectWeather()
        })
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == SEARCH_CITY_REQUEST && resultCode == Activity.RESULT_OK) {
            viewModel?.selectedCity = data?.getParcelableExtra(SELECTED_CITY)
        } else if (requestCode == SEARCH_WEATHER_REQUEST && resultCode == Activity.RESULT_OK) {
            val selected: ArrayList<Weather>? = data?.getParcelableArrayListExtra(SELECTED_WEATHER)
            selected?.let {
                viewModel?.selectedWeather = it
            }
        }
    }

    val view: HomeView = object : HomeView {

        override fun openResult(weather: ArrayList<Weather>, days: Int, city: City) {
            ResultActivity.start(this@MainActivity, weather, days, city)
        }

        override fun openSelectWeather(weather: List<Weather>, selectedWeather: List<Weather>) {
            SelectWeatherActivity.selectWeather(this@MainActivity, weather, selectedWeather)
        }

        override fun openSelectCities(cities: List<City>) {
            SelectCitiesActivity.selectCity(this@MainActivity, cities)
        }

    }
}

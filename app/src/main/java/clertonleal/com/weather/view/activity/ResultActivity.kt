package clertonleal.com.weather.view.activity

import android.app.Activity
import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import clertonleal.com.weather.R
import clertonleal.com.weather.WeatherApplication
import clertonleal.com.weather.adapter.ResultsAdapter
import clertonleal.com.weather.databinding.ActivityResultBinding
import clertonleal.com.weather.model.City
import clertonleal.com.weather.model.Weather
import clertonleal.com.weather.rest.WeatherDataRest
import clertonleal.com.weather.util.NUMBER_OF_DAYS
import clertonleal.com.weather.util.SELECTED_CITY
import clertonleal.com.weather.util.SELECTED_WEATHER
import clertonleal.com.weather.viewModel.ResultViewModel
import kotlinx.android.synthetic.main.activity_search.*
import javax.inject.Inject

class ResultActivity : AppCompatActivity() {

    @Inject
    lateinit var weatherDataRest: WeatherDataRest

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityResultBinding>(this, R.layout.activity_result)
        WeatherApplication.component?.inject(this)

        val weather = intent.getParcelableArrayListExtra<Weather>(SELECTED_WEATHER)
        val numberOfDays = intent.getIntExtra(NUMBER_OF_DAYS, 0)
        val city = intent.getParcelableExtra<City>(SELECTED_CITY)

        val viewModel = ResultViewModel(weather, numberOfDays, city, weatherDataRest, {
            recyclerView.adapter = ResultsAdapter(it)
        })

        binding.viewModel = viewModel
        viewModel.loadResults()
    }

    companion object {
        fun start(activity: Activity, weather: ArrayList<Weather>, days: Int, city: City) {
            val intent = Intent(activity, ResultActivity::class.java)
            intent.putParcelableArrayListExtra(SELECTED_WEATHER, weather)
            intent.putExtra(NUMBER_OF_DAYS, days)
            intent.putExtra(SELECTED_CITY, city)
            activity.startActivity(intent)
        }
    }
}

package clertonleal.com.weather.view.activity

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import clertonleal.com.weather.R
import clertonleal.com.weather.adapter.WeatherAdapter
import clertonleal.com.weather.model.Weather
import clertonleal.com.weather.util.SEARCH_WEATHER_REQUEST
import clertonleal.com.weather.util.SELECTED_WEATHER
import clertonleal.com.weather.util.WEATHER
import kotlinx.android.synthetic.main.activity_search.*
import java.util.*
import kotlin.collections.ArrayList

class SelectWeatherActivity : AppCompatActivity() {

    private var adapter: WeatherAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        val weather: ArrayList<Weather> = intent.extras.getParcelableArrayList(WEATHER)
        val selectedWeather: ArrayList<Weather> = intent.extras.getParcelableArrayList(SELECTED_WEATHER)

        adapter = WeatherAdapter(weather, selectedWeather)
        recyclerView.adapter = adapter
    }

    override fun onBackPressed() {
        val intent = Intent()
        intent.putParcelableArrayListExtra(SELECTED_WEATHER, adapter?.selectedWeather as ArrayList<Weather>)
        setResult(Activity.RESULT_OK, intent)
        finish()
        super.onBackPressed()
    }

    companion object {
        fun selectWeather(activity: Activity, weather: List<Weather>, selectedWeather: List<Weather>) {
            val intent = Intent(activity, SelectWeatherActivity::class.java)
            intent.putParcelableArrayListExtra(WEATHER, weather as ArrayList<Weather>)
            intent.putParcelableArrayListExtra(SELECTED_WEATHER, selectedWeather as ArrayList<Weather>)
            activity.startActivityForResult(intent, SEARCH_WEATHER_REQUEST)
        }
    }
}

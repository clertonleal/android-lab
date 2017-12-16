package clertonleal.com.weather.view

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import clertonleal.com.weather.R
import clertonleal.com.weather.WeatherApplication
import clertonleal.com.weather.rest.CityRest
import clertonleal.com.weather.rest.WeatherDataRest
import clertonleal.com.weather.rest.WeatherRest
import io.reactivex.android.schedulers.AndroidSchedulers
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject


class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var cityRest: CityRest

    @Inject
    lateinit var weatherRest: WeatherRest

    @Inject
    lateinit var weatherDataRest: WeatherDataRest

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WeatherApplication.component?.inject(this)
        setContentView(R.layout.activity_main)

//        cityRest.getCities()
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe({ cities ->
//                    stateText.text = cities.size.toString()
//                    Log.e("", cities.size.toString())
//                }
//                        , { error ->
//                    Log.e("", error.message)
//                })
//
//        weatherRest.getWeather()
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe({ weather ->
//                    stateText.text = weather.size.toString()
//                    Log.e("", weather.size.toString())
//                }
//                        , { error ->
//                    Log.e("", error.message)
//                })
//
//        weatherDataRest.getWeatherData("455821", 2017)
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe({ cities ->
//                    stateText.text = cities.size.toString()
//                    Log.e("", cities.size.toString())
//                }
//                        , { error ->
//                    Log.e("", error.message)
//                })
    }
}

package clertonleal.com.weather.view.activity

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import clertonleal.com.weather.R
import clertonleal.com.weather.adapter.CityAdapter
import clertonleal.com.weather.model.City
import clertonleal.com.weather.util.CITIES
import clertonleal.com.weather.util.SEARCH_CITY_REQUEST
import clertonleal.com.weather.util.SELECTED_CITY
import kotlinx.android.synthetic.main.activity_search.*
import java.util.ArrayList

class SelectCitiesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        val cities: List<City> = intent.extras.getParcelableArrayList(CITIES)
        recyclerView.adapter = CityAdapter(cities, {
            val intent = Intent()
            intent.putExtra(SELECTED_CITY, it)
            setResult(Activity.RESULT_OK, intent)
            finish()
        })

    }

    companion object {
        fun selectCity(activity: Activity, cities: List<City>) {
            val intent = Intent(activity, SelectCitiesActivity::class.java)
            intent.putParcelableArrayListExtra(CITIES, cities as ArrayList<City>)
            activity.startActivityForResult(intent, SEARCH_CITY_REQUEST)
        }
    }
}

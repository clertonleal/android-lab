package clertonleal.com.weather.view.activity.page

import android.support.test.espresso.Espresso
import android.support.test.espresso.action.ViewActions
import android.support.test.espresso.contrib.RecyclerViewActions
import android.support.test.espresso.matcher.ViewMatchers
import android.support.v7.widget.RecyclerView
import clertonleal.com.weather.R
import org.hamcrest.Matchers

class CityPage {

    fun selectFirstCity() : HomePage {
        val recyclerView = Espresso.onView(Matchers.allOf(ViewMatchers.withId(R.id.recyclerView)))
        recyclerView.perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, ViewActions.click()))
        return HomePage()
    }

}
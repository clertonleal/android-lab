package clertonleal.com.weather.view.activity.page

import android.support.test.espresso.Espresso
import android.support.test.espresso.action.ViewActions
import android.support.test.espresso.contrib.RecyclerViewActions
import android.support.test.espresso.matcher.ViewMatchers
import android.support.v7.widget.RecyclerView
import clertonleal.com.weather.R
import org.hamcrest.Matchers

class WeatherPage {

    fun selectWeather() : WeatherPage {
        val recyclerView2 = Espresso.onView(Matchers.allOf(ViewMatchers.withId(R.id.recyclerView)))
        recyclerView2.perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(2, ViewActions.click()))

        val recyclerView3 = Espresso.onView(Matchers.allOf(ViewMatchers.withId(R.id.recyclerView)))
        recyclerView3.perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(4, ViewActions.click()))

        val recyclerView4 = Espresso.onView(Matchers.allOf(ViewMatchers.withId(R.id.recyclerView)))
        recyclerView4.perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(26, ViewActions.click()))
        return this
    }

    fun clickInSelect() : HomePage {
        val actionMenuItemView = Espresso.onView(Matchers.allOf(ViewMatchers.withId(R.id.menu_main_setting),
                ViewMatchers.withText(R.string.select), ViewMatchers.isDisplayed()))
        actionMenuItemView.perform(ViewActions.click())
        return HomePage()
    }

}
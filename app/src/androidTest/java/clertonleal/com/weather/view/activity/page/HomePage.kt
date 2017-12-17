package clertonleal.com.weather.view.activity.page

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.matcher.ViewMatchers.isDisplayed
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.view.View
import clertonleal.com.weather.R
import org.hamcrest.Matchers.allOf


class HomePage {

    fun clickToSelectCity() : CityPage {
        val appCompatTextView = onView(allOf<View>(withId(R.id.stateText), isDisplayed()))
        appCompatTextView.perform(click())
        return CityPage()
    }

    fun type15Days() : HomePage {
        val appCompatEditText = onView(allOf(withId(R.id.fromText), isDisplayed()))
        appCompatEditText.perform(ViewActions.replaceText("15"), ViewActions.closeSoftKeyboard())
        return this
    }

    fun clickToSelectWeather(): WeatherPage {
        val appCompatTextView2 = onView(allOf(withId(R.id.weatherSelected), isDisplayed()))
        appCompatTextView2.perform(click())
        return WeatherPage()
    }

    fun clickInSearch() : ResultPage {
        val floatingActionButton = onView(allOf(withId(R.id.searchButton), isDisplayed()))
        floatingActionButton.perform(click())
        return ResultPage()
    }

}
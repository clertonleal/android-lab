package clertonleal.com.weather.view.activity.page

import android.support.test.espresso.Espresso
import android.support.test.espresso.assertion.ViewAssertions
import android.support.test.espresso.matcher.ViewMatchers
import clertonleal.com.weather.R
import org.hamcrest.Matchers

class ResultPage {

    fun checkResultTitle() : ResultPage {
        val textView = Espresso.onView(Matchers.allOf(ViewMatchers.withText(R.string.results),
                        ViewMatchers.isDisplayed()))
        textView.check(ViewAssertions.matches(ViewMatchers.withText(R.string.results)))
        return this
    }

    fun checkList() : ResultPage {
        val recyclerView5 = Espresso.onView(Matchers.allOf(ViewMatchers.withId(R.id.recyclerView),
                ViewMatchers.isDisplayed()))
        recyclerView5.check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        return this
    }

}
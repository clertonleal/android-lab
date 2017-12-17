package clertonleal.com.weather.view.activity


import android.support.test.filters.LargeTest
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import clertonleal.com.weather.view.activity.page.HomePage
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @Rule
    @JvmField
    var mActivityTestRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun mainActivityTest() {
        HomePage()
                .clickToSelectCity()
                .selectFirstCity()
                .type15Days()
                .clickToSelectWeather()
                .selectWeather()
                .clickInSelect()
                .clickInSearch()
                .checkResultTitle()
                .checkList()
    }

}

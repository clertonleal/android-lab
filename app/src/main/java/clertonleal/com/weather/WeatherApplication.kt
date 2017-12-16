package clertonleal.com.weather

import android.app.Application
import clertonleal.com.weather.di.DaggerWeatherComponent
import clertonleal.com.weather.di.WeatherComponent
import clertonleal.com.weather.di.WeatherModule


class WeatherApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        component = createComponent()
    }

    private fun createComponent(): WeatherComponent {
        return DaggerWeatherComponent
                .builder()
                .weatherModule(WeatherModule())
                .build()
    }

    companion object {
        var component: WeatherComponent? = null
    }

}
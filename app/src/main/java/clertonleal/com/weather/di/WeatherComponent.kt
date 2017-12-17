package clertonleal.com.weather.di

import clertonleal.com.weather.view.activity.MainActivity
import clertonleal.com.weather.view.activity.ResultActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(WeatherModule::class))
interface WeatherComponent {

    fun inject(mainActivity: MainActivity)
    fun inject(resultActivity: ResultActivity)

}
package clertonleal.com.weather.di

import clertonleal.com.weather.view.activity.MainActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(WeatherModule::class))
interface WeatherComponent {

    fun inject(mainActivity: MainActivity)

}
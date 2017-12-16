package clertonleal.com.weather.di

import clertonleal.com.weather.rest.CityRest
import clertonleal.com.weather.rest.WeatherDataRest
import clertonleal.com.weather.rest.WeatherRest
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class WeatherModule {

    @Provides
    @Singleton
    internal fun provideRestAdapter(): Retrofit {
        return Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(GsonBuilder().setDateFormat("yyyy-MM-dd").create()))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
                .baseUrl("http://10.0.2.2:8882/")
                .build()
    }

    @Provides
    internal fun provideCityRest(restAdapter: Retrofit): CityRest {
        return restAdapter.create(CityRest::class.java)
    }

    @Provides
    internal fun provideWeatherRest(restAdapter: Retrofit): WeatherRest {
        return restAdapter.create(WeatherRest::class.java)
    }

    @Provides
    internal fun provideWeatherDataRest(restAdapter: Retrofit): WeatherDataRest {
        return restAdapter.create(WeatherDataRest::class.java)
    }

}
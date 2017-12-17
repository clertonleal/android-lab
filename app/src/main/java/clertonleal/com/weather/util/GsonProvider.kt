package clertonleal.com.weather.util

import com.google.gson.GsonBuilder


object GsonProvider {

    fun gson() = GsonBuilder().setDateFormat("yyyy-MM-dd").create()

}
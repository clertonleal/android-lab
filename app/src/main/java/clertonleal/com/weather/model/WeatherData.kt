package clertonleal.com.weather.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import java.util.*

data class WeatherData(@SerializedName("date") val date: Date,
                       @SerializedName("temperature") val temperature: Temperature,
                       @SerializedName("weather") val weather: String,
                       @SerializedName("woeid") val cityId: String) : Parcelable {

    constructor(parcel: Parcel) : this(
            Date(parcel.readLong()),
            parcel.readParcelable(Temperature::class.java.classLoader),
            parcel.readString(),
            parcel.readString())

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeLong(date.time)
        parcel.writeParcelable(temperature, flags)
        parcel.writeString(weather)
        parcel.writeString(cityId)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<WeatherData> {
        override fun createFromParcel(parcel: Parcel): WeatherData {
            return WeatherData(parcel)
        }

        override fun newArray(size: Int): Array<WeatherData?> {
            return arrayOfNulls(size)
        }
    }
}
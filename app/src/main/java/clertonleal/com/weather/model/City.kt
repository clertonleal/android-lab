package clertonleal.com.weather.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class City(@SerializedName("woeid") val id: String = "",
                @SerializedName("district") val district: String,
                @SerializedName("province") val province: String = "",
                @SerializedName("state_acronym") val stateAcronym: String,
                @SerializedName("country") val country: String = "") : Parcelable {

    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString())

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(id)
        parcel.writeString(district)
        parcel.writeString(province)
        parcel.writeString(stateAcronym)
        parcel.writeString(country)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<City> {
        override fun createFromParcel(parcel: Parcel): City {
            return City(parcel)
        }

        override fun newArray(size: Int): Array<City?> {
            return arrayOfNulls(size)
        }
    }
}
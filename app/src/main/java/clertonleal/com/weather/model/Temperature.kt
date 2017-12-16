package clertonleal.com.weather.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class Temperature(@SerializedName("max") val max: Int,
                       @SerializedName("min") val min: Int,
                       @SerializedName("unit") val unit: String) : Parcelable {

    constructor(parcel: Parcel) : this(
            parcel.readInt(),
            parcel.readInt(),
            parcel.readString())

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(max)
        parcel.writeInt(min)
        parcel.writeString(unit)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Temperature> {
        override fun createFromParcel(parcel: Parcel): Temperature {
            return Temperature(parcel)
        }

        override fun newArray(size: Int): Array<Temperature?> {
            return arrayOfNulls(size)
        }
    }
}
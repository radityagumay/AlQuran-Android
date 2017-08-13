package android.alquran.radityalabs.net.alquran.data.network.response

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by radityagumay on 8/13/17.
 */
data class BaseResponse(
        @SerializedName("code")
        @Expose
        val code: Int,
        @SerializedName("status")
        @Expose
        val status: String
) : Parcelable {
    constructor(source: Parcel) : this(
            source.readInt(),
            source.readString()
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeInt(code)
        writeString(status)
    }

    companion object {
        @JvmField val CREATOR: Parcelable.Creator<BaseResponse> = object : Parcelable.Creator<BaseResponse> {
            override fun createFromParcel(source: Parcel): BaseResponse = BaseResponse(source)
            override fun newArray(size: Int): Array<BaseResponse?> = arrayOfNulls(size)
        }
    }
}
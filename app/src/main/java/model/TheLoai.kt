package model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class TheLoai {
    @SerializedName("Idtheloai")
    @Expose
    var idtheloai: String? = null
    @SerializedName("Idkeychude")
    @Expose
    var idkeychude: String? = null
    @SerializedName("Tentheloai")
    @Expose
    var tentheloai: String? = null
    @SerializedName("Hinhtheloai")
    @Expose
    var hinhtheloai: String? = null

}
package model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class QuangCao {
    @SerializedName("Idquangcao")
    @Expose
    var idquangcao: String? = null
    @SerializedName("Idhinhanh")
    @Expose
    var idhinhanh: String? = null
    @SerializedName("Idnoidung")
    @Expose
    var idnoidung: String? = null
    @SerializedName("Idbaihat")
    @Expose
    var idbaihat: String? = null
    @SerializedName("Tenbaihat")
    @Expose
    var tenbaihat: String? = null
    @SerializedName("Hinhbaihat")
    @Expose
    var hinhbaihat: String? = null

}
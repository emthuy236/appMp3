package model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class AlBum {
    @SerializedName("Idabum")
    @Expose
    var idabum: String? = null
    @SerializedName("Tenabum")
    @Expose
    var tenabum: String? = null
    @SerializedName("Tencasiabum")
    @Expose
    var tencasiabum: String? = null
    @SerializedName("Hinhabum")
    @Expose
    var hinhabum: String? = null

}
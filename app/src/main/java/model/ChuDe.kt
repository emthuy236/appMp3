package model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class ChuDe {
    @SerializedName("Idchude")
    @Expose
    var idchude: String? = null
    @SerializedName("Tenchude")
    @Expose
    var tenchude: String? = null
    @SerializedName("Hinhchude")
    @Expose
    var hinhchude: String? = null

}
package model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Playlistnew {
    @SerializedName("Idplaylist")
    @Expose
    var idplaylist: String? = null
    @SerializedName("Ten")
    @Expose
    var ten: String? = null
    @SerializedName("Hinh")
    @Expose
    var hinh: String? = null
    @SerializedName("Icon")
    @Expose
    var icon: String? = null

}
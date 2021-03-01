package model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class ChudevaTheloaitrongngay {
    @SerializedName("TheLoai")
    @Expose
    var theLoai: List<TheLoai>? = null
    @SerializedName("ChuDe")
    @Expose
    var chuDe: List<ChuDe>? = null

}
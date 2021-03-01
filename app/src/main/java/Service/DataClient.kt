package Service

import model.AlBum
import model.ChudevaTheloaitrongngay
import model.Playlistnew
import model.QuangCao
import retrofit2.http.GET

interface DataClient {
    @GET("songbannel.php")
    fun Getdata():retrofit2.Call<List<QuangCao>>

    @GET("playlistforcurrentday.php")
    fun Getplatlist():retrofit2.Call<List<Playlistnew>>

    @GET("chudevatheloaitrongngay.php")
    fun Getdatachuvaloai():retrofit2.Call<ChudevaTheloaitrongngay>

    @GET("abumhost.php")
    fun Getdataalbum():retrofit2.Call<List<AlBum>>
}
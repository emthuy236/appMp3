package Service

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.Protocol
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.*
import java.util.concurrent.TimeUnit

class APIRetrofitClient {
    companion object{
        private var retrofit:Retrofit? = null
        fun getClient( base_url:String):Retrofit{
            var build:OkHttpClient = OkHttpClient.Builder()
                .writeTimeout(5000,TimeUnit.MILLISECONDS)
                .readTimeout(5000,TimeUnit.MILLISECONDS)
                .connectTimeout(10000,TimeUnit.MILLISECONDS)
                .retryOnConnectionFailure(true)
                .protocols(Arrays.asList(Protocol.HTTP_1_1))
                .build()
            var gson:Gson = GsonBuilder().setLenient().create()
          retrofit = Retrofit.Builder()
              .baseUrl(base_url)
              .client(build)
              .addConverterFactory(GsonConverterFactory.create(gson))
              .build()
            return retrofit!!
        }
    }
}
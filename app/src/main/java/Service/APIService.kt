package Service

import retrofit2.create

class APIService {
    companion object{
         var baseurl:String = "https://emthuy23.000webhostapp.com/Server/"
        fun getData():DataClient{
            return APIRetrofitClient.getClient(baseurl).create()
        }
    }
}
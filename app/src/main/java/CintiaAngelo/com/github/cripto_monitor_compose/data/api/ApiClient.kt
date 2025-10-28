package CintiaAngelo.com.github.cripto_monitor_compose.data.api

import CintiaAngelo.com.github.cripto_monitor_compose.data.model.CryptoApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {
    private const val BASE_URL = "https://api.coingecko.com/api/v3/"

    val cryptoApi: CryptoApi by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CryptoApi::class.java)
    }
}
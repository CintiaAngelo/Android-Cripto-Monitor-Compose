package CintiaAngelo.com.github.cripto_monitor_compose.data.model

import com.google.gson.annotations.SerializedName

data class CryptoDetails(
    @SerializedName("id") val id: String,
    @SerializedName("symbol") val symbol: String,
    @SerializedName("name") val name: String,
    @SerializedName("description") val description: Map<String, String>,
    @SerializedName("links") val links: Map<String, Any>,
    @SerializedName("market_data") val marketData: MarketData
)

data class MarketData(
    @SerializedName("current_price") val currentPrice: Map<String, Double>,
    @SerializedName("price_change_percentage_24h") val priceChangePercentage24h: Double,
    @SerializedName("market_cap") val marketCap: Map<String, Double>,
    @SerializedName("total_volume") val totalVolume: Map<String, Double>,
    @SerializedName("high_24h") val high24h: Map<String, Double>,
    @SerializedName("low_24h") val low24h: Map<String, Double>
)
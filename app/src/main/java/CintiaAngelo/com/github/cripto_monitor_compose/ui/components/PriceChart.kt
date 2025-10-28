package CintiaAngelo.com.github.cripto_monitor_compose.ui.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.dp

@Composable
fun PriceChart(
    prices: List<Double>,
    modifier: Modifier = Modifier
) {
    if (prices.size < 2) return

    val maxPrice = prices.maxOrNull() ?: 0.0
    val minPrice = prices.minOrNull() ?: 0.0
    val priceRange = maxPrice - minPrice

    Canvas(
        modifier = modifier
            .fillMaxWidth()
            .height(120.dp)
    ) {
        val canvasWidth = size.width
        val canvasHeight = size.height

        val points = prices.mapIndexed { index, price ->
            val x = (index.toFloat() / (prices.size - 1)) * canvasWidth
            val y = canvasHeight - (((price - minPrice) / priceRange) * canvasHeight).toFloat()
            Offset(x, y)
        }

        // Draw chart line
        drawPath(
            path = androidx.compose.ui.graphics.Path().apply {
                points.forEachIndexed { index, point ->
                    if (index == 0) moveTo(point.x, point.y)
                    else lineTo(point.x, point.y)
                }
            },
            color = if (prices.last() >= prices.first()) Color.Green else Color.Red,
            style = Stroke(width = 3f)
        )

        // Draw area under curve
        drawPath(
            path = androidx.compose.ui.graphics.Path().apply {
                points.forEachIndexed { index, point ->
                    if (index == 0) moveTo(point.x, point.y)
                    else lineTo(point.x, point.y)
                }
                lineTo(canvasWidth, canvasHeight)
                lineTo(0f, canvasHeight)
                close()
            },
            color = if (prices.last() >= prices.first())
                Color.Green.copy(alpha = 0.3f)
            else
                Color.Red.copy(alpha = 0.3f)
        )
    }
}
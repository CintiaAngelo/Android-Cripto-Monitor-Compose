package CintiaAngelo.com.github.cripto_monitor_compose.ui.components

import CintiaAngelo.com.github.cripto_monitor_compose.data.model.Crypto
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage

@Composable
fun CryptoItem(
    crypto: Crypto,
    onItemClick: (String) -> Unit,
    onFavoriteClick: (Crypto) -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
        onClick = { onItemClick(crypto.id) },
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Imagem
            AsyncImage(
                model = crypto.image,
                contentDescription = "${crypto.name} logo",
                modifier = Modifier.size(40.dp)
            )

            // Informações
            Column(
                modifier = Modifier.weight(1f).padding(horizontal = 12.dp),
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = crypto.name,
                    style = MaterialTheme.typography.bodyLarge,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = crypto.symbol.uppercase(),
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
                Text(
                    text = "$ ${"%.2f".format(crypto.currentPrice)}", // CORRIGIDO
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.Medium
                )
            }

            // Variação e Favorito
            Column(
                horizontalAlignment = Alignment.End
            ) {
                Text(
                    text = "${"%.2f".format(crypto.priceChangePercentage24h)}%",
                    style = MaterialTheme.typography.bodyMedium,
                    color = if (crypto.priceChangePercentage24h >= 0) {
                        MaterialTheme.colorScheme.primary
                    } else {
                        MaterialTheme.colorScheme.error
                    },
                    fontWeight = FontWeight.Medium
                )

                Spacer(modifier = Modifier.height(4.dp))

                IconButton(
                    onClick = { onFavoriteClick(crypto) },
                    modifier = Modifier.size(24.dp)
                ) {
                    Icon(
                        imageVector = if (crypto.isFavorite) {
                            Icons.Filled.Favorite
                        } else {
                            Icons.Filled.FavoriteBorder
                        },
                        contentDescription = "Favorito",
                        tint = MaterialTheme.colorScheme.primary
                    )
                }
            }
        }
    }
}
package com.example.ludoon.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.ludoon.R
import com.example.ludoon.models.Feed
import com.example.ludoon.ui.theme.Purple40
import com.example.ludoon.ui.theme.spacingSmall

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
// ... (outros imports)

@Composable
fun FeedItem(feed: Feed) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(spacingSmall)
    ) {
        // A Box permite sobrepor a imagem e os textos
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(350.dp) // Defina a altura da sua Box/Imagem
        ) {
            // 1. A Imagem (fundo da Box)
            AsyncImage(
                model = feed.imageUrl,
                contentDescription = stringResource(
                    R.string.feed_content_description,
                    feed.userNickName
                ),

                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 30.dp), // Preenche toda a Box
                contentScale = ContentScale.Crop // Recomenda-se Crop ou Fit para imagens de feed
            )

            // 2. userNickName (Superior Esquerdo)
            Text(
                feed.userNickName,
                modifier = Modifier
                    .align(Alignment.TopStart) // Alinha no canto superior esquerdo
                    .padding(8.dp), // Adiciona um padding para afastar das bordas
//                    .background(color = Purple40.copy(alpha = 0.5f), shape = RectangleShape), // Fundo semitransparente para legibilidade
                style = MaterialTheme.typography.labelMedium,
                color = MaterialTheme.colorScheme.onPrimary, // Cor clara para contraste
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )

            // 3. localName (Superior Direito)
            Text(
                feed.localName,
                modifier = Modifier
                    .align(Alignment.TopEnd) // Alinha no canto superior direito
                    .padding(8.dp), // Adiciona um padding
//                    .background(color = Purple40.copy(alpha = 0.5f), shape = RectangleShape),

                style = MaterialTheme.typography.labelMedium,
                color = MaterialTheme.colorScheme.onPrimary,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }

        // 4. A Descrição (Abaixo da Box, como um elemento separado no Column)
        Text(
            feed.description,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp),
            style = MaterialTheme.typography.bodyMedium, // Alterei para bodyMedium, que é mais apropriado para legendas
            color = MaterialTheme.colorScheme.onPrimary,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis,
            textAlign = TextAlign.Left
        )
    }
}

@Preview
@Composable
fun FeedItemPreview() {
    FeedItem(
        feed = Feed(
            "@MestreDosDados",
            "LudusCafé, SP",
            "",
            "https://heiderlopes.github.io/my-website/img/ludoon/editoras/asmodee",
            "Primeira vitória em Terraforming Mars! Que jogo estratégico!",
            "15 min ago"
        )
    )
}
package com.sap.presentation.dashboard

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.sap.domain.model.Photo
import com.sap.presentation.components.DefaultText
import com.sap.presentation.components.GenericEmptyView
import com.sap.presentation.components.TextProperties
import com.seiko.imageloader.rememberImagePainter

@Composable
fun DashboardScreenContentLoaded(
    modifier: Modifier = Modifier,
    onSearchClicked: () -> Unit,
    photo: List<Photo>
) {
    if (photo.isEmpty()) {
        GenericEmptyView(onSearchClicked = onSearchClicked)
    } else {
        Column(
            modifier = modifier.fillMaxSize()
        ) {
            LazyVerticalGrid(
                columns = GridCells.Adaptive(minSize = 150.dp),
                modifier = Modifier.fillMaxSize().testTag("photoGrid")
            ) {
                items(photo) { item ->
                    PhotoCardItem(item)
                }
            }
        }
    }
}

@Composable
fun PhotoCardItem(photo: Photo) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .height(220.dp),
        shape = RoundedCornerShape(12.dp),
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            Image(
                painter = rememberImagePainter(url = photo.imageUrl),
                contentDescription = photo.title,
                modifier = Modifier
                    .fillMaxSize(),
                contentScale = ContentScale.Crop
            )

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.BottomStart)
                    .background(
                        Brush.verticalGradient(
                            colors = listOf(Color.Transparent, Color.Black.copy(alpha = 0.7f))
                        )
                    )
                    .padding(8.dp)
            ) {

                DefaultText(
                    text = photo.title,
                    color = MaterialTheme.colorScheme.onPrimary,
                    textProperties = TextProperties(
                        overflow = TextOverflow.Ellipsis,
                        maxLines = 1
                    )
                )
            }
        }
    }
}
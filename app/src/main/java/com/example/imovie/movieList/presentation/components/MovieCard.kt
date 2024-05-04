package com.example.imovie.movieList.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImagePainter
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import coil.size.Size
import com.example.imovie.movieList.data.model.Movie
import com.example.imovie.ui.theme.DarkPrimary
import com.example.imovie.ui.theme.PrimaryColor
import com.example.imovie.utils.CONSTANTS


@Composable
fun MovieCard(movie: Movie) {

    val imageP = rememberAsyncImagePainter(model = ImageRequest
        .Builder(LocalContext.current).data(CONSTANTS.IMAGE_BASE_URL + movie.poster_path)
        .size(Size.ORIGINAL)
        .build()
    )

    Box(
        modifier = Modifier
            .width(200.dp)
            .height(300.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(DarkPrimary)


    ) {
        if(imageP.state is AsyncImagePainter.State.Success){
            Image(painter = imageP, contentDescription = null,
                contentScale = ContentScale.FillBounds,
                modifier = Modifier.width(200.dp)
                    .height(300.dp).clip(RoundedCornerShape(10.dp))
            )
        }
    }
}
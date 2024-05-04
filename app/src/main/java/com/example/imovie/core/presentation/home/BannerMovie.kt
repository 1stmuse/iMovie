package com.example.imovie.core.presentation.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImagePainter
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import coil.size.Size
import com.example.imovie.R
import com.example.imovie.movieList.data.model.Movie
import com.example.imovie.ui.theme.PrimaryColor
import com.example.imovie.utils.CONSTANTS

@Composable
fun BannerMovie(
    movie: Movie?
) {

    val imageP = rememberAsyncImagePainter(model = ImageRequest
        .Builder(LocalContext.current).data(CONSTANTS.IMAGE_BASE_URL + movie?.poster_path)
        .size(Size.ORIGINAL)
        .build()
    )

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(400.dp)
            .background(PrimaryColor)
    ) {
        if(imageP.state is AsyncImagePainter.State.Success){
            Image(painter = imageP, contentDescription = null,
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(400.dp)
            )
        }

        if(imageP.state is AsyncImagePainter.State.Empty){
            Image(painter = painterResource(id = R.drawable.emptyimg), contentDescription = null )
        }
        if(imageP.state is AsyncImagePainter.State.Error){
            Image(painter = painterResource(id = R.drawable.emptyimg), contentDescription = null )
        }
    }

}
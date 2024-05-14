package com.example.imovie.movieDetail.presentation

import android.content.Context
import android.webkit.WebView
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.imovie.common.Header
import com.example.imovie.core.presentation.favourites.FavouriteViewModel
import com.example.imovie.ui.theme.PrimaryColor
import com.example.imovie.utils.CONSTANTS

@Composable
fun MovieDetailScreen(
    navController: NavController,
    movieId: String
) {
    var status = true
    val vm: MovieDetailViewModel = hiltViewModel()
    val favVM: FavouriteViewModel = hiltViewModel()
    val favs = favVM.favourites.collectAsState().value
    val uiState = vm.uiState.collectAsState().value
    val movie = uiState.movie
    val casts = uiState.cast
    val videos = uiState.videos


    fun isFav(): Boolean {
        return favs.any { it.movieId == movie?.id }
    }

    LaunchedEffect(key1 = 1){
        vm.getDetails(movieId.toInt())
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(top = 20.dp)
            .padding(horizontal = 20.dp)

    ) {
        Header(
            leftfIcon = {
                Icon(imageVector = Icons.Default.ArrowBack, contentDescription = null, tint = Color.White, modifier = Modifier.clickable {
                    navController.popBackStack()
                } )
            },
            title = movie?.title ?: "Movie Title"
        )
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .padding(bottom = 100.dp)
        ) {

            if(uiState.loading){
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    CircularProgressIndicator()
                }


            } else {
                if(videos.isNotEmpty()){
                    val youtubeLink = CONSTANTS.YOUTUBE_URL + videos[0].key
                    PlayerView(link = youtubeLink)
                }
                Spacer(modifier = Modifier.height(20.dp))

                Row (
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(text = "Title: ${movie?.title ?: ""}", color = Color.White)

                    Box(modifier = Modifier.padding(top = 0.dp).clickable {
                        favVM.toggleToFav(movie!!)
                    }) {
                        if(!isFav()) {
                            Icon(imageVector =Icons.Default.FavoriteBorder , contentDescription = null, tint = Color.White )
                        } else Icon(imageVector = Icons.Default.Favorite, contentDescription = null, tint = Color.Red )
                    }

                }

                Spacer(modifier = Modifier.height(20.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(text = "Realease Year", color = Color.White)
                        Text(text = movie?.release_date?.take(4) ?: "", color = Color.White)
                    }
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Text(text = "Language", color = Color.White)
                        Text(text = movie?.original_language ?: "", color = Color.White)
                    }
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(text = "Rating", color = Color.White)
                        Text(text = if(movie?.adult ?: false) "18+" else "PG-13", color = Color.White)
                    }
                }
                Spacer(modifier = Modifier.height(20.dp))
                Text(text = "Overview", color=Color.White, style = MaterialTheme.typography.headlineSmall)
                Spacer(modifier = Modifier.height(10.dp))
                Text(text = movie?.overview ?: "", color = Color.White)
                Spacer(modifier = Modifier.height(20.dp))
                Text(text = "Cast", color=Color.White, style = MaterialTheme.typography.headlineSmall)
                Spacer(modifier = Modifier.height(10.dp))
                LazyRow{
                    items(casts){cast ->
                        Column(
                            modifier = Modifier.width(100.dp)
                        ) {
                            AsyncImage(model = CONSTANTS.IMAGE_BASE_URL + cast.profile_path , contentDescription = null,
                                contentScale = ContentScale.Crop,
                                modifier = Modifier
                                    .height(150.dp)
                                    .clip(RoundedCornerShape(5.dp))
                            )
                            Spacer(modifier = Modifier.height(10.dp))
                            Text(text = cast.name, color = Color.White)
                        }
                        Spacer(modifier = Modifier.width(20.dp))
                    }
                }

            }

        }
    }

}
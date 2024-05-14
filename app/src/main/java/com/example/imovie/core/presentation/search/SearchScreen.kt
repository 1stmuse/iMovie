package com.example.imovie.core.presentation.search

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.imovie.common.AppTextInput
import com.example.imovie.common.SearchInput
import com.example.imovie.movieList.presentation.components.MovieCard
import com.example.imovie.navigation.Destination
import com.example.imovie.ui.theme.DarkPrimary
import com.example.imovie.ui.theme.PrimaryColor
import com.example.imovie.ui.theme.SecondaryColor
import kotlin.math.roundToInt


@Composable
fun SearchScreen(
    navController: NavController
) {
    
    val vm: SearchViewmodel = hiltViewModel()
    val uiState = vm.uiState.collectAsState().value
    
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(top = 40.dp)
            .padding(horizontal = 20.dp)
    ) {
        SearchInput(value = uiState.searchTerm, placeholder = "Search for a title..." ,
            onChange = {
                vm.searchMovie(UiEvents.OnChange(it))
            },
            leadingIcon = {
                Icon(imageVector = Icons.Default.Menu, contentDescription = null,
                    tint = PrimaryColor
                )
            },
            trailingIcon = {
                if(uiState.searchTerm.isEmpty()){
                    Icon(imageVector = Icons.Default.Search, contentDescription = null,
                        tint = PrimaryColor
                    )
                } else {
                    Icon(imageVector = Icons.Default.Close, contentDescription = null,
                        tint = PrimaryColor,
                        modifier = Modifier.clickable {
                            vm.searchMovie(UiEvents.OnChange(""))
                        }
                    )
                }
            }
        )
        Spacer(modifier = Modifier.height(20.dp))
        LazyColumn(
            modifier = Modifier.horizontalScroll(rememberScrollState())
        ) {
            if(uiState.movies.isNotEmpty()){
                items(uiState.movies){
                    Row(
                        modifier = Modifier
                            .height(200.dp)
                            .clickable {
                                navController.navigate("${Destination.MovieDetail.baseRoute}/${it.id}")
                            }
                    ) {
                        Column(
                            modifier = Modifier.width(150.dp)
                        ) { MovieCard(movie = it, onClick = {
                            navController.navigate("${Destination.MovieDetail.baseRoute}/${it.id}")
                        })
                        }

                        Spacer(modifier = Modifier.width(10.dp))
                        Column(
                            modifier = Modifier.width(200.dp)
                        ) {
                            Text(text = it.title, color = Color.White)
                            Spacer(modifier = Modifier.height(5.dp))
                            Text(text = "Year Release: ${it.release_date.take(4)}", color = Color.White)
                            Spacer(modifier = Modifier.height(5.dp))
                            Row {
                                Icon(imageVector = Icons.Default.Star, contentDescription = null,
                                    tint = Color.Yellow
                                )
                                Text(text = "${it.vote_average}".take(3), color = Color.White)
                            }
                            Spacer(modifier = Modifier.height(5.dp))
                            Text(text = it.overview, color = Color.White, overflow = TextOverflow.Ellipsis, maxLines = 3)
                        }
                    }
                    Spacer(modifier = Modifier.height(20.dp))
                    
                }
            }
        }
    }
}

@Preview
@Composable
fun SearchPrev() {
    SearchScreen(rememberNavController())
}
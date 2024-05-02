package com.example.imovie

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.WindowCompat
import com.example.imovie.navigation.Auth_Graph
import com.example.imovie.navigation.Dashboard_Graph
import com.example.imovie.navigation.IMovie
import com.example.imovie.ui.theme.IMovieTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
//        val splashScreen = installSplashScreen()
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(
            window, false
        )
        installSplashScreen()

        setContent {
            IMovieTheme {

                    IMovie(Dashboard_Graph)

            }
        }
    }
}

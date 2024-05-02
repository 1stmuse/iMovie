package com.example.imovie.auth


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.imovie.R
import com.example.imovie.common.AppButton
import com.example.imovie.common.ButtonVariant
import com.example.imovie.navigation.Destination

@Composable
fun OnboardingScreen(navController: NavHostController) {
    Box(modifier = Modifier
        .fillMaxSize()
        .padding(all = 0.dp),
        contentAlignment = Alignment.BottomEnd
    ){
        Image(painter = painterResource(id = R.drawable.onbaordimage), contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.FillBounds
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
                .clip(RoundedCornerShape(topStart = 15.dp, topEnd = 15.dp))
                .background(Color.Black.copy(alpha = 0.9f))
                .padding(horizontal = 20.dp)
                .padding(vertical = 20.dp)
            ,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Watch movies anytime anywhere", color=Color.White, textAlign = TextAlign.Center,
                style = MaterialTheme.typography.titleLarge
                )
            Text(text = "Explore a vast collection of blockbuster movies, timeless classics, and the latest releases.",
                color=Color.White,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(top = 15.dp),
                style = MaterialTheme.typography.titleMedium
            )
            Spacer(modifier = Modifier.height(20.dp))
            AppButton(label = "Login") {
                navController.popBackStack()
                navController.navigate(Destination.Login.route)
            }
            Spacer(modifier = Modifier.height(15.dp))
            AppButton(label = "Sign Up", variant = ButtonVariant.SECONDARY) {
                navController.popBackStack()
                navController.navigate(Destination.Signup.route)
            }
        }


    }
}

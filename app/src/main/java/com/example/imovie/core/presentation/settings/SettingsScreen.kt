package com.example.imovie.core.presentation.settings

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.imovie.common.Header

@Composable
fun SettingsScreen() {

    val imageUlr = "https://images.unsplash.com/photo-1511367461989-f85a21fda167?q=80&w=1000&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8Mnx8cHJvZmlsZXxlbnwwfHwwfHx8MA%3D%3D"

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(horizontal = 20.dp)
            .padding(top = 40.dp)
    ) {
        Header(leftfIcon = null, title = "Settings" )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                AsyncImage(model = imageUlr,
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .height(100.dp)
                        .width(100.dp)
                        .clip(CircleShape)
                )
                Column {
                    Text(text = "Zeta" , color = Color.White )
                    Text(text = "example@gmail.com", color = Color.White)
                }
            }
            Spacer(modifier = Modifier.height(30.dp))
            SettingsOptions.options.forEach {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Icon(imageVector = it.icon, contentDescription = null, tint = Color.White )
                    Text(text = it.label, color = Color.White, modifier = Modifier.padding(start = 10.dp))
                }
                Spacer(modifier = Modifier.height(30.dp))

            }

        }
    }
}


@Preview
@Composable
fun SettingsPrev() {
    SettingsScreen()
}
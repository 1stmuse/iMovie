package com.example.imovie.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun Header(
    leftfIcon: (@Composable () -> Unit)?,
    title: String
) {
    
    Row(
        modifier = Modifier.fillMaxWidth().padding(vertical = 20.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column(
            modifier = Modifier.width(70.dp)
        ) {
            if(leftfIcon != null){
                leftfIcon()
            }
        }

        Column(
            modifier = Modifier
        ) {
            Text(text = title, color = Color.White, style = MaterialTheme.typography.titleSmall, maxLines = 2, textAlign = TextAlign.Center)
        }

        Column(
            modifier = Modifier.width(70.dp)
        ) {

        }

    }
}

@Preview(showBackground = true)
@Composable
fun Header_Prev() {
    Header(leftfIcon = {  }, title = "Profile" )
}
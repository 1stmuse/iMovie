package com.example.imovie.navigation.components


import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.imovie.ui.theme.PrimaryColor

@Composable
fun BottomTabs( navController: NavHostController, selected: String = "", onClick: (String) -> Unit) {
    Row(
        modifier = Modifier.fillMaxWidth().background(Color.Black).navigationBarsPadding(),
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        Tabs.tabList.forEach {
            Column(
                modifier = Modifier.weight(1f).padding(vertical = 10.dp)
                    .clickable {
                               onClick(it.route)
                    }
                ,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Icon(imageVector = it.icon, contentDescription = null, tint = if(selected == it.route) PrimaryColor else Color.White )
                Text(text = it.label, color = if(selected == it.route) PrimaryColor else Color.White)
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun BottomTab_Preview() {
    BottomTabs(navController = rememberNavController(), onClick = {})
}
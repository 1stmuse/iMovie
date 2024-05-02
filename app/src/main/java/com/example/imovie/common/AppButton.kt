package com.example.imovie.common

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.imovie.ui.theme.PrimaryColor

enum class ButtonVariant {
    SECONDARY,
    PRIMARY
}

@Composable
fun AppButton(
    label: String,
    variant: ButtonVariant = ButtonVariant.PRIMARY,
    onPress: () -> Unit
) {

    val borderColor: Color =  when(variant){
        ButtonVariant.PRIMARY -> Color.Transparent
        ButtonVariant.SECONDARY -> PrimaryColor
    }
    Column(
        modifier = Modifier.border(
            width  = when(variant){
                ButtonVariant.PRIMARY -> 0.dp
                ButtonVariant.SECONDARY -> 1.dp
            },
            color = borderColor
        )
    ) {
        Button(onClick = onPress,
            shape = RoundedCornerShape(5.dp),
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                containerColor = when(variant){
                    ButtonVariant.PRIMARY -> PrimaryColor
                    ButtonVariant.SECONDARY -> Color.Transparent
                }
            ),
            contentPadding = PaddingValues(vertical = 15.dp)

            ) {
            Text(text = label, color = when(variant){
                ButtonVariant.PRIMARY -> Color.Black
                ButtonVariant.SECONDARY -> PrimaryColor
            }
            )
        }
    }

}


@Preview(showBackground = true)
@Composable
fun ButtonPrev() {
    AppButton(label = "Login", variant = ButtonVariant.PRIMARY){}
}
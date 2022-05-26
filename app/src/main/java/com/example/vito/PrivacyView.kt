package com.example.vito

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Favorite
import androidx.compose.material.icons.rounded.List
import androidx.compose.material.icons.rounded.Notifications
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun PrivacyView(navController: NavController) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {

        val image: Painter = painterResource(id = R.drawable.info)
        Image(painter = image,contentDescription = "", modifier = Modifier

            .padding(30.dp)
            .padding(top= 40.dp)
            .width(100.dp)
        )
        Text(text = "Privacy is Vital",
            fontSize = 18.sp,
            color = Color.Blue,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Left,
            modifier = Modifier
                .fillMaxWidth()
        )
        Text(text = "Here's how we protect your privacy...",
            fontSize = 18.sp,
            color = Color.Blue,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Left,
            modifier = Modifier
                .alpha(.4F)
                .fillMaxWidth()
        )




    }

}

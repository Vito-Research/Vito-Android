package com.example.vito

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
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
        modifier = Modifier.padding()
    ) {

        val image: Painter = painterResource(id = R.drawable.privacy)
        Image(painter = image,contentDescription = "", modifier = Modifier

            .padding(30.dp)
            .padding(top = 40.dp)
            .width(300.dp)
        )
        Text(text = "Privacy is Vital",
            fontSize = 38.sp,
            color = colorResource(R.color.blue),
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Left,
            modifier = Modifier
                .width(300.dp)
                .padding()
        )
        Text(text = "Here's how we protect your privacy...",
            fontSize = 22.sp,
            color = colorResource(R.color.blue),
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Left,
            modifier = Modifier
                .alpha(.4F)
                .width(300.dp)
                .padding()

        )
        Spacer(modifier = Modifier.height(50.dp))
        TLDRView(icon = Icons.Rounded.Lock,"Vito Processes On-Device", "Vito never exports health data off device")
        Spacer(modifier = Modifier.height(20.dp))
        TLDRView(icon = Icons.Rounded.KeyboardArrowDown, "Fitbit API", "Used to authenticate, request, and get data from your Fitbit")
        Spacer(modifier = Modifier.height(10.dp))
        Text(text = "Vito utilizes an on-device algorithm to build community trust, resulting in increased app usage and a reduction in the spread of infection. As a result, we believe that privacy is vital.",
            fontSize = 14.sp,
            color = Color.Black,
            fontWeight = FontWeight.SemiBold,
            textAlign = TextAlign.Left,
            modifier = Modifier
                .alpha(.6F)
                .width(250.dp)
                .padding()
        )

    }

}
@Composable
fun TLDRView(icon: ImageVector, title: String, text: String) {
    Row(modifier = Modifier.padding()) {
        Icon(icon, title, modifier = Modifier
            .alpha(0.8F)
            .width(50.dp))
        Column {
            Text(text = title,
                fontSize = 18.sp,
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Left,
                modifier = Modifier
                    .alpha(.9F)
                    .width(300.dp)
                    .padding()
            )
            Text(text = text,
                fontSize = 18.sp,
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Left,
                modifier = Modifier
                    .alpha(.6F)
                    .width(300.dp)
                    .padding()
            )
        }
    }
}
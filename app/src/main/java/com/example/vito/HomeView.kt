package com.example.vito

import androidx.compose.ui.text.font.FontWeight
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
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
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.vito.ui.theme.VitoTheme
import java.io.File
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import java.util.*
@Composable
fun HomeView(navController: NavController) {
    val scrollState = rememberScrollState()
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
          //  .scrollable(state = scrollState, orientation = Orientation.Vertical)
    ) {
        Header(navController= navController)
        AlertCard("ALERT")
        AlertDetails("Your heart rate while asleep is abnormally high compared to your previous data", icon= Icons.Rounded.Favorite)
        AlertDetails("This can be a sign of disease, intoxication, lack of sleep, or other factors", icon= Icons.Rounded.List)
        AlertDetails("This is not medical advice or a diagnosis, it's simply a datapoint to bring up to your doctor", icon= Icons.Rounded.Notifications)
//        Spacer(
//            modifier = Modifier
//                .height(40.dp)
//                .fillMaxWidth()
//        )
        LearnMore("Learn More?", "Learn more about our values and how the algorithm works", navController)



    }

    }


@Composable
fun AlertDetails(alertTitle: String, icon: ImageVector = Icons.Rounded.Build) {
    Column( modifier = Modifier
        .padding(10.dp)
       ) {
        Icon(icon, alertTitle, modifier = Modifier.alpha(0.8F))
        Text(text = alertTitle,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.alpha(0.7F)
        )
    }
}

@Composable
fun AlertCard(alertTitle: String) {
    Text(
        text = "Stress Event Level",
        color = Color.Black,
        textAlign = TextAlign.Left,
        fontSize = 25.sp,
        fontWeight = FontWeight.ExtraBold,
        modifier = Modifier

            .padding(10.dp)
            .fillMaxWidth()


    )
        Card(
            backgroundColor = colorResource(R.color.red),
            shape = RoundedCornerShape(15),
            modifier = Modifier

                .padding(10.dp)
                .padding(vertical = 10.dp)
                .height(130.dp)
                .fillMaxWidth()
                .alpha(.8F)


        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxWidth()
            ) {
            Text(
                text = alertTitle,
                color = Color.White,
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier

                    .padding(10.dp)


            )
        }
    }
}
@Composable
fun LearnMore(title: String, text: String, navController: NavController) {
TextButton(modifier =
    Modifier

    .padding(10.dp)

    .fillMaxWidth(),
    onClick = { navController.navigate("Onboarding") }) {


    Card(
        elevation = 10.dp,
        backgroundColor = Color.White,
        shape = RoundedCornerShape(10),
        modifier = Modifier

            .padding(10.dp)

            .fillMaxWidth()


    ) {

        Row {
            val image: Painter = painterResource(id = R.drawable.info)
            Image(
                painter = image, contentDescription = "", modifier = Modifier

                    .padding(30.dp)
                    .padding(top = 40.dp)
                    .width(100.dp)
            )

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 20.dp)

            ) {
                Row {
                    Spacer(
                        modifier = Modifier.padding()
                    )
                    Text(

                        text = title,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black,
                        fontSize = 24.sp,
                        textAlign = TextAlign.Right,
                        modifier = Modifier
                            .alpha(0.9F)
                            .padding(10.dp)


                    )
                }
                Row {
                    Spacer(modifier = Modifier.padding())
                    Text(
                        text = text,
                        color = Color.Black,
                        fontSize = 12.sp,
                        textAlign = TextAlign.Right,
                        modifier = Modifier
                            .alpha(0.6F)
                            .padding(10.dp)


                    )

                }
            }
        }
    }
}
}
@Composable
fun Greeting(name: String) {
    Button(onClick = {
        val alert = AlertLv1()

    }) {

    }

}

@Composable
fun Header(navController: NavController) {

    Row(modifier = Modifier
        .padding()
        .padding(vertical = 10.dp)) {

        TextButton(onClick = {
            navController.navigate("Data")

        }) {
            Icon(Icons.Rounded.DateRange, "", tint= colorResource(R.color.blue), modifier = Modifier
                .alpha(0.8F))
        }

        Spacer(
            modifier = Modifier
                .width(275.dp)
                .fillMaxWidth()
        )

        TextButton(modifier = Modifier,
                onClick = {
                    navController.navigate("Privacy")

        }
        ) {
            Icon(Icons.Rounded.Info, "", tint = colorResource(R.color.blue),  modifier = Modifier
                .alpha(0.8F))

        }
    }
}
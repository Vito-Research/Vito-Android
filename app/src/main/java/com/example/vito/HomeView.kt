package com.example.vito


import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Image
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
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Header(navController= navController)
        AlertCard("ALERT")
        AlertDetails("Your heart rate while asleep is abnormally high compared to your previous data", icon= Icons.Rounded.Favorite)
        AlertDetails("This can be a sign of disease, intoxication, lack of sleep, or other factors", icon= Icons.Rounded.List)
        AlertDetails("This is not medical advice or a diagnosis, it's simply a datapoint to bring up to your doctor", icon= Icons.Rounded.Notifications)
        Spacer(
            modifier = Modifier
                .height(40.dp)
                .fillMaxWidth()
        )
        LearnMore("Learn More", "Learn more about our values and how the algorithm works")



    }

    }


@Composable
fun AlertDetails(alertTitle: String, icon: ImageVector = Icons.Rounded.Build) {
    Column( modifier = Modifier
        .padding(10.dp)
       ) {
        Icon(icon, alertTitle)
        Text(text = alertTitle)
    }
}

@Composable
fun AlertCard(alertTitle: String) {

        Card(
            backgroundColor = Color.Red,
            shape = RoundedCornerShape(15),
            modifier = Modifier

                .padding(10.dp)
                .padding(vertical = 10.dp)
                .height(100.dp)
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
                modifier = Modifier

                    .padding(10.dp)


            )
        }
    }
}
@Composable
fun LearnMore(title: String, text: String) {

    Card(
        backgroundColor = Color.LightGray,
        shape = RoundedCornerShape(15),
        modifier = Modifier

            .padding(30.dp)

            .fillMaxWidth()
            .alpha(.8F)


    ) {
        Row {
            val image: Painter = painterResource(id = R.drawable.info)
            Image(painter = image,contentDescription = "", modifier = Modifier

                .padding(30.dp)
                .width(100.dp))

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxWidth()
                    .padding(vertical=20.dp)

            ) {
                Row {
                    Spacer(modifier = Modifier.padding()
                       )
                    Text(
                        text = title,
                        color = Color.Black,
                        fontSize = 20.sp,
                        modifier = Modifier

                            .padding(10.dp)


                    )
                }
                Row {
                    Text(
                        text = text,
                        color = Color.Gray,
                        fontSize = 10.sp,
                        modifier = Modifier

                            .padding(10.dp)


                    )
                    Spacer(modifier = Modifier.padding())
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

    Row(modifier = Modifier.padding()
        .padding(vertical = 10.dp)) {

        TextButton(onClick = {
            navController.navigate("Data")

        }) {
            Icon(Icons.Rounded.DateRange, "")
        }

        Spacer(
            modifier = Modifier
                .width(275.dp)
                .fillMaxWidth()
        )

        TextButton( modifier = Modifier,
                onClick = {
            val alert = AlertLv1()

        }
        ) {
            Icon(Icons.Rounded.Info, "")

        }
    }
}
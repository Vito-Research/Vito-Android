package com.example.vito

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.DateRange
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

data class Onboarding(val title: String, val text: String, val img: Painter, val next: Onboarding?)


@Composable
fun OnboardingView(navController: NavController) {
    val image: Painter = painterResource(id = R.drawable.privacy)
    var onboarding = remember {mutableStateOf(Onboarding(
        "We at Vito Believe Health And Privacy are Vital...",
        "We envision a world where you control your health data and can learn from it.",
        image,
        Onboarding("Our Core Values...", "Accessibility, Privacy, People", img = image, next =
        Onboarding("Our Core Values...", "Accessibility, Privacy, People", img = image, next = null))
    ))}
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
        //  .scrollable(state = scrollState, orientation = Orientation.Vertical)
    ) {
        Image(
            painter = onboarding.component1().img, contentDescription = "", modifier = Modifier

                .padding(30.dp)
                .padding(top = 40.dp)
                .width(300.dp)
        )
        Spacer(modifier = Modifier.padding().height(40.dp))
        Text(
            text = onboarding.component1().title,
            fontSize = 28.sp,
            color = colorResource(R.color.blue),
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Left,
            modifier = Modifier
                .width(300.dp)
                .padding()
        )
        Text(
            text = onboarding.component1().text,
            fontSize = 18.sp,
            color = colorResource(R.color.blue),
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Left,
            modifier = Modifier
                .alpha(.4F)
                .width(300.dp)
                .padding()

        )
        Spacer(modifier = Modifier.padding().fillMaxHeight(0.5F))
        TextButton(onClick = {
            if( onboarding.value.next == null) {
                navController.navigate("Home")
            } else {
                onboarding.value = onboarding.value.next!!
            }


        }) {
            Card(backgroundColor = colorResource(R.color.blue)) {
                Text(text = "Next",
                    fontSize = 38.sp,
                    color = colorResource(R.color.white),
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .width(300.dp)
                        .padding())
            }



        }
    }
}

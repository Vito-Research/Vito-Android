package com.example.vito


import androidx.compose.ui.text.font.FontWeight
import android.os.Build
import android.os.Bundle
import android.text.Layout
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
import androidx.compose.ui.focus.focusModifier
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
fun DataView() {
    Column(modifier = Modifier.padding().padding(vertical = 30.dp)) {

        Text(text = "Average Heart Rate", fontSize = 28.sp,
            color = colorResource(R.color.blue),
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Left, modifier = Modifier.padding(horizontal = 10.dp).fillMaxWidth())
        Text(text = "70 BPM", fontSize = 18.sp,
            color = colorResource(R.color.green),
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Left,  modifier = Modifier.padding(horizontal = 10.dp).fillMaxWidth())
        Column(modifier = Modifier.padding(vertical = 100.dp)) {
            AlertCard(alertTitle = "OK")
            Card(backgroundColor = Color.LightGray) {
                Text(text = "CHART HERE", Modifier.fillMaxWidth().fillMaxHeight())
            }
        }
    }
}

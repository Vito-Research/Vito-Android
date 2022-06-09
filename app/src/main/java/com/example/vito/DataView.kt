package com.example.vito


import android.annotation.SuppressLint
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.rounded.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
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
import com.example.vito.DataPoints.dataPoints1
import com.example.vito.DataPoints.dataPoints2
import com.example.vito.DataPoints.dataPoints3
import com.example.vito.DataPoints.dataPoints4
import com.example.vito.DataPoints.dataPoints6
import com.madrapps.plot.line.DataPoint
import com.madrapps.plot.line.LineGraph
import com.madrapps.plot.line.LinePlot
import java.util.*
@SuppressLint("UnrememberedMutableState")
@Composable
fun DataView() {
     val lines: State<List<List<List<DataPoint>>>> = mutableStateOf(
        listOf(
            listOf(dataPoints1, dataPoints2),
            listOf(dataPoints3, dataPoints2),
            listOf(dataPoints1, dataPoints2),
            listOf(dataPoints1, dataPoints2),
            listOf(dataPoints6, dataPoints4),
        )
    )
    Column(modifier = Modifier.padding().padding(vertical = 30.dp)) {

        Text(text = "Average Heart Rate", fontSize = 28.sp,
            color = colorResource(R.color.blue),
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Left, modifier = Modifier.padding(horizontal = 10.dp).fillMaxWidth())
        Text(text = "70 BPM", fontSize = 18.sp,
            color = colorResource(R.color.green),
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Left,  modifier = Modifier.padding(horizontal = 10.dp).fillMaxWidth())
        Column(modifier = Modifier.padding(vertical = 70.dp)) {
            AlertCard(alertTitle = "OK")
            Card(backgroundColor = Color.LightGray, modifier = Modifier.padding(top = 60.dp)) {
                SampleLineGraph(lines.value.get(0))
            }
        }
    }
}
@Composable
fun SampleLineGraph(lines: List<List<DataPoint>>) {
    LineGraph(
        plot = LinePlot(
            listOf(
                LinePlot.Line(
                    lines[0],
                    LinePlot.Connection(color =  colorResource(R.color.green)),
                    LinePlot.Intersection(color =  colorResource(R.color.green)),
                    LinePlot.Highlight(color =  colorResource(R.color.green)),
                )
            ),
            grid = LinePlot.Grid( colorResource(R.color.green), steps = 4),
        ),
        modifier = Modifier.fillMaxWidth().height(200.dp),
        onSelection = { xLine, points ->
            // Do whatever you want here
        }
    )
}
object DataPoints {
    val dataPoints1 = listOf(
        DataPoint(0f, 0f),
        DataPoint(1f, 20f),
        DataPoint(2f, 50f),
        DataPoint(3f, 10f),
        DataPoint(4f, 0f),
        DataPoint(5f, -25f),
        DataPoint(6f, -75f),
        DataPoint(7f, -100f),
        DataPoint(8f, -80f),
        DataPoint(9f, -75f),
        DataPoint(10f, -55f),
        DataPoint(11f, -45f),
        DataPoint(12f, 50f),
        DataPoint(13f, 80f),
        DataPoint(14f, 70f),
        DataPoint(15f, 125f),
        DataPoint(16f, 200f),
        DataPoint(17f, 170f),
        DataPoint(18f, 135f),
        DataPoint(19f, 60f),
        DataPoint(20f, 20f),
        DataPoint(21f, 40f),
        DataPoint(22f, 75f),
        DataPoint(23f, 50f),
    )

    val dataPoints2 = listOf(
        DataPoint(0f, 0f),
        DataPoint(1f, 0f),
        DataPoint(2f, 25f),
        DataPoint(3f, 75f),
        DataPoint(4f, 100f),
        DataPoint(5f, 80f),
        DataPoint(6f, 75f),
        DataPoint(7f, 50f),
        DataPoint(8f, 80f),
        DataPoint(9f, 70f),
        DataPoint(10f, 0f),
        DataPoint(11f, 0f),
        DataPoint(12f, 45f),
        DataPoint(13f, 20f),
        DataPoint(14f, 40f),
        DataPoint(15f, 75f),
        DataPoint(16f, 50f),
        DataPoint(17f, 75f),
        DataPoint(18f, 40f),
        DataPoint(19f, 20f),
        DataPoint(20f, 0f),
        DataPoint(21f, 0f),
        DataPoint(22f, 50f),
        DataPoint(23f, 25f),
    )

    val dataPoints3 = listOf(
        DataPoint(0f, 0f),
        DataPoint(1f, 0f),
        DataPoint(2f, 0f),
        DataPoint(3f, 0f),
        DataPoint(4f, 0f),
        DataPoint(5f, 25f),
        DataPoint(6f, 75f),
        DataPoint(7f, 100f),
        DataPoint(8f, 80f),
        DataPoint(9f, 75f),
        DataPoint(10f, 55f),
        DataPoint(11f, 45f),
        DataPoint(12f, 50f),
        DataPoint(13f, 80f),
        DataPoint(14f, 70f),
        DataPoint(15f, 25f),
        DataPoint(16f, 0f),
        DataPoint(17f, 0f),
        DataPoint(18f, 35f),
        DataPoint(19f, 60f),
        DataPoint(20f, 20f),
        DataPoint(21f, 40f),
        DataPoint(22f, 75f),
        DataPoint(23f, 50f),
    )

    val dataPoints4 = listOf(
        DataPoint(13f, 20f),
        DataPoint(14f, 40f),
        DataPoint(15f, 75f),
        DataPoint(16f, 50f),
        DataPoint(17f, 75f),
        DataPoint(18f, 40f),
        DataPoint(19f, 20f),
        DataPoint(20f, 0f),
        DataPoint(21f, 0f),
        DataPoint(22f, 50f),
        DataPoint(23f, 25f),
    )

    val dataPoints6 = listOf(
        DataPoint(-0.6f, -1f),
        DataPoint(-0.5f, 0f),
        DataPoint(-0.4f, 0.5f),
        DataPoint(-0.3f, 1f),
        DataPoint(-0.2f, 2f),
        DataPoint(-0.1f, 1.2f),
        DataPoint(-0f, 0.0f),
        DataPoint(0.1f, 0.3f),
        DataPoint(0.3f, 0.25f),
        DataPoint(0.4f, 0.75f),
        DataPoint(0.5f, 0.80f),
        DataPoint(0.8f, 1f),
        DataPoint(0.9f, 1.45f),
        DataPoint(1.2f, 0.50f),
        DataPoint(1.3f, 1.50f),
        DataPoint(1.4f, 0.80f),
        DataPoint(1.5f, 1.70f),
        DataPoint(1.6f, 2f),
        DataPoint(1.7f, 0f),
    )
}
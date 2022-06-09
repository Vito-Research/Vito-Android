package com.example.vito

import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
//import com.example.vito.fitbitauth.src.main.java.com.fitbit.authentication.*
import com.example.vito.ui.theme.VitoTheme
import io.github.boguszpawlowski.composecalendar.SelectableCalendar
import java.io.File
import java.util.*

class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    @OptIn(ExperimentalStdlibApi::class)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            VitoTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    ContentView()


                }
            }
        }
    }
    @Composable
    fun ContentView() {
        val navController = rememberNavController()

        NavHost(navController = navController, startDestination = "Home") {
            composable("Home") {  HomeView(navController= navController) }
            composable("Data") {

                SelectableCalendar()
            }
            composable("Privacy") {

                PrivacyView(navController)
            }
            composable("Onboarding") {

                OnboardingView(navController)
            }

            /*...*/
        }
    }

//    @Override
//    public void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        AuthenticationManager.onActivityResult(requestCode, resultCode, data, (AuthenticationHandler) this)
//    }
//
//
//    public void onAuthFinished(AuthenticationResult authenticationResult) {
//        if (authenticationResult.isSuccessful()) {
//            //WOOT WOOT!! It worked!
//        } else {
//            //Uh oh... errors...
//        }
//    }
//private fun login() {
//    AuthenticationManager.login(this);
//    ClientCredentials clientCredentials = new ClientCredentials(<CLIENT_ID>, <CLIENT_SECRET>, <REDIRECT_URL>);
//    String secureKey = "ba";
//
//    AuthenticationConfiguration config = new AuthenticationConfigurationBuilder()
//        .setClientCredentials(clientCredentials)
//        .setEncryptionKey(secureKey)
//        .addRequiredScopes(Scope.profile, Scope.settings)
//        .build();
//
//    AuthenticationManager.configure(this, config)
//}
    private fun listAssetFiles(path: String): Boolean {
        val list: Array<String>?

        var correct: Int = 0
        var total: Int = 0

            list =  application.assets.list(path)
            if (list!!.size > 0) {
                // This is a folder
                for (file in list) {

                    if (file.contains("Vito")) {
                        var alert = AlertLv1()
                        alert.resetAlert()

                        Log.i("", file.toString())
                        val inputString =
                            application.assets.open(file).bufferedReader()
                                .use { it.readText() }
                        val townList: List<String> = inputString.split("\n")
                        for (item: String in townList) {
                            // Log.i("", item.toString())
                            val row: List<String> = item.split(",")
                             Log.i("ROW", row.toString())
                            if (!row.contains("Heartrate") && row.indices.contains(2) && row[(2)].trim().toIntOrNull() != null) {


                                try {

                                    if (row.last().trim().toInt() != null) {
                                        alert.calculateMedian(row[2].trim().toInt())
                                        //Log.i("iOS", alert.state.alert.hr.last().toString())

                                        if (alert.returnAlert() == row.last().trim().toInt()) {
                                            correct += 1
                                            total += 1
                                        } else {
                                            Log.i("YIKES", alert.returnAlert().toString())

                                            total += 1
                                        }


                                    } else {
                                        Log.i("YIKES", "OOooooooOOf")
                                    }
                                    // Log.i("", alert.returnAlert().toString())
                                } catch (e: Exception) {
                                    Log.i("", e.toString())
                                }
                            }
                            // }

                        }

                    }
                }
            }
        Log.i("", ((correct).toDouble() / total.toDouble()).toString())


        return true
    }

    fun readFileUsingGetResource(fileName: String)

            = this::class.java.getResource(fileName).readText(Charsets.UTF_8)

}
private fun readTestDataFile(fileName: String): File {
    return File("src/jvmTest/resources/testdata/csv/$fileName")
}


@OptIn(ExperimentalStdlibApi::class)
class AlertLv1 {
     var state: Level

     init {

        this.state = Level.Zero
        this.resetAlert()
         }

     data class Alert(val clusterCount: Int = 0, var hr: IntArray = intArrayOf()) {

    }


     enum class Level(var alert: Alert = Alert()) {
        Zero,
        One,
        Two,
        Three,
        Four,
        Five,
    }
    fun returnAlert() : Int {
        when(state) {
            Level.Five -> {
                // Log.i("", "1")
                return 1

            }
            else -> {
                return 0
            }

        }
    }
    fun resetAlert() {
        this.state = Level.Zero
        this.state.alert.hr = intArrayOf()

    }

    fun med(list: List<Double>) = list.sorted().let {
        if (it.size % 2 == 0)
            ((it[it.size / 2] + it[(it.size - 1) / 2]) / 2).toFloat()
        else
            it[it.size / 2].toFloat()
    }
    fun calculateMedian(hr: Int) {


        this.state.alert.hr += hr
        val frozenState =  state
        Log.i("HR= ",hr.toString())
            when (state) {

                Level.Five -> {

                    val median = med(list = state.alert.hr.map { it.toDouble() }).toInt()

                    when {
                        hr >= (median + 4) -> this.state = Level.Five
                        (hr == (median + 3)) -> this.state = Level.Three
                        else -> this.state = Level.Zero
                    }
                    return
                }


                Level.Four -> {

                    val median = med(list = state.alert.hr.map { it.toDouble() }).toInt()
                    when {
                           hr >= (median + 4) -> this.state = Level.Five
                           (hr.toInt() == (median + 3)) -> this.state = Level.Three
                           else -> this.state = Level.Zero
                    }
                    return
                }
                Level.Three -> {
                    val median = med(list = state.alert.hr.map { it.toDouble() }).toInt()
                    when {
                        hr >= (median + 4) -> this.state = Level.Four
                        (hr.toInt() == (median + 3).toInt()) -> this.state = Level.Three
                        else -> this.state = Level.Zero
                    }
                    return
                }
                Level.Two -> {
                    // state.alert.hr += hr

                    val median = med(list = state.alert.hr.map { it.toDouble() }).toInt()
                    when {
                        hr >= (median + 4) -> this.state = Level.Five
                        (hr.toInt() == (median + 3).toInt()) -> this.state = Level.Three
                        else -> this.state = Level.Zero
                    }
                    return
                }
                Level.One -> {
                    val median = med(list = state.alert.hr.map { it.toDouble() }).toInt()
                    when {
                        hr >= (median + 4) -> this.state = Level.Four
                        (hr.toInt() == (median + 3).toInt()) -> this.state = Level.Three
                        else -> this.state = Level.Zero
                    }
                    return
                }

                Level.Zero -> {
                    val median = med(list = state.alert.hr.map { it.toDouble() }).toInt()


                    when {
                        hr >= (median + 4) -> this.state = Level.Two
                        (hr == (median + 3)) -> this.state = Level.One
                        else -> this.state = Level.Zero
                    }
                    return
                }
            }
    }
    public data class HeathData(val Start_Date: Date, var Start_Time:String, var hr: Double, var risk: Int) {


    }
    fun sortingSelection(array: MutableList<Int>): MutableList<Int> {

        for (i in 0 until array.size - 1) {
            var min = i
            for (j in i+1 until array.size) {
                if(array[j] < array[min]) {
                    min = j
                }
            }

            var temp = array[i]
            array[i] = array[min]
            array[min] = temp
        }

        return array
    }

    fun median(array: MutableList<Int>): Double {
        sortingSelection(array)

        if (array.size % 2 == 0) {
            return ((array[array.size / 2] + array[array.size / 2 - 1]) / 2).toDouble()
        } else {
            return (array[array.size / 2]).toDouble()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    VitoTheme {
        Greeting("Android")
    }
}

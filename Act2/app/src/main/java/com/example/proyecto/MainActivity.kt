package com.example.proyecto

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.proyecto.ui.theme.ProyectoTheme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ProyectoTheme {
                ViewContainer()
            }
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview
fun ViewContainer() {
    val intentContext = LocalContext.current
    var plusCounter = 0

    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()

    Scaffold(
        topBar = {
           TopAppBar(
               title = { Text(stringResource(R.string.app_name)) },
               colors = topAppBarColors(
                   containerColor = MaterialTheme.colorScheme.secondary,
                   titleContentColor = Color.White
               ),
               navigationIcon = {
                   IconButton(onClick = { /*Action*/ }) {
                       Icon(
                           imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                           contentDescription = "TODO",
                           tint = Color.White
                       )
                   }
               }
           )
       },
       bottomBar = {
           BottomAppBar(
               containerColor = MaterialTheme.colorScheme.secondary,
               contentColor = MaterialTheme.colorScheme.primary
           ) {
               Text(
                   modifier = Modifier.fillMaxWidth(),
                   textAlign = TextAlign.Center,
                   text = "micui",
                   color = Color.White,
                   fontSize = 18.sp,
               )
           }
       },
       floatingActionButton = {
           FloatingActionButton(onClick = {
               var str = ""

               if (plusCounter == 0) {
                   str = "naco"
               }
               else if (plusCounter == 1) {
                   str = "prieto"
               }
               else if (plusCounter == 2) {
                   str = "gato"
               }
               else if (plusCounter == 3) {
                   str = "pobre"
               }

               scope.launch {
                   snackbarHostState.showSnackbar(str)
               }

               plusCounter++

               if (plusCounter >= 4) {
                   plusCounter = 0
               }
           }) {
               Icon(
                   imageVector = Icons.Default.Add,
                   contentDescription = "Añadir" // TODO: xd
               )
           }
       },
        snackbarHost = {
            SnackbarHost(snackbarHostState);
        },
       modifier = Modifier.fillMaxSize()
   ) { innerPadding ->
       ContentView()
   }
}

@Composable
fun ContentView() {
    ProyectoTheme {
        var counter by rememberSaveable { mutableStateOf(0) }

        LazyColumn (
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Red)
                .padding(8.dp)
        ) {
            item {
                Image(
                    painter = painterResource(id = R.drawable.android1920x1080),
                    contentDescription = stringResource(R.string.image_description),
                    modifier = Modifier
                        .fillMaxSize()
                        .height(270.dp)
                        .padding(8.dp)
                        .padding(top = 55.dp)
                )

                Row(modifier = Modifier.padding(top = 2.dp)) {
                    Image(
                        painter = painterResource(R.drawable.baseline_add_circle_outline_24),
                        contentDescription = "Like",
                        modifier = Modifier
                            .clickable { counter++ }
                            .padding(start = 12.dp)
                    )
                    Text(
                        text = counter.toString(),
                        fontSize = 20.sp,
                        color = Color.White,
                        modifier = Modifier.padding(start = 8.dp)
                    )
                }

                Text(
                    text = stringResource(R.string.subject),
                    fontSize = 24.sp,
                    color = Color.White,
                    modifier = Modifier.fillMaxSize(),
                    textAlign = TextAlign.Center
                )

                Text(
                    text = stringResource(R.string.name),
                    fontSize = 20.sp,
                    color = Color.White,
                    modifier = Modifier.fillMaxSize(),
                    textAlign = TextAlign.Center
                )

                Text(
                    text = stringResource(R.string.last_name),
                    fontSize = 20.sp,
                    color = Color.White,
                    modifier = Modifier.fillMaxSize(),
                    textAlign = TextAlign.Center
                )

                LazyRow(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                ) {
                    item {
                        Image(
                            modifier = Modifier
                                .size(200.dp)
                                .fillMaxWidth()
                                .height(100.dp)
                                .padding(8.dp),
                            painter = painterResource(id = R.drawable.cui),
                            contentDescription = "Gato_1"
                        )
                        Image(
                            modifier = Modifier
                                .size(200.dp)
                                .fillMaxWidth()
                                .height(100.dp)
                                .padding(8.dp),
                            painter = painterResource(id = R.drawable.cui),
                            contentDescription = "Gato_1"
                        )
                        Image(
                            modifier = Modifier
                                .size(200.dp)
                                .fillMaxWidth()
                                .height(100.dp)
                                .padding(8.dp),
                            painter = painterResource(id = R.drawable.cui),
                            contentDescription = "Gato_1"
                        )
                        Image(
                            modifier = Modifier
                                .size(200.dp)
                                .fillMaxWidth()
                                .height(100.dp)
                                .padding(8.dp),
                            painter = painterResource(id = R.drawable.cui),
                            contentDescription = "Gato_1"
                        )
                        Image(
                            modifier = Modifier
                                .size(200.dp)
                                .fillMaxWidth()
                                .height(100.dp)
                                .padding(8.dp),
                            painter = painterResource(id = R.drawable.cui),
                            contentDescription = "Gato_1"
                        )
                        Image(
                            modifier = Modifier
                                .size(200.dp)
                                .fillMaxWidth()
                                .height(100.dp)
                                .padding(8.dp),
                            painter = painterResource(id = R.drawable.cui),
                            contentDescription = "Gato_1"
                        )
                        Image(
                            modifier = Modifier
                                .size(200.dp)
                                .fillMaxWidth()
                                .height(100.dp)
                                .padding(8.dp),
                            painter = painterResource(id = R.drawable.cui),
                            contentDescription = "Gato_1"
                        )
                        Image(
                            modifier = Modifier
                                .size(200.dp)
                                .fillMaxWidth()
                                .height(100.dp)
                                .padding(8.dp),
                            painter = painterResource(id = R.drawable.cui),
                            contentDescription = "Gato_1"
                        )
                        Image(
                            modifier = Modifier
                                .size(200.dp)
                                .fillMaxWidth()
                                .height(100.dp)
                                .padding(8.dp),
                            painter = painterResource(id = R.drawable.cui),
                            contentDescription = "Gato_1"
                        )
                        Image(
                            modifier = Modifier
                                .size(200.dp)
                                .fillMaxWidth()
                                .height(100.dp)
                                .padding(8.dp),
                            painter = painterResource(id = R.drawable.cui),
                            contentDescription = "Gato_1"
                        )
                        Image(
                            modifier = Modifier
                                .size(200.dp)
                                .fillMaxWidth()
                                .height(100.dp)
                                .padding(8.dp),
                            painter = painterResource(id = R.drawable.cui),
                            contentDescription = "Gato_1"
                        )
                        Image(
                            modifier = Modifier
                                .size(200.dp)
                                .fillMaxWidth()
                                .height(100.dp)
                                .padding(8.dp),
                            painter = painterResource(id = R.drawable.cui),
                            contentDescription = "Gato_1"
                        )
                        Image(
                            modifier = Modifier
                                .size(200.dp)
                                .fillMaxWidth()
                                .height(100.dp)
                                .padding(8.dp),
                            painter = painterResource(id = R.drawable.cui),
                            contentDescription = "Gato_1"
                        )
                        Image(
                            modifier = Modifier
                                .size(200.dp)
                                .fillMaxWidth()
                                .height(100.dp)
                                .padding(8.dp),
                            painter = painterResource(id = R.drawable.cui),
                            contentDescription = "Gato_1"
                        )
                    }
                }
            }
        }
    }
}
package com.clerdsonjuca.drive

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.clerdsonjuca.drive.ui.theme.DriveTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DriveTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Screen()
                }
            }
        }
    }
}

@Composable
fun Screen() {
    var state by remember { mutableStateOf(0) }
    var text by remember { mutableStateOf("Text") }
    val titles = listOf("Entrada", "Saida")
    Column {
        TopAppBar(

            title = { Text(text = "AppBar")},
            backgroundColor = Color.Cyan
            
                );
        Spacer(modifier = Modifier.padding(top = 50.dp))
        
        TabRow(
            selectedTabIndex = state
            ,
            backgroundColor = Color.White
        ) {
            titles.forEachIndexed { index, title ->
                Tab(
                    text = { Text(title) },
                    selected = state == index,
                    onClick = { state = index }
                )
            }
        }

        if(state+1 ==1){

            Column(
                modifier = Modifier.padding(top = 200.dp,start = 50.dp)


            ){
                Text(
                    text = "Numero da placa",
                    style = MaterialTheme.typography.body1
                    ,
                    textAlign = TextAlign.Start
                )


                TextField(
                    value = text,
                    onValueChange = {
                        text = it
                    },
                    label = { Text("Numero da placa") }
                )

    Button(

        onClick = { /*TODO*/ },
        modifier = Modifier.size(width = 280.dp,height = 60.dp),

                colors = ButtonDefaults.buttonColors(backgroundColor = Color.Green)
    ) {
        Text(text = "Confirmar Entrada")
    }



            }
        }
        if(state+1 ==2){

            Column(
                modifier = Modifier.padding(top = 200.dp,start = 50.dp)


            ){
                Text(
                    text = "Numero da placa",
                    style = MaterialTheme.typography.body1
                    ,
                    textAlign = TextAlign.Start
                )


                TextField(
                    value = text,
                    onValueChange = {
                        text = it
                    },
                    label = { Text("Numero da placa") }
                )

                Button(

                    onClick = { /*TODO*/ },
                    modifier = Modifier.size(width = 280.dp,height = 60.dp),

                            colors = ButtonDefaults.buttonColors(backgroundColor = Color.Gray)

                ) {
                    Text(text = "Pagamento")
                }
                Spacer(modifier = Modifier.padding(10.dp))
                Button(

                    onClick = { /*TODO*/ },
                    modifier = Modifier.size(width = 280.dp,height = 60.dp),


                            colors = ButtonDefaults.buttonColors(backgroundColor = Color.Green)
                ) {
                    Text(text = "Saida")
                }

                Spacer(modifier = Modifier.padding(10.dp))
                Button(

                    onClick = { /*TODO*/ },
                    modifier = Modifier.size(width = 280.dp,height = 60.dp),


                    colors = ButtonDefaults.buttonColors(backgroundColor = Color.White)
                ) {
                    Text(text = "Ver Hitorico")
                }


            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    DriveTheme {
        Screen()
    }
}
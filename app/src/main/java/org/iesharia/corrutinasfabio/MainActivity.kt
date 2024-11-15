package org.iesharia.corrutinasfabio

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Surface {
                Pantalla()
            }
        }
    }
}

@Composable
fun Pantalla() {
    val coroutineScope = rememberCoroutineScope()
    val context = LocalContext.current
    val contador: MutableState<Int> = remember { mutableStateOf(6) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(40.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = "Contador: ${contador.value}",
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(16.dp)
        )

        Button(
            onClick = {
                Toast.makeText(context, "Corrutina lanzada", Toast.LENGTH_SHORT).show()
                coroutineScope.launch {
                    for (i in 6 downTo 0) {
                        delay(1000)
                        contador.value = i
                    }
                    Toast.makeText(context, "Corrutina terminada", Toast.LENGTH_SHORT).show()
                }
            },
            modifier = Modifier
                .padding(16.dp)
                .size(120.dp),
        ) {
            Text(
                text = "Lanzar Corrutina",
                textAlign = TextAlign.Center
            )
        }
    }
}

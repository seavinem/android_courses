package com.example.businesscard

import android.graphics.Paint.Style
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme
import java.time.format.TextStyle

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting()
                }
            }
        }
    }
}

@Composable
fun Greeting() {
    MainInformation(
        image = painterResource(id = R.drawable.android_logo),
        name = "Kozlov Kirill Sergeevich",
        title = "Android Developer"
    )
    ContactInformation()
}

@Composable
fun MainInformation(image: Painter, name: String, title: String, modifier: Modifier = Modifier) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(0.80F),
        contentAlignment = Alignment.Center
    ){
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {

            Box(
                modifier = Modifier.padding(horizontal = 40.dp)
            )
            {
                Image(
                    painter = image,
                    contentDescription = null,
                )
            }
            Text(
                text = name,
                fontSize = 20.sp,
            )
            Text(
                text = title,
                fontSize = 20.sp
            )
        }
    }
}

@Composable
fun ContactInformation(modifier: Modifier = Modifier) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(0.95F),
        contentAlignment = Alignment.BottomCenter
    ) {
        Column(
            modifier = modifier.padding(10.dp),
            verticalArrangement = Arrangement.Bottom
        ) {
            Contact(
                icon = painterResource(R.drawable.baseline_call_black_48),
                tint = Color.Green,
                information = "+375(29)347-09-46"
            )
            Contact(
                icon = painterResource(R.drawable.baseline_send_black_48),
                tint = Color.Cyan,
                information = "tg: @michaelmcflore"
            )
            Contact(
                icon = painterResource(R.drawable.baseline_email_black_48),
                tint = Color.Gray,
                information = "Email: kirillkozlov@gmail.com"
            )
        }
    }
}

@Composable
fun Contact(icon: Painter, tint: Color, information: String, modifier: Modifier = Modifier) {
    Row {
        Icon(
            painter = icon,
            tint = tint,
            contentDescription = null,
        )
        Text(
            text = information,
            modifier = modifier.padding(horizontal = 15.dp),
            fontStyle = FontStyle.Normal
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    BusinessCardTheme {
        Greeting()
    }
}
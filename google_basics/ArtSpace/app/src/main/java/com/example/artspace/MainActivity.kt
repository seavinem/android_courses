package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspace.data.DataSource
import com.example.artspace.model.Artwork
import com.example.artspace.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ArtSpaceApp()
                }
            }
          }
    }
}

@Composable
fun ArtSpaceApp(modifier: Modifier = Modifier) {
    var pageID by remember { mutableIntStateOf(0) }
    val size = DataSource.artworks.size

    ArtworkLayout(
        artwork = DataSource.artworks[pageID],
        clickNext = {
            if(pageID == size-1) pageID = 0
            else pageID++
        },
        clickPrevious = {
            if(pageID == 0) pageID = size-1
            else pageID--
        },
        modifier = modifier
    )
}


@Composable
fun ArtworkLayout(
    artwork: Artwork,
    clickNext: () -> Unit,
    clickPrevious: () -> Unit,
    modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(32.dp))
        CreateImage(
            artwork = artwork
        )
        CreateDescription(
            artwork = artwork
        )
        Spacer(modifier = Modifier.height(32.dp))
        CreateButtons(
            clickNext = clickNext,
            clickPrevious = clickPrevious
        )
    }
}


@Composable
fun CreateImage(
    artwork: Artwork
) {
    Surface(
        modifier = Modifier
            .height(475.dp)
            .width(350.dp),
        shadowElevation = 8.dp
    ) {
        Image(
            painter = painterResource(id = artwork.artworkImage),
            contentDescription = null,
            modifier = Modifier.padding(32.dp)
        )
    }
}

@Composable
fun CreateDescription(
    artwork: Artwork
) {
    Surface(
        modifier = Modifier
            .height(150.dp)
            .width(350.dp)
            .padding(top = 32.dp),
        color = Color.LightGray
    ) {
        Column(
            modifier = Modifier.padding(10.dp)
        ) {
            Text(
                text = stringResource(id = artwork.title),
                fontSize = 28.sp,
                fontStyle = FontStyle.Normal
            )
            Text(
                text = stringResource(id = artwork.artist) + " (" +  artwork.year + ")",
                fontSize = 15.sp
            )
        }
    }
}

@Composable
fun CreateButtons(
    clickNext: () -> Unit,
    clickPrevious: () -> Unit
) {
    Row(
        modifier = Modifier.width(350.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Button(
            onClick = clickPrevious,
            modifier = Modifier
                .height(50.dp)
                .width(125.dp)
        ) {
            Text(
                text = "Previous",
                fontSize = 18.sp
            )

        }
        Button(
            onClick = clickNext,
            modifier = Modifier
                .height(50.dp)
                .width(125.dp)
        ) {
            Text(
                text = "Next",
                fontSize = 18.sp
            )
        }
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true)
@Composable
fun GreetingPreview() {
    ArtSpaceTheme {
        ArtworkLayout(
            artwork = DataSource.artworks[0],
            clickNext = {},
            clickPrevious = {},
            modifier = Modifier.fillMaxSize()
        )
    }
}
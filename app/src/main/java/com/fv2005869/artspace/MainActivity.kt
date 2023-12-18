package com.fv2005869.artspace


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.DefaultShadowColor
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.fv2005869.artspace.ui.theme.ArtSpaceTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceTheme {

                /*
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background,
                ) {
                    ArtSpaceAppPreview()
                }

                 */
            }
        }
    }
}

@Composable
fun ArtSpaceApp(modifier: Modifier = Modifier) {
    Row {
        Text(
            text = stringResource(id = R.string.app_name),
            fontSize = 30.sp,
            fontWeight = FontWeight.Black
        )
    }
}

@Composable
fun ViewImage(modifier: Modifier = Modifier) {

    Column(
        modifier = Modifier
            /*.border(2.dp, Color.Black, shape = RectangleShape)*/
            .padding(20.dp)
            .fillMaxWidth()
            .shadow(
                15.dp,
                RectangleShape,
                true,
                DefaultShadowColor,
                DefaultShadowColor
            ),
    ) {
        Image(
            painter = painterResource(id = R.drawable.o_pensador_august_rodin_c),
            contentDescription = null,
            contentScale = ContentScale.FillWidth,
            alignment = Alignment.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp)
        )
    }
}

@Composable
fun ViewInfo(modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            /*.border(width = 2.dp, Color.Black, shape = RectangleShape)*/
            .padding(10.dp),
        horizontalAlignment = Alignment.Start,
    ) {
        Text(
            text = "O Pensador",
            fontSize = 35.sp,
            fontWeight = FontWeight.Light,
        )
        Text(
            text = "August Rodin (1880)",
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp
        )
    }
}

@Composable
fun ViewButtons(modifier: Modifier = Modifier) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            /*.border(width = 2.dp, Color.Black, shape = RectangleShape)*/,
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        val buttonWidth = 120.dp
        Column {
            Button(
                onClick = {},
                modifier = Modifier.width(buttonWidth)
            ) {
                Text(text = "Voltar")
            }
        }
        Column {
            Spacer(modifier = Modifier)
        }
        Column {
            Button(
                onClick = {},
                modifier = Modifier.width(buttonWidth)
            ) {
                Text(
                    text = "Avançar"
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ArtSpaceAppPreview(modifier: Modifier = Modifier) {
    ArtSpaceTheme {
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(20.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            ArtSpaceApp()
            ViewImage()
            Spacer(modifier = Modifier)
            ViewInfo()
            Spacer(modifier = Modifier)
            ViewButtons()
        }

    }
}
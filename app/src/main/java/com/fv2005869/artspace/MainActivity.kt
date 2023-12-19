package com.fv2005869.artspace


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
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
                ArtSpaceAppPreview()
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
                .padding(20.dp)
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            ArtSpaceApp()
        }

    }
}

@Composable
fun ArtSpaceApp(modifier: Modifier = Modifier) {

    /* Imagem */
    var quadro by remember { mutableStateOf(0) }

    var tamMax = 4
    var imagem = 1
    var titulo = 1
    var autor = 1

    when (quadro) {
        0 -> {
            imagem = R.drawable.o_pensador_august_rodin_c
            titulo = R.string.titulo00
            autor = R.string.autor00
        }

        1 -> {
            imagem = R.drawable.pensador_mona_lisa_c
            titulo = R.string.titulo01
            autor = R.string.autor01
        }
        2 -> {
            imagem = R.drawable.girassois_vincent_van_gogh_c
            titulo = R.string.titulo02
            autor = R.string.autor02
        }
        3 -> {
            imagem = R.drawable.pensador_o_grito_c
            titulo = R.string.titulo03
            autor = R.string.autor03
        }
        4 -> {
            imagem = R.drawable.pensador_a_moca_com_brinco_de_perolas_c
            titulo = R.string.titulo04
            autor = R.string.autor04
        }

        else -> {
            imagem = R.drawable.o_pensador_august_rodin_c
            titulo = R.string.titulo01
            autor = R.string.autor01
        }
    }


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
            painter = painterResource(id = imagem),
            contentDescription = null,
            contentScale = ContentScale.FillWidth,
            alignment = Alignment.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp)
        )
    }

    Spacer(modifier = Modifier)

    /* texto */

    Column(
        modifier = Modifier
            .fillMaxWidth()
            /*.border(width = 2.dp, Color.Black, shape = RectangleShape)*/
            .padding(10.dp),
        horizontalAlignment = Alignment.Start,
    ) {
        Text(
            text = stringResource(id = titulo),
            fontSize = 35.sp,
            fontWeight = FontWeight.Light,
        )
        Text(
            text = stringResource(id = autor),
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp
        )
    }

    Spacer(modifier = Modifier)

    /* Botões */

    Row(
        modifier = Modifier
            .fillMaxWidth()
        /*.border(width = 2.dp, Color.Black, shape = RectangleShape)*/,
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        val buttonWidth = 120.dp
        Column {
            Button(
                onClick = {
                    if (quadro == 0) {
                        quadro = tamMax
                    } else {
                        quadro -= 1
                    }
                },
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
                onClick = {
                    if (quadro == tamMax) {
                        quadro = 0
                    } else {
                        quadro += 1
                    }
                },
                modifier = Modifier.width(buttonWidth)
            ) {
                Text(
                    text = "Avançar"
                )
            }
        }
    }

}
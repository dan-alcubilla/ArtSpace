package com.alexdan.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
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
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.alexdan.artspace.ui.theme.ArtSpaceTheme

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
                    SpaceArt()
                }
            }
        }
    }
}

@Composable
fun ArtworkWall(
    @DrawableRes artWorkImage: Int,
    modifier: Modifier = Modifier
) {
    Image(
        painter = painterResource(id = artWorkImage),
        contentDescription = null,
        modifier = modifier.padding(all = 15.dp),
        contentScale = ContentScale.Fit
    )
}

@Composable
fun ArtWorkDescriptor(
    @StringRes artWorkTitle: Int,
    @StringRes artWorkArtist: Int,
    @StringRes artWorkYear: Int,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.padding(all = 15.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.Start
    ) {
        Text(
            text = stringResource(artWorkTitle),
            color = Color.DarkGray,
            fontSize = 20.sp,
            fontStyle = FontStyle.Italic,
            fontWeight = FontWeight.Normal,
            fontFamily = FontFamily.SansSerif
        )
        Row {
            Text(
                text = stringResource(artWorkArtist),
                color = Color.Black,
                fontSize = 10.sp,
                fontStyle = FontStyle.Normal,
                fontWeight = FontWeight.Black,
                fontFamily = FontFamily.SansSerif,
                textAlign = TextAlign.Start
            )
            Text(
                text = stringResource(artWorkYear),
                modifier = modifier.padding(start = 3.dp),
                color = Color.Black,
                fontSize = 10.sp,
                fontStyle = FontStyle.Normal,
                fontWeight = FontWeight.Normal,
                fontFamily = FontFamily.SansSerif,
                textAlign = TextAlign.Start
            )
        }
    }
}

@Composable
fun SpaceArt() {
    val artWorkImage1 = R.drawable.the_starry_night
    val artWorkImage2 = R.drawable.the_scream
    val artWorkImage3 = R.drawable.the_mill
    val artWorkImage4 = R.drawable.las_meninas

    val artWorkTitle1 = R.string.the_starry_night
    val artWorkTitle2 = R.string.the_scream
    val artWorkTitle3 = R.string.the_mill
    val artWorkTitle4 = R.string.las_meninas

    val artWorkArtist1 = R.string.vincent_van_gogh
    val artWorkArtist2 = R.string.edvard_munch
    val artWorkArtist3 = R.string.rembrandt
    val artWorkArtist4 = R.string.diego_velazquez

    val artWorkYear1 = R.string.artwork1_year
    val artWorkYear2 = R.string.artwork2_year
    val artWorkYear3 = R.string.artwork3_year
    val artWorkYear4 = R.string.artwork4_year

    var currentArtWork = 1

    var artWorkImage by remember {
        mutableIntStateOf(artWorkImage1)
    }
    var artWorkTitle by remember {
        mutableIntStateOf(R.string.the_starry_night)
    }
    var artWorkArtist by remember {
        mutableIntStateOf(R.string.vincent_van_gogh)
    }
    var artWorkYear by remember {
        mutableIntStateOf(R.string.artwork1_year)
    }

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Surface(
            modifier = Modifier
                .height(450.dp)
                .width(400.dp)
                .padding(start = 15.dp, end = 15.dp),
            shape = RectangleShape,
            color = Color.White,
            shadowElevation = 30.dp,
            border = BorderStroke(1.dp, Color.LightGray)
        ) {
            ArtworkWall(artWorkImage = artWorkImage)
        }
        Spacer(modifier = Modifier.height(50.dp))
        Surface(
            modifier = Modifier
                .height(80.dp)
                .width(400.dp)
                .padding(start = 15.dp, end = 15.dp),
            shape = RectangleShape,
            color = Color.LightGray
        ) {
            ArtWorkDescriptor(
                artWorkTitle = artWorkTitle,
                artWorkArtist = artWorkArtist,
                artWorkYear = artWorkYear
            )
        }
        Spacer(modifier = Modifier.height(20.dp))
        Row {
            Button(
                onClick = {
                    when (currentArtWork) {
                        1 -> {
                            currentArtWork = 4
                            artWorkImage = artWorkImage4
                            artWorkTitle =  artWorkTitle4
                            artWorkArtist = artWorkArtist4
                            artWorkYear = artWorkYear4
                        }
                        2 -> {
                            currentArtWork = 1
                            artWorkImage = artWorkImage1
                            artWorkTitle =  artWorkTitle1
                            artWorkArtist = artWorkArtist1
                            artWorkYear = artWorkYear1
                          }
                        3 -> {
                            currentArtWork = 2
                            artWorkImage = artWorkImage2
                            artWorkTitle =  artWorkTitle2
                            artWorkArtist = artWorkArtist2
                            artWorkYear = artWorkYear2
                        }
                        4 -> {
                            currentArtWork = 3
                            artWorkImage = artWorkImage3
                            artWorkTitle =  artWorkTitle3
                            artWorkArtist = artWorkArtist3
                            artWorkYear = artWorkYear3
                        }
                    }
                },
                modifier = Modifier.width(160.dp)
            ) {
                Text(text = stringResource(R.string.previous))
            }
            Spacer(modifier = Modifier.width(40.dp))
            Button(
                onClick = {
                          when (currentArtWork) {
                              1 -> {
                                  currentArtWork = 2
                                  artWorkImage = artWorkImage2
                                  artWorkTitle =  artWorkTitle2
                                  artWorkArtist = artWorkArtist2
                                  artWorkYear = artWorkYear2
                              }
                              2 -> {
                                  currentArtWork = 3
                                  artWorkImage = artWorkImage3
                                  artWorkTitle =  artWorkTitle3
                                  artWorkArtist = artWorkArtist3
                                  artWorkYear = artWorkYear3
                              }
                              3 -> {
                                  currentArtWork = 4
                                  artWorkImage = artWorkImage4
                                  artWorkTitle =  artWorkTitle4
                                  artWorkArtist = artWorkArtist4
                                  artWorkYear = artWorkYear4
                              }
                              4 -> {
                                  currentArtWork = 1
                                  artWorkImage = artWorkImage1
                                  artWorkTitle =  artWorkTitle1
                                  artWorkArtist = artWorkArtist1
                                  artWorkYear = artWorkYear1
                              }
                          }
                },
                modifier = Modifier.width(160.dp)
            ) {
                Text(text = stringResource(R.string.next))
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SpaceArtPreview() {
    ArtSpaceTheme {
        SpaceArt()
    }
}
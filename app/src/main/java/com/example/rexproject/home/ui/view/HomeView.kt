package com.example.rexproject.home.ui.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.rexproject.R
import com.example.rexproject.home.ui.composables.ItemBottomBar
import com.example.rexproject.home.ui.composables.LifeBarGroup

@Composable
fun HomeView(
    modifier: Modifier = Modifier,
    username : String
) {
    val hp = 100
    val rexImg = when (hp) {
        in 100 downTo 88 -> R.drawable.rex6
        in 87 downTo 76 -> R.drawable.rex2
        in 75 downTo 64 -> R.drawable.rex5
        in 63 downTo 52 -> R.drawable.rex1
        in 51 downTo 40 -> R.drawable.rex4
        in 39 downTo 28 -> R.drawable.rex7
        in 27 downTo 16 -> R.drawable.rex9
        in 15 downTo 1 -> R.drawable.rex8
        else -> R.drawable.ic_launcher_foreground
    }
    Scaffold(
        containerColor = MaterialTheme.colorScheme.primaryContainer,
        topBar = { LifeBarGroup() },
        bottomBar = {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier
                    .height(100.dp)
                    .fillMaxWidth()
                    .background(MaterialTheme.colorScheme.inversePrimary)
            ) {
                ItemBottomBar(title = "Alimentalo", icon = R.drawable.meat)
                ItemBottomBar(title = "Limpialo", icon = R.drawable.sponge)
                ItemBottomBar(title = "Juega con el", icon = R.drawable.ball)
            }
        }
    ){
        Column(
            modifier = modifier
                .padding(it)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(rexImg),
                contentDescription = "Rex image",
                modifier = Modifier
                    .padding(16.dp)
                    .size(300.dp),
                contentScale = ContentScale.Fit
            )
            Text(
                text = username,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}
package com.example.rexproject.home.ui.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
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
import com.example.rexproject.shared.ui.LifeBar

@Composable
fun HomeView(
    modifier: Modifier = Modifier,
    username : String
) {
    Scaffold(
        containerColor = MaterialTheme.colorScheme.primaryContainer,
        topBar = {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = modifier
                    .padding(top = 20.dp)
                    .fillMaxWidth()
            ){
                LifeBar(percentage = 100, percentageTitle = "HP")
                LifeBar(percentage = 60, percentageTitle = "COMIDA")
                LifeBar(percentage = 40, percentageTitle = "CORDURA")
                LifeBar(percentage = 30, percentageTitle = "LIMPIEZA")
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
                painter = painterResource(R.drawable.rex6),
                contentDescription = "Rex image",
                modifier = Modifier
                    .padding(16.dp)
                    .size(300.dp),
                contentScale = ContentScale.Fit
            )
            Text(
                text = "Bienvenido $username",
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}
package com.example.rexproject.home.ui.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Snackbar
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

@Composable
fun HomeView(
    modifier: Modifier = Modifier,
    username : String
) {
    Scaffold(
        containerColor = MaterialTheme.colorScheme.primaryContainer,
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
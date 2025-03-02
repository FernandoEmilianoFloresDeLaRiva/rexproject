package com.example.rexproject.home.ui.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun LifeBarGroup(modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .padding(top = 50.dp)
            .fillMaxWidth()
    ){
        LifeBar(percentage = 100, percentageTitle = "HP")
        LifeBar(percentage = 60, percentageTitle = "COMIDA")
        LifeBar(percentage = 40, percentageTitle = "CORDURA")
        LifeBar(percentage = 30, percentageTitle = "LIMPIEZA")
    }
}
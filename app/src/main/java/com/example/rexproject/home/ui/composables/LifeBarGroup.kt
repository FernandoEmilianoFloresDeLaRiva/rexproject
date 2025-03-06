package com.example.rexproject.home.ui.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.rexproject.home.domain.adapters.DinoPetStatsAdapter

@Composable
fun LifeBarGroup(
    modifier: Modifier = Modifier,
    dinoPetStatsAdapter: DinoPetStatsAdapter
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .padding(top = 50.dp)
            .fillMaxWidth()
    ){
        LifeBar(percentage = dinoPetStatsAdapter.hp, percentageTitle = "HP")
        LifeBar(percentage = dinoPetStatsAdapter.food, percentageTitle = "COMIDA")
        LifeBar(percentage = dinoPetStatsAdapter.sanity, percentageTitle = "CORDURA")
        LifeBar(percentage = dinoPetStatsAdapter.clean, percentageTitle = "LIMPIEZA")
    }
}
package com.example.rexproject.shared.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun LifeBar(percentageTitle : String, percentage : Int) {
    val barColor = when {
        percentage > 70 -> Color.Green
        percentage in 40..70 -> Color.Yellow
        else -> Color.Red
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(7.dp)
    ) {
        Box(
            modifier = Modifier
                .height(20.dp)
                .width(400.dp)
                .background(
                    Color.Gray,
                    RoundedCornerShape(10.dp)
                )
        ) {
            Box(
                modifier = Modifier
                    .fillMaxHeight()
                    .width((400 * percentage / 100).dp)
                    .background(barColor,  RoundedCornerShape(10.dp))
            )
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,

                modifier = Modifier.padding( horizontal = 10.dp).fillMaxWidth()
            ){
                Text(text = percentageTitle, fontSize = 15.sp)
                Text(text = "$percentage%", fontSize = 18.sp)
            }
        }
    }
}
package com.example.rexproject.home.ui.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ItemBottomBar(
    modifier: Modifier = Modifier,
    title : String = "",
    icon : Int
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.padding(horizontal = 12.dp)
    ) {
        Image(
            painter = painterResource(id = icon),
            contentDescription = "Icon",
            modifier = modifier
                .padding(bottom = 8.dp)
                .size(24.dp)
        )
        Text(
            text = title,
            fontSize = 12.sp,
        )
    }
}
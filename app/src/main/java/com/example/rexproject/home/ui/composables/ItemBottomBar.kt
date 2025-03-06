package com.example.rexproject.home.ui.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ItemBottomBar(
    modifier: Modifier = Modifier,
    title : String = "",
    icon : Int,
    onClick : () -> Unit = {}
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .padding(horizontal = 12.dp)
            .clickable { onClick() }
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
            fontSize = 16.sp,
            color = MaterialTheme.colorScheme.primaryContainer,
            fontWeight = FontWeight.Bold
        )
    }
}
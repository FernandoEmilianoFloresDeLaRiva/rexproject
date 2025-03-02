package com.example.rexproject.create_user.ui.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.rexproject.create_user.ui.viewmodel.CreateUserViewModel
import com.example.rexproject.shared.data.states.viewmodel_manager.LocalViewModelProvider

@Composable
fun CreateUserView(
    modifier: Modifier = Modifier,
) {
    val createUserViewModel = LocalViewModelProvider.current.createUserViewModel
    val colorScheme = MaterialTheme.colorScheme

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(color = colorScheme.onSecondaryContainer)
            .padding(40.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){

        Text(
            text = "Crea tu username y comienza el cuidado de tu mascota :D",
            color = colorScheme.onPrimary,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            lineHeight = 28.sp
        )

        Spacer(modifier = modifier.height(50.dp))


        TextField(
            modifier = modifier.fillMaxWidth(),
            colors = TextFieldDefaults.colors(
                focusedContainerColor = colorScheme.primaryContainer,
                unfocusedContainerColor = colorScheme.surfaceContainer,
                cursorColor = colorScheme.primary,
                focusedIndicatorColor = colorScheme.primary,
                unfocusedIndicatorColor = Color.Transparent
            ),
            value = createUserViewModel.getUsername(),
            onValueChange = {createUserViewModel.setUsername(it)},
            label = { Text("Username") }
        )

        Spacer(modifier = modifier.height(50.dp))

        Button(
            onClick = { createUserViewModel.saveUsername() },
            modifier = modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
               containerColor = colorScheme.primaryContainer,
            ),
            shape = RoundedCornerShape(8.dp)
        ) {
            Text(
                "Crear username",
                color = colorScheme.onPrimaryContainer,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                lineHeight = 20.sp
            )
        }
    }
}
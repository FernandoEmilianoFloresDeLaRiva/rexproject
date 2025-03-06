package com.example.rexproject.home.ui.view

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
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
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.rexproject.R
import com.example.rexproject.home.ui.composables.ItemBottomBar
import com.example.rexproject.home.ui.composables.LifeBarGroup
import com.example.rexproject.shared.data.states.viewmodel_manager.LocalViewModelProvider
import com.example.rexproject.shared.utils.SoundManager

@RequiresApi(Build.VERSION_CODES.M)
@Composable
fun HomeView(
    modifier: Modifier = Modifier,
    username: String,
) {
    val ctx = LocalContext.current
    val homeViewModel = LocalViewModelProvider.current.homeViewModel

    var isClicked by remember { mutableStateOf(false) }
    val bounce = remember { Animatable(0f) }

    LaunchedEffect(Unit) {
        SoundManager.playBackground(context = ctx, soundRes = R.raw.background_music)
    }

    DisposableEffect(Unit) {
        onDispose {
            SoundManager.stopBackground()
        }
    }

    LaunchedEffect(isClicked) {
        if (isClicked) {
            bounce.animateTo(-20f, animationSpec = tween(300))
            bounce.animateTo(0f, animationSpec = tween(300))
            isClicked = false
        }
    }

    Scaffold(
        containerColor = MaterialTheme.colorScheme.surface,
        topBar = { LifeBarGroup(dinoPetStatsAdapter = homeViewModel.getDinoPetStats()) },
        bottomBar = {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier
                    .height(100.dp)
                    .fillMaxWidth()
                    .background(
                        brush = Brush.verticalGradient(
                            listOf(Color(0xFF4CAF50), Color(0xFF81C784))
                        )
                    ),
            ) {
                ItemBottomBar(
                    icon = R.drawable.meat,
                    title = "Alimentalo",
                    onClick = {
                        homeViewModel.increaseFood()
                        isClicked = true
                        SoundManager.playEffect(context = ctx, soundRes = R.raw.nom_nom_nom)
                    },
                    modifier = Modifier.scaleOnClick()
                )
                ItemBottomBar(
                    icon = R.drawable.sponge,
                    title = "Limpialo",
                    onClick = {
                        homeViewModel.increaseClean()
                        isClicked = true
                    },
                    modifier = Modifier.scaleOnClick()
                )
                ItemBottomBar(
                    icon = R.drawable.ball,
                    title = "Juega con él",
                    onClick = {
                        homeViewModel.increaseSanity()
                        isClicked = true
                    },
                    modifier = Modifier.scaleOnClick()
                )
            }
        }
    ) {
        Column(
            modifier = modifier
                .padding(it)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(homeViewModel.rexImg),
                contentDescription = "Rex image",
                modifier = Modifier
                    .padding(16.dp)
                    .size(300.dp),
                contentScale = ContentScale.Fit
            )
            Text(
                text = username,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                style = TextStyle(
                    shadow = Shadow(
                        color = Color.Gray,
                        offset = Offset(2f, 2f),
                        blurRadius = 4f
                    )
                ),
                color = Color.Black
            )
        }
    }
}

@Composable
fun Modifier.scaleOnClick(): Modifier {
    var isPressed by remember { mutableStateOf(false) }
    val scale = animateFloatAsState(if (isPressed) 1.1f else 1f, tween(200))

    return this
        .scale(scale.value)
        .pointerInput(Unit) {
            detectTapGestures(
                onPress = {
                    isPressed = true
                    tryAwaitRelease()
                    isPressed = false
                }
            )
        }
}

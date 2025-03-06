package com.example.rexproject.shared.utils

import android.content.Context
import android.media.MediaPlayer

object SoundManager {
    private var backgroundPlayer: MediaPlayer? = null
    private var effectPlayer: MediaPlayer? = null

    fun playBackground(context: Context, soundRes: Int) {
        if (backgroundPlayer == null) {
            backgroundPlayer = MediaPlayer.create(context, soundRes)
            backgroundPlayer?.isLooping = true
            backgroundPlayer?.start()
        }
    }

    fun playEffect(context: Context, soundRes: Int) {
        effectPlayer?.release()
        effectPlayer = MediaPlayer.create(context, soundRes)
        effectPlayer?.start()
    }

    fun stopBackground() {
        backgroundPlayer?.stop()
        backgroundPlayer?.release()
        backgroundPlayer = null
    }
}

package com.ricky.botreinar.presentation.treino_detalhe.components

import android.content.Context
import android.content.Context.VIBRATOR_SERVICE
import android.os.Build
import android.os.VibrationEffect
import android.os.Vibrator
import android.os.VibratorManager
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Pause
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.ProgressIndicatorDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat.getSystemService
import com.ricky.botreinar.common.Utils
import kotlinx.coroutines.delay

@Composable
fun TimerProgressBar(
    modifier: Modifier = Modifier,
    totalTime: Long,
    initialValue: Float = 1f,
) {

    val context = LocalContext.current

    val vibrator = context.getSystemService(Context.VIBRATOR_SERVICE) as Vibrator

    var value by remember {
        mutableStateOf(initialValue)
    }

    var currentTime by remember {
        mutableStateOf(totalTime)
    }

    var isTimerRunning by remember {
        mutableStateOf(false)
    }

    val progressAnimate by animateFloatAsState(
        targetValue = value,
        animationSpec = ProgressIndicatorDefaults.ProgressAnimationSpec,
        label = ""
    )

    LaunchedEffect(key1 = currentTime, key2 = isTimerRunning) {
        if (currentTime > 0 && isTimerRunning) {
            delay(100L)
            currentTime -= 100L
            value = currentTime / totalTime.toFloat()
        }
        if (currentTime <= 0 && isTimerRunning) {
            isTimerRunning = false
            val vibrationEffect1: VibrationEffect =
                VibrationEffect.createOneShot(1000, VibrationEffect.DEFAULT_AMPLITUDE)

            vibrator.cancel()
            vibrator.vibrate(vibrationEffect1)
        }
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = modifier
            .height(IntrinsicSize.Max)
            .clickable {
                if (currentTime <= 0L) {
                    currentTime = totalTime
                    isTimerRunning = true
                    value = 1f
                    vibrator.cancel()
                } else {
                    isTimerRunning = !isTimerRunning
                }
            }
    ) {
        Box(modifier = modifier.size(80.dp)) {
            CircularProgressIndicator(
                progress = progressAnimate,
                modifier = modifier.fillMaxSize()
            )
            Column(
                modifier = modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = Utils.formatTime(currentTime / 1000L),
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold,
                )
            }
        }
        Card(
            colors = CardDefaults.cardColors(
                containerColor = if (!isTimerRunning || currentTime <= 0L) {
                    Color.Green
                } else {
                    Color.Red
                }
            ),
            shape = RoundedCornerShape(10.dp),
            modifier = Modifier
                .padding(horizontal = 36.dp)

        ) {
            Icon(
                imageVector = if (!isTimerRunning) Icons.Default.PlayArrow else Icons.Default.Pause,
                contentDescription = null,
                modifier = Modifier
                    .padding(vertical = 4.dp, horizontal = 8.dp)

            )
        }

    }
}

@Preview
@Composable
fun TimerPreview() {
    TimerProgressBar(totalTime = 100L)
}


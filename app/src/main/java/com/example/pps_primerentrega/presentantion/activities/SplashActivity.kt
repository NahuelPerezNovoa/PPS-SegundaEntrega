package com.example.pps_primerentrega.presentantion.activities

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.pps_primerentrega.R
import com.example.pps_primerentrega.presentantion.ui.theme.PPSPrimerEntregaTheme
import com.example.pps_primerentrega.presentantion.ui.views.LoginView
import kotlinx.coroutines.delay

class SplashActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()

        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        setContent {
            PPSPrimerEntregaTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column(
                        modifier = Modifier.padding(innerPadding).fillMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.SpaceAround
                        ) {
                        val offsetXName = remember { Animatable(0f) }
                        LaunchedEffect(Unit) {
                            delay(1400)
                            offsetXName.animateTo(
                                targetValue = 2000f,
                                animationSpec = tween(durationMillis = 1000, easing = LinearOutSlowInEasing)
                            )
                        }

                        Text(
                            "Pérez Novoa Nahuel",
                            modifier = Modifier.padding(34.dp).fillMaxWidth().offset { IntOffset(offsetXName.value.toInt(), 0) },
                            style = MaterialTheme.typography.headlineMedium,
                            color = MaterialTheme.colorScheme.primary
                            )
                        Box(
                            contentAlignment = Alignment.Center
                        ) {
                            val composition by rememberLottieComposition(LottieCompositionSpec.Url("https://lottie.host/4f93691c-83cb-436a-8bd6-65369cbcf191/ckMDb0rbS2.lottie"))
                            val progress by animateLottieCompositionAsState(composition)
                            LottieAnimation(
                                modifier = Modifier.size(144.dp),
                                composition = composition,
                                progress = { progress },
                            )
                        }
                        val offsetXClass = remember { Animatable(0f) }
                        LaunchedEffect(Unit) {
                            delay(1400)
                            offsetXClass.animateTo(
                                targetValue = -2000f,
                                animationSpec = tween(durationMillis = 1000, easing = LinearOutSlowInEasing)
                            )
                        }
                        Text("PPS - 2025",
                            modifier = Modifier.padding(34.dp).fillMaxWidth().offset { IntOffset(offsetXClass.value.toInt(), 0) },
                            textAlign = TextAlign.End,
                            style = MaterialTheme.typography.headlineMedium,
                            color = MaterialTheme.colorScheme.primary
                        )
                    }
                }
            }
        }

        // Simula un tiempo de espera antes de abrir la siguiente actividad
        Thread {
            Thread.sleep(2000) // Espera 2 segundos
            runOnUiThread {
                startActivity(Intent(this, LoginActivity::class.java))
                finish()
            }
        }.start()
    }
}

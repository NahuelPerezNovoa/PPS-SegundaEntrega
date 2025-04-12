package com.example.pps_primerentrega.presentantion.activities

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.example.pps_primerentrega.R
import com.example.pps_primerentrega.presentantion.ui.theme.PPSPrimerEntregaTheme
import com.example.pps_primerentrega.presentantion.ui.views.LoginView

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
                        Text(
                            "Pérez Novoa Nahuel",
                            modifier = Modifier.padding(34.dp).fillMaxWidth(),
                            style = MaterialTheme.typography.headlineMedium,
                            color = MaterialTheme.colorScheme.primary
                            )
                        Box(
                            contentAlignment = Alignment.Center
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.ic_app), // Cambia `logo_app` por tu recurso de imagen
                                contentDescription = "Logo de la aplicación",
                                modifier = Modifier.size(128.dp)
                            )
                        }
                        Text("PPS - 2025",
                            modifier = Modifier.padding(34.dp).fillMaxWidth(),
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

package com.example.pps_primerentrega.presentantion.activities

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ButtonDefaults.ContentPadding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.ViewModelProvider
import coil.compose.AsyncImage
import coil.compose.rememberAsyncImagePainter
import com.example.pps_primerentrega.data.models.UserCredential
import com.example.pps_primerentrega.presentantion.ui.theme.PPSPrimerEntregaTheme
import com.example.pps_primerentrega.presentantion.ui.views.LoginView
import com.example.pps_primerentrega.presentantion.viewmodels.SessionViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LoginActivity : ComponentActivity() {

    private lateinit var viewModel: SessionViewModel
    private var usersCredentials: List<UserCredential> = listOf(
        UserCredential("prueba1@gmail.com","Qwer1234!","https://mighty.tools/mockmind-api/content/human/80.jpg"),
        UserCredential("prueba2@gmail.com","Qwer1234!","https://mighty.tools/mockmind-api/content/human/97.jpg"),
        UserCredential("prueba3@gmail.com","Qwer1234!","https://mighty.tools/mockmind-api/content/human/102.jpg")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this)[SessionViewModel::class.java]
        viewModel.user.observe(this){
            Log.wtf("LoginActivity", "User: $it")
            if(it != null){
                this.startActivity(Intent(this, MainActivity::class.java))
                this.finish()
            }
        }
        enableEdgeToEdge()
        setContent {
            PPSPrimerEntregaTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    LoginView (
                        modifier = Modifier.padding(innerPadding),
                        usersCredentials = usersCredentials,
                        viewModel = viewModel
                    )
                }
            }
        }
    }
}

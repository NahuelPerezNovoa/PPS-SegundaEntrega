package com.example.pps_primerentrega.presentantion.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.pps_primerentrega.data.models.UserCredential


@Composable
fun UserButtonView(userCredential: UserCredential, onClick: () -> Unit) {
    Box(
        modifier = Modifier
            .size(76.dp) // Tamaño del botón
            .clip(CircleShape)
            .clickable { onClick() }
    ) {
        Image(
            painter = rememberAsyncImagePainter(userCredential.image),
            contentDescription = "Imagen de perfil",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxSize()
                .clip(CircleShape)
        )
    }
}
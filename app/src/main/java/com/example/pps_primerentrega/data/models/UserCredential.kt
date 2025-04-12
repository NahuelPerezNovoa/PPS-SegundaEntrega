package com.example.pps_primerentrega.data.models

data class UserCredential(
    val email: String,
    val password: String,
    val image: String? = null
)
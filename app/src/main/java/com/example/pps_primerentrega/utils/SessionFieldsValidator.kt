package com.example.pps_primerentrega.utils

object SessionFieldsValidator {
    fun validateEmail(email: String): String? {
        if (email.isEmpty()) {
            return "El correo electrónico no puede estar vacío"
        }
        val emailRegex = Regex("^[A-Za-z](.*)([@]{1})(.{1,})(\\.)(.{1,})")
        if (!emailRegex.matches(email)) {
            return "El correo electrónico no es válido. Ej: usuario@example.com"
            }
        return null
    }

    fun validatePassword(password: String): String? {
        if (password.length < 8) {
            return "La contraseña debe tener al menos 8 caracteres"
        }
        if (!password.any { it.isUpperCase() }) {
            return "La contraseña debe contener al menos una letra mayúscula"
        }
        if (!password.any { it.isLowerCase() }) {
            return "La contraseña debe contener al menos una letra minúscula"
        }
        if (!password.any { it.isDigit() }) {
            return "La contraseña debe contener al menos un número"
        }
        if (!password.any { !it.isLetterOrDigit() }) {
            return "La contraseña debe contener al menos un carácter especial"
        }
        return null
    }
}
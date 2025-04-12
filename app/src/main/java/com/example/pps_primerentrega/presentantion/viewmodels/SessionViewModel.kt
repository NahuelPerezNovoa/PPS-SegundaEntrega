package com.example.pps_primerentrega.presentantion.viewmodels
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pps_primerentrega.utils.FirebaseAuthErrorHandler
import com.example.pps_primerentrega.utils.SessionFieldsValidator
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.auth
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class SessionViewModel: ViewModel() {

    var user : MutableLiveData<FirebaseUser?>
    private set

    var emailError: MutableLiveData<String?> = MutableLiveData(null)
    var passwordError: MutableLiveData<String?> = MutableLiveData(null)
    var authError: MutableLiveData<String?> = MutableLiveData(null)

    private val auth = Firebase.auth

    init {
        user = MutableLiveData(auth.currentUser)
    }

    fun signUp(email: String, password: String){
        viewModelScope.launch {
            withContext(Dispatchers.Main) {
                emailError.value = SessionFieldsValidator.validateEmail(email)
                passwordError.value = SessionFieldsValidator.validatePassword(password)
            }

            if(emailError.value != null || passwordError.value != null){
                return@launch
            }
            auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        authError.value = null
                        user.value = auth.currentUser
                    } else {
                        authError.value = FirebaseAuthErrorHandler.getErrorMessage(task.exception!!)
                    }
                }
        }
    }

    fun login(email: String, password: String){
        viewModelScope.launch {
            withContext(Dispatchers.Main) {
                emailError.value = SessionFieldsValidator.validateEmail(email)
                passwordError.value = SessionFieldsValidator.validatePassword(password)
            }

            if(emailError.value != null || passwordError.value != null){
                return@launch
            }
            auth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        authError.value = null
                        user.value = auth.currentUser
                    } else {
                        authError.value = FirebaseAuthErrorHandler.getErrorMessage(task.exception!!)
                    }
                }
        }
    }

    suspend fun logOut(){
        auth.signOut()
        withContext(Dispatchers.Main){
            user.value = null
        }
    }
}
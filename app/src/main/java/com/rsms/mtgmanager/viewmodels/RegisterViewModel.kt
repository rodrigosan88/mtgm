package com.rsms.mtgmanager.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.rsms.mtgmanager.domain.LoginResult
import com.rsms.mtgmanager.domain.Registration
import com.rsms.mtgmanager.domain.User
import com.rsms.mtgmanager.interactors.RegistrationInteractor
import com.rsms.mtgmanager.interactors.UserInteractor
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.Exception
import kotlin.coroutines.CoroutineContext

class RegisterViewModel( val app: Application) : AndroidViewModel(app), CoroutineScope {

    override val coroutineContext: CoroutineContext = Dispatchers.Main

    private val interactor = RegistrationInteractor(app.applicationContext)

    val username: MutableLiveData<String> = MutableLiveData("")
    val password: MutableLiveData<String> = MutableLiveData("")
    val repeatPassword: MutableLiveData<String> = MutableLiveData("")
    val registrationResult: MutableLiveData<LoginResult> = MutableLiveData<LoginResult>()

    fun registerUser(){
        val registration = Registration(this.username.value.toString(), this.password.value.toString(), this.repeatPassword.value.toString())

        launch {
            try {
                registrationResult.value = interactor.validateRegistrationData(registration)
            } catch (e: Exception) {
                val res = LoginResult("fail", e.localizedMessage)
                registrationResult.value = res
            }
        }

    }

}
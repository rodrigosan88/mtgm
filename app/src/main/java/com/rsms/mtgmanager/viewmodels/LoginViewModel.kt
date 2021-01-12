package com.rsms.mtgmanager.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.rsms.mtgmanager.domain.LoginResult
import com.rsms.mtgmanager.domain.User
import com.rsms.mtgmanager.interactors.UserInteractor
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.Exception
import kotlin.coroutines.CoroutineContext

class LoginViewModel( val app: Application) : AndroidViewModel(app), CoroutineScope {

    override val coroutineContext: CoroutineContext = Dispatchers.Main

    private val interactor = UserInteractor(app.applicationContext)

    val username: MutableLiveData<String> = MutableLiveData("")
    val password: MutableLiveData<String> = MutableLiveData("")
    val loginResult: MutableLiveData<LoginResult> = MutableLiveData<LoginResult>()

    fun validateUser(){
        val user : User = User(this.username.value.toString(), this.password.value.toString())

        launch {
            try {
                loginResult.value = interactor.validateUserCredentials(user)
            } catch (e: Exception) {
                val res = LoginResult("fail", e.localizedMessage)
                loginResult.value = res
            }
        }

    }

}
package com.rsms.mtgmanager.interactors

import android.content.Context
import android.util.Patterns
import com.rsms.mtgmanager.R
import com.rsms.mtgmanager.domain.LoginResult
import com.rsms.mtgmanager.domain.Registration
import com.rsms.mtgmanager.domain.User
import com.rsms.mtgmanager.repositories.network.services.AuthService
import java.lang.Exception

class RegistrationInteractor(private val context: Context) {

    private val authService = AuthService(context)

    suspend fun validateRegistrationData(registration: Registration?): LoginResult {
        if(registration == null) {
            throw Exception(context.getString(R.string.msg_user_blank))
        }

        if(registration.username.isBlank()){
            throw Exception(context.getString(R.string.msg_username_blank))
        }

        if(!Patterns.EMAIL_ADDRESS.matcher(registration.username).matches()){
            throw Exception(context.getString(R.string.msg_username_pattern))
        }

        if(registration.password.isBlank()) {
            throw Exception(context.getString(R.string.msg_password_blank))
        }

        if(registration.password.length < 6) {
            throw Exception(context.getString(R.string.msg_password_length))
        }

        if(registration.password != registration.repeatPassword){
            throw Exception(context.getString(R.string.msg_password_length))
        }

        return this.authService.registerWithEmailAndPassword(registration.username, registration.password)
    }

}
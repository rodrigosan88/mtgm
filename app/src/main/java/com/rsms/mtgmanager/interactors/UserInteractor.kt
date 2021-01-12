package com.rsms.mtgmanager.interactors

import android.content.Context
import android.util.Log
import android.util.Patterns
import com.rsms.mtgmanager.R
import com.rsms.mtgmanager.domain.LoginResult
import com.rsms.mtgmanager.domain.User
import com.rsms.mtgmanager.repositories.network.services.AuthService
import java.lang.Exception

class UserInteractor(private val context: Context) {

    private val authService = AuthService(context)

    suspend fun validateUserCredentials(user: User?): LoginResult{

        if(user == null) {
            throw Exception(context.getString(R.string.msg_user_blank))
        }

        if(user.username.isBlank()){
            throw Exception(context.getString(R.string.msg_username_blank))
        }

        if(!Patterns.EMAIL_ADDRESS.matcher(user.username).matches()){
            throw Exception(context.getString(R.string.msg_username_pattern))
        }

        if(user.password.isBlank()) {
            throw Exception(context.getString(R.string.msg_password_blank))
        }

        if(user.password.length < 6) {
            throw Exception(context.getString(R.string.msg_password_length))
        }

        return authService.loginWithEmailAndPassword(user.username, user.password)
    }
}
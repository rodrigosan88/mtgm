package com.rsms.mtgmanager.repositories.network.services

import android.content.Context
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.rsms.mtgmanager.R
import com.rsms.mtgmanager.domain.LoginResult
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

class AuthService (private val context: Context) {

    private val auth = Firebase.auth

    suspend fun loginWithEmailAndPassword(email: String, password: String) : LoginResult = suspendCoroutine {nextStep ->

        val operation = auth.signInWithEmailAndPassword(email, password)

        operation.addOnCompleteListener { op ->
            val res = if(op.isSuccessful) {
                LoginResult("success", context.getString(R.string.msg_login_success))
            } else {
                LoginResult("fail", op.exception?.localizedMessage)
            }
            nextStep.resume(res)
        }
    }

}
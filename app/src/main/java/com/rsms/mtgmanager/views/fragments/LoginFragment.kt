package com.rsms.mtgmanager.views.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.rsms.mtgmanager.R
import com.rsms.mtgmanager.databinding.FragmentLoginBinding
import com.rsms.mtgmanager.domain.User
import com.rsms.mtgmanager.viewmodels.LoginViewModel

class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding

    private val viewModel: LoginViewModel by lazy {
        ViewModelProvider(this).get(LoginViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        binding.fragment = this
        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        viewModel.loginResult.observe(viewLifecycleOwner) {result ->
            when(result.status) {
                "success" -> {
                    Toast.makeText(context, result.message, Toast.LENGTH_LONG).show()
                    findNavController().navigate(R.id.action_loginFragment_to_dashboardFragment)
                }
                else -> {
                    Toast.makeText(context, result.message, Toast.LENGTH_LONG).show()
                }
            }
        }

        return binding.root
    }

    fun signInUser(){
        this.viewModel.validateUser();
    }

}
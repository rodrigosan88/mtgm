package com.rsms.mtgmanager.views.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.rsms.mtgmanager.R
import com.rsms.mtgmanager.databinding.FragmentLoginBinding
import com.rsms.mtgmanager.databinding.FragmentRegistrationBinding
import com.rsms.mtgmanager.viewmodels.LoginViewModel
import com.rsms.mtgmanager.viewmodels.RegisterViewModel

class RegistrationFragment : Fragment() {


    private lateinit var binding: FragmentRegistrationBinding

    private val viewModel: RegisterViewModel by lazy {
        ViewModelProvider(this).get(RegisterViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRegistrationBinding.inflate(inflater, container, false)
        binding.fragment = this
        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        viewModel.registrationResult.observe(viewLifecycleOwner) {result ->
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

    fun registerUser(){
        this.viewModel.registerUser()
    }

}
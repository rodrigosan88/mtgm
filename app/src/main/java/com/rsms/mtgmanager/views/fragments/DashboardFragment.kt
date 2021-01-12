package com.rsms.mtgmanager.views.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.rsms.mtgmanager.R
import com.rsms.mtgmanager.databinding.FragmentDashboardBinding

class DashboardFragment : Fragment() {

    private lateinit var binding: FragmentDashboardBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDashboardBinding.inflate(inflater, container, false)
        binding.fragment = this
        return binding.root
    }

    fun cardsList(){
        findNavController().navigate(R.id.action_dashboardFragment_to_cardsActivity)
    }

    fun setsList(){
        findNavController().navigate(R.id.action_dashboardFragment_to_setsActivity)
    }
}
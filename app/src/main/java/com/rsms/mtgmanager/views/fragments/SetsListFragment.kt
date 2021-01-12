package com.rsms.mtgmanager.views.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.rsms.mtgmanager.R
import com.rsms.mtgmanager.domain.Set
import com.rsms.mtgmanager.repositories.network.services.MTGService
import com.rsms.mtgmanager.views.adapters.SetsAdapter
import kotlinx.android.synthetic.main.activity_sets.*
import kotlinx.android.synthetic.main.fragment_sets_list.*
import kotlinx.coroutines.launch

class SetsListFragment : Fragment() {

    lateinit var sets: ArrayList<Set>

    private lateinit var mtgService: MTGService

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_sets_list, container, false)

        this.mtgService = MTGService(requireContext())

        lifecycleScope.launch() {
            val result = mtgService.getSets() as ArrayList<Set>
            sets = result
            onResult(sets)
        }

        return view
    }

    private fun onResult(setList: ArrayList<Set>) {
        val setsAdapter = SetsAdapter(requireContext().applicationContext, setList)
        rvSets.adapter = setsAdapter
        rvSets.layoutManager = LinearLayoutManager(requireContext())
    }

}
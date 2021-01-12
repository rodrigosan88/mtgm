package com.rsms.mtgmanager.views.activities

import android.content.Context
import android.os.Bundle
import android.util.AttributeSet
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.rsms.mtgmanager.R
import com.rsms.mtgmanager.domain.Set
import com.rsms.mtgmanager.repositories.network.services.MTGService
import com.rsms.mtgmanager.viewmodels.SetsViewModel
import com.rsms.mtgmanager.views.adapters.SetsAdapter
import kotlinx.android.synthetic.main.activity_sets.*
import kotlinx.coroutines.launch

class SetsActivity : AppCompatActivity() {

//    lateinit var sets: ArrayList<Set>

//    private lateinit var mtgService: MTGService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sets)

//        this.mtgService = MTGService(this)
//
//        lifecycleScope.launch() {
//            val result = mtgService.getSets() as ArrayList<Set>
//            sets = result
//            onResult(sets)
//        }
    }

//    private fun onResult(setList: ArrayList<Set>) {
//        val setsAdapter = SetsAdapter(this.applicationContext, setList)
//        rvSets.adapter = setsAdapter
//        rvSets.layoutManager = LinearLayoutManager(this)
//    }
}
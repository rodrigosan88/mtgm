package com.rsms.mtgmanager.views.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.rsms.mtgmanager.R
import com.rsms.mtgmanager.domain.Set
import kotlinx.android.synthetic.main.set_item.*

class SetDetailFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_set_detail, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setName.text = (arguments?.getSerializable("selectedSet") as Set).name
    }
}
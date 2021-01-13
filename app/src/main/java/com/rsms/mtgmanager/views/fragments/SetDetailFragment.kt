package com.rsms.mtgmanager.views.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.rsms.mtgmanager.R
import com.rsms.mtgmanager.domain.Set
import kotlinx.android.synthetic.main.fragment_set_detail.*

class SetDetailFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_set_detail, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val set = (arguments?.getSerializable("selectedSet") as Set)
        tvSetName.text = set.name
        tvSetCode.text = set.code
        tvSetType.text = set.type
        tvSetReleaseDate.text = set.releaseDate.toString()
    }
}
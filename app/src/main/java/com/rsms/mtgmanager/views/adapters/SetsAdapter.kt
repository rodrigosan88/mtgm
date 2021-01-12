package com.rsms.mtgmanager.views.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.rsms.mtgmanager.R
import com.rsms.mtgmanager.domain.Card
import com.rsms.mtgmanager.domain.Set

class SetsAdapter(val context: Context, private val sets: List<Set>) :
    RecyclerView.Adapter<SetsAdapter.SetsViewHolder>() {

    class SetsViewHolder(val listItemView: View) : RecyclerView.ViewHolder(listItemView) {
        val setName = listItemView.findViewById<TextView>(R.id.setName)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SetsViewHolder {
        val inflater = LayoutInflater.from(parent.context)

        val setsView = inflater.inflate(R.layout.set_item, parent, false)

        return SetsViewHolder(setsView)
    }

    override fun onBindViewHolder(viewHolder: SetsAdapter.SetsViewHolder, position: Int) {
        val set: Set = sets[position]
        viewHolder.setName.text = set.name
        viewHolder.itemView.setOnClickListener {
            val navController = Navigation.findNavController(viewHolder.itemView)
            val bundle = bundleOf("selectedSet" to set)
            navController!!.navigate(R.id.action_setsListFragment2_to_setDetailFragment, bundle)
        }
    }

    override fun getItemCount(): Int {
        return sets.size
    }
}
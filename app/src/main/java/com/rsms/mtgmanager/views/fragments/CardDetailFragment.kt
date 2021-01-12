package com.rsms.mtgmanager.views.fragments

import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import com.rsms.mtgmanager.R
import com.rsms.mtgmanager.domain.Card
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_card_detail.*

class CardDetailFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_card_detail, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val card = (arguments?.getSerializable("selectedCard") as Card)
        tvCardName.text = card.name
        tvDescription.text = card.text
        Picasso.get().load(card.imageUrl).resize(900,1300).centerCrop().into(ivCardImage)
    }



}
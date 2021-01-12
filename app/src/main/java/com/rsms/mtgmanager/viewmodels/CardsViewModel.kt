package com.rsms.mtgmanager.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.rsms.mtgmanager.domain.Card
import com.rsms.mtgmanager.interactors.CardsInteractor
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class CardsViewModel( val app: Application) : AndroidViewModel(app), CoroutineScope {
    override val coroutineContext: CoroutineContext = Dispatchers.Main

    val cardList: MutableLiveData<ArrayList<Card>> = MutableLiveData<ArrayList<Card>>()

    private val cardsInteractor = CardsInteractor(app.applicationContext)

    fun recoverCards(){
        launch {
            cardList.value = cardsInteractor.recoverCards()
        }
    }
}
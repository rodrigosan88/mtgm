package com.rsms.mtgmanager.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.rsms.mtgmanager.domain.Set
import com.rsms.mtgmanager.interactors.SetsInteractor
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class SetsViewModel( val app: Application) : AndroidViewModel(app), CoroutineScope {
    override val coroutineContext: CoroutineContext = Dispatchers.Main

    val setList: MutableLiveData<ArrayList<Set>> = MutableLiveData<ArrayList<Set>>()

    private val setsInteractor = SetsInteractor(app.applicationContext)

    fun recoverSets(){
        launch {
            setList.value = setsInteractor.recoverSets()
        }
    }
}
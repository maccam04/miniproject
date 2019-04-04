package com.macsanityapps.capsl.navigation.gamelist

import androidx.databinding.ObservableArrayList
import androidx.databinding.ObservableBoolean
import com.macsanityapps.base.core.BaseViewModel
import com.macsanityapps.capsl.domain.model.GameListResult
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class GameListViewModel(private val gameListRepository: GameListRepository) : BaseViewModel() {

    val state = State()

    fun list() {
        if (state.loading.get() || state.loaded.get()) return
        state.loading.set(true)

        gameListRepository.list()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    state.gameList.clear()

                    it.results?.let { data -> state.gameList.addAll(data) }

                    state.loading.set(false)
                    state.loaded.set(true)
                },
                {
                    //Timber.e(it, "Failed to load notes")
                    state.loading.set(false)
                }
            )
            .addToDispose()
    }

    class State {
        val gameList = ObservableArrayList<GameListResult>()
        val loading = ObservableBoolean()
        val loaded = ObservableBoolean()
    }

}
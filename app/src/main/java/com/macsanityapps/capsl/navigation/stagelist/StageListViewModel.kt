package com.macsanityapps.capsl.navigation.stagelist

import androidx.databinding.ObservableArrayList
import androidx.databinding.ObservableBoolean
import com.macsanityapps.base.core.BaseViewModel
import com.macsanityapps.capsl.domain.model.StageListResult
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class StageListViewModel(private val stageListRepository: StageListRepository) : BaseViewModel() {

    val state = State()

    fun list() {
        if (state.loading.get() || state.loaded.get()) return
        state.loading.set(true)

        stageListRepository.list()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    //Timber.d("Notes loaded")
                    state.stageList.clear()

                    it.results?.let { data -> state.stageList.addAll(data) }

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
        val stageList = ObservableArrayList<StageListResult>()
        val loading = ObservableBoolean()
        val loaded = ObservableBoolean()
    }


}
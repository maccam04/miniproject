package com.macsanityapps.base.core

import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

abstract class BaseViewModel : ViewModel() {

    private val dispose = CompositeDisposable()

    override fun onCleared() {
        super.onCleared()
        dispose.clear()
    }

    fun Disposable.addToDispose() =
            dispose.add(this)



}
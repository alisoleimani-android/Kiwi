package com.kiwi.android.core

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

inline fun CoroutineScope.createExceptionHandler(
    crossinline action: (throwable: Throwable) -> Unit
) = CoroutineExceptionHandler { _, throwable ->
    throwable.printStackTrace()

    /**
     * A [CoroutineExceptionHandler] can be called from any thread. So, if [action] is supposed to
     * run in the main thread, you need to be careful and call this function on the a scope that
     * runs in the main thread, such as a viewModelScope.
     */
    launch {
        action(throwable)
    }
}

inline fun <T> Flow<T>.collectOn(
    coroutineScope: CoroutineScope,
    crossinline onCollected: (T) -> Unit
) {
    coroutineScope.launch {
        this@collectOn.collect {
            onCollected(it)
        }
    }
}

inline fun <T> Flow<T>.collectOn(
    lifecycleOwner: LifecycleOwner,
    crossinline onCollected: (T) -> Unit
) {
    lifecycleOwner.lifecycleScope.launch {
        this@collectOn
            .flowWithLifecycle(lifecycleOwner.lifecycle, Lifecycle.State.STARTED)
            .collect {
                onCollected(it)
            }
    }
}
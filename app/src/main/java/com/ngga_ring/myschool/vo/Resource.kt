package com.zenwel.pos.vo

import android.app.Activity
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.databinding.ObservableBoolean
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.kaopiz.kprogresshud.KProgressHUD
import com.zenwel.pos.R
import com.zenwel.pos.utils.AdaptiveRVAdapter
import com.zenwel.pos.utils.parseError
import com.zenwel.pos.utils.setHud
import com.zenwel.pos.utils.zenToast
import com.zenwel.pos.vo.Status.*
import timber.log.Timber

/**
 * A generic class that holds a value with its loading status.
 * @param <T>
</T> */
data class Resource<out T>(val status: Status, val data: T?, val message: String?) {
    private var hud: KProgressHUD? = null
    private var loadingObs: ObservableBoolean? = null
    private var loadingAction: (()-> Unit)? = null
    private var errorAction: (()-> Unit)? = null
    private var emptyAction: (()-> Unit)? = null
    private val argsForLoadingCondition = ArrayList<Any>()

    /**
     * Pass your [KProgressHUD] here to automatically show/dismiss it based on [Resource.status]
     */
    fun setLoading(mHud: KProgressHUD) = apply { hud = mHud }
    /**
     * Pass your [ObservableBoolean] here to automatically set true/false based on [Resource.status]
     */
    fun setLoading(mLoadingObs: ObservableBoolean) = apply { loadingObs = mLoadingObs }
    /**
     * Pass any of your loading property such as ViewGroup, View, ObservableField, etc.
     * Supported args -> [SwipeRefreshLayout],[ObservableBoolean],[KProgressHUD],[View],[ViewGroup]
     */
    fun addArgsForLoadingCondition(vararg args: Any) = apply {
        argsForLoadingCondition.run {
            args.forEach {
                when(it){
                    is KProgressHUD -> hud = it
                    is ObservableBoolean -> loadingObs = it
                    else -> if (it.noDuplicateArgs()) add(it)
                }
            }

            hud?.let { if (it.noDuplicateArgs()) add(it) }
            loadingObs?.let { if (it.noDuplicateArgs()) add(it) }
        }
    }
    /**
     * Set action when api result is [Status.LOADING]
     * @param action action when api result is [Status.LOADING]
     */
    fun setLoadingAction(action: ()->Unit) = apply {
        loadingAction = action
    }

    /**
     * Set action when api result is [Status.ERROR]
     * @param action action when api result is [Status.ERROR]
     */
    fun setErrorAction(action: ()->Unit) = apply {
        errorAction = action
    }

    /**
     * Set action when api result is [Status.EMPTY]
     * @param action action when api result is [Status.EMPTY]
     */
    fun setEmptyAction(action: ()->Unit) = apply {
        emptyAction = action
    }

    /**
     * Convenient way to set action from observing api call result.
     * You can [setLoadingAction],[setErrorAction],and [setEmptyAction] before call this function.
     * @param successAction action when api result is [Status.SUCCESS]
     */
    fun doResult(act: Activity, successAction: ()-> Unit) = act.run {
        setLoadingHud(act)
        addArgsForLoadingCondition()

        when(status){
            LOADING -> if (loadingAction == null){
                if (argsForLoadingCondition.isNotLoading()) {
                    loadingObs?.set(true) ?: hud?.show()
                } else return@run
            }else loadingAction?.invoke()
            SUCCESS -> {
                argsForLoadingCondition.setAllOffFromLoading()
                successAction()
            }
            ERROR -> {
                argsForLoadingCondition.setAllOffFromLoading()
                if (errorAction == null) {
                    parseError(message)
                } else errorAction?.invoke()
            }
            EMPTY -> {
                argsForLoadingCondition.setAllOffFromLoading()
                if (emptyAction == null) {
                    parseError(message)
                } else emptyAction?.invoke()
            }
            DISCONNECTED -> {
                argsForLoadingCondition.setAllOffFromLoading()
                zenToast(getString(R.string.disconnected_alert_message), status)
            }
            else -> argsForLoadingCondition.setAllOffFromLoading()
        }
    }

    private fun setLoadingHud(act: Activity){
        hud = if (loadingObs == null) {
            hud ?: act.setHud()
        } else null
    }
    private fun Any.noDuplicateArgs() = argsForLoadingCondition.find { it == this } == null
    private fun List<Any>.isNotLoading() = filter { it.getNotLoadingCondition() }.isNotEmpty()
    private fun Any.getNotLoadingCondition() =
        when(this){
            is SwipeRefreshLayout -> !isRefreshing
            is ObservableBoolean -> !get()
            is KProgressHUD -> !isShowing
            is View -> !isVisible
            is ViewGroup -> !isVisible
            is AdaptiveRVAdapter<*,*> -> isLoadingMore()
            else -> false
        }
    private fun List<Any>.setAllOffFromLoading() = forEach {
        it.setOffFromLoading()
    }
    private fun Any.setOffFromLoading() {
        when(this){
            is SwipeRefreshLayout -> isRefreshing = false
            is ObservableBoolean -> set(false)
            is KProgressHUD -> dismiss()
            is View -> isVisible = false
            is ViewGroup -> isVisible = false
            is AdaptiveRVAdapter<*,*> -> isLoadingMore(false)
        }
    }

    companion object {
        fun <T> success(data: T?): Resource<T> {
            Timber.d("Response SUCCESS")
            return Resource(SUCCESS, data, null)
        }

        fun <T> error(msg: String, data: T?): Resource<T> {
            Timber.d("Response ERROR")
            return Resource(ERROR, data, msg)
        }

        fun <T> empty(msg: String?, data: T?): Resource<T> {
            Timber.d("Response EMPTY")
            return Resource(EMPTY, data, msg)
        }

        fun <T> loading(data: T? = null): Resource<T> {
            return Resource(LOADING, data, null)
        }

        fun <T> disconnected(data: T?): Resource<T> {
            Timber.d("Response DISCONNECTED")
            return Resource(DISCONNECTED, data, "Connection not available")
        }

    }
}
package com.example.easysushi.core

import android.content.Context
import android.util.Log
import androidx.annotation.StringRes
import java.lang.ref.WeakReference

object ResResolver {
    private const val FAILED_TO_GET_RES_PLACEHOLDER = "Ошибка getString!"
    private const val FAILED_TO_GET_RES_PLACEHOLDER_ARGS = "Ошибка getString(args)!"

    private var contextWeak: WeakReference<Context>? = null

    fun setContext(context: Context) {
        contextWeak = WeakReference(context)
    }

    fun getString(@StringRes id: Int): String {
        return runCatching { contextWeak?.get()?.getString(id) }
            .onFailure { Log.e("getString", "getStringError ResId is $id") }
            .getOrNull()
            ?: FAILED_TO_GET_RES_PLACEHOLDER
    }

    fun getString(@StringRes id: Int, vararg args: Any): String {
        return runCatching { contextWeak?.get()?.getString(id, *args) }
            .onFailure {
                Log.e(
                    "getStringVarargsError",
                    "getString(@StringRes=$id, args: ${args.contentToString()})",
                    it
                )
            }
            .getOrNull()
            ?: FAILED_TO_GET_RES_PLACEHOLDER_ARGS
    }
}

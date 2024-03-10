package com.example.easysushi.core

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.util.Log
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.core.content.ContextCompat
import com.example.easysushi.R
import com.yandex.runtime.image.ImageProvider
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

    // Используется в таком виде (через Bitmap), так как yandex mapkit не поддерживает векторные иконки
    fun getImageProviderWithDrawableRes(
        @DrawableRes resourceId: Int
    ): ImageProvider =
        runCatching {
            ImageProvider.fromBitmap(
                createBitmapFromVector(resourceId)
            )
        }.getOrDefault(
            ImageProvider.fromBitmap(
                createBitmapFromVector(R.drawable.ic_launcher_background)
            ).also {
                Log.e("getImageProvider", "getImageProvider error, setting default icon")
            }
        )

    private fun createBitmapFromVector(art: Int): Bitmap? {
        val drawable = contextWeak?.get()?.let { ContextCompat.getDrawable(it, art) } ?: return null
        val bitmap = Bitmap.createBitmap(
            drawable.intrinsicWidth,
            drawable.intrinsicHeight,
            Bitmap.Config.ARGB_8888
        )
        val canvas = Canvas(bitmap)
        drawable.setBounds(0, 0, canvas.width, canvas.height)
        drawable.draw(canvas)
        return bitmap
    }
}

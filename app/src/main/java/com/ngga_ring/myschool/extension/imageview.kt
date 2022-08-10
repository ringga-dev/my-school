package com.ngga_ring.myschool.extension

import android.graphics.Color
import android.graphics.drawable.Drawable
import android.widget.ImageView
import androidx.annotation.DrawableRes
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.ngga_ring.core.customview.TextDrawable

fun ImageView.loadOrText(
    url: String?,
    text: String?,
    textSize: Float = 16F,
    textColor: Int = Color.BLACK,
    backgroundColor: Int = Color.TRANSPARENT,
    progressStroke: Float = 5F,
    progressRadius: Float = 30F,
) {
    val progressDrawable = CircularProgressDrawable(context)
    progressDrawable.strokeWidth = progressStroke.dp
    progressDrawable.centerRadius = progressRadius.dp
    progressDrawable.start()

    val context = this@loadOrText.context
    val textDrawable = TextDrawable(
        context,
        text ?: "",
        textSize,
        textColor,
        backgroundColor,
    )
    textDrawable.setBounds(0, 0, 40, 40)

    Glide.with(this)
        .load(url)
        .placeholder(progressDrawable)
        .error(textDrawable)
        .into(this)
}

fun ImageView.loadOrDefault(
    url: String?,
    @DrawableRes resId: Int,
    progressStroke: Float = 5F,
    progressRadius: Float = 30F,
) {
    val progressDrawable = CircularProgressDrawable(context)
    progressDrawable.strokeWidth = progressStroke.dp
    progressDrawable.centerRadius = progressRadius.dp
    progressDrawable.start()

    Glide.with(this)
        .load(url)
        .placeholder(progressDrawable)
        .error(resId)
        .into(this)
}



fun ImageView.loadOrDefault(
    url: String?,
    drawable: Drawable,
    progressStroke: Float = 5F,
    progressRadius: Float = 30F,
) {
    val progressDrawable = CircularProgressDrawable(context)
    progressDrawable.strokeWidth = progressStroke.dp
    progressDrawable.centerRadius = progressRadius.dp
    progressDrawable.start()

    Glide.with(this)
        .load(url)
        .placeholder(progressDrawable)
        .error(drawable)
        .into(this)
}
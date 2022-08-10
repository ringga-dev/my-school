package com.ngga_ring.core.customview

import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.ngga_ring.core.R
import com.ngga_ring.core.databinding.ViewBlurLoadingBinding
import eightbitlab.com.blurview.RenderScriptBlur

class LoadingView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null
) : FrameLayout(context, attrs) {

    private val binding: ViewBlurLoadingBinding

    var dismissOnOutsideClick = true
    var onDismissed: () -> Unit = {}

    init {
        binding = ViewBlurLoadingBinding.inflate(LayoutInflater.from(context), this, true)
        binding.progressBar.startAnimation(
            AnimationUtils.loadAnimation(context, R.anim.rotate_progress_bar)
        )

        val decorView = (context as AppCompatActivity).window.decorView
        val rootView = decorView.findViewById<View>(android.R.id.content) as ViewGroup
        val windowBackground = decorView.background

        binding.blurView.setupWith(rootView)
            .setFrameClearDrawable(windowBackground)
            .setBlurAlgorithm(RenderScriptBlur(context))
            .setBlurRadius(3F) // Optional
            .setBlurAutoUpdate(true)

        binding.root.setOnClickListener {
            if (dismissOnOutsideClick) {
                isVisible = false
                onDismissed()
            }
        }
    }

}
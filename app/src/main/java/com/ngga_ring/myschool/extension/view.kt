package com.ngga_ring.myschool.extension

import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.Transformation

fun View.expandAnimate() {
    val matchParentMeasureSpec = View.MeasureSpec.makeMeasureSpec(
        (this.parent as View).width,
        View.MeasureSpec.EXACTLY
    )
    val wrapContentMeasureSpec =
        View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED)
    this.measure(matchParentMeasureSpec, wrapContentMeasureSpec)
    val targetHeight = this.measuredHeight

    this.layoutParams.height = 1
    this.visibility = View.VISIBLE
    val animation = object : Animation() {
        override fun applyTransformation(interpolatedTime: Float, t: Transformation?) {
            this@expandAnimate.layoutParams.height =
                if (interpolatedTime == 1f) ViewGroup.LayoutParams.WRAP_CONTENT else (targetHeight * interpolatedTime).toInt()
            this@expandAnimate.requestLayout()
        }

        override fun willChangeBounds(): Boolean {
            return true
        }
    }

    animation.duration = (targetHeight / this.context.resources.displayMetrics.density).toLong()
    this.startAnimation(animation)
}

fun View.collapseAnimate() {
    val initialHeight = this.measuredHeight
    val animation = object : Animation() {
        override fun applyTransformation(interpolatedTime: Float, t: Transformation?) {
            if (interpolatedTime == 1f) {
                this@collapseAnimate.visibility = View.GONE
            } else {
                this@collapseAnimate.layoutParams.height =
                    initialHeight - (initialHeight * interpolatedTime).toInt()
                this@collapseAnimate.requestLayout()
            }
        }

        override fun willChangeBounds(): Boolean {
            return true
        }
    }

    animation.duration =
        (initialHeight / this.context.resources.displayMetrics.density).toLong()
    this.startAnimation(animation)
}
package com.ngga_ring.core.customview

import android.content.Context
import android.graphics.*
import android.graphics.drawable.Drawable
import androidx.core.content.res.ResourcesCompat
import com.ngga_ring.core.R

/**
 * Create text drawable
 */
class TextDrawable(
    context: Context,
    private val text: String,
    textSize: Float = 16F,
    textColor: Int = Color.BLACK,
    private var backgroundColor: Int = Color.TRANSPARENT,
) : Drawable() {

    private val paint: Paint = Paint()

    init {
        val font = ResourcesCompat.getFont(context, R.font.nunito_bold)
        paint.typeface = font

        val spSize = textSize * context.resources.displayMetrics.scaledDensity
        paint.textSize = spSize

        paint.color = textColor
        paint.isAntiAlias = true
        paint.textAlign = Paint.Align.CENTER
    }

    override fun draw(canvas: Canvas) {
        canvas.drawColor(backgroundColor)

        val yCenter = (bounds.exactCenterY() - (paint.descent() + paint.ascent()) / 2)
        canvas.drawText(text, bounds.exactCenterX(), yCenter, paint)
    }

    override fun setAlpha(alpha: Int) {
        paint.alpha = alpha
    }

    override fun setColorFilter(cf: ColorFilter?) {
        paint.colorFilter = cf
    }

    override fun getOpacity(): Int {
        return PixelFormat.TRANSLUCENT
    }
}
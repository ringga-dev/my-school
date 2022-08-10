package com.ngga_ring.core.customview

import android.annotation.SuppressLint
import android.content.Context
import android.content.res.ColorStateList
import android.graphics.Color.red
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.inputmethod.EditorInfo
import androidx.annotation.StringRes
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import androidx.core.widget.addTextChangedListener
import com.google.android.material.textfield.TextInputLayout
import com.ngga_ring.core.R
import com.ngga_ring.core.databinding.ViewEditTextBinding

@SuppressLint("ResourceType")
class CustomEditText @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null
) : ConstraintLayout(context, attrs) {

    private val binding: ViewEditTextBinding

    var text: String
        get() = binding.input.text.toString()
        set(value) = binding.input.setText(value)

    var error: String
        get() = binding.error.text.toString()
        set(value) {
            binding.error.isVisible = value.isNotEmpty()
            binding.error.text = value
            if (value.isNotEmpty()) {
                binding.layout.setBoxStrokeColorStateList(boxStrokeError)
            } else {
                binding.layout.setBoxStrokeColorStateList(boxStrokeColorStateList)
            }
        }

    private val errorColorState = arrayOf(intArrayOf(android.R.attr.state_enabled))
    var boxStrokeError = ColorStateList(errorColorState, intArrayOf(ContextCompat.getColor(context, R.color.red)))
    var boxStrokeColorStateList = ContextCompat.getColorStateList(context, R.color.input_stroke_color_state)!!

    init {

        val inflater = LayoutInflater.from(context)
        binding = ViewEditTextBinding.inflate(inflater, this)
        binding.layout.errorIconDrawable = null
        binding.input.addTextChangedListener { error = "" }

        val set = intArrayOf(
            android.R.attr.enabled, //0
            android.R.attr.text, //1
            android.R.attr.hint, //2
            android.R.attr.title, //3
            android.R.attr.inputType, //4
            com.google.android.material.R.attr.endIconMode, //5
            com.google.android.material.R.attr.endIconDrawable, //6
            com.google.android.material.R.attr.suffixText, //7
        )
        val a = context.obtainStyledAttributes(attrs, set)
        val isEnabled = a.getBoolean(0, true)
        val text = a.getText(1) ?: ""
        val hint = a.getText(2) ?: ""
        val title = a.getText(3) ?: ""
        val inputType = a.getInt(4, EditorInfo.TYPE_CLASS_TEXT)
        val endIconMode = a.getInt(5, TextInputLayout.END_ICON_NONE)
        val endIconDrawableId = a.getInt(6, 0)
        val suffix = a.getText(7) ?: ""

        this.text = text.toString()
        this.isEnabled = isEnabled
        binding.input.inputType = inputType
        binding.input.hint = hint
        binding.title.text = title
        binding.layout.endIconMode = endIconMode
        if (suffix.isNotEmpty()) {
            binding.suffix.isVisible = true
            binding.suffix.text = suffix
        }
        if (endIconDrawableId != 0) {
            binding.layout.setEndIconDrawable(endIconDrawableId)
        }
        a.recycle()

    }

    fun setText(@StringRes res: Int) {
        text = context.getString(res)
    }

    override fun setEnabled(enabled: Boolean) {
        super.setEnabled(enabled)

        binding.layout.isEnabled = enabled
        binding.input.isEnabled = enabled
    }
}

package com.example.myapplication.utils.UIBaseComponent

import android.content.Context
import android.graphics.Typeface
import android.util.AttributeSet
import android.widget.TextView
import com.example.myapplication.MasterApplication
import com.example.myapplication.R
import com.example.myapplication.utils.FontManager


class LightTextView:TextView {
    private var fontName: String = "iran_sans_mobile.ttf"

    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs){ init(attrs) }
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ){ init(attrs) }

    constructor(
        context: Context?,
        attrs: AttributeSet?,
        defStyleAttr: Int,
        defStyleRes: Int
    ) : super(context, attrs, defStyleAttr, defStyleRes){
        init(attrs)
    }

    fun init(attrs: AttributeSet?){
        setAttributes(attrs)
        try {
            val myTypeface = FontManager.instance.iranSans
            typeface = myTypeface
        }catch(Errr:Exception){
            println(Errr.message)
        }




    }

    fun setAttributes(attrs: AttributeSet?) {
        val a = context.theme.obtainStyledAttributes(attrs, R.styleable.LightTextView, 0, 0)
        try {
            fontName = a.getString(R.styleable.LightTextView_c_font) ?: "iran_sans_mobile"
        } finally {
            a.recycle()
        }
    }
}
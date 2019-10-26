package com.example.myapplication.utils

import android.graphics.Typeface
import com.example.myapplication.MasterApplication

class FontManager private constructor() {
    private var IranSans: Typeface? = null
    private var IranSansBold: Typeface? = null
    private var IranSansMedium: Typeface? = null
    private var IranYekanRegular: Typeface? = null
    private var IranYekanLight: Typeface? = null
    private var IranYekanBold: Typeface? = null

    val iranSans: Typeface?
        get() {
            if (sInstance!!.IranSans == null)
                sInstance!!.IranSans = Typeface.createFromAsset(
                    MasterApplication.getInstance()?.getAssets(),
                    "fonts/iran_sans_mobile.ttf"
                )
            return sInstance!!.IranSans
        }
    val iranSansMedium: Typeface?
        get() {
            if (sInstance!!.IranSansMedium == null)
                sInstance!!.IranSansMedium = Typeface.createFromAsset(
                    MasterApplication.getInstance()?.getAssets(),
                    "fonts/iran_sans_mobile_medium.ttf"
                )
            return sInstance!!.IranSansMedium
        }

    val iranSansBold: Typeface?
        get() {
            if (sInstance!!.IranSansBold == null)
                sInstance!!.IranSansBold = Typeface.createFromAsset(
                    MasterApplication.getInstance()?.getAssets(),
                    "fonts/iran_sans_mobile_bold.ttf"
                )
            return sInstance!!.IranSansBold
        }
    val iranYekanRegular: Typeface?
        get() {
            if (sInstance!!.IranYekanRegular == null)
                sInstance!!.IranYekanRegular = Typeface.createFromAsset(
                    MasterApplication.getInstance()?.getAssets(),
                    "fonts/IRANYekanRegular.ttf"
                )
            return sInstance!!.IranYekanRegular
        }
    val iranYekanLight: Typeface?
        get() {
            if (sInstance!!.IranYekanLight == null)
                sInstance!!.IranYekanLight = Typeface.createFromAsset(
                    MasterApplication.getInstance()?.getAssets(),
                    "fonts/IRANYekanLight.ttf"
                )
            return sInstance!!.IranYekanLight
        }
    val iranYekanBold: Typeface?
        get() {
            if (sInstance!!.IranYekanBold == null)
                sInstance!!.IranYekanBold = Typeface.createFromAsset(
                    MasterApplication.getInstance()?.getAssets(),
                    "fonts/IRANYekanLight.ttf"
                )
            return sInstance!!.IranYekanBold
        }

    fun getFont(index: Int): Typeface? {
        when (index) {
            1 -> return iranSans
            2 -> return iranYekanBold
            3 -> return iranYekanLight
            4 -> return iranSansBold
            5 -> return iranSansMedium
            6 -> return iranSans
            else -> return iranSans
        }
    }

    companion object {

        private var sInstance: FontManager? = null

        var instance: FontManager
            get() {
                if (sInstance == null)
                    sInstance = FontManager()
                return sInstance!!
            }
        private set(value) {}
    }

}

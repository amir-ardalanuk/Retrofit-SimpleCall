package com.example.myapplication.Abstracts

import android.app.Activity

interface ActivityInterface {

    val activity: Activity

    fun showError(message : String?)

    fun showLoadingDialog()

    fun showLoadingDialog(b: Boolean)

    fun showLoadingDialog(text: Any)

    fun dismissLoadingDialog()

    fun toast(txt: Any)

    fun toast(txt: Any, length: Int)


    fun showLoadingDialog(s: Any, b: Boolean?)

    fun showNoInternetDialog()

    fun hideNoInternetDialog()

//    fun showConfirmDialog(message: String, dismissListener: DialogInterface.OnDismissListener)
//
//    fun showConfirmDialog(
//        title: String, message: String,
//        dismissListener: DialogInterface.OnDismissListener, cancelable: Boolean, textGravity: Int
//    )
//
//    fun showConfirmDialog(
//        stringFromResource: String, description: String, buttonText: String,
//        dismissListener: DialogInterface.OnDismissListener, cancelable: Boolean, textGravity: Int
//    )
//
//    fun showConfirmDialog(
//        stringFromResource: String, description: String, buttonText: String,
//        dismissListener: DialogInterface.OnDismissListener, cancelable: Boolean, textGravity: Int,
//        drawable: Drawable?
//    )
}

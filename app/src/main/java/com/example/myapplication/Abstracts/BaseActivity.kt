package com.example.myapplication.Abstracts

import android.app.Activity
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager

abstract class BaseActivity : FragmentActivity(),ActivityInterface {
     override val activity: Activity
         get() = this

     override fun showLoadingDialog() {
         TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
     }

     override fun showLoadingDialog(b: Boolean) {
         TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
     }

     override fun showLoadingDialog(text: Any) {
         TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
     }

     override fun dismissLoadingDialog() {
         TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
     }

     override fun toast(txt: Any) {
         TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
     }

     override fun toast(txt: Any, length: Int) {
         TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
     }

     override fun showLoadingDialog(s: Any, b: Boolean?) {
         TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
     }

     override fun showNoInternetDialog() {
         TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
     }

     override fun hideNoInternetDialog() {
         TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
     }

     override fun showError(message: String?) {

     }

    fun goToFragment(fragment: Fragment, tag: String, containerId: Int) {
        try {
            val transaction = supportFragmentManager.beginTransaction()
//            transaction.setCustomAnimations(
//                R.anim.fade_in, R.anim.fade_out, R.anim.fade_in,
//                R.anim.fade_out
//            )
            transaction.add(containerId, fragment)
            transaction.addToBackStack(tag)
            transaction.commit()
        } catch (e: Exception) {
            e.printStackTrace()
        }

    }

    /**
     * @param fragment gold fragment
     * @param tag name
     * @param containerId res container
     */
    fun goToFragmentWithoutRemovingCurrent(fragment: Fragment, tag: String, containerId: Int) {
        try {
            val transaction = supportFragmentManager.beginTransaction()
//            transaction.setCustomAnimations(
//                R.anim.fade_in, R.anim.fade_out, R.anim.fade_in,
//                R.anim.fade_out
//            )
            transaction.add(containerId, fragment)
            transaction.addToBackStack(tag)
            transaction.commit()
        } catch (e: Exception) {
            e.printStackTrace()
        }

    }

 }

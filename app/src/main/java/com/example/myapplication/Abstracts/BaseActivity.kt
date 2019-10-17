package com.example.myapplication.Abstracts

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer


@Suppress("NON_EXHAUSTIVE_WHEN")
abstract class BaseActivity<T:BaseViewModel> : AppCompatActivity(),ActivityInterface,ContractView {
     override val activity: Activity
         get() = this


    abstract var containerViewId : Int
    abstract var viewModel : T?


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        subscribeUI()
    }

    fun subscribeUI(){
        this.viewModel?.baseState?.observeForever {state ->
            when(state){
                BaseViewModelState.errorMessage -> state.message?.let { toast(it) }
                else -> println(state)
            }
        }
    }
    override fun getContext(): Context {
        return this
    }

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
        Toast.makeText(this,txt.toString(),Toast.LENGTH_LONG).show()
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

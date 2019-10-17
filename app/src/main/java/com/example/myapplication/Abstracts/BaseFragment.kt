package com.example.myapplication.Abstracts

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import butterknife.Unbinder
import io.reactivex.disposables.CompositeDisposable

abstract class BaseFragment : Fragment() , FragmentInterface,ContractView {

    var unbinder: Unbinder? = null

    abstract val viewModel  : BaseViewModel?

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        viewModel?.bag = getBag()
//        this.viewModel?.fragmentInterface = this
    }

    abstract fun getBag():CompositeDisposable?

    override fun onDestroyView() {
        super.onDestroyView()
        unbinder?.unbind()
        getBag()?.dispose()
    }

    override fun showError(string: String?) {
        Toast.makeText(this.context , string , Toast.LENGTH_LONG).show()
    }

    override fun getContext(): Context {
        return context
    }
}
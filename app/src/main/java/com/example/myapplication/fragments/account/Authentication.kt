package com.example.myapplication.fragments.account


import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import butterknife.BindView
import butterknife.ButterKnife
import com.example.myapplication.API.Database.UserRepository
import com.example.myapplication.Abstracts.BaseFragment

import com.example.myapplication.R
import com.example.myapplication.activities.home.HomeActivity
import com.example.myapplication.utils.addDispose
import com.example.myapplication.utils.bindTo
import com.example.myapplication.utils.setState
import com.jakewharton.rxbinding3.view.clicks
import com.jakewharton.rxbinding3.widget.textChanges
import io.reactivex.BackpressureStrategy
import io.reactivex.disposables.CompositeDisposable

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class Authentication : BaseFragment() {


    override fun getBag(): CompositeDisposable? = _bag


    private val _bag: CompositeDisposable = CompositeDisposable()
    override var viewModel: AuthenticationViewModel? = null


    @BindView(R.id.fragment_authenticate_et_mobile) lateinit var etPhoneNumber:EditText
    @BindView(R.id.fragment_authenticate_et_code) lateinit var etCode:EditText
    @BindView(R.id.fragment_authenticate_btn_submit) lateinit var btnSumbit:Button



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_authentication, container, false)
        ButterKnife.bind(this,view);
        this.context?.let {
            viewModel = AuthenticationViewModelFactory(UserRepository(it)).create(AuthenticationViewModel::class.java)
        }

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bindData()
    }

    fun bindData(){
        viewModel?.let {
            etCode.textChanges().map{it.toString()}.bindTo(it.codeSubject)?.addDispose(_bag)
            etPhoneNumber.textChanges().map{it.toString()}.bindTo(it.mobileSubject)?.addDispose(_bag)
            btnSumbit.clicks().subscribe { click -> it.run { submitClick() } }.addDispose(_bag)
        }

        viewModel?.let{
            it.mobileStateSubject.subscribe { it?.let { etPhoneNumber.setState(it) }}.addDispose(_bag)
            it.codeStateSubject.subscribe{ it?.let { etCode.setState(it) }}.addDispose(_bag)
            it.buttonTitle.subscribe { it?.let{ btnSumbit.text = it }}.addDispose(_bag);
            it.stateSubject.filter { it == AuthenticationViewModel.AuthState.Done }.subscribe {  routeToHome() }
            }
        }


    fun routeToHome(){
        val i = Intent(this.context,HomeActivity::class.java)
        i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(i)
        activity?.finish()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        unbinder?.unbind()
        _bag.dispose()
    }
}

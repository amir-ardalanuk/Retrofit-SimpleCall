package com.example.myapplication.activities.home

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity;
import com.example.myapplication.Abstracts.BaseActivity
import com.example.myapplication.Abstracts.BaseViewModel
import com.example.myapplication.R
import com.example.myapplication.fragments.mainLoadFragment.MainLoadFragment
import io.reactivex.disposables.CompositeDisposable

import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity() : BaseActivity<BaseViewModel>() {

    override var viewModel: BaseViewModel? = null
    val _bag = CompositeDisposable()


    override var containerViewId: Int = R.id.home_activity_container

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        goToFragment(MainLoadFragment(),"Main_Load_Fragment",containerViewId);

    }

    override fun onBackPressed() {
        super.onBackPressed()
    }
}

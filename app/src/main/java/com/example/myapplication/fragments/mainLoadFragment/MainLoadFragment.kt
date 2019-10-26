package com.example.myapplication.fragments.mainLoadFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import butterknife.BindView
import butterknife.ButterKnife
import com.example.myapplication.API.DAL.PrefrencesStandard
import com.example.myapplication.API.DAL.PrefrencesStandardKey
import com.example.myapplication.Abstracts.BaseFragment

import com.example.myapplication.R
import com.example.myapplication.adapters.LoadCategoryAdapter
import com.example.myapplication.API.Database.UserRepository
import io.reactivex.disposables.CompositeDisposable

class MainLoadFragment : BaseFragment() {

    @BindView(R.id.main_load_category_rec) lateinit var listOfCategory : RecyclerView
    @BindView(R.id.main_load_list_rec) lateinit var listOfLoad : RecyclerView

    val adapter = LoadCategoryAdapter()


    val _bag = CompositeDisposable()

    override fun getBag(): CompositeDisposable? = this._bag

    companion object {
        fun newInstance() = MainLoadFragment()
    }

    override lateinit var  viewModel: MainLoadViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.main_load_fragment, container, false)
        PrefrencesStandardKey.cartable
        this.context?.let {
            viewModel = MainLoadViewModelFactory(UserRepository(it), PrefrencesStandard.standard).create(MainLoadViewModel::class.java)
        }

        ButterKnife.bind(this,view)
        return  view
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupAdapters()
        subscribeUI()
    }

    private fun subscribeUI() {
        viewModel.headerItem.observe(viewLifecycleOwner,Observer{
            adapter.submitList(it)
        })
        adapter.list = viewModel.headerItem.value
    }

    fun setupAdapters(){
        listOfCategory.adapter = adapter
        listOfCategory.layoutManager = StaggeredGridLayoutManager(1,LinearLayoutManager.HORIZONTAL)
    }


}

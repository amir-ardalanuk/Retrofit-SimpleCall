package com.example.myapplication.Fragments.AuthenticateUser


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders

import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentAuthenticationBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class Authentication : Fragment() {

    private var bind: FragmentAuthenticationBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_authentication, container, false)
       // val vm = ViewModelProviders.of(this).get(AuthenticationViewModel::class.java)
        bind = FragmentAuthenticationBinding.bind(view)

        bind?.setLifecycleOwner(this)
        return bind?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val viewModel = ViewModelProviders.of(this).get(AuthenticationViewModel :: class.java)
        bind?.viewModel = viewModel
        bin
    }


}

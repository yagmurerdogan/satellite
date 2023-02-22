package com.yagmurerdogan.satellite.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.viewbinding.ViewBinding

abstract class BaseFragment<VM : ViewModel>(view: Int) : Fragment(view) {

    abstract val binding: ViewBinding
    abstract val viewModel: VM

    abstract fun initUI()

    open fun observeViewModel(viewModel: VM) {}

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUI()
        observeViewModel(viewModel = viewModel)
    }
}
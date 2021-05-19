package com.example.lok.ui.fragment

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.lok.R
import com.example.lok.ui.gacha.GachaViewModel

class GachaFragment : Fragment() {

    companion object {
        fun newInstance() = GachaFragment()
    }

    private lateinit var viewModel: GachaViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.gacha_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(GachaViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
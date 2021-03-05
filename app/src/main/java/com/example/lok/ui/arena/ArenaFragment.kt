package com.example.lok.ui.arena

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.lok.R

class ArenaFragment : Fragment() {

    companion object {
        fun newInstance() = ArenaFragment()
    }

    private lateinit var viewModel: ArenaViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.arena_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(ArenaViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
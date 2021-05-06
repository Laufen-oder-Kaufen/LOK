package com.example.lok.ui.team

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.example.lok.R
import com.example.lok.TestData
import com.example.lok.ui.adapter.CharacterAdapter

class TeamFragment : Fragment() {

    companion object {
        fun newInstance() = TeamFragment()
    }

    private lateinit var viewModel: TeamViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.team_fragment, container, false)
        val allTeam = view.findViewById<GridView>(R.id.teamGridView)
        val activeTeam = view.findViewById<GridView>(R.id.activeTeamGridView)

        allTeam.adapter = CharacterAdapter(requireContext(), TestData.myHeroes.size, "all")
        activeTeam.adapter = CharacterAdapter(requireContext(), 4, "active")
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(TeamViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
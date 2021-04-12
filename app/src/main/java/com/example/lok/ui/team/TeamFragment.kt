package com.example.lok.ui.team

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.lok.R
import kotlinx.android.synthetic.main.team_fragment.view.*

class TeamFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.team_fragment, container, false)
        view.activeTeamGridView.adapter = LVAdapter(requireContext())
        view.teamGridView.adapter = GVAdapter(requireContext())
        return view
    }

//    override fun onActivityCreated(savedInstanceState: Bundle?) {
//        super.onActivityCreated(savedInstanceState)
//        viewModel = ViewModelProviders.of(this).get(TeamViewModel::class.java)
//        // TODO: Use the ViewModel
//    }

    private class LVAdapter(context: Context) : BaseAdapter() {

        private val nContext : Context

        private val names = arrayListOf<String>(
            "Ritter", "Magier", "Heiler", "Tank", "Bauer", "Paladin")
        private val images = arrayOf(
            R.drawable.con6, R.drawable.con7, R.drawable.con8,
            R.drawable.con10, R.drawable.con11, R.drawable.con12)

        init{
            this.nContext = context
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            val listLayoutInflater = LayoutInflater.from(nContext)
            val rowActive = listLayoutInflater.inflate(R.layout.row_team, parent, false)
            val imageView = rowActive.findViewById<ImageView>(R.id.row_team_image)
            val nameTextView = rowActive.findViewById<TextView>(R.id.row_team_name)
            imageView.setImageResource(images.get(position))
            nameTextView.text = names.get(position)
            return rowActive
        }

        override fun getItem(position: Int): Any {
            return "Test String"
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        // how many rows in my list
        override fun getCount(): Int {
            return 4
        }

    }

    private class GVAdapter(context: Context) : BaseAdapter() {

        private val mContext : Context

        private val names = arrayListOf<String>(
            "Ritter", "Magier", "Heiler", "Tank", "Bauer", "Paladin",
            "Name", "Name", "Name","Name", "Name", "Name",
            "Name", "Name", "Name",)
        private val images = arrayOf(
            R.drawable.con6, R.drawable.con7, R.drawable.con8,
            R.drawable.con10, R.drawable.con11, R.drawable.con12,
            R.drawable.con20, R.drawable.con21, R.drawable.con22,
            R.drawable.con23, R.drawable.con24, R.drawable.con25,
            R.drawable.con26, R.drawable.con27, R.drawable.con28)

        init{
            this.mContext = context
        }
        // rendering each row
        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            val layoutInflater = LayoutInflater.from(mContext)
            val rowMain = layoutInflater.inflate(R.layout.row_team, parent, false)
            val imageView = rowMain.findViewById<ImageView>(R.id.row_team_image)
            val nameTextView = rowMain.findViewById<TextView>(R.id.row_team_name)
            imageView.setImageResource(images.get(position))
            nameTextView.text = names.get(position)
            return rowMain
        }

        override fun getItem(position: Int): Any {
            return "Test String"
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        // how many rows in my list
        override fun getCount(): Int {
            return 9
        }

    }

}
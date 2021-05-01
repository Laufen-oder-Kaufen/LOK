package com.example.lok.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.lok.R

class RecyclerAdapter (private var names: List<String>, private var images: List<Int>) : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>(){

    inner class ViewHolder(teamView: View) : RecyclerView.ViewHolder(teamView){

        val name: TextView = teamView.findViewById(R.id.name)
        val image: ImageView = teamView.findViewById(R.id.image)

        init {
            teamView.setOnClickListener { v: View ->
                val position: Int = adapterPosition
                Toast.makeText(teamView.context, "You clicked on item nr ${position + 1}", Toast.LENGTH_LONG).show()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v: View = LayoutInflater.from(parent.context).inflate(R.layout.character_card, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.name.text = names[position]
        holder.image.setImageResource(images[position])
    }

    override fun getItemCount(): Int {
        return names.size
    }
}
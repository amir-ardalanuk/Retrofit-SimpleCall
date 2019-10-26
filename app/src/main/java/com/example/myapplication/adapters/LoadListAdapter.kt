package com.example.myapplication.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.model.response.EnumsName

class LoadListAdapter : ListAdapter<String, LoadListAdapter.ViewHolder>(LoadListDiffCallback()) {


    override fun getItemCount(): Int {
        return super.getItemCount()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LoadListAdapter.ViewHolder {
        return ViewHolder( LayoutInflater.from(parent.context).inflate(R.layout.row_load_item,parent,false) )
    }

    override fun onBindViewHolder(holder: LoadListAdapter.ViewHolder, position: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    class  ViewHolder(itemView: View)  : RecyclerView.ViewHolder(itemView){

        init {

        }
    }

}
private class LoadListDiffCallback : DiffUtil.ItemCallback<String>() {

    override fun areItemsTheSame(
        oldItem: String,
        newItem: String
    ): Boolean {
        return oldItem != newItem
    }

    override fun areContentsTheSame(
        oldItem: String,
        newItem: String
    ): Boolean {
        return oldItem != newItem
    }
}
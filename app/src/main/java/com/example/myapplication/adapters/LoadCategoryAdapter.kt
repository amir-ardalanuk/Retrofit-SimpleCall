package com.example.myapplication.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import butterknife.BindView
import butterknife.ButterKnife
import com.example.myapplication.R

class LoadCategoryAdapter : ListAdapter<String,LoadCategoryAdapter.ViewHolder>(LoadCategoryDiffCallback()) {

    private var itemList : MutableList<String>? = null;
    var list : MutableList<String>?
    get() {return this.itemList}
    set(value) {
        itemList = value
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.row_load_category,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = itemList?.size ?: 0

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val context = holder.itemView.context
        val data = this.itemList?.get(position)

        holder.tvTitle.text = data
    }

    class ViewHolder : RecyclerView.ViewHolder {

        @BindView(R.id.row_load_category_title) lateinit var tvTitle:TextView

        constructor(itemView : View) : super(itemView) {
            ButterKnife.bind(this,itemView)
        }
    }


}
private class LoadCategoryDiffCallback : DiffUtil.ItemCallback<String>() {

    override fun areItemsTheSame(
        oldItem: String,
        newItem: String
    ): Boolean {
        return oldItem.equals(newItem)
    }

    override fun areContentsTheSame(
        oldItem: String,
        newItem: String
    ): Boolean {
        return oldItem.equals(newItem)
    }
}
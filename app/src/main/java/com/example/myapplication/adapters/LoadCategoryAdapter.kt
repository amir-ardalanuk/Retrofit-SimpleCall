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
import com.example.myapplication.model.response.EnumsName
import com.example.myapplication.utils.UIBaseComponent.LightTextView

class LoadCategoryAdapter : ListAdapter<EnumsName,LoadCategoryAdapter.ViewHolder>(LoadCategoryDiffCallback()) {

    private var itemList : MutableList<EnumsName>? = null;
    var list : MutableList<EnumsName>?
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

        holder.tvTitle.text = data?.name ?: "name"
    }

    class ViewHolder : RecyclerView.ViewHolder {

        @BindView(R.id.row_load_category_title) lateinit var tvTitle:LightTextView

        constructor(itemView : View) : super(itemView) {
            ButterKnife.bind(this,itemView)
        }
    }


}
private class LoadCategoryDiffCallback : DiffUtil.ItemCallback<EnumsName>() {

    override fun areItemsTheSame(
        oldItem: EnumsName,
        newItem: EnumsName
    ): Boolean {
        return oldItem.value != newItem.value
    }

    override fun areContentsTheSame(
        oldItem: EnumsName,
        newItem: EnumsName
    ): Boolean {
        return oldItem.value != newItem.value
    }
}
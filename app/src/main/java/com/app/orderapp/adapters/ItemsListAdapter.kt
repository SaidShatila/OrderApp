package com.app.orderapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.DatePicker
import android.widget.Spinner
import androidx.recyclerview.widget.RecyclerView
import com.app.orderapp.databinding.OrderDefinitionItemBinding
import com.app.orderapp.entities.Items
import com.app.orderapp.orderdefinition.OrderDefinitionItemViewModel

class ItemsListAdapter(
    private val item: Spinner,
    private val quantity: Spinner,
    private val items : List<Items>,
    private val date: DatePicker
) : RecyclerView.Adapter<ItemsListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemsListViewHolder {
        return ItemsListViewHolder(
            OrderDefinitionItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ItemsListViewHolder, position: Int) {
        holder.binding.viewModel = OrderDefinitionItemViewModel(item,quantity,date)
    }

    override fun getItemCount() = items.size
}


class ItemsListViewHolder(val binding: OrderDefinitionItemBinding) : RecyclerView.ViewHolder(binding.root)
package com.example.testapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.testapp.databinding.ListItemDrawerBinding
import com.example.testapp.model.Plane


/**
 * Adapter for [RecyclerView] in Drawer
 */
class PlaneDrawerAdapter(private val clickListener: PlaneDrawerListener) :
    ListAdapter<Plane, PlaneDrawerAdapter.PlaneDrawerViewHolder>(DiffCallback) {

    class PlaneDrawerViewHolder(
        var binding: ListItemDrawerBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(clickListener: PlaneDrawerListener, plane: Plane) {
            binding.plane = plane
            binding.clickListener = clickListener
        }
    }

    companion object DiffCallback : DiffUtil.ItemCallback<Plane>() {

        override fun areItemsTheSame(oldItem: Plane, newItem: Plane): Boolean {
            return oldItem.name == newItem.name
        }

        override fun areContentsTheSame(oldItem: Plane, newItem: Plane): Boolean {
            return oldItem.year == newItem.year && oldItem.description == newItem.description
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlaneDrawerViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return PlaneDrawerViewHolder(
            ListItemDrawerBinding.inflate(layoutInflater, parent, false)
        )
    }

    override fun onBindViewHolder(holder: PlaneDrawerViewHolder, position: Int) {
        val plane = getItem(position)
        holder.bind(clickListener, plane)
    }
}

/**
 * Listener which plane item clicked
 */
class PlaneDrawerListener(val clickListener: (plane: Plane) -> Unit) {
    fun onClick(plane: Plane) {
        clickListener(plane)
    }
}

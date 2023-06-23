package com.example.testapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.Animation.AnimationListener
import android.view.animation.AnimationUtils
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.testapp.R
import com.example.testapp.databinding.ListItemBinding
import com.example.testapp.model.Plane


class PlaneAdapter(val clickListener: PlaneListener) :
ListAdapter<Plane, PlaneAdapter.PlaneViewHolder>(DiffCallback) {

    class PlaneViewHolder(
        var binding: ListItemBinding
    ) : RecyclerView.ViewHolder(binding.root){

        fun bind(clickListener: PlaneListener, plane: Plane) {
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

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlaneViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return PlaneViewHolder(
            ListItemBinding.inflate(layoutInflater, parent, false)
        )
    }

    override fun onBindViewHolder(holder: PlaneViewHolder, position: Int) {
        val plane = getItem(position)
        holder.bind(clickListener, plane)
    }
}

class PlaneListener(val clickListener: (plane: Plane) -> Unit) {
    fun onClick(plane: Plane, item: ConstraintLayout) {

        val anim = AnimationUtils.loadAnimation(item.context, R.anim.tap)
        anim.duration = 100

        anim.setAnimationListener(object : AnimationListener {
            override fun onAnimationStart(animation: Animation) {}
            override fun onAnimationRepeat(animation: Animation) {}
            override fun onAnimationEnd(animation: Animation) {
                clickListener(plane)
            }
        })
        item.startAnimation(anim)
    }
}

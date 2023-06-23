package com.example.testapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.testapp.databinding.FragmentPlaneDetailBinding
import com.example.testapp.model.PlaneViewModel

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 * Allows to add a plane to [PlaneViewModel] and navigate to [PlaneDetailFragment]
 */
class PlaneDetailFragment : Fragment() {

    // shared ViewModel
    private val viewModel: PlaneViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        // Retrieve and inflate the layout for this fragment
        val binding = FragmentPlaneDetailBinding.inflate(inflater)
        binding.lifecycleOwner = this
        binding.detailFragment = this@PlaneDetailFragment
        binding.viewModel = viewModel

        return binding.root
    }

    /**
     * Add image in [ImageView] if image not null, else make it [View.GONE]
     */
    fun placeImage(imageView: ImageView): Int {
        if (viewModel.plane.value?.imageBody == null) return View.GONE
        imageView.setImageResource(viewModel.plane.value!!.imageBody!!)

        return View.VISIBLE
    }
}
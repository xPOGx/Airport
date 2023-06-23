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
 */
class PlaneDetailFragment : Fragment() {

    private val viewModel: PlaneViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentPlaneDetailBinding.inflate(inflater)
        binding.lifecycleOwner = this
        binding.detailFragment = this@PlaneDetailFragment
        binding.viewModel = viewModel

        return binding.root
    }

    fun placeImage(imageView: ImageView) : Int {
        if (viewModel.plane.value?.imageBody == null)
            return View.GONE
        imageView.setImageResource(viewModel.plane.value!!.imageBody!!)

        return View.VISIBLE
    }
}
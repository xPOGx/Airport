package com.example.testapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.testapp.adapter.PlaneAdapter
import com.example.testapp.adapter.PlaneListener
import com.example.testapp.databinding.FragmentPlaneListBinding
import com.example.testapp.model.PlaneViewModel

/**
 * Entry fragment for the app. Displays a [RecyclerView] of plane items.
 */
class PlaneListFragment : Fragment() {

    // shared ViewModel
    private val viewModel: PlaneViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        // Retrieve and inflate the layout for this fragment
        val binding = FragmentPlaneListBinding.inflate(inflater)

        // Set adapter for RecycleView and fill it with data
        val adapter = PlaneAdapter(PlaneListener { plane ->
            viewModel.onPlaneClicked(plane)
            navigationToNextFragment()
        })
        adapter.submitList(viewModel.planes.value)
        binding.recyclerView.adapter = adapter

        return binding.root
    }

    /**
     * Navigate to [PlaneDetailFragment] and send plane.name as argument for fragment Title
     */
    private fun navigationToNextFragment() {
        val action = PlaneListFragmentDirections.actionPlaneListFragmentToPlaneDetailFragment(
            viewModel.plane.value!!.name
        )
        findNavController().navigate(action)
    }
}
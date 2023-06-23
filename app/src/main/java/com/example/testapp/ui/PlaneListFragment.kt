package com.example.testapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.testapp.adapter.PlaneAdapter
import com.example.testapp.adapter.PlaneDrawerAdapter
import com.example.testapp.adapter.PlaneDrawerListener
import com.example.testapp.adapter.PlaneListener
import com.example.testapp.model.PlaneViewModel
import com.example.testapp.databinding.FragmentPlaneListBinding

/**
 * Entry fragment for the app. Displays a [RecyclerView] of planes.
 */
class PlaneListFragment : Fragment() {

    private val viewModel: PlaneViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        // Retrieve and inflate the layout for this fragment
        val binding = FragmentPlaneListBinding.inflate(inflater)

        val adapter = PlaneAdapter(PlaneListener { plane ->
            viewModel.onPlaneClicked(plane)
            navigationToNextFragment()
        })
        adapter.submitList(viewModel.planes.value)
        binding.recyclerView.adapter = adapter

        return binding.root
    }

    private fun navigationToNextFragment() {
        val action = PlaneListFragmentDirections.actionPlaneListFragmentToPlaneDetailFragment(
            viewModel.plane.value!!.name
        )
        findNavController().navigate(action)
    }
}
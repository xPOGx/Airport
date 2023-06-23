package com.example.testapp.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.testapp.data.DataSource

/**
 * Shared [ViewModel] in activity
 */
class PlaneViewModel : ViewModel() {
     // List of planes
    private var _planes = MutableLiveData<List<Plane>>()
    val planes: LiveData<List<Plane>> = _planes

    // Plane item
    private var _plane = MutableLiveData<Plane>()
    val plane: LiveData<Plane> = _plane

    /**
     * Get plane list from [DataSource]
     */
    fun getPlaneList() {
        _planes.value = DataSource.planes
    }

    /**
     * Initialize clicked plane item
     */
    fun onPlaneClicked(plane: Plane) {
        _plane.value = plane
    }
}
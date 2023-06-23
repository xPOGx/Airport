package com.example.testapp.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.testapp.data.DataSource

class PlaneViewModel : ViewModel() {
    private var _planes = MutableLiveData<List<Plane>>()
    val planes: LiveData<List<Plane>> = _planes

    private var _plane = MutableLiveData<Plane>()
    val plane: LiveData<Plane> = _plane

    fun getPlaneList() {
        _planes.value = DataSource.planes
    }

    fun onPlaneClicked(plane: Plane) {
        _plane.value = plane
    }
}
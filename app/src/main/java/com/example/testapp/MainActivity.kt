package com.example.testapp

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI.setupActionBarWithNavController
import com.example.testapp.adapter.PlaneDrawerAdapter
import com.example.testapp.adapter.PlaneDrawerListener
import com.example.testapp.databinding.ActivityMainBinding
import com.example.testapp.model.PlaneViewModel
import com.example.testapp.ui.PlaneListFragmentDirections


/**
 * Main Activity and entry point for the app.
 */
class MainActivity : AppCompatActivity() {

    private val viewModel: PlaneViewModel by viewModels()

    private lateinit var navController: NavController
    private lateinit var binding: ActivityMainBinding
    private lateinit var drawerLayout: DrawerLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        drawerLayout = binding.drawerLayout
        setContentView(binding.root)

        val toolbar = binding.appBarMain.toolbar
        val drawerImage = binding.appBarMain.toolbarDrawer
        drawerImage.setOnClickListener { manageDrawer() }

        setSupportActionBar(toolbar)

        val headerLayout = binding.headerLayoutNavView
        headerLayout.imageViewHeader.setOnClickListener { manageDrawer() }

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController

        connectAdapter()

        setupActionBarWithNavController(this, navController)
    }

    private fun connectAdapter() {
        if (viewModel.planes.value == null) {
            viewModel.getPlaneList()
        }

        val adapterDrawer = PlaneDrawerAdapter(PlaneDrawerListener { plane ->
            viewModel.onPlaneClicked(plane)
            manageDrawer()
            navigationToNextFragment()
        })
        adapterDrawer.submitList(viewModel.planes.value)
        binding.navDrawerRecyclerView.adapter = adapterDrawer
    }

    private fun navigationToNextFragment() {
        val action = PlaneListFragmentDirections.actionPlaneListFragmentToPlaneDetailFragment(
            viewModel.plane.value!!.name
        )
        try {
            navController.navigate(action)
        } catch (e: Exception) {
            onSupportNavigateUp()
            navController.navigate(action)
        }

    }

    private fun manageDrawer() {
        if (drawerLayout.isDrawerOpen(GravityCompat.END)) {
            drawerLayout.closeDrawer(GravityCompat.END)
        } else {
            drawerLayout.openDrawer(GravityCompat.END)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }
}
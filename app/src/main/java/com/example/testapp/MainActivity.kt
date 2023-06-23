package com.example.testapp

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI.setupActionBarWithNavController
import com.example.testapp.databinding.ActivityMainBinding
import com.google.android.material.navigation.NavigationView


/**
 * Main Activity and entry point for the app.
 */
class MainActivity : AppCompatActivity() {

//    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var navController: NavController
    private lateinit var binding: ActivityMainBinding
    private lateinit var drawerLayout: DrawerLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val toolbar = binding.appBarMain.toolbar
        val drawerImage = binding.appBarMain.toolbarDrawer
        drawerImage.setOnClickListener { manageDrawer() }

        setSupportActionBar(toolbar)

        drawerLayout = binding.drawerLayout

        val navView: NavigationView = binding.navView
        val header = navView.getHeaderView(0)
        val imageClose: ImageView = header.findViewById(R.id.image_view_header)
        imageClose.setOnClickListener { manageDrawer() }

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController

        setupActionBarWithNavController(this, navController)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
//        appBarConfiguration = AppBarConfiguration(
//            navController.graph, drawerLayout
//        )

//        setupActionBarWithNavController(navController, appBarConfiguration)
//        navView.setupWithNavController(navController)
    }

    private fun manageDrawer() {
        if (drawerLayout.isDrawerOpen(GravityCompat.END)) {
            drawerLayout.closeDrawer(GravityCompat.END)
        } else {
            drawerLayout.openDrawer(GravityCompat.END)
        }
    }


//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        if (drawerLayout.isDrawerOpen(GravityCompat.END)) {
//            drawerLayout.closeDrawer(GravityCompat.END)
//        } else {
//            drawerLayout.openDrawer(GravityCompat.END)
//        }
//
//        return true
//    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }
}
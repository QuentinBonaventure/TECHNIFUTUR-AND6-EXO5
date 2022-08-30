package com.technifutur.neopixl.exo5


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.MenuItem
import android.view.View

import android.widget.TextView
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController

import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.*
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView
import com.technifutur.neopixl.exo5.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {


    private lateinit var binding: ActivityMainBinding
     lateinit var  drawerLayout: DrawerLayout


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        drawerLayout = binding.drawerLayout
        val navView: NavigationView = binding.navigationView



        val navhostFragment = supportFragmentManager.findFragmentById(R.id.navHostFragment) as NavHostFragment
        val navController = navhostFragment.navController
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)

            NavigationUI.setupWithNavController(bottomNavigationView, navController)
        setSupportActionBar(binding.toolbar)

       // setSupportActionBar(findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbar))

        val appBarConfiguration: AppBarConfiguration?
        appBarConfiguration = AppBarConfiguration(
            setOf(
                 R.id.basketFragment,
                R.id.tennisFragment,
                R.id.handFragment), drawerLayout

               // R.id.handFragment
            )
        binding.toolbar.setupWithNavController(navController,appBarConfiguration)




        NavigationUI.setupActionBarWithNavController(this,navController, appBarConfiguration)
       // setupActionBarWithNavController(navController,appBarConfiguration)
        NavigationUI.setupWithNavController(binding.navigationView, navController)


        navController.addOnDestinationChangedListener{ controller, destination, arguments ->
            when (destination.id) {
                R.id.basketFragment -> {findViewById<TextView>(R.id.toolbarTitle).text = resources.getString(R.string.basket)
                findViewById<BottomNavigationView>(R.id.bottomNavigationView).visibility = View.VISIBLE
                }
                R.id.tennisFragment ->{ findViewById<TextView>(R.id.toolbarTitle).text = resources.getString(R.string.tennis)
                findViewById<BottomNavigationView>(R.id.bottomNavigationView).visibility = View.VISIBLE}

                R.id.handFragment -> {findViewById<TextView>(R.id.toolbarTitle).text = resources.getString(R.string.hand)
                findViewById<BottomNavigationView>(R.id.bottomNavigationView).visibility = View.VISIBLE}

                R.id.infoFragment ->{ findViewById<TextView>(R.id.toolbarTitle).text = resources.getString(R.string.infos)
                    findViewById<BottomNavigationView>(R.id.bottomNavigationView).visibility = View.GONE}
                R.id.contactFragment -> {findViewById<TextView>(R.id.toolbarTitle).text = resources.getString(R.string.contactTitle)
                    findViewById<BottomNavigationView>(R.id.bottomNavigationView).visibility = View.GONE}
                R.id.pratiqueFragment2 ->{ findViewById<TextView>(R.id.toolbarTitle).text = resources.getString(R.string.pratiqueTitle)
                    findViewById<BottomNavigationView>(R.id.bottomNavigationView).visibility = View.GONE}
                R.id.entrainementFragment -> {findViewById<TextView>(R.id.toolbarTitle).text = resources.getString(R.string.entrainementTitle)
                    findViewById<BottomNavigationView>(R.id.bottomNavigationView).visibility = View.GONE}

                else -> findViewById<TextView>(R.id.toolbarTitle).text = null
            }
        }

        binding.navigationView.bringToFront()



    }

    // pour la fleche du retour
    override fun onSupportNavigateUp(): Boolean {
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.navHostFragment) as NavHostFragment
        val navController = navHostFragment.navController
        return navController.navigateUp()
    }

    override fun onBackPressed() {
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START)
        }else {
            super.onBackPressed()
        }

    }




}



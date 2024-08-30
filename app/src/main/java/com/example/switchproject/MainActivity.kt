package com.example.switchproject

import android.os.Bundle
import android.view.Menu
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.switchproject.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        try {
            removeAllFragmentsFromBottomNav()
            getNavController()
        }catch (e: Exception){
            e.printStackTrace()
        }


    }

    private fun getNavController(){
        val navHostFragmentView = supportFragmentManager.findFragmentById(R.id.navHostFragmentView) as NavHostFragment
        val navControllerView= navHostFragmentView.navController

        binding.bottomNav.setupWithNavController(navControllerView)

    }

    private fun removeAllFragmentsFromBottomNav(){
        binding.bottomNav.menu.removeItem(R.id.givingFragment)
        binding.bottomNav.menu.removeItem(R.id.happinessFragment)
        binding.bottomNav.menu.removeItem(R.id.kindnessFragment)
        binding.bottomNav.menu.removeItem(R.id.optimismFragment)
        binding.bottomNav.menu.removeItem(R.id.respectFragment)
    }

    fun addHappinessFragmentToBottomNav(isHappinessOn: Boolean){
        if(isHappinessOn && binding.bottomNav.menu.size()< 5){
            if (binding.bottomNav.menu.findItem(R.id.happinessFragment) == null) {
                binding.bottomNav.menu.add(Menu.NONE, R.id.happinessFragment, Menu.NONE, "Happiness")
                    .setIcon(R.drawable.ic_happiness)
            }
        }else {
            binding.bottomNav.menu.removeItem(R.id.happinessFragment)
        }
    }

    fun addGivingFragmentToBottomNav(isGivingOn: Boolean){
        if (isGivingOn && binding.bottomNav.menu.size()< 5){
            if (binding.bottomNav.menu.findItem(R.id.givingFragment) == null) {
                binding.bottomNav.menu.add(Menu.NONE, R.id.givingFragment, Menu.NONE, "Giving")
                    .setIcon(R.drawable.ic_giving)
            }
        }else {
            binding.bottomNav.menu.removeItem(R.id.givingFragment)
        }
    }

    fun addKindnessFragmentToBottomNav(isKindnessOn: Boolean){
        if(isKindnessOn && binding.bottomNav.menu.size()< 5){
            if (binding.bottomNav.menu.findItem(R.id.kindnessFragment) == null) {
                binding.bottomNav.menu.add(Menu.NONE, R.id.kindnessFragment, Menu.NONE, "Kindness")
                    .setIcon(R.drawable.ic_kindness)
            }
        }else {
            binding.bottomNav.menu.removeItem(R.id.kindnessFragment)
        }
    }

    fun addOptimismFragmentToBottomNav(isOptimismOn: Boolean){
        if(isOptimismOn && binding.bottomNav.menu.size()< 5){
            if (binding.bottomNav.menu.findItem(R.id.optimismFragment) == null) {
                binding.bottomNav.menu.add(Menu.NONE, R.id.optimismFragment, Menu.NONE, "Optimism")
                    .setIcon(R.drawable.ic_optimism)
            }
        }else {
            binding.bottomNav.menu.removeItem(R.id.optimismFragment)
        }
    }

    fun addRespectFragmentToBottomNav(isRespectOn: Boolean){
        if(isRespectOn && binding.bottomNav.menu.size()< 5){
            if (binding.bottomNav.menu.findItem(R.id.respectFragment) == null) {
                binding.bottomNav.menu.add(Menu.NONE, R.id.respectFragment, Menu.NONE, "Respect")
                    .setIcon(R.drawable.ic_respect)
            }
        }else {
            binding.bottomNav.menu.removeItem(R.id.respectFragment)
        }
    }

    fun hideBottomNav(isEgoChecked: Boolean){
        if (isEgoChecked){
            binding.bottomNav.visibility = View.GONE
        }else{
            binding.bottomNav.visibility = View.VISIBLE
        }
    }
}
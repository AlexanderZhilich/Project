package com.example.bottomnavigation.UI
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.viewpager.widget.ViewPager
import com.example.bottomnavigation.LocalModel.LocalModel
import com.example.bottomnavigation.R
import com.example.bottomnavigation.Repository.Repository
import com.example.bottomnavigation.ViewModel.ToleranceViewModel
import com.example.bottomnavigation.ViewModel.ToleranceViewModelFactory
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var viewModel: ToleranceViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomNavigationView=findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host) as NavHostFragment
        val navController = navHostFragment.navController
        val appBarConfiguration = AppBarConfiguration(setOf(R.id.all, R.id.get_one))
        val instruction=R.string.Instruction
        setupActionBarWithNavController(navController, appBarConfiguration)
        bottomNavigationView.setupWithNavController(navController)
        fab.setOnClickListener {
            val dialogBuilder = AlertDialog.Builder(this)
            dialogBuilder
                .setTitle("Инструкция")
                .setMessage(instruction)
                .setPositiveButton("Понятно"){_,_->
                    val text =
                    "Приятной работы"
                    val duration = Toast.LENGTH_LONG
                    val toast = Toast.makeText(this, text, duration)
                    toast.setGravity(Gravity.CENTER, 0, 0)
                    toast.show()}
            val dialog=dialogBuilder.create()
            dialog.show()
        }
        val localModel = LocalModel(this)
        val repository = Repository(localModel)
        val factory = ToleranceViewModelFactory(repository)

        viewModel = ViewModelProvider(this, factory).get(ToleranceViewModel::class.java)
        viewModel.tolerancesLive.setValue(mutableListOf())

        /*Запрет на тёмную тему*/
        AppCompatDelegate.setDefaultNightMode(
            AppCompatDelegate.MODE_NIGHT_NO)
    }

}
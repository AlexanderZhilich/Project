package com.example.bottomnavigation.UI

import android.app.ActionBar
import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.findNavController
import com.example.bottomnavigation.R
import kotlinx.android.synthetic.main.activity_main.*


class SplashFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        return inflater.inflate(R.layout.fragment_splash, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        (activity as AppCompatActivity).supportActionBar!!.hide()
        (activity as AppCompatActivity).bottomNavigationView.visibility = View.GONE
        val navController = findNavController()
        Handler().postDelayed(
            { navController.navigate(R.id.action_splashFragment_to_get_one) }, 1500
        )
    }
}
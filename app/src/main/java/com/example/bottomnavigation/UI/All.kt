package com.example.bottomnavigation.UI

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.bottomnavigation.R
import com.example.bottomnavigation.RemoteModel.FullTolerance
import com.example.bottomnavigation.ViewModel.ToleranceViewModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_all.*
import kotlinx.android.synthetic.main.fragment_get_one.*

class All : Fragment() {
    lateinit var navController: NavController
    lateinit var viewModel: ToleranceViewModel
    var fullTolerances = mutableListOf<FullTolerance>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(activity as MainActivity).get(ToleranceViewModel::class.java)
        return inflater.inflate(R.layout.fragment_all, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        (activity as AppCompatActivity).supportActionBar!!.show()
        (activity as AppCompatActivity).bottomNavigationView.visibility = View.VISIBLE
        (activity as AppCompatActivity).fab.visibility=View.GONE
        super.onViewCreated(view, savedInstanceState)
        navController = findNavController()
        viewModel.tolerancesLive.observe(viewLifecycleOwner, Observer {
            Log.d("!!!", it.toString())
            fullTolerances.clear()
            fullTolerances.addAll(it)
            recyclerView.adapter?.notifyDataSetChanged()
        })

        val adapter = ToleranceAdapter(fullTolerances, this)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(activity)
        buttonClearAll.setOnClickListener {
            fullTolerances.clear()
            viewModel.deleteAllTolerancesFromTolerancesLive()
            recyclerView.adapter?.notifyDataSetChanged()

        }
    }
    fun onLongClick(position: Int) {
        fullTolerances.removeAt(position)
        viewModel.deleteToleranceFromTolerancesLive(position)
        recyclerView.adapter?.notifyItemRemoved(position)
    }
}


package com.example.bottomnavigation.UI

import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.example.bottomnavigation.QueryBuilder
import com.example.bottomnavigation.R
import com.example.bottomnavigation.RemoteModel.FullTolerance
import com.example.bottomnavigation.ViewModel.ToleranceViewModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_all.*
import kotlinx.android.synthetic.main.fragment_get_one.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.Exception


class Get_one : Fragment() {
    lateinit var navController: NavController
    lateinit var viewModel: ToleranceViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(activity as MainActivity).get(ToleranceViewModel::class.java)
        return inflater.inflate(R.layout.fragment_get_one, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        (activity as AppCompatActivity).supportActionBar!!.show()
        (activity as AppCompatActivity).bottomNavigationView.visibility = View.VISIBLE
        (activity as AppCompatActivity).fab.visibility = View.VISIBLE
        super.onViewCreated(view, savedInstanceState)
        val queryBuilder = QueryBuilder()
        navController = findNavController()

        val tolerancesDroppingOutList = resources.getStringArray(R.array.Tolerances)
        val arrayAdapter =
            ArrayAdapter(requireContext(), R.layout.dropdown_item, tolerancesDroppingOutList)
        autoCompleteTextView.setAdapter(arrayAdapter)




        buttonGetOne.setOnClickListener {
            val tolerance = autoCompleteTextView.text.toString()
            if (tolerance != "Выберите посадку") {
                val toleranceRequest = queryBuilder.toleranceRequest(tolerance)
                val sizeIn = edSize.text.toString()
                val r1 = Regex("^\\d*\\.?\\d*\$")
                if (r1.matches(sizeIn) && sizeIn != "." && sizeIn.isNotEmpty()) {
                    val size = sizeIn.toDouble()
                    val sizeUp = queryBuilder.sizeUpRequest(size)
                    val sizeDw = queryBuilder.sizeDwRequest(size)
                    Log.d("2",sizeUp)
                    Log.d("2",sizeDw)
                    val fullSize = size.toString() + tolerance

                    val toleranceUp = queryBuilder.getTolerance(
                        viewModel.getOneTolerance(sizeUp),
                        toleranceRequest
                    )
                    Log.d("2",viewModel.getOneTolerance(sizeUp))
                    Log.d("2",viewModel.getOneTolerance(sizeDw))
                    Log.d("2",toleranceUp)
                    val toleranceDw = queryBuilder.getTolerance(
                        viewModel.getOneTolerance(sizeDw),
                        toleranceRequest
                    )
                    Log.d("2",toleranceDw)
                    if (toleranceUp != "-" && toleranceDw != "-") {
                        if (toleranceUp != "?" && toleranceDw != "?") {
                            val fullTolerance = FullTolerance(
                                fullSize,
                                toleranceUp.toDouble(),
                                toleranceDw.toDouble(),
                                size + toleranceUp.toDouble(),
                                size + toleranceDw.toDouble()

                            )
                            viewModel.addToTolerancesLive(fullTolerance)
                            edSize.text.clear()
                        } else {

                            val text =
                                "Основные отклонения $tolerance для любого квалитета не применяют для номинальных размеров до 1 мм включительно."
                            val duration = Toast.LENGTH_LONG
                            val toast = Toast.makeText(context, text, duration)
                            toast.setGravity(Gravity.CENTER, 0, 0)
                            toast.show()
                            return@setOnClickListener
                        }
                    } else {
                        val text =
                            "Значения для классов допусков t5, t6, t7, t8 для номинальных размеров до 24 мм включительно в программе не проставлены. Вместо них рекомендуется применять классы допусков u5, u6, u7, u8"
                        val duration = Toast.LENGTH_LONG
                        val toast = Toast.makeText(context, text, duration)
                        toast.setGravity(Gravity.CENTER, 0, 0)
                        toast.show()
                        return@setOnClickListener
                    }

                } else {
                    val text = "Введите целое или дробное число больше 0"
                    val duration = Toast.LENGTH_LONG

                    val toast = Toast.makeText(context, text, duration)
                    toast.setGravity(Gravity.CENTER, 0, 0)
                    toast.show()
                    return@setOnClickListener
                }
            } else {
                val text = "Посадка не выбрана"
                val duration = Toast.LENGTH_LONG

                val toast = Toast.makeText(context, text, duration)
                toast.setGravity(Gravity.CENTER, 0, 0)
                toast.show()
                return@setOnClickListener
            }
        }
    }
}



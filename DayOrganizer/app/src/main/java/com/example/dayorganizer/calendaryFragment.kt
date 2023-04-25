package com.example.dayorganizer

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dayorganizer.databinding.FragmentCalendaryBinding


class calendaryFragment : Fragment() {
    private var _binding: FragmentCalendaryBinding? =null
    private val binding get()= _binding!!
    private val mainVM by activityViewModels<MainViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentCalendaryBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = DaysAdapter(
            daysList = mainVM.loadDataFromDB(),
            onDayClick = {
                day -> mainVM.setDay(day)
                //wysweitl liste taskow dla tego dnia
            }
        )
        binding.calendarViewDaysList.layoutManager = LinearLayoutManager(requireContext())
        binding.calendarViewDaysList.adapter = adapter


        binding.calendarViewEditButt.setOnClickListener {
            findNavController().navigate(R.id.action_calendaryFragment_to_detailFragment)
            Toast.makeText(context, mainVM.loadDataFromDB().size.toString(), Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}
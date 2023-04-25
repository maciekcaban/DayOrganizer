package com.example.dayorganizer

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.dayorganizer.databinding.DaysRowBinding

class DaysAdapter(private val daysList: List<Day>,
                  private val onDayClick: (Day) -> Unit )
    :RecyclerView.Adapter<DaysAdapter.MyDaysViewHolder>()
{

    inner class MyDaysViewHolder(binding: DaysRowBinding): ViewHolder(binding.root){
        val name = binding.daysRowDate
        //nwm czy tzreba tu liste zadan wrzucic

        init{
            binding.root.setOnClickListener{
                onDayClick(daysList[adapterPosition])
            }
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyDaysViewHolder {
        return MyDaysViewHolder(
            binding = DaysRowBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return daysList.size
    }

    override fun onBindViewHolder(holder: MyDaysViewHolder, position: Int) {
        holder.name.text = daysList[position].date
    }

}
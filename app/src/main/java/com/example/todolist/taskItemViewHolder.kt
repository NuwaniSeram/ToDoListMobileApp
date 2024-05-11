package com.example.todolist

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import com.example.todolist.databinding.TaskItemBoxBinding
import java.time.format.DateTimeFormatter

class taskItemViewHolder(
    private val context: Context,
    private val binding: TaskItemBoxBinding
): RecyclerView.ViewHolder(binding.root) {

    private val timeFormat = DateTimeFormatter.ofPattern("HH:mm")
    fun bindtaskItem(taskItem: TaskItem){
        binding.name.text = taskItem.name

        if(taskItem.dueTime != null)
            binding.time.text = timeFormat.format(taskItem.dueTime)

        else
            binding.time.text = ""
    }
}
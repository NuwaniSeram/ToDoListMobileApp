package com.example.todolist

import android.content.Context
import android.graphics.Paint
import androidx.recyclerview.widget.RecyclerView
import com.example.todolist.databinding.TaskItemBoxBinding
import java.time.format.DateTimeFormatter

class taskItemViewHolder(
    private val context: Context,
    private val binding: TaskItemBoxBinding,
    private val clickListener: TaskItemClickListener
): RecyclerView.ViewHolder(binding.root) {

    private val timeFormat = DateTimeFormatter.ofPattern("HH:mm")
    fun bindtaskItem(taskItem: TaskItem){
        binding.name.text = taskItem.name

        if (taskItem.isCompleted()){
            binding.name.paintFlags = Paint.STRIKE_THRU_TEXT_FLAG
            binding.time.paintFlags = Paint.STRIKE_THRU_TEXT_FLAG
        }

        binding.completeBtn.setImageResource(taskItem.imageResource())
        binding.completeBtn.setColorFilter(taskItem.imagecolor(context))

        binding.completeBtn.setOnClickListener{
            clickListener.completeTaskItem(taskItem)
        }
        binding.taskBoxContainer.setOnClickListener{
            clickListener.editTaskItem(taskItem)
        }

        if(taskItem.dueTime() != null)
            binding.time.text = timeFormat.format(taskItem.dueTime())

        else
            binding.time.text = ""
    }
}
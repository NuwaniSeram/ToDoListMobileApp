package com.example.todolist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.todolist.databinding.TaskItemBoxBinding

class TaskItemAdapter(
    private val taskItems: List<TaskItem>
): RecyclerView.Adapter<taskItemViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): taskItemViewHolder {
        val from = LayoutInflater.from(parent.context)
        val binding = TaskItemBoxBinding.inflate(from, parent, false)
        return taskItemViewHolder(parent.context, binding)
    }

    override fun getItemCount(): Int = taskItems.size

    override fun onBindViewHolder(holder: taskItemViewHolder, position: Int) {
        holder.bindtaskItem(taskItems[position])
    }
}
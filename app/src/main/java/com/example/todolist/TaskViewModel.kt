package com.example.todolist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import java.time.LocalTime
import java.time.LocalDate
import java.util.UUID

class TaskViewModel(private val repo: TaskItemRepo): ViewModel() {

    var taskItems: LiveData<List<TaskItem>> = repo.allTaskItems.asLiveData()

    fun addTaskItem(newTask: TaskItem) = viewModelScope.launch {
        repo.insertTaskItem(newTask)
    }

    fun updateTaskItem(taskItem: TaskItem) = viewModelScope.launch {
        repo.updateTaskItem(taskItem)
    }

    fun setCompleted(taskItem: TaskItem) = viewModelScope.launch {
        if (!taskItem.isCompleted()){
            taskItem.completedDateString = TaskItem.dateFormatter.format(LocalDate.now())
        }
        repo.updateTaskItem(taskItem)
    }
}

class TaskItemModelFactory(private val repo: TaskItemRepo): ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(TaskViewModel::class.java)){
            return TaskViewModel(repo) as T
        }
        throw IllegalArgumentException("Unknown Class for View Model")
    }
}
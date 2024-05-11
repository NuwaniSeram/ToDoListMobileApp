package com.example.todolist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.lifecycle.ViewModelProvider
import com.example.todolist.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var taskViewModel: TaskViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        taskViewModel = ViewModelProvider(this).get(TaskViewModel::class.java)
        binding.newTaskBtn.setOnClickListener {
            NewTask().show(supportFragmentManager, "newTaskTag")
        }

        taskViewModel.name.observe(this){
            binding.tName.text = String.format("Task Name: %s", it)
        }
        taskViewModel.description.observe(this){
            binding.tDecs.text = String.format("Task description: %s", it)
        }
    }

}
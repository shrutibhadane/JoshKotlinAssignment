package com.projects.joshkotlinassignment

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.projects.joshkotlinassignment.databinding.ActivityMainBinding

private lateinit var binding: ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        var clickCount: Int = 0

        binding.clickButton.setOnClickListener {

            // get user input
            val userInput: String = binding.editText.text.toString().trim()
            var num: Int = 0

            if (userInput != "") {
                num = userInput.toInt()
            }

            if (num != 0) {

                clickCount += 1

                // show/hide layout
                binding.textView.visibility = View.GONE
                binding.recyclerView.visibility = View.VISIBLE

                // this creates a vertical layout Manager
                binding.recyclerView.layoutManager = LinearLayoutManager(this)

                // ArrayList of class ItemsViewModel
                val data = ArrayList<ItemsViewModel>()

                // This loop will create 20 Views containing
                // the image with the count of view
                for (i in 1..num) {
                    data.add(ItemsViewModel(+i))
                }

                // This will pass the ArrayList to our Adapter
                val adapter = MainAdapter(clickCount, data)

                // Setting the Adapter with the recyclerview
                binding.recyclerView.adapter = adapter

            } else {

                // show/hide layout
                binding.textView.visibility = View.VISIBLE
                binding.recyclerView.visibility = View.GONE

                Toast.makeText(
                    this@MainActivity,
                    "Please enter your input.",
                    Toast.LENGTH_SHORT
                ).show()

            }
        }

    }
}
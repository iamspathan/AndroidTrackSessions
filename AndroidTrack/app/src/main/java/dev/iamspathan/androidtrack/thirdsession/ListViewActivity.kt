package dev.iamspathan.androidtrack.thirdsession

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import dev.iamspathan.androidtrack.R
import dev.iamspathan.androidtrack.databinding.ActivityListViewBinding

class ListViewActivity : AppCompatActivity() {

    lateinit var binding : ActivityListViewBinding

    val fruitArray =  mutableListOf("Apple", "Banana","Pinapple", "Orange", "Papaya", "Melon",
        "Grapes", "Water Melon","Lychee", "Guava", "Mango", "Kivi","Banana","Pinapple", "Orange", "Papaya", "Melon",
        "Grapes", "Water Melon","Lychee", "Guava", "Mango", "Kivi")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListViewBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val fruitAdapter = ArrayAdapter<String>(applicationContext, android.R.layout.simple_list_item_1, fruitArray)
        binding.fruitListView.adapter = fruitAdapter
    }
}
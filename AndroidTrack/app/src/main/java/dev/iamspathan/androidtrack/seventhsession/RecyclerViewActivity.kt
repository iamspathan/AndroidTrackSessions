package dev.iamspathan.androidtrack.seventhsession

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemClickListener
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import dev.iamspathan.androidtrack.R
import dev.iamspathan.androidtrack.databinding.ActivityRecyclerViewBinding
import dev.iamspathan.androidtrack.databinding.ActivityRelativeLayoutDemoBinding

class RecyclerViewActivity : AppCompatActivity(), onItemClickListener{

    val personList = mutableListOf(
        Person("Sohail Pathan",R.drawable.snapchat, "Nagpur,MH", "Biryani" ),
        Person("Sanchita Kasat",R.drawable.snapchat, "Surat, Gujarat", "Momos" ),
        Person("Shreya Santoshwar",R.drawable.snapchat, "Nagpur, MH", "Pav Bhaji" ),
        Person("Saniya Imroze",R.drawable.snapchat, "Nagpur, MH", "Pizza")
    )


    lateinit var  binding  : ActivityRecyclerViewBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecyclerViewBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.personRecyclerView.adapter = PersonAdapter(personList,this)
        binding.personRecyclerView.layoutManager = LinearLayoutManager(this)
    }


}
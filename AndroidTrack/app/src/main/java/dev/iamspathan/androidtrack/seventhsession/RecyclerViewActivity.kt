package dev.iamspathan.androidtrack.seventhsession

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import dev.iamspathan.androidtrack.R
import dev.iamspathan.androidtrack.databinding.ActivityRecyclerViewBinding

class RecyclerViewActivity : AppCompatActivity(), OnPersonClickListener{

    val personList = mutableListOf(
        Person("Sohail Pathan","https://firebasestorage.googleapis.com/v0/b/gdg-nagpur-web-app.appspot.com/o/sohail.jpg?alt=media&token=d4cabccb-3831-4027-9772-2d4362c81603", "Nagpur,MH", "Biryani" , "https://www.linkedin.com/in/iamspathan/"),
        Person("Sanchita Kasat","https://firebasestorage.googleapis.com/v0/b/gdg-nagpur-web-app.appspot.com/o/WTM%20Team%2Fsanchita.jpg?alt=media&token=5c84f9cf-2530-49db-afc1-85697bb3676a", "Surat, Gujarat", "Momos" ,"http://www.linkedin.com/in/sanchita-kasat0500"),
        Person("Shreya Santoshwar","https://firebasestorage.googleapis.com/v0/b/gdg-nagpur-web-app.appspot.com/o/WTM%20Team%2Fkavya.jpg?alt=media&token=1c3c8a67-5008-47fb-9d6d-386323d689b4", "Nagpur, MH", "Pav Bhaji" ,"https://www.linkedin.com/in/shreya-santoshwar-666447197/"),
        Person("Saniya Imroze","https://firebasestorage.googleapis.com/v0/b/gdg-nagpur-web-app.appspot.com/o/WTM%20Team%2Fsaniya.jpg?alt=media&token=cecd8c03-62dc-4d72-993a-ca15f634f52f", "Nagpur, MH", "Pizza","https://www.linkedin.com/in/saniya-imroze-144a72192")
    )


    lateinit var  binding  : ActivityRecyclerViewBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecyclerViewBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.personRecyclerView.adapter = PersonAdapter(personList,this, this)
        binding.personRecyclerView.layoutManager = LinearLayoutManager(this)
    }

    override fun onPersonClick(position: Int) {
       //Navigate to another Activity
        val intent = Intent(Intent.ACTION_VIEW)
        intent.data = Uri.parse(personList[position].linkedInProfile)
        startActivity(intent)
    }
}
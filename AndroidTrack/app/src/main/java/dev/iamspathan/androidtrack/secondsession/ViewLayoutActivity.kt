package dev.iamspathan.androidtrack.secondsession

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import dev.iamspathan.androidtrack.R
import dev.iamspathan.androidtrack.databinding.ActivitySecondBinding
import dev.iamspathan.androidtrack.databinding.ActivityViewLayoutBinding
import dev.iamspathan.androidtrack.firstsession.SecondActivity

class ViewLayoutActivity : AppCompatActivity() {

    lateinit var binding : ActivityViewLayoutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityViewLayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.validButton.setOnClickListener {
            if (binding.usernameEditText.text.isEmpty() || binding.passwordEditText.text.isEmpty()){
                Toast.makeText(this, "Please enter the correct value", Toast.LENGTH_SHORT).show()
            }else {
                val intent = Intent(this, SuccessLoginActivity::class.java)
                startActivity(intent)
            }

            Log.d("EDITEXT", "${binding.usernameEditText.text} ")
        }
    }

}
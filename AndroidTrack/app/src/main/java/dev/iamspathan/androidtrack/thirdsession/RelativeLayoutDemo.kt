package dev.iamspathan.androidtrack.thirdsession

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import dev.iamspathan.androidtrack.R
import dev.iamspathan.androidtrack.databinding.ActivityRelativeLayoutDemoBinding
import dev.iamspathan.androidtrack.secondsession.SuccessLoginActivity

class RelativeLayoutDemo : AppCompatActivity() {

    lateinit var binding : ActivityRelativeLayoutDemoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRelativeLayoutDemoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.submitButton.setOnClickListener {
            validateForm()
        }
    }



    fun validateForm(){

        //Either one of the gender Radiobutton should be selected and CheckBox should be marked -> New Activity
        // If  Not, It should show Toast that you haven't marked one of the entity.

        if ((binding.maleRadioButton.isChecked || binding.femaleRadioButton.isChecked) && binding.termsCheckBox.isChecked) {
            startActivity(Intent(this, SuccessLoginActivity::class.java))
        }else{
            Toast.makeText(this, "You haven't marked one of the entity", Toast.LENGTH_SHORT).show()
        }




    }






}
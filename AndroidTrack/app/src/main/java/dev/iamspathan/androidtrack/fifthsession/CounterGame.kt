package dev.iamspathan.androidtrack.fifthsession

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import dev.iamspathan.androidtrack.R
import dev.iamspathan.androidtrack.databinding.ActivityCounterGameBinding

class CounterGame : AppCompatActivity() {

    private var mCount = 0

    private val KEY = "SANCHITA"

    lateinit var binding : ActivityCounterGameBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCounterGameBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    fun increment(view: View){
        mCount+=1
        binding.showCount.text = mCount.toString()

    }

    fun decrement(view: View){
        mCount-=1
        binding.showCount.text = mCount.toString()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(KEY,mCount)

    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        val saveValue = savedInstanceState.getInt(KEY)
        mCount = saveValue
        binding.showCount.text = saveValue.toString()
    }

    override fun onBackPressed() {
        Toast.makeText(this, "You Pressed Back", Toast.LENGTH_SHORT).show()

        val alertDialog = AlertDialog.Builder(this)
        alertDialog.setTitle("Are you sure you want to exit ?")

        alertDialog.setPositiveButton("Yes", DialogInterface.OnClickListener { dialog, which ->
            finishAffinity()
        })

        alertDialog.setNegativeButton("No", DialogInterface.OnClickListener { dialog, which ->

        })

        alertDialog.show()

    }












}
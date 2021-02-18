package dev.iamspathan.androidtrack.sixthsession

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import dev.iamspathan.androidtrack.R
import dev.iamspathan.androidtrack.databinding.ActivityFragmentDemoBinding

class FragmentDemoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFragmentDemoBinding

    val TAG = "FRAGMENTDEMO"

    val NAME = "FragmentDemoActivity"

    val fragmentManager = supportFragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFragmentDemoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Log.d(TAG, "$NAME OnCreate")

        /*
        * -> SupportFragmentManager
        * -> Initialize fragment Transaction
        * -> ADD/REPLACE/REMOVE
        * -> COMMIT
        * */

        fragmentManager
            .beginTransaction()
            .add(R.id.fragmentContainer, FirstFragment())
            .commit()
    }


    override fun onStart() {
        super.onStart()
        Log.d(TAG, "$NAME OnStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "$NAME OnResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "$NAME OnPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "$NAME OnStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "$NAME OnDestroy")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "$NAME OnRestart")
    }

}
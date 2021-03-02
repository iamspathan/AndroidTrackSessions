package dev.iamspathan.androidtrack.workmanagersession

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.work.Constraints
import androidx.work.Data
import androidx.work.NetworkType.CONNECTED
import androidx.work.OneTimeWorkRequest
import androidx.work.PeriodicWorkRequest
import androidx.work.WorkManager
import dev.iamspathan.androidtrack.databinding.ActivityWoerkManagerDemoNewBinding
import java.util.concurrent.TimeUnit.MINUTES

class WorkManagerDemoNew : AppCompatActivity() {

        companion object{
            const val KEY = "dev.iamspathan.androidtrack.workmanagersession"
        }


    lateinit var binding: ActivityWoerkManagerDemoNewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWoerkManagerDemoNewBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.buttonStart.setOnClickListener {
          startSingleExecution()
        }

    }

    private fun periodicWorkExecution(){

        val constraint = Constraints.Builder()
            .setRequiresCharging(true)
            .setRequiredNetworkType(CONNECTED)
            .setRequiresBatteryNotLow(true)
            .build()

        val workManager = WorkManager.getInstance(applicationContext)

        val periodicuploadWorkRequest  = PeriodicWorkRequest.Builder(
            UploadWorkRequest::class.java,
            15,
            MINUTES)
            .setConstraints(constraint)
            .build()

        workManager.enqueue(periodicuploadWorkRequest)
        workManager.getWorkInfoByIdLiveData(periodicuploadWorkRequest.id).observe(
            this, Observer {
                binding.statusTextView.text = it.state.name
            }
        )

    }


    private fun startSingleExecution(){


        val workManager = WorkManager.getInstance(applicationContext)
        val inputData = Data.Builder()
            .putInt(KEY, 600000)
            .build()

        val uploadWorkRequest  = OneTimeWorkRequest.Builder(UploadWorkRequest::class.java)
            .setInputData(inputData)
            .build()

        val downloadWorkRequest  = OneTimeWorkRequest.Builder(DownloadWorkRequest::class.java)
            .build()

        val dispatchWorkRequest = OneTimeWorkRequest.Builder(DispatchWorkRequest::class.java)
            .build()


        workManager
            .beginWith(uploadWorkRequest)
            .then(dispatchWorkRequest)
            .then(downloadWorkRequest)
            .enqueue()


        workManager.getWorkInfoByIdLiveData(uploadWorkRequest.id).observe(
            this, Observer {
                binding.statusTextView.text = it.state.name

                if (it.state.isFinished) {

                    val currentDate = it.outputData.getString("DATE")

                    Toast.makeText(this, "$currentDate", Toast.LENGTH_LONG).show()
                }

            }
        )

    }

}
package dev.iamspathan.androidtrack.tenthsession

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
import dev.iamspathan.androidtrack.databinding.ActivityWorkManagerDemoBinding
import java.util.concurrent.TimeUnit.SECONDS

class WorkManagerDemo : AppCompatActivity() {

    lateinit var activityWorkManagerDemoBinding: ActivityWorkManagerDemoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityWorkManagerDemoBinding = ActivityWorkManagerDemoBinding.inflate(layoutInflater)
        setContentView(activityWorkManagerDemoBinding.root)

        activityWorkManagerDemoBinding.startWork.setOnClickListener {
            periodicWorkRequest()
        }

    }


    private fun periodicWorkRequest(){

        val workManager  = WorkManager.getInstance(applicationContext)

        val workRequest = PeriodicWorkRequest.Builder(DownloadWork::class.java, 10, SECONDS)
            .build()

        workManager.enqueue(workRequest)

    }



    private fun oneTimeWorkRequest(){

        val constraint = Constraints.Builder()
            .setRequiresCharging(true)
            .setRequiredNetworkType(CONNECTED)
            .build()

        val workManager = WorkManager.getInstance(applicationContext)

        val data = Data.Builder()
            .putInt("CONSTANT", 60000)
            .build()

        val uploadRequest = OneTimeWorkRequest.Builder(UploadWork::class.java)
            .setConstraints(constraint)
            .build()

        val filterRequest = OneTimeWorkRequest.Builder(FilteringWork::class.java)
            .build()

        val downloadingRequest = OneTimeWorkRequest.Builder(DownloadWork::class.java)
            .build()

        val parallelWorker = mutableListOf<OneTimeWorkRequest>()
        parallelWorker.add(filterRequest)
        parallelWorker.add(downloadingRequest)

        workManager.beginWith(parallelWorker)
            .then(uploadRequest)
            .enqueue()

        workManager.getWorkInfoByIdLiveData(uploadRequest.id)
            .observe(this, Observer {
                activityWorkManagerDemoBinding.statusTextView.text = it.state.name

                if (it.state.isFinished) {
                    val date = it.outputData.getString(UploadWork.KEY_WORKER)
                    Toast.makeText(this, "$date", Toast.LENGTH_SHORT).show()
                }
            })

        }


}
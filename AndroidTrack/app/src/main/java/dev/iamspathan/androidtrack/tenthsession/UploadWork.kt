package dev.iamspathan.androidtrack.tenthsession

import android.content.Context
import android.util.Log
import androidx.work.Data
import androidx.work.Worker
import androidx.work.WorkerParameters
import java.text.SimpleDateFormat
import java.util.Date

class UploadWork(context: Context, workerParameters: WorkerParameters) : Worker(context,workerParameters) {

    companion object {
        const val KEY_WORKER = "TIME_KEY"
    }

    override fun doWork(): Result {
        try {
            val count = inputData.getInt("CONSTANT", 1)
            for (i in 0 until 1000 ){
                Log.d("MYTAG", "UPLOADING $i" )
            }

            val date = SimpleDateFormat("dd-mm-yyyy hh:mm:ss")
            val currentDate = date.format(Date())
            val data = Data.Builder()
                .putString(KEY_WORKER, currentDate)
                .build()

            return Result.success(data)
        }catch (e:Exception){
            return Result.failure()
        }

    }
}
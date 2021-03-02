package dev.iamspathan.androidtrack.workmanagersession

import android.content.Context
import android.util.Log
import androidx.work.Data
import androidx.work.Worker
import androidx.work.WorkerParameters
import dev.iamspathan.androidtrack.tenthsession.UploadWork
import dev.iamspathan.androidtrack.tenthsession.UploadWork.Companion
import java.lang.Exception
import java.text.SimpleDateFormat
import java.util.Date

class UploadWorkRequest(context: Context, workerParameters: WorkerParameters) : Worker(context, workerParameters){

    val TAG = "WORK"

    override fun doWork(): Result {

        try {
            val outputData = inputData.getInt(WorkManagerDemoNew.KEY, 1000)
            for (i in 0..100) {
                Log.d(TAG, "UPLOADING $i")
            }
            val date = SimpleDateFormat("dd-mm-yyyy hh:mm:ss")
            val currentDate = date.format(Date())
            val data = Data.Builder()
                .putString("DATE", currentDate)
                .build()
            return Result.success(data)
    }catch (e:Exception){
         return Result.failure()

        }
    }

}
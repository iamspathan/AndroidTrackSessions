package dev.iamspathan.androidtrack.workmanagersession

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters
import java.lang.Exception

class DispatchWorkRequest (context: Context, workerParameters: WorkerParameters) : Worker(context, workerParameters){

    val TAG = "WORK"

    override fun doWork(): Result {

        try {
            for (i in 0..100) {
                Log.d(TAG, "DISPATCHING $i")
            }
            return Result.success()
        }catch (e: Exception){
            return Result.failure()

        }
    }

}
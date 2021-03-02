package dev.iamspathan.androidtrack.tenthsession

import android.content.Context
import android.util.Log
import androidx.work.Data
import androidx.work.Worker
import androidx.work.WorkerParameters
import java.text.SimpleDateFormat
import java.util.Date

class FilteringWork(context: Context, workerParameters: WorkerParameters) : Worker(context,workerParameters) {


    override fun doWork(): Result {
        try {
            val count = inputData.getInt("CONSTANT", 1)
            for (i in 0 until 1000 ){
                Log.d("MYTAG", "Filtering $i" )
            }

            return Result.success()
        }catch (e:Exception){
            return Result.failure()
        }

    }
}
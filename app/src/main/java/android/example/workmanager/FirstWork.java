package android.example.workmanager;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

public class FirstWork extends Worker {

    public FirstWork(@NonNull Context context, @NonNull WorkerParameters workerParams) {
        super(context, workerParams);
    }

    @NonNull
    @Override
    public Result doWork() {
        Context context = getApplicationContext();

        try{

            Utils.buildStatusNotification(context);
            return Result.success();

        } catch (Exception e) {
            e.printStackTrace();
            return Result.failure();
        }

    }
}

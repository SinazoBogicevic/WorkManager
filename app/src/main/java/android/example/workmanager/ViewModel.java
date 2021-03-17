package android.example.workmanager;

import android.app.Application;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;
import androidx.work.WorkRequest;

public class ViewModel extends AndroidViewModel {
    private final WorkManager workManager;

    public ViewModel(@NonNull Application application) {
        super(application);
        workManager = WorkManager.getInstance(application);
    }

    public void showNotification(){
        WorkRequest workRequest = new OneTimeWorkRequest.Builder(FirstWork.class).build();
        workManager.enqueue(workRequest);
    }


}

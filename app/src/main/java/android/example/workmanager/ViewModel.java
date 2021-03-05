package android.example.workmanager;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

public class ViewModel extends AndroidViewModel {

    public ViewModel(@NonNull Application application) {
        super(application);
    }

    public void showNotification(Context context){
        Utils.buildNotification(context);
        Log.i("Test", "showNotification: ");
    }
}

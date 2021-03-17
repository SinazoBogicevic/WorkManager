package android.example.workmanager;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import static android.example.workmanager.Constants.CHANNEL_ID;
import static android.example.workmanager.Constants.NOTIFICATION_ID;
import static android.example.workmanager.Constants.NOTIFICATION_MESSAGE;
import static android.example.workmanager.Constants.NOTIFICATION_TITLE;

final class Utils {

    private Utils(){}

    static void buildNotificationChannel(Context context){
        // without channel, notification will be ignore on
        // devices running API 26+
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            CharSequence name = String.valueOf(R.string.channel_name);
            CharSequence description = String.valueOf(R.string.channel_description);
            int importance = NotificationManager.IMPORTANCE_LOW;

            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, name, importance);
            channel.setDescription((String) description);

            //after setting the channel, importance cannot be changed
            // or other notification behaviour

            NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

            if(notificationManager != null){
                notificationManager.createNotificationChannel(channel);
            }

        }

    }

    static void buildStatusNotification(Context context){
        //creates the notification
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, CHANNEL_ID);
        builder.setSmallIcon(R.drawable.ic_launcher_background)
                .setContentTitle(NOTIFICATION_TITLE)
                .setContentText(NOTIFICATION_MESSAGE)
                .setPriority(NotificationCompat.PRIORITY_LOW);

        //shows the notification
        NotificationManagerCompat.from(context).notify(NOTIFICATION_ID, builder.build());
    }
}

package admob.deneme.yecappbank.uygulamaicibildirim;

import android.annotation.TargetApi;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import      android.app.Notification;
import      android.app.PendingIntent;
import      android.content.Intent;
import      android.app.NotificationManager;
import android.widget.Toast;



public class MainActivity extends AppCompatActivity {
    Handler handle = null;
    Runnable runnable = null;
    int zaman;
    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Uri alarmSound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);


        zaman = 10;
        handle = new Handler();
        runnable = new Runnable() {

            @Override
            public void run() {

               zaman--;
                if (zaman == 2) {


                    long[] vibrate = {0,300,400};
                    Intent intent = new Intent(MainActivity.this, bildirim.class);
                    PendingIntent pIntent = PendingIntent.getActivity(MainActivity.this, (int) System.currentTimeMillis(), intent, 0);
                    Notification myNotify  = new Notification.Builder(MainActivity.this)

                            .setContentText("Yaklaşan etkinliklerinizi görmek için tıklayınız.")
                            .setSmallIcon(R.drawable.ic_launcher)
                            .setContentIntent(pIntent)
                            .setVibrate(vibrate)
                            .setSound(alarmSound)
                            .setAutoCancel(true).build();
                    NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                    notificationManager.notify(0, myNotify);


                } else {
                    handle.removeCallbacks(runnable);


                }
                handle.postDelayed(runnable, 1000);

            }
        };
        runnable.run();















    }




}

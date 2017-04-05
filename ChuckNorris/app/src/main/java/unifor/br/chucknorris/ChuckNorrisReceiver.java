package unifor.br.chucknorris;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.app.TaskStackBuilder;

/**
 * Created by Bruno Lopes on 04/04/2017.
 */

public class ChuckNorrisReceiver extends BroadcastReceiver {

    public static final int REQUEST_CODE = 1;
    public static final int NOTIFICATION_ID = 2;

    @Override
    public void onReceive(Context context, Intent intent) {

        if ("CHUCK_NORRIS".equals(intent.getAction())) {

            Notification.Builder builder = new Notification.Builder(context)
                    .setContentTitle("Chuck Norris")
                    .setContentText("Existe uma nova missão para você!")
                    .setSmallIcon(R.mipmap.ic_launcher)
                    .setAutoCancel(true);

            Intent resultIntent = new Intent(context, ChuckNorrisActivity.class);

            TaskStackBuilder stackBuilder = TaskStackBuilder.create(context);
            stackBuilder.addParentStack(ChuckNorrisActivity.class);
            stackBuilder.addNextIntent(resultIntent);

            PendingIntent pit = stackBuilder.getPendingIntent(REQUEST_CODE,
                    PendingIntent.FLAG_UPDATE_CURRENT);
            builder.setContentIntent(pit);

            NotificationManager notificationManager = (NotificationManager)
                    context.getSystemService(Context.NOTIFICATION_SERVICE);
            notificationManager.notify(NOTIFICATION_ID, builder.build());

        }

    }

}

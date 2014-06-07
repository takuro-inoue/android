/**
 *
 */
package takinoue.missionstatement.broadcastreceiver;

import java.util.Calendar;
import java.util.TimeZone;

import takinoue.missionstatement.activity.MainActivity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * 定時に画面を起動するためのBroadcastReceiver
 */
public class SetTimerBroadcastReceiver extends BroadcastReceiver{

    @Override
    public void onReceive(Context context, Intent intent) {

        Intent createActivityIntent = new Intent(context, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, createActivityIntent, 0);

        // 起動する時刻のCalendar(15:00:00)
        Calendar calendarSet = Calendar.getInstance(TimeZone.getTimeZone("Asia/Tokyo"));
        calendarSet.set(Calendar.HOUR_OF_DAY, 15);
        calendarSet.set(Calendar.MINUTE, 0);
        calendarSet.set(Calendar.SECOND, 0);

        // 現時刻のCalendar
        Calendar calendarNow = Calendar.getInstance(TimeZone.getTimeZone("Asia/Tokyo"));

        // 起動する時刻が現時刻より過去の場合は翌日に
        if(calendarSet.compareTo(calendarNow) <= 0) {
            calendarSet.add(Calendar.DATE, 1);
        }

        AlarmManager alarmManager = (AlarmManager)context.getSystemService(Context.ALARM_SERVICE);
        alarmManager.set(AlarmManager.RTC_WAKEUP, calendarSet.getTimeInMillis(), pendingIntent);
    }
}

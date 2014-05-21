
package takinoue.missionstatement.activity;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.TimeZone;

import takinoue.missionstatement.R;
import takinoue.missionstatement.bean.MissionStatementBean;
import takinoue.missionstatement.helper.DBHelper;
import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.animation.AlphaAnimation;
import android.widget.TextView;

public class MainActivity extends Activity {

    private DBHelper dbHelper;

    private ArrayList<MissionStatementBean> missionStatementBeanList;
    private int index = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbHelper = new DBHelper(getApplicationContext(), "missionStatement", 1);
        missionStatementBeanList = dbHelper.getMissionStatementAtCategory(1);
        missionStatementBeanList.addAll(dbHelper.getMissionStatementAtCategory(4));

        MissionStatementBean missionStatementBean = missionStatementBeanList.get(index);
        index++;

        // 言葉
        TextView wordsTextView = (TextView) findViewById(R.id.wordsTextView);
        wordsTextView.setText(missionStatementBean.getWords());

        // 人名
        TextView personTextView = (TextView) findViewById(R.id.personTextView);
        personTextView.setText(missionStatementBean.getPerson());

        // 定時に画面を起動するための処理
        setTimer();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    /**
     * タップされた時の処理.
     */
    @Override
    public boolean onTouchEvent(MotionEvent event) {

        switch (event.getAction() & MotionEvent.ACTION_MASK) {
            case MotionEvent.ACTION_DOWN:
                // タップされたとき

                //フェードインするアニメーション
                AlphaAnimation alphaAnimation = new AlphaAnimation(Float.valueOf("0.2"), Float.valueOf("1.0"));
                alphaAnimation.setDuration(200);

                if(index < missionStatementBeanList.size()) {

                    MissionStatementBean missionStatementBean = missionStatementBeanList.get(index);

                    // 言葉
                    TextView wordsTextView = (TextView) findViewById(R.id.wordsTextView);
                    wordsTextView.setText(missionStatementBean.getWords());
                    wordsTextView.setAnimation(alphaAnimation);

                    // 人名
                    TextView personTextView = (TextView) findViewById(R.id.personTextView);
                    personTextView.setText(missionStatementBean.getPerson());
                    personTextView.setAnimation(alphaAnimation);

                    index++;

                }else {

                    finish();
                }
        }

        return super.onTouchEvent(event);
    }

    /**
     * 定時に画面を起動するための処理.
     */
    private void setTimer() {

        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(getApplicationContext(), 0, intent, 0);

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

        AlarmManager alarmManager = (AlarmManager)getSystemService(ALARM_SERVICE);
        alarmManager.set(AlarmManager.RTC_WAKEUP, calendarSet.getTimeInMillis(), pendingIntent);
    }

}

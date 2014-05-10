
package takinoue.missionstatement.activity;

import java.util.ArrayList;

import takinoue.missionstatement.R;
import takinoue.missionstatement.bean.MissionStatementBean;
import takinoue.missionstatement.helper.DBHelper;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MotionEvent;
import android.widget.TextView;
import android.view.animation.AlphaAnimation;

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
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

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

}

package yoav.ex3;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.SystemClock;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class MyAsync extends AsyncTask<Activity, Void, Long>{
    private Activity main;
    @Override
    protected Long doInBackground(Activity... activity) {
        main=activity[0];
        return SystemClock.elapsedRealtime();
    }
    @Override
    protected void onPostExecute(Long startTime) {
        long time=SystemClock.elapsedRealtime() - (startTime);
        Intent intent = new Intent(main, AsyncAndHandlerActivity.class);
        String msg ="The Time It Took For Async: "+String.valueOf(time);
        intent.putExtra(EXTRA_MESSAGE, msg);
        intent.putExtra("msg2",Color.RED);
        main.startActivity(intent);
    }

}

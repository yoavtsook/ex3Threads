package yoav.ex3;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.widget.Button;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class MyHandlerThread extends HandlerThread {
    private Handler mHandler;
    private Looper mLooper;
    private Activity myActivity;
    private Activity myActivity;
    Long time;
    public MyHandlerThread(String name,Activity activity){
        super(name);
        time=SystemClock.elapsedRealtime();
        myActivity=activity;
    }

    public void run() {
        myActivity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(myActivity, AsyncAndHandlerActivity.class);
                time=SystemClock.elapsedRealtime()-time;
                String message ="time passed: "+String.valueOf(time);
                intent.putExtra(EXTRA_MESSAGE, message);
                intent.putExtra("msg2", Color.YELLOW);
                myActivity.startActivity(intent);
            }
        });
        this.quit();
    }
}

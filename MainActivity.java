package yoav.ex3;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Activity main;
    Button async;
    Button handler_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        main=this;
        async=findViewById(R.id.syncBtn);
        handler_button=findViewById(R.id.handler);
        async.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            MyAsync sync=new MyAsync();
            sync.execute(main);
            }
        });
        handler_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyHandlerThread my_handler_thread=new MyHandlerThread("myHandler",main);
                my_handler_thread.start();
            }
        });
    }
}

package yoav.ex3;

import android.graphics.Color;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.text.style.BackgroundColorSpan;
import android.widget.EditText;
import android.widget.TextView;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class AsyncAndHandlerActivity extends AppCompatActivity {
    String MSG="msg2";
	int background;
    EditText time;
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.async_and_handler_view);
        background=0;
        time=findViewById(R.id.edit);
        String str;
        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if(extras != null) {
                str= extras.getString(EXTRA_MESSAGE);
                background=extras.getInt(MSG);
            } else {
                str= null;
            }
        } else {
            str= (String) savedInstanceState.getSerializable(EXTRA_MESSAGE);
        }
        ConstraintLayout bgElement = (ConstraintLayout) findViewById(R.id.my_constraint);
        bgElement.setBackgroundColor(background);
        time.setText(str);
    }
}

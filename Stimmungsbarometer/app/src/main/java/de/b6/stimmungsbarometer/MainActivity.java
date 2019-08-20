package de.b6.stimmungsbarometer;

import androidx.appcompat.app.AppCompatActivity;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseObject;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ImageButton button0,button1,button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("604b921fe3728d7bd9540b79a4247aa98a7963ef")
                .server("http://192.168.44.9/parse/")
                .build()
        );

        button0=(ImageButton)findViewById(R.id.button);
        button0.setOnClickListener(this);
        button1=findViewById(R.id.button2);
        button1.setOnClickListener(this);
        button2=findViewById(R.id.button3);
        button2.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        ParseObject gameScore = new ParseObject("Mood_B6");
        gameScore.put("time", Calendar.getInstance().getTime());
        switch (view.getId()){
            case R.id.button:
                gameScore.put("mood",0);
                break;
                case R.id.button2:
                gameScore.put("mood",1);
                break;
            case R.id.button3:
                gameScore.put("mood",2);
                break;
        }
        gameScore.saveInBackground();
        Toast.makeText(this, "Danke für dein Feedback!", Toast.LENGTH_LONG).show();
        button0.setEnabled(false);
        button1.setEnabled(false);
        button2.setEnabled(false);

        button0.postDelayed(new Runnable() {
            @Override
            public void run() {
                button0.setEnabled(true);
                button1.setEnabled(true);
                button2.setEnabled(true);
            }
        },3000);
    }
}

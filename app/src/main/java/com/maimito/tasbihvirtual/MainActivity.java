package com.maimito.tasbihvirtual;

import android.content.Context;
import android.os.Bundle;
import android.os.Vibrator;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {
    TextView counter, th, rh;
    FloatingActionButton reset;
    Button toucharea;
    int count, counttotal;
    Vibrator v;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);

        toucharea = findViewById(R.id.touchArea);
        th = findViewById(R.id.touchHint);
        rh = findViewById(R.id.resetHint);
        counter = findViewById(R.id.counter);
        reset = findViewById(R.id.resetButton);

        toucharea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rh.setVisibility(View.INVISIBLE);
                th.setVisibility(View.INVISIBLE);
                if(count < 32){
                    count++;
                    v.vibrate(50);
                }
                else {
                    count = 0;
                    v.vibrate(500);
                }
                counttotal++;
                counter.setText(Integer.toString(counttotal));

            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count = 0;
                counttotal = 0;
                counter.setText(Integer.toString(counttotal));
            }
        });
    }
}
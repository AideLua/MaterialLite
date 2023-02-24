package io.github.jesse205.materiallite;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import io.github.jesse205.materiallite.widget.MaterialButton;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MaterialButton btn1=findViewById(R.id.btn1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
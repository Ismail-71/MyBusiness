package com.example.mybusiness;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

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
    }

    public void lunchSettings(View view){
        Intent i = new Intent(this, SettingActivity.class);

        startActivity(i);
    }

    public void Disable(View v) {

        v.setEnabled(false);
        Log.d("Button", "Button Clicked");

        Button b = (Button) v;
        b.setText(R.string.disabled);

        View vv = findViewById(R.id.button3);
        vv.setEnabled(false);

        Button bb = (Button) vv;
        bb.setText(R.string.disabled);
        Toast.makeText(this, "new click", Toast.LENGTH_LONG).show();


    }
}
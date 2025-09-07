package com.example.mybusiness;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class DashboardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        Toolbar toolbar = findViewById(R.id.toolbar_dashboard);
        setSupportActionBar(toolbar);
        // No need to set title here as it's set in XML, but you can if needed
        // if (getSupportActionBar() != null) {
        //     getSupportActionBar().setTitle(R.string.title_activity_dashboard);
        // }
    }
}

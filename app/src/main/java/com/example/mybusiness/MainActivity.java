package com.example.mybusiness;


import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText editTextUsername;
    private EditText editTextPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        editTextUsername = findViewById(R.id.editTextUsername);
        editTextPassword = findViewById(R.id.editTextPassword);
        Button buttonLogin = findViewById(R.id.buttonLogin);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        buttonLogin.setOnClickListener(v -> loginUser());
    }

    private void loginUser() {
        String username = editTextUsername.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();

        if (TextUtils.isEmpty(username)) {
            editTextUsername.setError(getString(R.string.error_username_empty));
            editTextUsername.requestFocus();
            return;
        }

        if (TextUtils.isEmpty(password)) {
            editTextPassword.setError(getString(R.string.error_password_empty));
            editTextPassword.requestFocus();
            return;
        }

        // --- IMPORTANT: Hardcoded credentials for demonstration ONLY ---
        // --- In a real app, validate against a backend or secure storage ---
        if (username.equals("user") && password.equals("password")) {
            Toast.makeText(MainActivity.this, R.string.login_successful, Toast.LENGTH_SHORT).show();
            // TODO: Navigate to another activity upon successful login
            // For example:

            // finish(); // Optional: finish MainActivity so user can't go back to login screen
        } else {
            Toast.makeText(MainActivity.this, R.string.login_failed, Toast.LENGTH_SHORT).show();
        }
    }
}
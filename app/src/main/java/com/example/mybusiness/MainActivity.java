package com.example.mybusiness;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
// Removed Toast import as it's no longer used for login success/failure

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText editTextUsername;
    private EditText editTextPassword;
    private TextView textViewLoginError; // TextView for displaying login errors/success

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // EdgeToEdge.enable(this); // Consider if EdgeToEdge is still needed/desired for a login screen
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar_main);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(R.string.login_title);
        }

        editTextUsername = findViewById(R.id.editTextUsername);
        editTextPassword = findViewById(R.id.editTextPassword);
        Button buttonLogin = findViewById(R.id.buttonLogin);
        textViewLoginError = findViewById(R.id.textViewLoginError); // Initialize the TextView

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

        // Hide message before validation
        textViewLoginError.setVisibility(View.GONE);

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
            textViewLoginError.setText(R.string.login_successful);
            textViewLoginError.setBackgroundColor(ContextCompat.getColor(this, R.color.success_background_green));
            textViewLoginError.setVisibility(View.VISIBLE);
            // TODO: Navigate to another activity upon successful login
            // For example:
            // Intent intent = new Intent(MainActivity.this, HomeActivity.class);
            // startActivity(intent);
            // finish(); // Optional: finish MainActivity so user can't go back to login screen
        } else {
            textViewLoginError.setText(R.string.login_failed);
            textViewLoginError.setBackgroundColor(ContextCompat.getColor(this, R.color.error_background_red));
            textViewLoginError.setVisibility(View.VISIBLE);
        }
    }
}

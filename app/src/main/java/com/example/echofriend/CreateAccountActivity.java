package com.example.echofriend;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class CreateAccountActivity extends AppCompatActivity {

    EditText mainName, surname, handle, userEmail, loginPass;
    Button signUp;
    TextView existingAccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_create_account);

        mainName = findViewById(R.id.firstName);
        surname = findViewById(R.id.lastName);
        handle = findViewById(R.id.username);
        userEmail = findViewById(R.id.email);
        loginPass = findViewById(R.id.password);
        signUp = findViewById(R.id.createAccountBtn);
        existingAccount = findViewById(R.id.alreadyAccount);

        signUp.setOnClickListener(v -> createAccount());

        existingAccount.setOnClickListener(view -> {
            Intent intent = new Intent(CreateAccountActivity.this, LoginActivity.class);
            startActivity(intent);
            finish();
        });
    }

    private void createAccount() {
        String firstNameStr = mainName.getText().toString().trim();
        String lastNameStr = surname.getText().toString().trim();
        String usernameStr = handle.getText().toString().trim();
        String emailStr = userEmail.getText().toString().trim();
        String passwordStr = loginPass.getText().toString().trim();

        if (TextUtils.isEmpty(firstNameStr) || TextUtils.isEmpty(lastNameStr) ||
                TextUtils.isEmpty(usernameStr) || TextUtils.isEmpty(emailStr) ||
                TextUtils.isEmpty(passwordStr)) {
            Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
            return;
        }

        String successMessage = "Account created for " + usernameStr;
        Toast.makeText(this, successMessage, Toast.LENGTH_LONG).show();

        Intent intent = new Intent(CreateAccountActivity.this, LoginActivity.class);
        startActivity(intent);
        finish();
    }
}

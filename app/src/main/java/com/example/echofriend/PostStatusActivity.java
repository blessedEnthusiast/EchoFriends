package com.example.echofriend;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class PostStatusActivity extends AppCompatActivity {

    private EditText statusInput;
    private Button postButton;

    // Simple in-memory store for status posts
    public static List<String> posts = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_status);

        statusInput = findViewById(R.id.statusEditText);
        postButton = findViewById(R.id.postStatusButton);

        postButton.setOnClickListener(v -> postStatus());
    }

    private void postStatus() {
        String statusText = statusInput.getText().toString().trim();

        if (TextUtils.isEmpty(statusText)) {
            Toast.makeText(this, "Please enter a status", Toast.LENGTH_SHORT).show();
            return;
        }

        // Add new status to list (newest first)
        posts.add(0, statusText);

        Toast.makeText(this, "Status posted!", Toast.LENGTH_SHORT).show();

        // Clear input after posting
        statusInput.setText("");
    }
}

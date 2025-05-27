package com.example.echofriend;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class FriendsActivity extends AppCompatActivity {
    public ImageView backButton;
    public Button searchButton;
    public EditText friendsUsername;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_friends);

        backButton = (ImageView) findViewById(R.id.friends_backButton);
        searchButton = (Button) findViewById(R.id.searchButton);
        friendsUsername = (EditText)  findViewById(R.id.friends_username);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FriendsActivity.this, HomeActivity.class);
                startActivity(intent);
                finish();
            }
        });

        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            String username = friendsUsername.getText().toString();
            //to be continued
            }
        });
    }
}
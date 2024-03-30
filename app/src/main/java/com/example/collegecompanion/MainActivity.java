package com.example.collegecompanion;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button chatbotButton = findViewById(R.id.chatbotButton);
        chatbotButton.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, ChatbotActivity.class)));

        Button studentCornerButton = findViewById(R.id.studentCornerButton);
        studentCornerButton.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, StudentCornerActivity.class)));

        Button idCardButton = findViewById(R.id.idCardButton);
        idCardButton.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, IDCardActivity.class)));
    }
}


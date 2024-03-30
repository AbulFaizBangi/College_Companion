package com.example.collegecompanion;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;

import androidx.appcompat.app.AppCompatActivity;

public class IDCardActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_id_card);
        // Implement ID card functionality

    }
    private static final int PICK_IMAGE_REQUEST = 1;
    private void openGallery() {
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(intent, PICK_IMAGE_REQUEST);
    }

}
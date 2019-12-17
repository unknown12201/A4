package com.example.cameraapplication;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ImageView ivCaputredImage;
    Button btnOpenCamera;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ivCaputredImage = (ImageView) findViewById(R.id.ivCaputredImage);
        btnOpenCamera = (Button) findViewById(R.id.btnOpenCamera);
        btnOpenCamera.setOnClickListener(this);
    }

    // Opne Camera
    @Override
    public void onClick(View v)
    {
        Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(cameraIntent,1001);
    }

    // Getting the Caputered Image into ImageView


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        if (requestCode == 1001)
        {
            Bitmap mBitmap = (Bitmap) data.getExtras().get("data");
            ivCaputredImage.setImageBitmap(mBitmap);
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}


package com.mobicule.newdocscanner;

import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import java.io.FileNotFoundException;
import java.io.IOException;

public class ImageActivity extends AppCompatActivity {

    ImageView img;
    Bitmap bmp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);

        img = findViewById(R.id.img);

        Uri uri = getIntent().getExtras().getParcelable("Uri");
        try {
            bmp = MediaStore.Images.Media.getBitmap(getContentResolver(), uri);
            //getContentResolver().delete(uri, null, null);
            img.setImageBitmap(bmp);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

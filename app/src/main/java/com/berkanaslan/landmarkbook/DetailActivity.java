package com.berkanaslan.landmarkbook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.media.Image;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ImageView imageView = (ImageView)findViewById(R.id.imageView2);
        TextView textView = (TextView)findViewById(R.id.textView);

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");

        textView.setText(name);
        /*imageView.setImageBitmap(MainActivity.selectedImage);*/

        Globals globals = Globals.getInstance();
        Bitmap bitmap = globals.getData();
        imageView.setImageBitmap(bitmap);

    }
}

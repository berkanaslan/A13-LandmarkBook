package com.berkanaslan.landmarkbook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    static Bitmap selectedImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView)findViewById(R.id.listView);
        /* Landmark Names Array*/
        final ArrayList<String> landmarkNames = new ArrayList<String>();
        landmarkNames.add("Pisa Tower");
        landmarkNames.add("Roma Colosseum");
        landmarkNames.add("Eiffel Tower");
        landmarkNames.add("London Bridge");

        /* Landmark Image Bitmap Resources*/
        Bitmap pisa = BitmapFactory.decodeResource(getApplication().getResources(),R.drawable.pisatower);
        Bitmap romaColosseum = BitmapFactory.decodeResource(getApplication().getResources(),R.drawable.colesseum);
        Bitmap eiffelTower = BitmapFactory.decodeResource(getApplication().getResources(),R.drawable.eiffel);
        Bitmap londonBridge = BitmapFactory.decodeResource(getApplication().getResources(),R.drawable.londonbridge);

        /*L Landmark Images Array*/
        final ArrayList<Bitmap> landmarkImages = new ArrayList<Bitmap>();
        landmarkImages.add(pisa);
        landmarkImages.add(romaColosseum);
        landmarkImages.add(eiffelTower);
        landmarkImages.add(londonBridge);

        /* landmarkNames == listView*/
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, landmarkNames);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Intent intent = new Intent(getApplicationContext(), DetailActivity.class);

                intent.putExtra("name", landmarkNames.get(i));
                /*selectedImage = landmarkImages.get(i);*/

                Bitmap bitmap = landmarkImages.get(i);
                Globals globals = Globals.getInstance();
                globals.setData(bitmap);

                startActivity(intent);



            }
        });





    }
}

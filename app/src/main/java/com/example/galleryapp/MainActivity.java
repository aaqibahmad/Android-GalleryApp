package com.example.galleryapp;

import android.app.Activity;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Gallery;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends Activity
{
    ImageButton button;
    ImageView selectedImage;
    private Integer[] mImageIds = {
            R.drawable.picture_one,
            R.drawable.picture_two,
            R.drawable.picture_three,
            R.drawable.picture_four,
            R.drawable.picture_five,
            R.drawable.picture_six,
            R.drawable.picture_seven,
            R.drawable.picture_eight
    };
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button=(ImageButton)findViewById(R.id.imageButton);
        Gallery gallery = (Gallery) findViewById(R.id.gallery1);
        selectedImage=(ImageView)findViewById(R.id.imageView1);
        gallery.setSpacing(2);
        gallery.setAdapter(new GalleryImageAdapter(this));

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(), ImageSwitcherActivity.class);
                startActivity(intent);
            }
        });
        // clicklistener for Gallery
        gallery.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this,"Image Selected", Toast.LENGTH_SHORT).show();
                // show the selected Image
                selectedImage.setImageResource(mImageIds[position]);
            }

        });
    }

}

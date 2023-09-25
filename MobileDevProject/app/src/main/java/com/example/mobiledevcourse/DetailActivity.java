package com.example.mobiledevcourse;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent in = getIntent();
        int index = in.getIntExtra("com.example.mobiledevcourse.ITEM_INDEX", -1);
        Log.d("asd", Integer.toString(index));

        if (index > -1) {
            int pic = getImg(index);
            ImageView img = (ImageView) findViewById(R.id.imageView);
            scaleImg(img, pic);
        }

        TextView name = (TextView) findViewById(R.id.NameTextView);
        TextView power= (TextView) findViewById(R.id.PowerTextView);
        TextView Weight = (TextView) findViewById(R.id.WeightTextView);

        name.setText(MainActivity.vehicles[index]);
        power.setText("Power: " + MainActivity.powers[index]);
        Weight.setText("Weight: " + MainActivity.weights[index]);


    }

    private int getImg(int index) {
        switch (index) {
            case 0: return R.drawable.xfg;
            case 1: return R.drawable.xrt;
            case 2: return R.drawable.lx6;
            case 3: return R.drawable.fbm;
            case 4: return R.drawable.bf1;
            default: return -1;
        }
    }

    private void scaleImg(ImageView img, int pic) {
        Display screen = getWindowManager().getDefaultDisplay();
        BitmapFactory.Options options = new BitmapFactory.Options();

        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(getResources(), pic, options);

        int imgWidth = options.outWidth;
        int screenWidth = screen.getWidth();

        if (imgWidth > screenWidth) {
            int ratio = Math.round( (float)imgWidth / (float)screenWidth);
            options.inSampleSize = ratio;

        }

        options.inJustDecodeBounds = false;
        Bitmap scaledImg = BitmapFactory.decodeResource(getResources(), pic, options);
        img.setImageBitmap(scaledImg);

    }
}
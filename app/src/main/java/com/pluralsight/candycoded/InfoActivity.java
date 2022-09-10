package com.pluralsight.candycoded;

import static com.pluralsight.candycoded.util.IntentUtils.hasResolvedActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;

public class InfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        Uri uri = Uri.parse("android.resource://com.codeschool.candycoded/" + R.drawable.store_front);
        ImageView candyStoreImageView = (ImageView) findViewById(R.id.image_view_candy_store);
        Picasso.with(this).load(uri).into(candyStoreImageView);
    }

    // ***
    // TODO - Task 2 - Launch the Google Maps Activity
    // ***
    public void createMapIntent(View view) {
//        final Uri uri = Uri.parse("google.streetview:cbll=46.414382,10.013988");
        final Uri uri = Uri.parse("geo:0,0?q=618 E South St Orlando, FL 32801");
        final Intent mapIntent = new Intent(Intent.ACTION_VIEW, uri)
                .setPackage("com.google.android.apps.maps");

//        if (mapIntent.resolveActivity(getPackageManager()) != null) {
        if (hasResolvedActivity(this, mapIntent)) {
            startActivity(mapIntent);
        }
    }

    // ***
    // TODO - Task 3 - Launch the Phone Activity
    // ***
    public void createPhoneIntent(View view) {
        final Uri uri = Uri.parse("tel:0123456789");
//        final Intent phoneIntent = new Intent(Intent.ACTION_DIAL, uri);
        final Intent phoneIntent = new Intent(Intent.ACTION_DIAL);
        phoneIntent.setData(uri);
        startActivity(phoneIntent);
    }

}

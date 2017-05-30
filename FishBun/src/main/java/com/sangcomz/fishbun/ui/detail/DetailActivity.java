package com.sangcomz.fishbun.ui.detail;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;

import com.sangcomz.fishbun.R;
import com.sangcomz.fishbun.define.Define;

import java.util.ArrayList;

public class DetailActivity extends AppCompatActivity {
    private ArrayList<Uri> pickedImages = new ArrayList<>();
    private Uri[] images;
    private int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        }
        setContentView(R.layout.activity_detail_actiivy);
        initValue();
        initAdapter();
    }

    private void initValue() {
        Intent intent = getIntent();
        pickedImages = intent.getParcelableArrayListExtra(Define.BUNDLE_NAME.PICKED_IMAGES.name());
        position = intent.getIntExtra(Define.BUNDLE_NAME.POSITION.name(), -1);
        Parcelable[] parcelables = intent.getBundleExtra(Define.BUNDLE_NAME.IMAGES.name()).getParcelableArray(Define.BUNDLE_NAME.IMAGES.name());
        if (parcelables != null) {
            images = new Uri[parcelables.length];
            System.arraycopy(parcelables, 0, images, 0, parcelables.length);
        }
    }

    private void initAdapter(){

    }
}

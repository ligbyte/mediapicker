package com.cy.mediapicker.activity;

import android.content.Intent;
import android.view.View;

import com.cy.mediapicker.R;
import com.cy.mediapicker.entity.Photo;
import com.cy.mediapicker.entity.PhotoDirectory;
import com.cy.mediapicker.util.MediaManager;

import java.util.ArrayList;

public class AlbumActivity extends MediaPickerActivity implements MediaManager.OnCheckchangeListener {

    public static final String EXTREA_PHOTOS = "photos";


    protected void readIntentParams() {
        Intent intent = getIntent();
        selectMode = intent.getBooleanExtra(EXTREA_SELECT_MODE, true);
        btnSend.setVisibility(selectMode ? View.VISIBLE : View.GONE);
        ArrayList<Photo> photoArrayList = (ArrayList<Photo>) intent.getSerializableExtra(EXTREA_PHOTOS);


        ArrayList<PhotoDirectory> photoDirectoryArrayList = new ArrayList<>();
        PhotoDirectory photoDirectory = new PhotoDirectory();
        photoDirectory.setPhotos(photoArrayList);
        photoDirectory.setSelected(true);
        photoDirectoryArrayList.add(photoDirectory);
        MediaManager.getInstance().setPhotoDirectorys(photoDirectoryArrayList);
        MediaManager.getInstance().setSelectIndex(0);
    }


    @Override
    protected void initUi() {
        super.initUi();
        findViewById(R.id.bottom).setVisibility(View.GONE);
    }
}

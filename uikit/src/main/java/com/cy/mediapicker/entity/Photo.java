package com.cy.mediapicker.entity;

import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;

import java.io.Serializable;

/**
 * Created by donglua on 15/6/30.
 */
public class Photo implements Serializable {

    private int id;
    private String path;
    private String mimetype;
    private long duration;
    private int width, height;
    private long size;
    private long adddate;
    private boolean fullImage;//是否使用原图，默认图片传送需要进过压缩。

    public Photo(int id, String path, String mimetype, int width, int height, long size) {
        this.id = id;
        this.path = path;
        this.mimetype = mimetype;
        this.width = width;
        this.height = height;
        this.size = size;
    }


    public Photo() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Photo)) return false;

        Photo photo = (Photo) o;

        return id == photo.id;
    }

    public long getAdddate() {
        return adddate;
    }

    public void setAdddate(long adddate) {
        this.adddate = adddate;
    }

    public boolean isFullImage() {
        return fullImage;
    }

    public void setFullImage(boolean fullImage) {
        this.fullImage = fullImage;
    }

    public String getMimetype() {
        return mimetype;
    }

    public void setMimetype(String mimetype) {
        this.mimetype = mimetype;
    }

    @Override
    public int hashCode() {
        return id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public String getMediaUri() {
        if (Build.VERSION.SDK_INT >= 29) {
            Uri mediaUri = mimetype.startsWith("image") ? MediaStore.Images.Media.EXTERNAL_CONTENT_URI : MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
            return mediaUri.buildUpon().appendPath(String.valueOf(getId())).build().toString();
        } else {
            return "file:///" + getPath();
        }
    }

    @Override
    public String toString() {
        return "Photo{" +
                "id=" + id +
                ", path='" + path + '\'' +
                ", mimetype='" + mimetype + '\'' +
                ", duration=" + duration +
                ", width=" + width +
                ", height=" + height +
                ", size=" + size +
                ", fullImage=" + fullImage +
                '}';
    }
}

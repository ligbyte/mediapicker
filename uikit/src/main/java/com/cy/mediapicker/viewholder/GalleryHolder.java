package com.cy.mediapicker.viewholder;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.recyclerview.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.cy.mediapicker.R;
import com.cy.mediapicker.view.SquareImageView;

/**
 * Created by Administrator on 2017/3/14.
 */

public class GalleryHolder extends RecyclerView.ViewHolder {
    public SquareImageView thumbIv;
    public AppCompatCheckBox appCompatCheckBox;
    public TextView tvVideoDuration,tvGifFlag;
    public ImageView ivVideoFlag;

    public GalleryHolder(View itemView) {
        super(itemView);
        itemView.setClickable(true);
        thumbIv = (SquareImageView) itemView.findViewById(R.id.iv_thumb);
        thumbIv.setScaleType(ImageView.ScaleType.CENTER_CROP);
        appCompatCheckBox = (AppCompatCheckBox) itemView.findViewById(R.id.cb_media);
        tvVideoDuration = (TextView) itemView.findViewById(R.id.tv_video_duration);
        tvGifFlag = (TextView) itemView.findViewById(R.id.tv_gif_flag);
        ivVideoFlag = (ImageView) itemView.findViewById(R.id.iv_video_flag);
        thumbIv.setShade(new ColorDrawable(Color.parseColor("#92000000")));
    }
}
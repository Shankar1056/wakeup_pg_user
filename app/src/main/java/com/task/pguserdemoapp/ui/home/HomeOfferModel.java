package com.task.pguserdemoapp.ui.home;

import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.google.gson.annotations.SerializedName;

public class HomeOfferModel {
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    @SerializedName("id")
    int id;
    @SerializedName("image")
    String image;
    @SerializedName("description")
    String description;
    @SerializedName("status")
    Boolean status;


    @BindingAdapter("image")
    public static void loadImage(ImageView view, String imageUrl) {
        Glide.with(view.getContext())
                .load(imageUrl).apply(new RequestOptions().circleCrop())
                .into(view);
    }

    public HomeOfferModel(int id, String image, String description, Boolean status) {
        this.id = id;
        this.image = image;
        this.description = description;
        this.status = status;
    }

}

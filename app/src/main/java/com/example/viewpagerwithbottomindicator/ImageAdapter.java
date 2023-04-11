package com.example.viewpagerwithbottomindicator;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ImageViewHolder> {

    private static final int[] IMAGES = {R.drawable.dice_1, R.drawable.dice_1, R.drawable.dice_1};
    private LayoutInflater inflater;

    public ImageAdapter(Context context) {
        inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = inflater.inflate(R.layout.item_image, parent, false);
        return new ImageViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ImageViewHolder holder, int position) {
        holder.image.setImageResource(IMAGES[position]);
    }

    @Override
    public int getItemCount() {
        return IMAGES.length;
    }

    class ImageViewHolder extends RecyclerView.ViewHolder {

        ImageView image;

        ImageViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image_holder);
        }
    }
}

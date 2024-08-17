package com.example.trealthapp;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

    ImageView imageView;
    TextView nameView, priceView;
    private String context;

    public MyViewHolder(@NonNull View itemView) {
        super(itemView);
        nameView = itemView.findViewById(R.id.name);
        priceView = itemView.findViewById(R.id.price);
        imageView = itemView.findViewById(R.id.imageview);

        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int position = getAdapterPosition();
        Toast.makeText(itemView.getContext(), "position: " + position, Toast.LENGTH_SHORT).show();

        // Get the context from the item view
        Context context = itemView.getContext();

        // Start the new activity
        Intent intent = new Intent(context, LabTestDetailsActivity.class);
        // Assuming you want to pass some data to the new activity
        intent.putExtra("ITEM_POSITION", position);
        intent.putExtra("Package", nameView.getText());
        context.startActivity(intent);
    }

}

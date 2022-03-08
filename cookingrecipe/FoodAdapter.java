package com.example.cookingrecipe;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.FoodHolder> {

    List<FoodItem> data;
    int selectedItem = 0;

    private Context mcontext;

    private ArrayList<String> mImageNames = new ArrayList<>();
    private ArrayList<String> mImages = new ArrayList<>();

    ///////

    public FoodAdapter(Context context, List<FoodItem> data){
        this.data = data;
        this.mcontext = context;
    }


    @NonNull
    @Override
    public FoodHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.food_holder,parent,false);

        return new FoodHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FoodHolder holder, int position) {
        holder.time.setText(String.format("Mins %d",data.get(position).getTime()));
        holder.image.setImageResource(data.get(position).getImage());
        holder.title.setText(data.get(position).getName());
        holder.ratingBar.setRating(data.get(position).getRating());

        if(selectedItem == position){
            holder.cardView.animate().scaleX(1.1f);
            holder.cardView.animate().scaleY(1.1f);
            holder.title.setTextColor(Color.WHITE);
            holder.time.setTextColor(Color.WHITE);
            holder.llbackground.setBackgroundResource(R.drawable.splash);

        }
        else {
            holder.cardView.animate().scaleX(1.1f);
            holder.cardView.animate().scaleY(1.1f);
            holder.title.setTextColor(Color.BLACK);
            holder.time.setTextColor(Color.BLACK);
            holder.llbackground.setBackgroundResource(R.color.white);
        }

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class FoodHolder extends RecyclerView.ViewHolder {
        RatingBar ratingBar;
        ImageView image;
        TextView title;
        TextView time;
        LinearLayout llbackground;

        CardView cardView;
        public FoodHolder(View holder){
            super(holder);
            ratingBar = holder.findViewById(R.id.rating);
            title = holder.findViewById(R.id.food_title);
            image = holder.findViewById(R.id.food_img);
            time = holder.findViewById(R.id.txt_time);
            cardView = holder.findViewById(R.id.food_background);
            llbackground = holder.findViewById(R.id.ll_background);

            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    selectedItem = getAdapterPosition();
                    notifyDataSetChanged();
                    Intent i = new Intent(mcontext, Recipe.class);
                    mcontext.startActivity(i);
                }
            });
        }
    }
}


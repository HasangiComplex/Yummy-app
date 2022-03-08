package com.example.cookingrecipe;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.graphics.PorterDuff;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.card.MaterialCardView;

import java.util.List;

public class FoodCategoryAdapter extends RecyclerView.Adapter<FoodCategoryAdapter.CategoryHolder>{

    List<FoodCategory> data;
    Context context;
    int selectedItem = 0;

    OnCategoryClick onCategoryClick;

    public interface OnCategoryClick{
        void onClick(int pos);
    }

    public FoodCategoryAdapter(List<FoodCategory> data, Context context,OnCategoryClick onCategoryClick){
        this.context = context;
        this.data = data;
        this.onCategoryClick = onCategoryClick;
    }

    @NonNull
    @Override
    public CategoryHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.category_holder,parent,false);
        return new CategoryHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryHolder holder, int position) {
        holder.image.setImageResource(data.get(position).getImage());
        holder.title.setText(data.get(position).getName());
        if(position== selectedItem){
            holder.cardView.setOutlineSpotShadowColor(context.getColor(R.color.red));
            holder.cardView.setOutlineAmbientShadowColor(context.getColor(R.color.red));
            holder.title.setTextColor(context.getColor(R.color.red));
            holder.cardView.setStrokeWidth(2);
            holder.image.setColorFilter(ContextCompat.getColor(context,R.color.red), PorterDuff.Mode.SRC_IN);
        }else{
            holder.cardView.setOutlineSpotShadowColor(context.getColor(R.color.gray));
            holder.cardView.setOutlineAmbientShadowColor(context.getColor(R.color.gray));
            holder.title.setTextColor(context.getColor(R.color.gray));
            holder.cardView.setStrokeWidth(0);
            holder.image.setColorFilter(ContextCompat.getColor(context,R.color.gray), PorterDuff.Mode.SRC_IN);

        }
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class CategoryHolder extends RecyclerView.ViewHolder{
        TextView title;
        ImageView image;
        MaterialCardView cardView;
        public CategoryHolder(View holder){
            super(holder);
            title = holder.findViewById(R.id.txt_title);
            image = holder.findViewById(R.id.img);
            cardView = holder.findViewById(R.id.card_view);

            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    selectedItem = getAdapterPosition();

                    if(onCategoryClick !=null){
                        onCategoryClick.onClick(getAdapterPosition());

                    }
                    notifyDataSetChanged();
                }
            });
        }

    }
}

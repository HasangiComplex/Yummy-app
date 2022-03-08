package com.example.cookingrecipe;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerCategories;
    RecyclerView recyclerItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerCategories = findViewById(R.id.recycler_categories);
        recyclerItems = findViewById(R.id.recycler_food);

        setCategories();
        setFoodItems(0);

    }

    private void setCategories(){
        List<FoodCategory> data = new ArrayList<>();

        FoodCategory foodCategory = new FoodCategory("Rice", R.drawable.ic_rice);
        FoodCategory foodCategory2 = new FoodCategory("Curry", R.drawable.ic_curry);
        FoodCategory foodCategory3 = new FoodCategory("Spaghetti", R.drawable.ic_spaguetti);
        FoodCategory foodCategory4 = new FoodCategory("Snacks", R.drawable.ic_sandwich);
        FoodCategory foodCategory5 = new FoodCategory("Desserts", R.drawable.ic_ice_cream);


        data.add(foodCategory);
        data.add(foodCategory2);
        data.add(foodCategory3);
        data.add(foodCategory4);
        data.add(foodCategory5);


        FoodCategoryAdapter foodCategoryAdapter = new FoodCategoryAdapter(data, MainActivity.this, new FoodCategoryAdapter.OnCategoryClick() {
            @Override
            public void onClick(int pos) {
                setFoodItems(pos);
            }
        });

        recyclerCategories.setLayoutManager(new LinearLayoutManager(MainActivity.this,RecyclerView.HORIZONTAL,false));
        recyclerCategories.setAdapter(foodCategoryAdapter);
        foodCategoryAdapter.notifyDataSetChanged();
    }

    private void setFoodItems(int pos){
        List<FoodItem> foodItems = new ArrayList<>();
        switch (pos){
            case 0:
                FoodItem foodItem = new FoodItem("Chicken Fried rice", 4.5f, 60, R.drawable.chickenfriedrice);
                FoodItem foodItem2 = new FoodItem("Nasi goreng", 3.5f, 60, R.drawable.nasi_goreng);
                FoodItem foodItem3 = new FoodItem("Biriyani", 4.0f, 60, R.drawable.biriyani);
                FoodItem foodItem4 = new FoodItem("Egg Fried rice", 3.8f, 60, R.drawable.eggfriedrice);
                FoodItem foodItem5 = new FoodItem("Mongolian rice", 4.3f, 60, R.drawable.mongolian_rice);


                foodItems.add(foodItem);
                foodItems.add(foodItem2);
                foodItems.add(foodItem3);
                foodItems.add(foodItem4);
                foodItems.add(foodItem5);
                break;
            case 1:
                FoodItem foodItem6 = new FoodItem("Dhal curry", 4.5f, 60, R.drawable.dhalcurry);
                FoodItem foodItem7 = new FoodItem("Chicken curry", 4.0f, 60, R.drawable.chickencurry);
                FoodItem foodItem8 = new FoodItem("Fish curry", 3.8f, 60, R.drawable.fishcurry);
                FoodItem foodItem9 = new FoodItem("Polos curry", 4.3f, 60, R.drawable.poloscurry);
                FoodItem foodItem10 = new FoodItem("Pumpkin curry", 4.3f, 60, R.drawable.pumpkin_curry);


                foodItems.add(foodItem6);
                foodItems.add(foodItem7);
                foodItems.add(foodItem8);
                foodItems.add(foodItem9);
                foodItems.add(foodItem10);
                break;
            case 2:
                FoodItem foodItem11 = new FoodItem("Macaroni", 4.5f, 60, R.drawable.macaroni);
                FoodItem foodItem12 = new FoodItem("Spaghetti", 3.5f, 60, R.drawable.spaghetti);
                FoodItem foodItem13 = new FoodItem("Egg Noodle", 4.0f, 60, R.drawable.egg_noodles);
                FoodItem foodItem14 = new FoodItem("Chicken Noodle", 3.8f, 60, R.drawable.chicken_noodles);
                FoodItem foodItem15 = new FoodItem("Rice Noodle", 4.3f, 60, R.drawable.rice_noodles);


                foodItems.add(foodItem11);
                foodItems.add(foodItem12);
                foodItems.add(foodItem13);
                foodItems.add(foodItem14);
                foodItems.add(foodItem15);
                break;

            case 3:
                FoodItem foodItem16 = new FoodItem("Patty", 4.5f, 60, R.drawable.patty);
                FoodItem foodItem17 = new FoodItem("Rolls", 3.5f, 60, R.drawable.rolls);
                FoodItem foodItem18 = new FoodItem("Samosa", 4.0f, 60, R.drawable.samosa);
                FoodItem foodItem19 = new FoodItem("Sandwiches", 3.8f, 60, R.drawable.sandwich);
                FoodItem foodItem20 = new FoodItem("Cutlet", 4.3f, 60, R.drawable.cutlet);

                foodItems.add(foodItem16);
                foodItems.add(foodItem17);
                foodItems.add(foodItem18);
                foodItems.add(foodItem19);
                foodItems.add(foodItem20);
                break;

            case 4:
                FoodItem foodItem21 = new FoodItem("Custard Pudding", 4.5f, 60, R.drawable.custardpudding);
                FoodItem foodItem22 = new FoodItem("Watalappan", 3.5f, 60, R.drawable.watalappan);
                FoodItem foodItem23 = new FoodItem("Fruit Salad", 4.0f, 60, R.drawable.fruitsalad);
                FoodItem foodItem24 = new FoodItem("Chocolate Brownies", 3.8f, 60, R.drawable.chocolatebrownie);
                FoodItem foodItem25 = new FoodItem("Ice Cream", 4.3f, 60, R.drawable.icecream);

                foodItems.add(foodItem21);
                foodItems.add(foodItem22);
                foodItems.add(foodItem23);
                foodItems.add(foodItem24);
                foodItems.add(foodItem25);
                break;

        }

        FoodAdapter foodAdapter = new FoodAdapter(this,foodItems);

        recyclerItems.setLayoutManager(new LinearLayoutManager(MainActivity.this,RecyclerView.HORIZONTAL,false));
        recyclerItems.setAdapter(foodAdapter);

    }
}
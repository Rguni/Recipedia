package com.example.rj.app2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;


public class RecipeScreen extends Activity {

    MyDatabaseHelper myHelper;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recipe_layout);
        TextView recipeTitle = (TextView) findViewById(R.id.recipe_title);


        Recipe recipe = (Recipe) getIntent().getSerializableExtra("Recipe");

        recipeTitle.setText(recipe.getDishes_Name());

    }
}

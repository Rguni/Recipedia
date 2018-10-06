package com.example.rj.app2;

import android.app.Activity;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.method.ScrollingMovementMethod;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;


public class RecipeScreen extends Activity {

    MyDatabaseHelper myHelper;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recipe_layout);
        TextView recipeTitle = (TextView) findViewById(R.id.recipe_title);
        TextView cookingMethod = (TextView) findViewById(R.id.cooking_method);
        ImageView recipePicture = (ImageView) findViewById(R.id.recipe_picture);
        final ListView listView = (ListView) findViewById(R.id.recipe_ingredients);

        Recipe recipe = (Recipe) getIntent().getSerializableExtra("Recipe");

        recipeTitle.setText(recipe.getDishes_Name());
        recipePicture.setImageBitmap(BitmapFactory.decodeByteArray(recipe.getDishes_Picture(),0,recipe.getDishes_Picture().length));

        List <String> ingredients =recipe.getDishes_Ingredients();
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                this,
                R.layout.row_layout,
                R.id.txtViewInRecipe,
                ingredients);
        listView.setAdapter(arrayAdapter);

        cookingMethod.setMovementMethod(new ScrollingMovementMethod());
        cookingMethod.setText(recipe.getDishes_Description());

    }
}

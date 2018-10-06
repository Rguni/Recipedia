package com.example.rj.app2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.NonNull;
import android.util.Log;

import java.sql.Blob;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class MyDatabaseHelper extends SQLiteOpenHelper {

    private static final String TAG = "SQLite";

    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "Recipedia_Manager";

    // Table name: Note.
    private static final String TABLE_DISHES = "Dishes";

    public MyDatabaseHelper(Context context)  {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Create table "Dishes" in database
        db.execSQL(Recipe.CREATE_TABLE);
        createRecipe(db);

//        GetImageFromInt getimage = new GetImageFromInt(this);
//        getimage.execute(Recipe.IMAGEURL);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + Recipe.TABLE_NAME);

        // Create tables again
        onCreate(db);
    }




    // If Note table has no data
    // default, Insert 2 records.
    public void createRecipe(SQLiteDatabase db)  {
            Recipe recipe1 = new Recipe(10001, "Pancakes",
                    "Pancakes can be salt or sweet", null);
            Recipe recipe2 = new Recipe(10002, "Chicken Soup",
                    "Get prepared from dead chicken", null);
            Recipe recipe3 = new Recipe(10003, "Fried chicken",
                    "Get prepared from dead chicken", null);
            this.addRecipe(recipe1, db);
            this.addRecipe(recipe2, db);
            this.addRecipe(recipe3, db);
    }


    public void addRecipe(Recipe recipe, SQLiteDatabase db) {

        //get writable DB connection, as we want to put data into DB
        //SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(Recipe.COLUMN_DISHES_ID, recipe.getRecipeId());
        values.put(Recipe.COLUMN_DISHES_NAME, recipe.getDishes_Name());
        values.put(Recipe.COLUMN_DISHES_DESCRIPTION, recipe.getDishes_Description());

        // TODO just placeholder for inserting a picture to database
        //values.put(Recipe.COLUMN_DISHES_PICTURE, recipe.getDishes_Picture());

        // Inserting Row
        db.insert(TABLE_DISHES, null, values);

        // Closing database connection
       // db.close();

    }


    public Recipe getRecipe(long id) {

        // get readable database as we are not inserting anything
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(Recipe.TABLE_NAME,
                new String[] {Recipe.COLUMN_DISHES_ID, Recipe.COLUMN_DISHES_NAME, Recipe.COLUMN_DISHES_DESCRIPTION},
                Recipe.COLUMN_DISHES_ID + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);

        if (cursor != null)
            cursor.moveToFirst();

        // prepare recipe obj to send
        Recipe recipe = new Recipe(
                cursor.getInt(cursor.getColumnIndex(Recipe.COLUMN_DISHES_ID)),
                cursor.getString(cursor.getColumnIndex(Recipe.COLUMN_DISHES_NAME)),
                cursor.getString(cursor.getColumnIndex(Recipe.COLUMN_DISHES_DESCRIPTION)),
                null);
        // return note
        return recipe;
    }

    public List<Recipe> getAllRecipes(){

        List<Recipe> recipes = new ArrayList<>();

        // Select ALL recipes query
        String selectQuery = "SELECT * FROM " + Recipe.TABLE_NAME;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        recipes = populateList(cursor,recipes);

        cursor.close();

        db.close();

        return recipes;

    }


    public int getRecipesCount(){

        // Select ALL recipes query
        String selectQuery = "SELECT * FROM " + Recipe.TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        int count = cursor.getCount();
        cursor.close();

        //return amount of notes in DB
        return count;
    }

    public List<Recipe> searchWordRecipe(String searchWord){

        List<Recipe> recipes = new ArrayList<>();
        String searchQuery = "SELECT * FROM " + Recipe.TABLE_NAME
                            +" WHERE " + Recipe.COLUMN_DISHES_NAME
                            +" LIKE '%" + searchWord + "%'";

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(searchQuery, null);

        recipes = populateList(cursor,recipes);

        cursor.close();
        db.close();

        return recipes;

    }

    private List<Recipe> populateList(@NonNull Cursor cursor, List<Recipe> recipeList){

        // looping through all rows and adding to recipe to list
        if (cursor.moveToFirst()){
            do{
                Recipe recipe = new Recipe();
                recipe.setRecipeId(cursor.getInt(cursor.getColumnIndex(Recipe.COLUMN_DISHES_ID)));
                recipe.setDishes_Name(cursor.getString(cursor.getColumnIndex(Recipe.COLUMN_DISHES_NAME)));
                recipe.setDishes_Description(cursor.getString(cursor.getColumnIndex(Recipe.COLUMN_DISHES_DESCRIPTION)));

                // TODO create Blob transfer method
                // recipe.setDishes_Picture(cursor.getBlob(cursor.getColumnIndex(Recipe.COLUMN_DISHES_PICTURE)));
                recipeList.add(recipe);
            }while (cursor.moveToNext());
        }

        return  recipeList;

    }

}
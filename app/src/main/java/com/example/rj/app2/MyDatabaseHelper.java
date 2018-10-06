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

    SQLiteDatabase db;

    public MyDatabaseHelper(Context context)  {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        this.db = db;
        db.execSQL(Recipe.CREATE_TABLE);
        createRecipe();

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

    //Insert records in the table.
    public void createRecipe() {
        Recipe recipe1 = new Recipe(10001, "Pancakes",
                "Pancakes can be salt or sweet",
                "http://stjamesandleo.org/wp-content/uploads/2016/11/Pancakes-450x450.jpg",
                null);
        GetImageFromInt getimage1 = new GetImageFromInt(this);
        getimage1.execute(recipe1);

        Recipe recipe2 = new Recipe(10002, "Chicken Soup",
                "Get prepared from dead chicken",
                "http://stjamesandleo.org/wp-content/uploads/2016/11/Pancakes-450x450.jpg", null);
        GetImageFromInt getimage2 = new GetImageFromInt(this);
        getimage2.execute(recipe2);
        Recipe recipe3 = new Recipe(10003, "Fried chicken",
                "Get prepared from dead chicken",
                "http://stjamesandleo.org/wp-content/uploads/2016/11/Pancakes-450x450.jpg", null);
        GetImageFromInt getimage3 = new GetImageFromInt(this);
        getimage3.execute(recipe3);
    }


    public void addRecipe(Recipe recipe) {

        //get writable DB connection, as we want to put data into DB
        //SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(Recipe.COLUMN_DISHES_ID, recipe.getRecipeId());
        values.put(Recipe.COLUMN_DISHES_NAME, recipe.getDishes_Name());
        values.put(Recipe.COLUMN_DISHES_DESCRIPTION, recipe.getDishes_Description());
        values.put(Recipe.COLUMN_PICTURE_URL, recipe.getPicture_Url());
        values.put(Recipe.COLUMN_DISHES_PICTURE, recipe.getDishes_Picture());

        // Inserting Row
        db.insert(TABLE_DISHES, null, values);

        // Closing database connection
        // db.close();

    }


    public Recipe getRecipe(long id) {

        // get readable database as we are not inserting anything
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(Recipe.TABLE_NAME,
                new String[] {Recipe.COLUMN_DISHES_ID, Recipe.COLUMN_DISHES_NAME,
                        Recipe.COLUMN_DISHES_DESCRIPTION, Recipe.COLUMN_PICTURE_URL,
                        Recipe.COLUMN_DISHES_PICTURE},
                Recipe.COLUMN_DISHES_ID + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);

        if (cursor != null)
            cursor.moveToFirst();

        // prepare recipe obj to send
        Recipe recipe = new Recipe(
                cursor.getInt(cursor.getColumnIndex(Recipe.COLUMN_DISHES_ID)),
                cursor.getString(cursor.getColumnIndex(Recipe.COLUMN_DISHES_NAME)),
                cursor.getString(cursor.getColumnIndex(Recipe.COLUMN_DISHES_DESCRIPTION)),
                cursor.getString(cursor.getColumnIndex(Recipe.COLUMN_PICTURE_URL)),
                cursor.getBlob(cursor.getColumnIndex(Recipe.COLUMN_DISHES_PICTURE)));
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
                recipe.setPicture_Url(cursor.getString(cursor.getColumnIndex(Recipe.COLUMN_PICTURE_URL)));
                // TODO create Blob transfer method
                recipe.setDishes_Picture(cursor.getBlob(cursor.getColumnIndex(Recipe.COLUMN_DISHES_PICTURE)));
                recipeList.add(recipe);
            }while (cursor.moveToNext());
        }

        return  recipeList;

    }

}
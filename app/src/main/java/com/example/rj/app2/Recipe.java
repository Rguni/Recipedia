package com.example.rj.app2;
import java.io.Serializable;
import java.sql.Blob;
import java.util.List;


public class Recipe implements Serializable {


    // Database related values

    // Name of dishes table in database
    public static final String TABLE_NAME = "Dishes";

    // Name of columns in "Dishes" table
    public static final String COLUMN_DISHES_ID ="Dishes_Id";
    public static final String COLUMN_DISHES_NAME ="Dishes_Name";
    public static final String COLUMN_DISHES_DESCRIPTION = "Dishes_Description";
    public static final String COLUMN_DISHES_INGREDIENTS = "Dishes_Ingredients";
    public static final String COLUMN_PICTURE_URL = "Picture_Url";
    public static final String COLUMN_DISHES_PICTURE = "Dishes_Picture";

    // Class related values
    private int Dishes_ID;
    private String Dishes_Name;
    private String Dishes_Description;
    private List<String> Dishes_Ingredients;
    private String Picture_Url;
    private byte[] Dishes_Picture;


    // Create table "Dishes" SQL query
    public static  final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + "("
                    + COLUMN_DISHES_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + COLUMN_DISHES_NAME + " TEXT, "
                    + COLUMN_DISHES_DESCRIPTION + " TEXT, "
                    + COLUMN_DISHES_INGREDIENTS + " TEXT, "
                    + COLUMN_PICTURE_URL + " TEXT, "
                    + COLUMN_DISHES_PICTURE + " BLOB"
                    + ")";

    public Recipe()  {
    }

    public Recipe(String Dishes_Name, String Dishes_Description, List<String> Dishes_Ingredients,
                  String Picture_Url, byte[] Dishes_Picture) {
        this.Dishes_Name = Dishes_Name;
        this.Dishes_Description = Dishes_Description;
        this.Dishes_Ingredients = Dishes_Ingredients;
        this.Picture_Url = Picture_Url;
        this.Dishes_Picture = Dishes_Picture;
    }

    public Recipe(int Dishes_ID, String Dishes_Name, String Dishes_Description,
                  List<String> Dishes_Ingredients, String Picture_Url, byte[] Dishes_Picture) {
        this.Dishes_ID = Dishes_ID;
        this.Dishes_Name = Dishes_Name;
        this.Dishes_Description = Dishes_Description;
        this.Dishes_Ingredients = Dishes_Ingredients;
        this.Picture_Url = Picture_Url;
        this.Dishes_Picture  = Dishes_Picture;
    }

    public int getRecipeId() {
        return Dishes_ID;
    }

    public void setRecipeId(int Dishes_ID) {
        this.Dishes_ID = Dishes_ID;
    }

    public String getDishes_Name() {
        return Dishes_Name;
    }
    public void setDishes_Name(String dishes_Name) {
        this.Dishes_Name = dishes_Name;
    }

    public String getDishes_Description() {
        return Dishes_Description;
    }
    public void setDishes_Description(String dishes_Description) {
        this.Dishes_Description = dishes_Description;
    }

    public List<String> getDishes_Ingredients() {
        return Dishes_Ingredients;
    }
    public void setDishes_Ingredients(List<String> dishes_Ingredients) {
        this.Dishes_Ingredients = dishes_Ingredients;
    }

    public String getPicture_Url() {
        return Picture_Url;
    }
    public void setPicture_Url(String Picture_Url) {
        this.Picture_Url = Picture_Url;
    }

    public byte[] getDishes_Picture() { return Dishes_Picture; }
    public void setDishes_Picture(byte[] dishes_Picture) { Dishes_Picture = dishes_Picture; }

    @Override
    public String toString()  {
        return this.Dishes_Name;
    }




}

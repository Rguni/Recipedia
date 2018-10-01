package com.example.rj.app2;
import java.io.Serializable;
import java.sql.Blob;


public class Recipe implements Serializable {

    private int Dishes_ID;
    private String Dishes_Name;
    private String Dishes_Description;
    private Blob Dishes_Picture;

    public Recipe()  {
    }

        public Recipe(String Dishes_Name, String Dishes_Description, Blob Dishes_Picture) {
            this.Dishes_Name = Dishes_Name;
            this.Dishes_Description = Dishes_Description;
            this.Dishes_Picture = Dishes_Picture;
        }

        public Recipe(int Dishes_ID, String Dishes_Name, String Dishes_Description, Blob Dishes_Picture) {
            this.Dishes_ID = Dishes_ID;
            this.Dishes_Name = Dishes_Name;
            this.Dishes_Description = Dishes_Description;
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

        public Blob getDishes_Picture() {
            return Dishes_Picture;
        }

        public void setDishes_Picture(Blob dishes_Picture) {
            Dishes_Picture = dishes_Picture;
        }

        @Override
        public String toString()  {
            return this.Dishes_Name;
        }


}

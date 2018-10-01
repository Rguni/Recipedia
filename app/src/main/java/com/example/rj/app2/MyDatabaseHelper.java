package com.example.rj.app2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.sql.Blob;


public class MyDatabaseHelper extends SQLiteOpenHelper {

    private static final String TAG = "SQLite";

    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "Recipedia_Manager";

    // Table name: Note.
    private static final String TABLE_DISHES = "Dishes";

    private static final String COLUMN_DISHES_ID ="Dishes_Id";
    private static final String COLUMN_DISHES_NAME ="Dishes_Name";
    private static final String COLUMN_DISHES_DESCRIPTION = "Dishes_Description";
    private static final Blob COLUMN_DISHES_PICTURE = null;

    public MyDatabaseHelper(Context context)  {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Create table
    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.i(TAG, "MyDatabaseHelper.onCreate ... ");
        // Script.
        String script = "CREATE TABLE " + TABLE_DISHES + "("
                + COLUMN_DISHES_ID + " INTEGER PRIMARY KEY," + COLUMN_DISHES_NAME + " TEXT,"
                + COLUMN_DISHES_DESCRIPTION + " TEXT" + COLUMN_DISHES_PICTURE + " BLOB" + ")";
        // Execute Script.
        db.execSQL(script);
        createRecipe(db);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        Log.i(TAG, "MyDatabaseHelper.onUpgrade ... ");
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_DISHES);

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
        Log.i(TAG, "MyDatabaseHelper.addRecipe ... " + recipe.getDishes_Name());
        ContentValues values = new ContentValues();
        values.put(COLUMN_DISHES_ID, recipe.getRecipeId());
        values.put(COLUMN_DISHES_NAME, recipe.getDishes_Name());
        values.put(COLUMN_DISHES_DESCRIPTION, recipe.getDishes_Description());

        // Inserting Row
        db.insert(TABLE_DISHES, null, values);

        // Closing database connection
    }


    public Recipe getRecipe(int id) {
        Log.i(TAG, "MyDatabaseHelper.getNote ... " + id);

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_DISHES, new String[] {COLUMN_DISHES_ID,
                        COLUMN_DISHES_NAME, COLUMN_DISHES_DESCRIPTION}, COLUMN_DISHES_ID + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        Recipe recipe = new Recipe(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1), cursor.getString(2), null);
        // return note
        return recipe;
    }


//    public List<Note> getAllNotes() {
//        Log.i(TAG, "MyDatabaseHelper.getAllNotes ... " );
//
//        List<Note> noteList = new ArrayList<Note>();
//        // Select All Query
//        String selectQuery = "SELECT  * FROM " + TABLE_DISHES;
//
//        SQLiteDatabase db = this.getWritableDatabase();
//        Cursor cursor = db.rawQuery(selectQuery, null);
//
//        // looping through all rows and adding to list
//        if (cursor.moveToFirst()) {
//            do {
//                Note note = new Note();
//                note.setNoteId(Integer.parseInt(cursor.getString(0)));
//                note.setNoteTitle(cursor.getString(1));
//                note.setNoteContent(cursor.getString(2));
//                // Adding note to list
//                noteList.add(note);
//            } while (cursor.moveToNext());
//        }
//
//        // return note list
//        return noteList;
//    }

    public int getNotesCount() {
        Log.i(TAG, "MyDatabaseHelper.getNotesCount ... " );

        String countQuery = "SELECT  * FROM " + TABLE_DISHES;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);

        int count = cursor.getCount();

        cursor.close();

        // return count
        return count;
    }


//    public int updateNote(Note note) {
//        Log.i(TAG, "MyDatabaseHelper.updateNote ... "  + note.getNoteTitle());
//
//        SQLiteDatabase db = this.getWritableDatabase();
//
//        ContentValues values = new ContentValues();
//        values.put(COLUMN_DISHES_NAME, note.getNoteTitle());
//        values.put(COLUMN_DISHES_DESCRIPTION, note.getNoteContent());
//
//        // updating row
//        return db.update(TABLE_DISHES, values, COLUMN_DISHES_ID + " = ?",
//                new String[]{String.valueOf(note.getNoteId())});
//    }
//
//    public void deleteNote(Note note) {
//        Log.i(TAG, "MyDatabaseHelper.updateNote ... " + note.getNoteTitle() );
//
//        SQLiteDatabase db = this.getWritableDatabase();
//        db.delete(TABLE_DISHES, COLUMN_DISHES_ID + " = ?",
//                new String[] { String.valueOf(note.getNoteId()) });
//        db.close();
//    }

}
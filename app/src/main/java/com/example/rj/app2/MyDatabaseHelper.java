package com.example.rj.app2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;


public class MyDatabaseHelper extends SQLiteOpenHelper {

    private static final String TAG = MyDatabaseHelper.class.getSimpleName();

    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "Recipedia_Manager";

    // Table name: Note.
    private static final String TABLE_DISHES = "Dishes";

    private static final String COLUMN_DISHES_ID ="Dishes_Id";
    private static final String COLUMN_DISHES_NAME ="Dishes_Name";
    private static final String COLUMN_DISHES_DESCRIPTION = "Dishes_Description";
    private static final String COLUMN_DISHES_PICTURE = "Dishes_Picture";

    private String IMAGEURL = "http://stjamesandleo.org/wp-content/uploads/2016/11/Pancakes-450x450.jpg";
    private byte[] Image,ImageBlob;

    SQLiteDatabase db;

    public MyDatabaseHelper(Context context)  {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.getWritableDatabase();
    }

    // Create table
    @Override
    public void onCreate(SQLiteDatabase db) {
        this.db = db;
        Log.i(TAG, "MyDatabaseHelper.onCreate ... ");
        // Script.
        String script = "CREATE TABLE " + TABLE_DISHES + "("
                + COLUMN_DISHES_ID + " INTEGER PRIMARY KEY, " + COLUMN_DISHES_NAME + " TEXT, "
                + COLUMN_DISHES_DESCRIPTION + " TEXT, " + COLUMN_DISHES_PICTURE + " BLOB" + ")";
        // Execute Script.
        db.execSQL(script);
        GetImageFromInt getimage = new GetImageFromInt(this);
        getimage.execute(IMAGEURL);
//        try {
//            createRecipe(db);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        Log.i(TAG, "MyDatabaseHelper.onUpgrade ... ");
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_DISHES);

        // Create tables again
        onCreate(db);
    }

//    public byte[] ImageFromUrl() throws Exception {
//        URL url = new URL(IMAGEURL);
//        ByteArrayOutputStream output = new ByteArrayOutputStream();
//
//        try {
//            InputStream inputStream = url.openStream();
//            int n = 0;
//            byte [] buffer = new byte[ 1024 ];
//            while (-1 != (n = inputStream.read(buffer))) {
//                output.write(buffer, 0, n);
//            }
//        }
//    catch (IOException i ){}
//
//        return output.toByteArray();
//    }
 //   Image  = getLogoImage(IMAGEURL);

    // If Dishes table has no data
    // default, Insert n records.
    public void createRecipe(byte[] image) throws Exception {
            Recipe recipe1 = new Recipe(10001, "Pancakes",
                    "Pancakes can be salt or sweet", image);
            Recipe recipe2 = new Recipe(10002, "Chicken Soup",
                    "Get prepared from dead chicken", image);
            Recipe recipe3 = new Recipe(10003, "Fried chicken",
                    "Get prepared from dead chicken", image);
            this.addRecipe(recipe1);
            this.addRecipe(recipe2);
            this.addRecipe(recipe3);
    }


    public void addRecipe(Recipe recipe) throws Exception {
        Log.i(TAG, "MyDatabaseHelper.addRecipe ... " + recipe.getDishes_Name());
        ContentValues values = new ContentValues();
        values.put(COLUMN_DISHES_ID, recipe.getRecipeId());
        values.put(COLUMN_DISHES_NAME, recipe.getDishes_Name());
        values.put(COLUMN_DISHES_DESCRIPTION, recipe.getDishes_Description());
        values.put(COLUMN_DISHES_PICTURE, recipe.getDishes_Picture());
        // Inserting Row
        db.insert(TABLE_DISHES, null, values);
    }

     public Recipe getRecipe(int id) {
        Log.i(TAG, "MyDatabaseHelper.getDishes ... " + id);

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_DISHES, new String[] {COLUMN_DISHES_ID,
                        COLUMN_DISHES_NAME, COLUMN_DISHES_DESCRIPTION, COLUMN_DISHES_PICTURE}, COLUMN_DISHES_ID + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        Recipe recipe = new Recipe(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1), cursor.getString(2), cursor.getBlob(3));


        return recipe;
    }

//    public Bitmap loadIcon(long iconId) {
//        // Prepare the cursor to read from database....
//        byte[] bitmapData = recipegetBlob(cursor.getColumnIndex(TABLE_DISHES.COLUMN_DISHES_PICTURE));
//
//        return BitmapFactory.decodeByteArray(bitmapData, 0, bitmapData.length);
//    }
//
//    byte[] bitmapData = cursor.getBlob(cursor.getColumnIndex(Columns.Icons.DATA))

//    storedItem.setImageBitmap(BitmapFactory.decodeByteArray(blob, 0, blob.length));
//
//            Log.i("RETURN TRUE BLOB",cursor.getString(3));





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
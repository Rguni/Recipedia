package com.example.rj.app2;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class MainActivity extends AppCompatActivity {

    MyDatabaseHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        helper = new MyDatabaseHelper(this);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        final TextView infoTextView = (TextView) findViewById(R.id.textView);
        final ImageView infoImageView = (ImageView) findViewById(R.id.imageView1);

        switch (id) {
            case R.id.action_recipe_1:
//                item.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
//                    @Override
//                    public boolean onMenuItemClick(MenuItem item)
{
                        Recipe recipe1 = helper.getRecipe(10001);
                        String Recipe1 = recipe1.getDishes_Name();
                        String Recipe2 = recipe1.getDishes_Description();
                        byte[] Recipe3 = recipe1.getDishes_Picture();
                        infoTextView.setText(Recipe1 + "\n" + Recipe2);

                            infoImageView.setImageBitmap(BitmapFactory.decodeByteArray(Recipe3,
                                    0, Recipe3.length));

//                        setImageView image = recipe1.getDishes_Picture();
//                        BitmapFactory.decodeByteArray(image, 0, image.length);
                        return false;
                    }


//                });//recipe.getRecipe();
//                String title = this.textTitle.getText().toString();
//                String content = this.textContent.getText().toString();

//                return true;
            case R.id.action_recipe_2:
                infoTextView.setText("Your choice Chicken Soup!");
                return true;
            case R.id.action_recipe_3:
                infoTextView.setText("Your choice Fried Chicken!");
                return true;
            case R.id.action_recipe_4:
                infoTextView.setText("Your choice Icecream!");
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


//    public static void watchYoutubeVideo(String id) {
//        Intent appIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("vnd.youtube:" + id));
//        Intent webIntent = new Intent(Intent.ACTION_VIEW,
//                Uri.parse("http://www.youtube.com/watch?v=" + id));
//        try {
//            startActivity(appIntent);
//        } catch (ActivityNotFoundException ex) {
//            startActivity(webIntent);
//        }
//    }

}

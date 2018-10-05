package com.example.rj.app2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    MyDatabaseHelper helper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        helper = new MyDatabaseHelper(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        final TextView infoTextView = (TextView) findViewById(R.id.textView);

        // Операции для выбранного пункта меню
        switch (id) {
            case R.id.action_recipe_1:
//                item.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
//                    @Override
//                    public boolean onMenuItemClick(MenuItem item)
                        {
                        Recipe recipe1 = helper.getRecipe(10001);
                        String Recipe1 = recipe1.getDishes_Name();
                        String Recipe2 = recipe1.getDishes_Description();
//                            byte[] Recipe3 = recipe1.getDishes_Picture();
                        infoTextView.setText(Recipe1 + "\n" + Recipe2);
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

    public void onMenuButtonClicked(View view){
        Intent getMenuScreenIntent = new Intent(this, MenuScreen.class);

        final int result = 1;
        getMenuScreenIntent.putExtra("callingActivity","MainActivity");
        startActivityForResult(getMenuScreenIntent, result);
    }

    public void onSearchButtonClicked(View view){
        Intent getSearchScreenIntent = new Intent(this, SearchScreen.class);

        final int result = 1;
        getSearchScreenIntent.putExtra("callingActivity","MainActivity");
        startActivityForResult(getSearchScreenIntent, result);
    }

//    public void onSearchButtonClicked(View view){
//        Intent getSearchScreenIntent = new Intent(this, SearchScreen.class);
//        EditText searchWordET = (EditText) findViewById(R.id.searchWordToSend);
//        String searchWord = String.valueOf(searchWordET.getText());
//
//        final int result = 1;
//
//        getSearchScreenIntent.putExtra("SearchQuery", searchWord);
//        startActivityForResult(getSearchScreenIntent, result);
//    }


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

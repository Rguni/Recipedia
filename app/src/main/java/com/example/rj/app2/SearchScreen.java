package com.example.rj.app2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class SearchScreen extends Activity {
    MyDatabaseHelper myHelper;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.searchscreen_layout);

        //intent to open new recipe
        final Intent sendRecipeIntent = new Intent(this, RecipeScreen.class);

        myHelper = new MyDatabaseHelper(this);

        //put search request on screen
        Intent searchedValueSended = getIntent();

        String wordToPut= searchedValueSended.getStringExtra("SearchWord");
        TextView searchMemo = (TextView) findViewById(R.id.queryWord);
        searchMemo.setText("You searched for "+wordToPut);

        //populate search screen with list of of recipes
        final ListView listView = (ListView) findViewById(R.id.searchListView);
        final List<Recipe> recipeList = myHelper.searchWordRecipe(wordToPut);
        if(wordToPut.isEmpty()||recipeList.isEmpty()){
            Toast.makeText(SearchScreen.this,"There no items for your search",Toast.LENGTH_LONG).show();
        }else {
            ArrayAdapter<Recipe> arrayAdapter = new ArrayAdapter<Recipe>(
                    this,
                    R.layout.row_layout,
                    R.id.txtViewInRecipe,
                    recipeList);

            listView.setAdapter(arrayAdapter);

            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    String thingsPicked = "You selected " + String.valueOf(parent.getItemAtPosition(position));

                    Toast.makeText(SearchScreen.this, thingsPicked, Toast.LENGTH_SHORT).show();

                    sendRecipeIntent.putExtra("Recipe", recipeList.get(position));

                    startActivityForResult(sendRecipeIntent, 1);


                }
            });
        }




    }
}

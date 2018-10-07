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
import java.util.Arrays;
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
        Recipe recipe1 = new Recipe(10001,
                "Pancakes",
                " 1. Put 100g plain flour, 2 large eggs, 300ml milk, 1 tbsp sunflower or vegetable oil and a pinch of salt into a bowl or large jug, then whisk to a smooth batter." +
                        "\n\n 2. Set aside for 30 mins to rest if you have time, or start cooking straight away." +
                        "\n\n 3. Set a medium frying pan or crêpe pan over a medium heat and carefully wipe it with some oiled kitchen paper." +
                        "\n\n 4. When hot, cook your pancakes for 1 min on each side until golden, keeping them warm in a low oven as you go." +
                        "\n\n 5. Serve with lemon wedges and caster sugar, or your favourite filling.",
                Arrays.asList("100g plain flour," +
                        "2 large eggs," +
                        "300ml milk," +
                        "1 tbsp sunflower oil," +
                        "Lemon wedges to serve(optional)," +
                        "Caster sugar to serve (optional)"),
                "https://www.bbcgoodfood.com/sites/default/files/styles/recipe/public/recipe_images/recipe-image-legacy-id--1273477_8.jpg?itok=6VhpTntM",
                null);
        GetImageFromInt getimage1 = new GetImageFromInt(this);
        getimage1.execute(recipe1);

        Recipe recipe2 = new Recipe(10002,
                "Roast chicken soup",
                " 1. Heat 1 tbsp olive oil in a large heavy-based pan. Add 2 chopped onions, 3 chopped medium carrots and 1 tbsp roughly chopped thyme leaves, then gently fry for 15 mins." +
                        "\n\n 2. Stir in 1.4l chicken stock, bring to a boil, cover, then simmer for 10 mins." +
                        "\n\n 3. Add 300g shredded leftover roast chicken, remove half the mixture, then purée with a stick blender. " +
                        "\n\n 4. Tip back into the pan with the rest of the soup, 200g frozen peas and seasoning, then simmer for 5 mins until hot through." +
                        "\n\n 5. Mix 3 tbsp Greek yogurt,1 crushed garlic clove and a squeeze lemon juice, swirl into the soup in bowls, then serve." +
                        "\n\n 6. If you want to use a slow cooker, gently fry 2 chopped onions, 3 chopped medium carrots and1 tbsp roughly chopped thyme leaves for 15 mins then tip them with the veg into your slow cooker with 1 litre stock. If you're using a chicken carcass, add it now." +
                        "\n\n 7. Cover and cook for 2-3 hours on High until the veg is tender. If you used a carcass remove it now, shredding any remaining chicken from the bones." +
                        "\n\n 8. Stir back into the soup, or add 300g shredded leftover roast chicken now, plus 200g frozen peas." +
                        "\n\n 9. Cook for 30 mins more. Remove half the mixture and purée with a stick blender, then serve as above.",
                Arrays.asList("1 tbsp olive oil," +
                        "2 onions chopped," +
                        "3 medium carrots chopped," +
                        "1 tbsp thyme leaves roughly chopped," +
                        "1.4l chicken stock," +
                        "300g leftover roast chicken shredded and skin removed," +
                        "200g frozen peas," +
                        "3 tbsp Greek yogurt," +
                        "1 garlic clove crushed," +
                        "squeeze lemon juice"),
                "https://www.bbcgoodfood.com/sites/default/files/styles/recipe/public/recipe_images/recipe-image-legacy-id--1074495_11.jpg?itok=ZeOmX4dB",
                null);
        GetImageFromInt getimage2 = new GetImageFromInt(this);
        getimage2.execute(recipe2);

        Recipe recipe3 = new Recipe(10003,
                "Pan-fried chicken in mushroom sauce",
                " 1. Heat the oil in a large non-stick frying pan. Fry the thighs for 8-10 mins, skin side only, until golden brown, then transfer to a casserole dish. Fry the drumsticks for about 5 mins each side and add them to the thighs." +
                        "\n\n 2. Pour the stock over the chicken legs in the casserole. There should be enough stock to just cover the chicken, if not add a little water. Bring stock to the boil and cover, leaving lid slightly ajar. Cook at just below simmering point for 30-35 mins until chicken is cooked." +
                        "\n\n 3. While chicken is simmering, drain oil from the pan. Heat the butter in pan and add onion. Sweat onion for 5 mins until soft, but not coloured. Turn up the heat, add the mushrooms, then fry for 3 mins until they soften and start to smell wonderful. Pour over the white wine, raise the heat to maximum and boil rapidly for 6-8 mins until reduced by two-thirds. Turn off the heat and leave until chicken has cooked." +
                        "\n\n 4. Once chicken legs are cooked, strain stock into pan with the onion, mushrooms and white wine, bring back to the boil and reduce again by two-thirds until it is thick and syrupy. Pour in double cream, bring it to the boil, season if you want, then pour it over chicken. Heat chicken through in the sauce for 2-3 mins then turn off the heat and leave for a few mins before serving. This is such an aromatic and beautiful looking dish you should serve it straight from the casserole with the lid on.",
                Arrays.asList("2 tbsp sunflower oil," +
                        "6 large free-range chicken legs halved at the joint so you have 6 thighs and 6 drumsticks," +
                        "700ml/1¼ pts chicken stock (or water)," +
                        "50g butter," +
                        "1 onion finely diced," +
                        "400g mixed wild mushrooms," +
                        "300ml/½ pt dry white wine," +
                        "284ml pot double cream"),
                "https://www.bbcgoodfood.com/sites/default/files/styles/recipe/public/user-collections/my-colelction-image/2015/12/recipe-image-legacy-id--337474_12.jpg?itok=CVp4Onv_",
                null);
        GetImageFromInt getimage3 = new GetImageFromInt(this);
        getimage3.execute(recipe3);

        Recipe recipe4 = new Recipe(10004,
                "Beef stroganoff",
                " 1. Heat 1 tbsp olive oil in a non-stick frying pan then add 1 sliced onion and cook on a medium heat until completely softened, around 15 mins, adding a little splash of water if it starts to stick." +
                        "\n\n 2. Crush in 1 garlic clove and cook for 2-3 mins more, then add 1 tbsp butter." +
                        "\n\n 3. Once the butter is foaming a little, add 250g sliced mushrooms and cook for around 5 mins until completely softened." +
                        "\n\n 4. Season everything well, then tip onto a plate." +
                        "\n\n 5. Tip 1 tbsp plain flour into a bowl with a big pinch of salt and pepper, then toss 500g sliced fillet steak in the seasoned flour." +
                        "\n\n 6. Add the steak pieces to the pan, splashing in a little oil if the pan looks dry, and fry for 3-4 mins, until well coloured." +
                        "\n\n 7. Tip the onions and mushrooms back into the pan. Whisk 150g crème fraîche, 1 tsp English mustard and 100ml beef stock together, then stir into the pan." +
                        "\n\n 8. Cook over a medium heat for around 5 mins." +
                        "\n\n 9. Scatter with some chopped parsley, and serve with pappardelle or rice.",
                Arrays.asList("1 tbsp olive oil," +
                        "1 onion sliced," +
                        "1 clove of garlic," +
                        "1 tbsp butter," +
                        "250g mushrooms sliced," +
                        "1 tbsp plain flour," +
                        "500g fillet steak, sliced," +
                        "150g crème fraîche," +
                        "1 tsp English mustard," +
                        "100ml beef stock," +
                        "½ small pack of parsley chopped"),
                "https://www.bbcgoodfood.com/sites/default/files/styles/recipe/public/recipe/recipe-image/2017/09/beefstroganoff.jpg?itok=H6XBu1VQ",
                null);
        GetImageFromInt getimage4 = new GetImageFromInt(this);
        getimage4.execute(recipe4);

        Recipe recipe5 = new Recipe(10005,
                "Thai pumpkin soup",
                " 1. Heat oven to 200C/180C fan/gas 6. Toss the pumpkin or squash in a roasting tin with half the oil and seasoning, then roast for 30 mins until golden and tender." +
                        "\n\n 2. Meanwhile, put the remaining oil in a pan with the onion, ginger and lemongrass. Gently cook for 8-10 mins until softened. Stir in the curry paste for 1 min, followed by the roasted pumpkin, all but 3 tbsp of the coconut milk and the stock." +
                        " Bring to a simmer, cook for 5 mins, then fish out the lemongrass. Cool for a few mins, then whizz until smooth with a hand blender, or in a large blender in batches. Return to the pan to heat through, seasoning with salt, pepper, lime juice and sugar, if it needs it." +
                        " Serve drizzled with the remaining coconut milk and scattered with chilli, if you like.",
                Arrays.asList("1½ kg pumpkin or squash peeled and roughly chopped," +
                        "4 tsp sunflower oil," +
                        "1 onion sliced," +
                        "1 tbsp grated ginger," +
                        "1 lemongrass bashed a little," +
                        "3-4 tbsp Thai red curry paste," +
                        "400ml can coconut milk," +
                        "850ml vegetable stock," +
                        "lime juice and sugar for seasoning," +
                        "1 red chilli sliced to serve (optional)"),
                "https://www.bbcgoodfood.com/sites/default/files/styles/recipe/public/recipe_images/recipe-image-legacy-id--404477_10.jpg?itok=cq7TF-0G",
                null);
        GetImageFromInt getimage5 = new GetImageFromInt(this);
        getimage5.execute(recipe5);

        Recipe recipe6 = new Recipe(10006,
                "Roast salmon with pesto sauce & beetroot slaw",
                "1. Heat oven to 200C/180C fan/gas 6 and line a baking tray with foil. Season the salmon fillets and put them on the tray, skin-side down. Drizzle the tops with a little oil and cook for 10-12 mins." +
                        "\n\n 2. Meanwhile, in a bowl, combine the beetroot, celeriac, carrots, vinegar, remaining oil, the seeds and some seasoning. Spoon the pesto and soured cream into a small bowl, mix, then season. Serve the salmon fillets with the crunchy slaw and pesto sauce.",
                Arrays.asList("1½ tbsp olive oil," +
                        "4 salmon fillets," +
                        "2 raw beetroot about 250g peeled and coarsely grated," +
                        "175g celeriac peeled and coarsely grated," +
                        "2 carrots about 175g coarsely grated," +
                        "1 tbsp cider vinegar," +
                        "2 tbsp mixed seeds, toasted," +
                        "2 tbsp pesto," +
                        "4 tbsp soured cream"),
                "https://www.bbcgoodfood.com/sites/default/files/styles/recipe/public/recipe_images/roast-salmon-with-pesto-sauce-beetroot-slaw.jpg?itok=S-AsYE9e",
                null);
        GetImageFromInt getimage6 = new GetImageFromInt(this);
        getimage6.execute(recipe6);

        Recipe recipe7 = new Recipe(10007,
                "Chilli chicken wraps",
                " 1. Heat the oil in a large frying pan over a medium heat. Add the chicken, brown on all sides, then remove. Add the onion, garlic, ginger and a pinch of salt. Cook for 5 mins or until softened." +
                        "\n\n 2. Increase the heat to high. Return the chicken to the pan with the spices, tomato purée, chilli and lemon juice. Season well and cook for 10 mins or until the chicken is tender." +
                        "\n\n 3. Divide the chicken, red onion, chutney, herbs and yogurt between the four warm rotis. Roll up and serve with plenty of napkins",
                Arrays.asList("2 tbsp vegetable oil," +
                        "6 boneless skinless chicken thighs cut into bite-sized pieces," +
                        "1 large onion thinly sliced into half-moons," +
                        "2 garlic cloves finely chopped," +
                        "3cm piece ginger  peeled and finely chopped," +
                        "½ tsp ground cumin," +
                        "½ tsp garam masala," +
                        "1 tbsp tomato purée," +
                        "1 red chilli thinly sliced into rings," +
                        "juice ½ lemon," +
                        "4 rotis warmed," +
                        "½ small red onion, chopped," +
                        "4 tbsp mango chutney or lime pickle," +
                        "4 handfuls mint or coriander," +
                        "4 tbsp yogurt"),
                "https://www.bbcgoodfood.com/sites/default/files/styles/recipe/public/recipe/recipe-image/2016/04/chilli-chicken-wraps.jpg?itok=vymDqDgk",
                null);
        GetImageFromInt getimage7 = new GetImageFromInt(this);
        getimage7.execute(recipe7);

        Recipe recipe8 = new Recipe(10008,
                "Chunky sausage & tomato pasta",
                " 1. Heat the olive oil in a heavy-based pan (preferably not non-stick) and add the sausages. Fry for about 8 mins until golden and cooked through. Tip in the garlic and fry for 1 min. Pour in the white wine and boil until it has reduced by half." +
                        "\n\n 2. Stir in the tomato purée and tomatoes, and season to taste. Simmer for 15 mins until the sauce is rich and thick." +
                        "\n\n 3. While the sauce cooks, boil the pasta according to pack instructions and drain. Stir in the basil if using, and cooked pasta into the sauce, then serve in bowls with grated or shaved Parmesan.",
                Arrays.asList("1 tbsp olive oil," +
                        "4 thick pork sausages cut into bite-sized pieces," +
                        "2 garlic cloves crushed," +
                        "200ml medium white wine," +
                        "1 tbsp tomato purée," +
                        "400g can chopped tomatoes," +
                        "500g pack rigatoni or penne," +
                        "handful basil leaves torn (optional)," +
                        "parmesan to serve"),
                "https://www.bbcgoodfood.com/sites/default/files/styles/recipe/public/recipe_images/recipe-image-legacy-id--338950_11.jpg?itok=uzab8n_G",
                null);
        GetImageFromInt getimage8 = new GetImageFromInt(this);
        getimage8.execute(recipe8);

        Recipe recipe9 = new Recipe(10009,
                "Apple crumble sundae",
                " 1. In a small saucepan, melt the butter over a gentle heat and add the apples, cinnamon and sugar. Cook for 10 mins or until the apples have softened but still hold their shape." +
                        "\n\n 2. Split the mixture between four sundae glasses or bowls. Sit 2 scoops of ice cream on top of each, followed by the crushed biscuits. Serve while the apple mix is still warm.",
                Arrays.asList("2 tbsp butter," +
                        "4 Granny Smiths apples cored and diced," +
                        "1 tsp ground cinnamon," +
                        "2 tbsp light brown sugar," +
                        "8 scoops vanilla ice cream," +
                        "2 ginger nuts biscuits crushed"),
                "https://www.bbcgoodfood.com/sites/default/files/styles/recipe/public/recipe/recipe-image/2016/11/apple-crumble-sundae.jpg?itok=t24QYO_-",
                null);
        GetImageFromInt getimage9 = new GetImageFromInt(this);
        getimage9.execute(recipe9);

        Recipe recipe10 = new Recipe(10010,
                "Spicy meatballs",
                " 1. Heat oven to 180C/fan 160C/gas 4." +
                        "\n\n 2. Put the mince into the mixing bowl. Add the onions, garlic, curry powder, cumin, garam masala, paprika or cayenne pepper and coriander, then mix well. By adding these spices, you’ll get a delicious flavour without having to add any salt." +
                        "\n\n 3. Add the beaten egg and breadcrumbs, then mix again." +
                        "\n\n 4. Divide the meat mixture into 15-18 evensized pieces and shape into balls (they should be about the size of a walnut). Always wash your hands thoroughly after handling raw meat so you don’t transfer any germs that may be on the meat to other food or equipment." +
                        "\n\n 5. Heat the oil in the frying pan over a medium heat and add the meatballs using a spoon. Cook them for 5 mins, turning until golden brown. Remove from the pan and place them on to the tray. Bake in the oven for 15-20 mins." +
                        "\n\n 6. Remove from the oven. Remember to use oven gloves! Allow to cool slightly and serve with a fresh, crisp green salad, some pitta bread and tomato salsa.",
                Arrays.asList("500g minced chicken turkey lamb beef or pork," +
                        "1 medium onion," +
                        "2 garlic cloves crushed or chopped," +
                        "2 tsp mild or medium curry powder," +
                        "2 tsp ground cumin," +
                        "1 tsp garam masala," +
                        "½ tsp paprika or cayenne pepper," +
                        "2 tbsp fresh coriander chopped," +
                        "1 egg beaten," +
                        "50g fresh breadcrumb," +
                        "1 tbsp olive oil"),
                "https://www.bbcgoodfood.com/sites/default/files/styles/recipe/public/recipe_images/recipe-image-legacy-id--364491_12.jpg?itok=LXsn4qp0",
                null);
        GetImageFromInt getimage10 = new GetImageFromInt(this);
        getimage10.execute(recipe10);

//        Recipe recipe2 = new Recipe(10002,
//                "Roast chicken soup",
//                " 1. Heat 1 tbsp olive oil in a large heavy-based pan. Add 2 chopped onions, 3 chopped medium carrots and 1 tbsp roughly chopped thyme leaves, then gently fry for 15 mins." +
//                        "\n\n 2. Stir in 1.4l chicken stock, bring to a boil, cover, then simmer for 10 mins." +
//                        "\n\n 3. Add 300g shredded leftover roast chicken, remove half the mixture, then purée with a stick blender. " +
//                        "\n\n 4. Tip back into the pan with the rest of the soup, 200g frozen peas and seasoning, then simmer for 5 mins until hot through." +
//                        "\n\n 5. Mix 3 tbsp Greek yogurt,1 crushed garlic clove and a squeeze lemon juice, swirl into the soup in bowls, then serve." +
//                        "\n\n 6. If you want to use a slow cooker, gently fry 2 chopped onions, 3 chopped medium carrots and1 tbsp roughly chopped thyme leaves for 15 mins then tip them with the veg into your slow cooker with 1 litre stock. If you're using a chicken carcass, add it now." +
//                        "\n\n 7. Cover and cook for 2-3 hours on High until the veg is tender. If you used a carcass remove it now, shredding any remaining chicken from the bones." +
//                        "\n\n 8. Stir back into the soup, or add 300g shredded leftover roast chicken now, plus 200g frozen peas." +
//                        "\n\n 9. Cook for 30 mins more. Remove half the mixture and purée with a stick blender, then serve as above.",
//                Arrays.asList("1 tbsp olive oil," +
//                        "2 onions chopped," +
//                        "3 medium carrots chopped," +
//                        "1 tbsp thyme leaves roughly chopped," +
//                        "1.4l chicken stock," +
//                        "300g leftover roast chicken shredded and skin removed," +
//                        "200g frozen peas," +
//                        "3 tbsp Greek yogurt," +
//                        "1 garlic clove crushed," +
//                        "squeeze lemon juice"),
//                "https://www.bbcgoodfood.com/sites/default/files/styles/recipe/public/recipe_images/recipe-image-legacy-id--1074495_11.jpg?itok=ZeOmX4dB",
//                null);
//        GetImageFromInt getimage2 = new GetImageFromInt(this);
//        getimage2.execute(recipe2);
//
//        Recipe recipe2 = new Recipe(10002,
//                "Roast chicken soup",
//                " 1. Heat 1 tbsp olive oil in a large heavy-based pan. Add 2 chopped onions, 3 chopped medium carrots and 1 tbsp roughly chopped thyme leaves, then gently fry for 15 mins." +
//                        "\n\n 2. Stir in 1.4l chicken stock, bring to a boil, cover, then simmer for 10 mins." +
//                        "\n\n 3. Add 300g shredded leftover roast chicken, remove half the mixture, then purée with a stick blender. " +
//                        "\n\n 4. Tip back into the pan with the rest of the soup, 200g frozen peas and seasoning, then simmer for 5 mins until hot through." +
//                        "\n\n 5. Mix 3 tbsp Greek yogurt,1 crushed garlic clove and a squeeze lemon juice, swirl into the soup in bowls, then serve." +
//                        "\n\n 6. If you want to use a slow cooker, gently fry 2 chopped onions, 3 chopped medium carrots and1 tbsp roughly chopped thyme leaves for 15 mins then tip them with the veg into your slow cooker with 1 litre stock. If you're using a chicken carcass, add it now." +
//                        "\n\n 7. Cover and cook for 2-3 hours on High until the veg is tender. If you used a carcass remove it now, shredding any remaining chicken from the bones." +
//                        "\n\n 8. Stir back into the soup, or add 300g shredded leftover roast chicken now, plus 200g frozen peas." +
//                        "\n\n 9. Cook for 30 mins more. Remove half the mixture and purée with a stick blender, then serve as above.",
//                Arrays.asList("1 tbsp olive oil," +
//                        "2 onions chopped," +
//                        "3 medium carrots chopped," +
//                        "1 tbsp thyme leaves roughly chopped," +
//                        "1.4l chicken stock," +
//                        "300g leftover roast chicken shredded and skin removed," +
//                        "200g frozen peas," +
//                        "3 tbsp Greek yogurt," +
//                        "1 garlic clove crushed," +
//                        "squeeze lemon juice"),
//                "https://www.bbcgoodfood.com/sites/default/files/styles/recipe/public/recipe_images/recipe-image-legacy-id--1074495_11.jpg?itok=ZeOmX4dB",
//                null);
//        GetImageFromInt getimage2 = new GetImageFromInt(this);
//        getimage2.execute(recipe2);
//
//        Recipe recipe2 = new Recipe(10002,
//                "Roast chicken soup",
//                " 1. Heat 1 tbsp olive oil in a large heavy-based pan. Add 2 chopped onions, 3 chopped medium carrots and 1 tbsp roughly chopped thyme leaves, then gently fry for 15 mins." +
//                        "\n\n 2. Stir in 1.4l chicken stock, bring to a boil, cover, then simmer for 10 mins." +
//                        "\n\n 3. Add 300g shredded leftover roast chicken, remove half the mixture, then purée with a stick blender. " +
//                        "\n\n 4. Tip back into the pan with the rest of the soup, 200g frozen peas and seasoning, then simmer for 5 mins until hot through." +
//                        "\n\n 5. Mix 3 tbsp Greek yogurt,1 crushed garlic clove and a squeeze lemon juice, swirl into the soup in bowls, then serve." +
//                        "\n\n 6. If you want to use a slow cooker, gently fry 2 chopped onions, 3 chopped medium carrots and1 tbsp roughly chopped thyme leaves for 15 mins then tip them with the veg into your slow cooker with 1 litre stock. If you're using a chicken carcass, add it now." +
//                        "\n\n 7. Cover and cook for 2-3 hours on High until the veg is tender. If you used a carcass remove it now, shredding any remaining chicken from the bones." +
//                        "\n\n 8. Stir back into the soup, or add 300g shredded leftover roast chicken now, plus 200g frozen peas." +
//                        "\n\n 9. Cook for 30 mins more. Remove half the mixture and purée with a stick blender, then serve as above.",
//                Arrays.asList("1 tbsp olive oil," +
//                        "2 onions chopped," +
//                        "3 medium carrots chopped," +
//                        "1 tbsp thyme leaves roughly chopped," +
//                        "1.4l chicken stock," +
//                        "300g leftover roast chicken shredded and skin removed," +
//                        "200g frozen peas," +
//                        "3 tbsp Greek yogurt," +
//                        "1 garlic clove crushed," +
//                        "squeeze lemon juice"),
//                "https://www.bbcgoodfood.com/sites/default/files/styles/recipe/public/recipe_images/recipe-image-legacy-id--1074495_11.jpg?itok=ZeOmX4dB",
//                null);
//        GetImageFromInt getimage2 = new GetImageFromInt(this);
//        getimage2.execute(recipe2);
//
//        Recipe recipe2 = new Recipe(10002,
//                "Roast chicken soup",
//                " 1. Heat 1 tbsp olive oil in a large heavy-based pan. Add 2 chopped onions, 3 chopped medium carrots and 1 tbsp roughly chopped thyme leaves, then gently fry for 15 mins." +
//                        "\n\n 2. Stir in 1.4l chicken stock, bring to a boil, cover, then simmer for 10 mins." +
//                        "\n\n 3. Add 300g shredded leftover roast chicken, remove half the mixture, then purée with a stick blender. " +
//                        "\n\n 4. Tip back into the pan with the rest of the soup, 200g frozen peas and seasoning, then simmer for 5 mins until hot through." +
//                        "\n\n 5. Mix 3 tbsp Greek yogurt,1 crushed garlic clove and a squeeze lemon juice, swirl into the soup in bowls, then serve." +
//                        "\n\n 6. If you want to use a slow cooker, gently fry 2 chopped onions, 3 chopped medium carrots and1 tbsp roughly chopped thyme leaves for 15 mins then tip them with the veg into your slow cooker with 1 litre stock. If you're using a chicken carcass, add it now." +
//                        "\n\n 7. Cover and cook for 2-3 hours on High until the veg is tender. If you used a carcass remove it now, shredding any remaining chicken from the bones." +
//                        "\n\n 8. Stir back into the soup, or add 300g shredded leftover roast chicken now, plus 200g frozen peas." +
//                        "\n\n 9. Cook for 30 mins more. Remove half the mixture and purée with a stick blender, then serve as above.",
//                Arrays.asList("1 tbsp olive oil," +
//                        "2 onions chopped," +
//                        "3 medium carrots chopped," +
//                        "1 tbsp thyme leaves roughly chopped," +
//                        "1.4l chicken stock," +
//                        "300g leftover roast chicken shredded and skin removed," +
//                        "200g frozen peas," +
//                        "3 tbsp Greek yogurt," +
//                        "1 garlic clove crushed," +
//                        "squeeze lemon juice"),
//                "https://www.bbcgoodfood.com/sites/default/files/styles/recipe/public/recipe_images/recipe-image-legacy-id--1074495_11.jpg?itok=ZeOmX4dB",
//                null);
//        GetImageFromInt getimage2 = new GetImageFromInt(this);
//        getimage2.execute(recipe2);
//
//        Recipe recipe2 = new Recipe(10002,
//                "Roast chicken soup",
//                " 1. Heat 1 tbsp olive oil in a large heavy-based pan. Add 2 chopped onions, 3 chopped medium carrots and 1 tbsp roughly chopped thyme leaves, then gently fry for 15 mins." +
//                        "\n\n 2. Stir in 1.4l chicken stock, bring to a boil, cover, then simmer for 10 mins." +
//                        "\n\n 3. Add 300g shredded leftover roast chicken, remove half the mixture, then purée with a stick blender. " +
//                        "\n\n 4. Tip back into the pan with the rest of the soup, 200g frozen peas and seasoning, then simmer for 5 mins until hot through." +
//                        "\n\n 5. Mix 3 tbsp Greek yogurt,1 crushed garlic clove and a squeeze lemon juice, swirl into the soup in bowls, then serve." +
//                        "\n\n 6. If you want to use a slow cooker, gently fry 2 chopped onions, 3 chopped medium carrots and1 tbsp roughly chopped thyme leaves for 15 mins then tip them with the veg into your slow cooker with 1 litre stock. If you're using a chicken carcass, add it now." +
//                        "\n\n 7. Cover and cook for 2-3 hours on High until the veg is tender. If you used a carcass remove it now, shredding any remaining chicken from the bones." +
//                        "\n\n 8. Stir back into the soup, or add 300g shredded leftover roast chicken now, plus 200g frozen peas." +
//                        "\n\n 9. Cook for 30 mins more. Remove half the mixture and purée with a stick blender, then serve as above.",
//                Arrays.asList("1 tbsp olive oil," +
//                        "2 onions chopped," +
//                        "3 medium carrots chopped," +
//                        "1 tbsp thyme leaves roughly chopped," +
//                        "1.4l chicken stock," +
//                        "300g leftover roast chicken shredded and skin removed," +
//                        "200g frozen peas," +
//                        "3 tbsp Greek yogurt," +
//                        "1 garlic clove crushed," +
//                        "squeeze lemon juice"),
//                "https://www.bbcgoodfood.com/sites/default/files/styles/recipe/public/recipe_images/recipe-image-legacy-id--1074495_11.jpg?itok=ZeOmX4dB",
//                null);
//        GetImageFromInt getimage2 = new GetImageFromInt(this);
//        getimage2.execute(recipe2);
//
//        Recipe recipe2 = new Recipe(10002,
//                "Roast chicken soup",
//                " 1. Heat 1 tbsp olive oil in a large heavy-based pan. Add 2 chopped onions, 3 chopped medium carrots and 1 tbsp roughly chopped thyme leaves, then gently fry for 15 mins." +
//                        "\n\n 2. Stir in 1.4l chicken stock, bring to a boil, cover, then simmer for 10 mins." +
//                        "\n\n 3. Add 300g shredded leftover roast chicken, remove half the mixture, then purée with a stick blender. " +
//                        "\n\n 4. Tip back into the pan with the rest of the soup, 200g frozen peas and seasoning, then simmer for 5 mins until hot through." +
//                        "\n\n 5. Mix 3 tbsp Greek yogurt,1 crushed garlic clove and a squeeze lemon juice, swirl into the soup in bowls, then serve." +
//                        "\n\n 6. If you want to use a slow cooker, gently fry 2 chopped onions, 3 chopped medium carrots and1 tbsp roughly chopped thyme leaves for 15 mins then tip them with the veg into your slow cooker with 1 litre stock. If you're using a chicken carcass, add it now." +
//                        "\n\n 7. Cover and cook for 2-3 hours on High until the veg is tender. If you used a carcass remove it now, shredding any remaining chicken from the bones." +
//                        "\n\n 8. Stir back into the soup, or add 300g shredded leftover roast chicken now, plus 200g frozen peas." +
//                        "\n\n 9. Cook for 30 mins more. Remove half the mixture and purée with a stick blender, then serve as above.",
//                Arrays.asList("1 tbsp olive oil," +
//                        "2 onions chopped," +
//                        "3 medium carrots chopped," +
//                        "1 tbsp thyme leaves roughly chopped," +
//                        "1.4l chicken stock," +
//                        "300g leftover roast chicken shredded and skin removed," +
//                        "200g frozen peas," +
//                        "3 tbsp Greek yogurt," +
//                        "1 garlic clove crushed," +
//                        "squeeze lemon juice"),
//                "https://www.bbcgoodfood.com/sites/default/files/styles/recipe/public/recipe_images/recipe-image-legacy-id--1074495_11.jpg?itok=ZeOmX4dB",
//                null);
//        GetImageFromInt getimage2 = new GetImageFromInt(this);
//        getimage2.execute(recipe2);
//
//        Recipe recipe2 = new Recipe(10002,
//                "Roast chicken soup",
//                " 1. Heat 1 tbsp olive oil in a large heavy-based pan. Add 2 chopped onions, 3 chopped medium carrots and 1 tbsp roughly chopped thyme leaves, then gently fry for 15 mins." +
//                        "\n\n 2. Stir in 1.4l chicken stock, bring to a boil, cover, then simmer for 10 mins." +
//                        "\n\n 3. Add 300g shredded leftover roast chicken, remove half the mixture, then purée with a stick blender. " +
//                        "\n\n 4. Tip back into the pan with the rest of the soup, 200g frozen peas and seasoning, then simmer for 5 mins until hot through." +
//                        "\n\n 5. Mix 3 tbsp Greek yogurt,1 crushed garlic clove and a squeeze lemon juice, swirl into the soup in bowls, then serve." +
//                        "\n\n 6. If you want to use a slow cooker, gently fry 2 chopped onions, 3 chopped medium carrots and1 tbsp roughly chopped thyme leaves for 15 mins then tip them with the veg into your slow cooker with 1 litre stock. If you're using a chicken carcass, add it now." +
//                        "\n\n 7. Cover and cook for 2-3 hours on High until the veg is tender. If you used a carcass remove it now, shredding any remaining chicken from the bones." +
//                        "\n\n 8. Stir back into the soup, or add 300g shredded leftover roast chicken now, plus 200g frozen peas." +
//                        "\n\n 9. Cook for 30 mins more. Remove half the mixture and purée with a stick blender, then serve as above.",
//                Arrays.asList("1 tbsp olive oil," +
//                        "2 onions chopped," +
//                        "3 medium carrots chopped," +
//                        "1 tbsp thyme leaves roughly chopped," +
//                        "1.4l chicken stock," +
//                        "300g leftover roast chicken shredded and skin removed," +
//                        "200g frozen peas," +
//                        "3 tbsp Greek yogurt," +
//                        "1 garlic clove crushed," +
//                        "squeeze lemon juice"),
//                "https://www.bbcgoodfood.com/sites/default/files/styles/recipe/public/recipe_images/recipe-image-legacy-id--1074495_11.jpg?itok=ZeOmX4dB",
//                null);
//        GetImageFromInt getimage2 = new GetImageFromInt(this);
//        getimage2.execute(recipe2);
//
//        Recipe recipe2 = new Recipe(10002,
//                "Roast chicken soup",
//                " 1. Heat 1 tbsp olive oil in a large heavy-based pan. Add 2 chopped onions, 3 chopped medium carrots and 1 tbsp roughly chopped thyme leaves, then gently fry for 15 mins." +
//                        "\n\n 2. Stir in 1.4l chicken stock, bring to a boil, cover, then simmer for 10 mins." +
//                        "\n\n 3. Add 300g shredded leftover roast chicken, remove half the mixture, then purée with a stick blender. " +
//                        "\n\n 4. Tip back into the pan with the rest of the soup, 200g frozen peas and seasoning, then simmer for 5 mins until hot through." +
//                        "\n\n 5. Mix 3 tbsp Greek yogurt,1 crushed garlic clove and a squeeze lemon juice, swirl into the soup in bowls, then serve." +
//                        "\n\n 6. If you want to use a slow cooker, gently fry 2 chopped onions, 3 chopped medium carrots and1 tbsp roughly chopped thyme leaves for 15 mins then tip them with the veg into your slow cooker with 1 litre stock. If you're using a chicken carcass, add it now." +
//                        "\n\n 7. Cover and cook for 2-3 hours on High until the veg is tender. If you used a carcass remove it now, shredding any remaining chicken from the bones." +
//                        "\n\n 8. Stir back into the soup, or add 300g shredded leftover roast chicken now, plus 200g frozen peas." +
//                        "\n\n 9. Cook for 30 mins more. Remove half the mixture and purée with a stick blender, then serve as above.",
//                Arrays.asList("1 tbsp olive oil," +
//                        "2 onions chopped," +
//                        "3 medium carrots chopped," +
//                        "1 tbsp thyme leaves roughly chopped," +
//                        "1.4l chicken stock," +
//                        "300g leftover roast chicken shredded and skin removed," +
//                        "200g frozen peas," +
//                        "3 tbsp Greek yogurt," +
//                        "1 garlic clove crushed," +
//                        "squeeze lemon juice"),
//                "https://www.bbcgoodfood.com/sites/default/files/styles/recipe/public/recipe_images/recipe-image-legacy-id--1074495_11.jpg?itok=ZeOmX4dB",
//                null);
//        GetImageFromInt getimage2 = new GetImageFromInt(this);
//        getimage2.execute(recipe2);
//
//        Recipe recipe2 = new Recipe(10002,
//                "Roast chicken soup",
//                " 1. Heat 1 tbsp olive oil in a large heavy-based pan. Add 2 chopped onions, 3 chopped medium carrots and 1 tbsp roughly chopped thyme leaves, then gently fry for 15 mins." +
//                        "\n\n 2. Stir in 1.4l chicken stock, bring to a boil, cover, then simmer for 10 mins." +
//                        "\n\n 3. Add 300g shredded leftover roast chicken, remove half the mixture, then purée with a stick blender. " +
//                        "\n\n 4. Tip back into the pan with the rest of the soup, 200g frozen peas and seasoning, then simmer for 5 mins until hot through." +
//                        "\n\n 5. Mix 3 tbsp Greek yogurt,1 crushed garlic clove and a squeeze lemon juice, swirl into the soup in bowls, then serve." +
//                        "\n\n 6. If you want to use a slow cooker, gently fry 2 chopped onions, 3 chopped medium carrots and1 tbsp roughly chopped thyme leaves for 15 mins then tip them with the veg into your slow cooker with 1 litre stock. If you're using a chicken carcass, add it now." +
//                        "\n\n 7. Cover and cook for 2-3 hours on High until the veg is tender. If you used a carcass remove it now, shredding any remaining chicken from the bones." +
//                        "\n\n 8. Stir back into the soup, or add 300g shredded leftover roast chicken now, plus 200g frozen peas." +
//                        "\n\n 9. Cook for 30 mins more. Remove half the mixture and purée with a stick blender, then serve as above.",
//                Arrays.asList("1 tbsp olive oil," +
//                        "2 onions chopped," +
//                        "3 medium carrots chopped," +
//                        "1 tbsp thyme leaves roughly chopped," +
//                        "1.4l chicken stock," +
//                        "300g leftover roast chicken shredded and skin removed," +
//                        "200g frozen peas," +
//                        "3 tbsp Greek yogurt," +
//                        "1 garlic clove crushed," +
//                        "squeeze lemon juice"),
//                "https://www.bbcgoodfood.com/sites/default/files/styles/recipe/public/recipe_images/recipe-image-legacy-id--1074495_11.jpg?itok=ZeOmX4dB",
//                null);
//        GetImageFromInt getimage2 = new GetImageFromInt(this);
//        getimage2.execute(recipe2);
    }


    public void addRecipe(Recipe recipe) {

        //get writable DB connection, as we want to put data into DB
        //SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(Recipe.COLUMN_DISHES_ID, recipe.getRecipeId());
        values.put(Recipe.COLUMN_DISHES_NAME, recipe.getDishes_Name());
        values.put(Recipe.COLUMN_DISHES_DESCRIPTION, recipe.getDishes_Description());
        values.put(Recipe.COLUMN_DISHES_INGREDIENTS, listToCsv(recipe.getDishes_Ingredients(),','));
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
                new String[] {Recipe.COLUMN_DISHES_ID,
                        Recipe.COLUMN_DISHES_NAME,
                        Recipe.COLUMN_DISHES_DESCRIPTION,
                        Recipe.COLUMN_DISHES_INGREDIENTS,
                        Recipe.COLUMN_PICTURE_URL,
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
                Arrays.asList(cursor.getString(cursor.getColumnIndex(Recipe.COLUMN_DISHES_INGREDIENTS)).split("\\s*,\\s*")),
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
                recipe.setDishes_Ingredients(Arrays.asList(cursor.getString(cursor.getColumnIndex(Recipe.COLUMN_DISHES_INGREDIENTS)).split("\\s*,\\s*")));
                recipe.setPicture_Url(cursor.getString(cursor.getColumnIndex(Recipe.COLUMN_PICTURE_URL)));
                recipe.setDishes_Picture(cursor.getBlob(cursor.getColumnIndex(Recipe.COLUMN_DISHES_PICTURE)));
                recipeList.add(recipe);
            }while (cursor.moveToNext());
        }

        return  recipeList;

    }

    String listToCsv(List<String> listOfStrings, char separator) {
        StringBuilder sb = new StringBuilder();

        // all but last
        for(int i = 0; i < listOfStrings.size() - 1 ; i++) {
            sb.append(listOfStrings.get(i));
            sb.append(separator);
        }

        // last string, no separator
        if(listOfStrings.size() > 0){
            sb.append(listOfStrings.get(listOfStrings.size()-1));
        }

        return sb.toString();
    }

}
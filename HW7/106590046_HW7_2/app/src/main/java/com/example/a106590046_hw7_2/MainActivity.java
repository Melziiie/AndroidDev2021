package com.example.a106590046_hw7_2;

import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;

import android.view.Menu;
import android.view.MenuItem;

import java.util.Hashtable;
import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {
    private final Hashtable<Integer, String> mTitleList = new Hashtable<Integer, String>();
    private final Hashtable<Integer, String> mDescList = new Hashtable<Integer, String>();
    private final Hashtable<Integer, String> mIngredientsList = new Hashtable<Integer, String>();
    private final Hashtable<Integer, String> mProcedureList = new Hashtable<Integer, String>();
    private final Hashtable<Integer, Integer> mThumbnailList = new Hashtable<Integer, Integer>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //Titles
        {
            mTitleList.put(1,"Chicken & chorizo rice pot");
            mTitleList.put(2,"Griddled tuna with bean & tomato salad");
            mTitleList.put(3,"Cheesy tuna pasta bake");
            mTitleList.put(4,"Sausage and red pepper pasta");
            mTitleList.put(5,"Gazpacho pasta salad");
//            mTitleList.put(6,"Chicken & chorizo rice pot");
//            mTitleList.put(7,"Chicken & chorizo rice pot");
//            mTitleList.put(8,"Chicken & chorizo rice pot");
//            mTitleList.put(9,"Chicken & chorizo rice pot");
//            mTitleList.put(10,"Chicken & chorizo rice pot");
        }

        //Desc
        {
            mDescList.put(1,"Save on effort and washing up with this one-pot wonder that is packed with flavour. Eat some for dinner and save the rest for lunch the next day.");
            mDescList.put(2,"The fresh tuna in this dish has a lovely meaty texture that’s even better when marinated before cooking");
            mDescList.put(3,"If you're looking for a simple, easy-to-follow creamy tuna pasta bake recipe, this is the one! Absolutely easy, cheesy and loaded with veggies!");
            mDescList.put(4,"This Sausage & Red Pepper Pasta is easy, flavorful and the answer to what you’re making for supper tonight. It’s simple, quick, packed full of savory and hearty flavor, and the best part? It’s all made in 30 minutes! ");
            mDescList.put(5,"Fresh tomato, cucumber, and bell pepper make this southwest-inspired pasta salad nutritious and tasty.\n");
//            mDescList.put(6,"");
//            mDescList.put(7,"");
//            mDescList.put(8,"");
//            mDescList.put(9,"");
//            mDescList.put(10,"");
        }

        //Ingredients
        {
            mIngredientsList.put(1,"1 tbsp oil\n8 chicken pieces or 1 whole chicken, jointed\n1 large onion, chopped\n1 red pepper, deseeded and chopped into large chunks\n3 garlic cloves, crushed\n225g chorizo, skinned and sliced\n1 tbsp tomato puree\n1 tbsp thyme leaf, chopped\n150ml white wine\n850ml chicken stock\n400g long grain rice\n2 tbsp chopped parsley\n");
            mIngredientsList.put(2,"2 fresh tuna steaks, about 175g/6oz each\n" +
                    "1 tbsp olive oil \n" +
                    "1 tbsp lemon juice\n" +
                    "1 large garlic clove, crushed\n" +
                    "1 tbsp chopped rosemary leaves\n" +
                    "410g can cannellini bean, drained and rinsed\n" +
                    "8 cherry tomatoes, quartered\n" +
                    "Â½ small red onion, thinly sliced\n" +
                    "50g bag rocket\n" +
                    "2 tbsp extra-virgin olive oil\n" +
                    "1 tbsp lemon juice\n" +
                    "1 tsp wholegrain mustard\n" +
                    "1 tsp clear honey");
            mIngredientsList.put(3,"450g pasta shells\n" +
                    "1 tablespoon vegetable oil\n" +
                    "1 (295g) tin condensed cream of mushroom soup\n" +
                    "1 1/2 (300g) tin mixed vegetables, drained\n" +
                    "1 (185g) tin tuna, drained\n" +
                    "275g grated Cheddar cheese, divided\n" +
                    "salt and pepper to taste");
            mIngredientsList.put(4,"225g uncooked farfalle pasta\n" +
                    "225g mild Italian sausages, casings removed\n" +
                    "125g roasted red peppers, drained and chopped\n" +
                    "225g sliced fresh mushrooms\n" +
                    "125ml vodka\n" +
                    "800g passata\n" +
                    "125ml single cream\n" +
                    "1/8 teaspoon crushed chillies\n" +
                    "40g grated Parmesan cheese");
            mIngredientsList.put(5,"225g (8 oz) fusilli pasta\n" +
                    "4 spring onions, chopped\n" +
                    "1 green pepper, chopped\n" +
                    "1 jalapeÃ±o chilli, seeded and minced\n" +
                    "2 tomatoes, chopped\n" +
                    "1 cucumber\n" +
                    "4 tablespoons olive oil\n" +
                    "1/4 teaspoon salt\n" +
                    "1 clove garlic, crushed\n" +
                    "4 tablespoons fresh lime juice\n" +
                    "1/4 teaspoon freshly ground black pepper\n" +
                    "175ml (6 fl oz) tomato juice");
//            mIngredientsList.put(6,"");
//            mIngredientsList.put(7,"");
//            mIngredientsList.put(8,"");
//            mIngredientsList.put(9,"");
//            mIngredientsList.put(10,"");
        }

        //Procedures
        {
            mProcedureList.put(1,"Heat the oil in a large flameproof casserole dish and brown the chicken pieces on all sides â€“ you may have to do this in batches. Remove from the dish and put to one side.\nLower the heat, add the onion and pepper, and gently cook for 10 mins until softened. Add the garlic and chorizo, and cook for a further 2 mins until the chorizo has released some of its oils into the dish. Stir in the tomato purÃ©e and cook for 1 min more.\nReturn the chicken pieces to the dish along with the thyme, white wine and stock. Bring the liquid to a boil, cover the dish with a tight-fitting lid and lower the heat. Cook for 30 mins.\nTip in the rice and stir everything together. Cover, set over a low heat and cook for a further 15 mins, or until the rice is cooked and has absorbed most of the cooking liquid. Remove from the heat and leave the dish to sit for 10 mins to absorb any remaining liquid. Season to taste and scatter with parsley to serve.");
            mProcedureList.put(2,"Put the tuna in a shallow dish, drizzle over the oil and lemon juice, scatter over the garlic and rosemary. Turn the tuna so it is well coated. Cover and put in the fridge for 30 minutes (you can leave it for longer if convenient).\n" +
                    "Tip the beans into a large bowl. Toss in the tomatoes, onion and rocket. Put the oil, lemon juice, mustard, honey and salt and pepper in a screw top jar. Seal and put aside.\n" +
                    "Heat a cast iron ridged grill pan or frying pan until very hot. Cook the tuna on a moderately high heat for 2 minutes each side don't overcook or it will be dry.\n" +
                    "Shake the dressing. Pour over the salad. Mix. Serve the salad with the tuna on top.");
            mProcedureList.put(3,"Bring a large pot of lightly salted water to the boil. Add 1 tablespoon oil to the water. Add pasta and cook for 8 to 10 minutes or until al dente; drain. Preheat oven to 180 C / Gas 4.\n" +
                    "In a 2 litre saucepan over medium heat, combine the soup, vegetables, tuna and half of the cheese. Gently fold pasta into the soup mixture and mix thoroughly. Pour mixture into a 20x30cm baking dish. Sprinkle remaining cheese on top.\n" +
                    "Bake in a preheated oven until cheese is melted and bubbly.");
            mProcedureList.put(4,"Bring a large pot of lightly salted water to the boil. Place farfalle pasta in the pot, cook for 8 to 10 minutes, until al dente and drain.\n" +
                    "In a frying pan over medium heat, cook the sausagemeat until evenly brown. Mix in the roasted red peppers, mushrooms and vodka. Bring to the boil. Cook and stir 5 minutes, until most of the vodka has evaporated and mushrooms are tender.\n" +
                    "Mix the tomatoes, single cream and crushed chillies into the frying pan. Cover, reduce heat to low and cook, stirring frequently, 15 minutes. Serve over the pasta and top with Parmesan cheese.");
            mProcedureList.put(5,"Cook fusilli according to package instructions; drain.\n" +
                    "In large bowl combine pasta, onion, green pepper, jalapeÃ±o, tomatoes, cucumber, oil, salt, garlic, lime juice, black pepper and tomato juice. Toss well and chill in refrigerator for 2 hours. Toss again before serving.");
//            mProcedureList.put(6,"");
//            mProcedureList.put(7,"");
//            mProcedureList.put(8,"");
//            mProcedureList.put(9,"");
//            mProcedureList.put(10,"");
        }

        //Thumbnails
        {
            mThumbnailList.put(1, R.drawable.chickNrice);
            mThumbnailList.put(2, R.drawable.griddledtuna);
            mThumbnailList.put(3, R.drawable.tunabake);
            mThumbnailList.put(4,R.drawable.sausagepasta);
            mThumbnailList.put(5,R.drawable.gazpacho);
//            mThumbnailList.put(6,R.drawable.);
//            mThumbnailList.put(7,R.drawable.);
//            mThumbnailList.put(8,R.drawable.);
//            mThumbnailList.put(9,R.drawable.);
//            mThumbnailList.put(10,R.drawable.);
        }

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
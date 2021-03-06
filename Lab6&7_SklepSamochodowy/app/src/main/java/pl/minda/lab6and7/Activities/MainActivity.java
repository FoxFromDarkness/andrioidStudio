package pl.minda.lab6and7.Activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import pl.minda.lab6and7.R;


public class MainActivity extends ToolbarCreator {

    private AdapterView.OnItemClickListener itemClickListener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setIdMenu(R.menu.main_menu);
        setThisActivity(MainActivity.this);

        createAdapter(MainActivity.this, CategoryActivity.class);

        ListView listView = findViewById(R.id.listView_main);
        listView.setOnItemClickListener(itemClickListener);

    }

    private void createAdapter(final Context thisActivity, final Class nextActivity) {
        itemClickListener = new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> listView, View itemView, int position, long id) {

                switch (position) {
                    case 0:
                        Intent intentPizza = new Intent(thisActivity, nextActivity);
                        intentPizza.putExtra("category", "SPORT");
                        startActivity(intentPizza);
                        break;
                    case 1:
                        Intent intentDrink = new Intent(thisActivity, nextActivity);
                        intentDrink.putExtra("category", "SUV");
                        startActivity(intentDrink);
                        break;
                    case 2:
                        Intent intentOther = new Intent(thisActivity, nextActivity);
                        intentOther.putExtra("category", "PREMIUM");
                        startActivity(intentOther);
                        break;
                }
            }
        };
    }



}

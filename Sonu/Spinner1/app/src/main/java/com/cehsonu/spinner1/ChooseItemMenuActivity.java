package com.cehsonu.spinner1;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class ChooseItemMenuActivity extends AppCompatActivity {

    Price price=new Price();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_item_menu);
    }

    public void showPrice(View view)  {
        Spinner itemView=(Spinner)findViewById(R.id.food_types_view);
        String itemName=String.valueOf(itemView.getSelectedItem());
        String prices=price.getPrice(itemName);
        TextView show_price_view=(TextView)findViewById(R.id.food_items_view);
        show_price_view.setText(prices);
    }
}

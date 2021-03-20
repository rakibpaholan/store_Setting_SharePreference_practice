package com.example.storecolorsettingssharepreferencepractice;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private LinearLayout linearLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        linearLayout = (LinearLayout)findViewById(R.id.linearLayout);


        linearLayout.setBackgroundColor(load_color());

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_resource,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (item.getItemId()==R.id.redish_color_id){
            int color_code = getResources().getColor(R.color.red_color);
            linearLayout.setBackgroundColor(color_code);
            Toast.makeText(MainActivity.this,"Red",Toast.LENGTH_SHORT).show();
            store_color(color_code);
        }
        if (item.getItemId()==R.id.yellowsh_color_id){
            int color_code = getResources().getColor(R.color.yellow_color);
            linearLayout.setBackgroundColor(color_code);
            Toast.makeText(MainActivity.this,"Yellow",Toast.LENGTH_SHORT).show();
            store_color(color_code);
        }
        if (item.getItemId()==R.id.pinkish_color_id){
            int color_code = getResources().getColor(R.color.pink);
            linearLayout.setBackgroundColor(color_code);
            Toast.makeText(MainActivity.this,"Pink",Toast.LENGTH_SHORT).show();
            store_color(color_code);
        }

        return super.onOptionsItemSelected(item);
    }
    public void store_color(int color){
        SharedPreferences sharedPreferences = getSharedPreferences("color_code", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("keyOfColor",color);
        editor.commit();
    }

    private int load_color(){
        SharedPreferences sharedPreferences = getSharedPreferences("color_code",Context.MODE_PRIVATE);
        int color_code = sharedPreferences.getInt("keyOfColor",getResources().getColor(R.color.design_default_color_primary_dark));
        return color_code;
    }
}
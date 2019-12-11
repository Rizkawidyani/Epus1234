package com.yenny.epus;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private ImageButton imageButton1;
    private ImageButton imageButton2;
    private ImageButton imageButton3;
    private ImageButton imageButton4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showStart();

        imageButton1 = (ImageButton)findViewById(R.id.imageButton1);
        imageButton1.setOnClickListener(this);
        imageButton3 = (ImageButton)findViewById(R.id.imageButton3);
        imageButton3.setOnClickListener(this);
        imageButton4 = (ImageButton)findViewById(R.id.imageButton4);
        imageButton4.setOnClickListener(this);
    }

    private void showStart() {
        FragmentManager fm = getSupportFragmentManager();
        StartFragment editStartFragment = StartFragment.newInstance("Some Title");
        editStartFragment.show(fm, "fragment_start");
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.imageButton1:
                Intent moveIntent = new Intent(MainActivity.this, GenreBook.class);
                startActivity(moveIntent);
                break;
            case R.id.imageButton3:
                Intent moveIntentabout = new Intent(MainActivity.this, About.class);
                startActivity(moveIntentabout);
                break;
            case R.id.imageButton4:
                Intent moveIntentprofile = new Intent(MainActivity.this, Profile.class);
                startActivity(moveIntentprofile);
                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.iconback, menu);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.logo_foreground);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.exit:
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(getApplicationContext(),Login.class));
                break;
        }
        return false;
    }
}
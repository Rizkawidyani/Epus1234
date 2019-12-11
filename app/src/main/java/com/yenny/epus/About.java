package com.yenny.epus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class About extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.iconback, menu);
        setContentView(R.layout.activity_about);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.about_foreground);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.back:
                About.this.finish();
                break;
            case R.id.home:
                Intent moveIntent = new Intent(About.this, MainActivity.class);
                startActivity(moveIntent);
                break;
            case R.id.exit:
                finishAffinity();
                System.exit(0);
                break;
        }
        return false;
    }

}

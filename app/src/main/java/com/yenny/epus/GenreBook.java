package com.yenny.epus;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;


public class GenreBook extends AppCompatActivity implements View.OnClickListener {
    private Button btnShowDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_genre_book);

        btnShowDialog = (Button) findViewById(R.id.btn_show_dialog);
        btnShowDialog.setOnClickListener(this);
    }


    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_show_dialog:
                GenreFragment mOptionDialogFragment = new GenreFragment();
                mOptionDialogFragment.setOnOptionDialogListener(new GenreFragment.OnOptionDialogListener() {
                @Override
                public void onOptionChoosen(String text) {
                    Toast.makeText(getParent(), text, Toast.LENGTH_SHORT).show();
                    }
                });
            FragmentManager mFragmentManager = getSupportFragmentManager();
            mOptionDialogFragment.show(mFragmentManager,GenreFragment.class.getSimpleName());
            break;

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.iconback, menu);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.book_foreground);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.back:
                GenreBook.this.finish();
                break;
            case R.id.home:
                Intent moveIntent = new Intent(GenreBook.this, MainActivity.class);
                startActivity(moveIntent);
                break;
            case R.id.exit:
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(getApplicationContext(),Login.class));
                break;
        }
        return false;
    }
}
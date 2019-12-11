package com.yenny.epus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;

import com.google.firebase.auth.FirebaseAuth;

public class DescriptionBookMariposa extends AppCompatActivity {
    private WebView webViewMariposa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description_book_mariposa);

        // ambil id
        webViewMariposa = (WebView) findViewById(R.id.webViewMariposa);

        // aktifkan javascript
        webViewMariposa.getSettings().setJavaScriptEnabled(true);

        // fungsi zoom (opsional)
        webViewMariposa.getSettings().setBuiltInZoomControls(true);

        // isi url
        webViewMariposa.loadUrl("https://mochisreview.wordpress.com/2019/04/15/resensi-novel-mariposa/");

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
                DescriptionBookMariposa.this.finish();
                break;
            case R.id.home:
                Intent moveIntent = new Intent(DescriptionBookMariposa.this, MainActivity.class);
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
package com.yenny.epus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

public class DescriptionBook extends AppCompatActivity {
    private WebView webViewLaskar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description_book);
// ambil id
        webViewLaskar = (WebView) findViewById(R.id.webViewLaskar);

        // aktifkan javascript
        webViewLaskar.getSettings().setJavaScriptEnabled(true);

        // fungsi zoom (opsional)
        webViewLaskar.getSettings().setBuiltInZoomControls(true);

        // isi url
        webViewLaskar.loadUrl("https://myblogersinformation1.blogspot.com/2016/11/novel-laskar-pelangi-karya-andrea.html?m=1");

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
                DescriptionBook.this.finish();
                break;
            case R.id.home:
                Intent moveIntent = new Intent(DescriptionBook.this, MainActivity.class);
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

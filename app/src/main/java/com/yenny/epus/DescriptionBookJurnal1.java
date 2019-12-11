package com.yenny.epus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;

import com.google.firebase.auth.FirebaseAuth;

public class DescriptionBookJurnal1 extends AppCompatActivity {
    private WebView webViewBook;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description_book_jurnal1);
        // ambil id
        webViewBook = (WebView) findViewById(R.id.webViewBook);

        // aktifkan javascript
        webViewBook.getSettings().setJavaScriptEnabled(true);

        // fungsi zoom (opsional)
        webViewBook.getSettings().setBuiltInZoomControls(true);

        // isi url
        webViewBook.loadUrl("https://journal.unnes.ac.id/nju/index.php/JPP");

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
                DescriptionBookJurnal1.this.finish();
                break;
            case R.id.home:
                Intent moveIntent = new Intent(DescriptionBookJurnal1.this, MainActivity.class);
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

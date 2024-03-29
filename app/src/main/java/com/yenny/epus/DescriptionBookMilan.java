package com.yenny.epus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;

import com.google.firebase.auth.FirebaseAuth;

public class DescriptionBookMilan extends AppCompatActivity {
    private WebView webViewMilan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description_book_milan);

        // ambil id
        webViewMilan = (WebView) findViewById(R.id.webViewMilan);

        // aktifkan javascript
        webViewMilan.getSettings().setJavaScriptEnabled(true);

        // fungsi zoom (opsional)
        webViewMilan.getSettings().setBuiltInZoomControls(true);

        // isi url
        webViewMilan.loadUrl("https://mahasiswaindonesia.id/milan-kata-orang-hatinya-membeku-seperti-es/amp/");

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
                DescriptionBookMilan.this.finish();
                break;
            case R.id.home:
                Intent moveIntent = new Intent(DescriptionBookMilan.this, MainActivity.class);
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

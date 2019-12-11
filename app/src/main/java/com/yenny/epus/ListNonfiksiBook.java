package com.yenny.epus;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class ListNonfiksiBook extends Activity {

    ListView simpleList;
    String title[] = {"Cerdas Berbahasa sesuai EYD", "Ketatanegaraan","Khasiat Buah Dan Sayur", "Media Pembelajaran Aktif", "Otot"};
    int cover[] = {R.drawable.non_cerdasberbahasasesuaieyd, R.drawable.non_ketatanegaraan, R.drawable.non_khasiat, R.drawable.non_mediapembelajaranaktif, R.drawable.non_otot,};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_nonfiksi_book);
        simpleList = (ListView) findViewById(R.id.simpleListView);
        CustomAdapter customAdapter = new CustomAdapter(getApplicationContext(), title, cover);
        simpleList.setAdapter(customAdapter);
        simpleList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 0) {
                    Intent intent = new Intent(getApplication(), DescriptionBookEYD.class);
                    startActivity(intent);
                } else if (i == 1) {
                    Intent intent = new Intent(getApplication(), DescriptionBookKetatanegaraan.class);
                    startActivity(intent);
                } else if (i == 2) {
                    Intent intent = new Intent(getApplication(), DescriptionBookKhasiatTomat.class);
                    startActivity(intent);
                } else if (i == 3) {
                    Intent intent = new Intent(getApplication(), DescriptionBookMediaPembAktif.class);
                    startActivity(intent);
                } else if (i == 4) {
                    Intent intent = new Intent(getApplication(), DescriptionBookOtot.class);
                    startActivity(intent);

                } else {
                    Toast t = Toast.makeText(getApplication(), title[i], Toast.LENGTH_SHORT);
                    t.setGravity(Gravity.CENTER | Gravity.CENTER, 0, 0);
                    t.show();
                }
            }
        });
    }
}

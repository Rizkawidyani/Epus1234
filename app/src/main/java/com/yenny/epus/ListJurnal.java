package com.yenny.epus;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class ListJurnal extends Activity {

    ListView simpleList;
    String title[] = {"Jurnal Penelitian Pendidikan", "Jurnal Penelitian Perikanan Indonesia","Jurnal Penelitian Sosial dan Ekonomi Kehutanan"};
    int cover[] = {R.drawable.j_jurnalpenelitianpendidikan, R.drawable.j_jurnalpenelitianperikananindonesia, R.drawable.j_jurnalpenelitiansosialdanekonomikehutanan};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_jurnal);
        simpleList = (ListView) findViewById(R.id.simpleListView);
        CustomAdapter customAdapter = new CustomAdapter(getApplicationContext(), title, cover);
        simpleList.setAdapter(customAdapter);
        simpleList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 0) {
                    Intent intent = new Intent(getApplication(), DescriptionBookJurnal1.class);
                    startActivity(intent);
                } else if (i == 1) {
                    Intent intent = new Intent(getApplication(), DescriptionBookJurnal2.class);
                    startActivity(intent);
                } else if (i == 2) {
                    Intent intent = new Intent(getApplication(), DescriptionBookJurnal3.class);
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

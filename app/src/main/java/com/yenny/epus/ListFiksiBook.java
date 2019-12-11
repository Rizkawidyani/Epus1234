package com.yenny.epus;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class ListFiksiBook extends Activity {

    ListView simpleList;
    String title[] = {"Laskar Pelangi", "The Book Alice", "Milan", "Mariposa", "Hope", "Bintang"};
    int cover[] = {R.drawable.laskar_pelangi, R.drawable.the_book_alice, R.drawable.milan, R.drawable.mariposa, R.drawable.hope, R.drawable.bintang};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_fiksi_book);
        simpleList = (ListView) findViewById(R.id.simpleListView);
        CustomAdapter customAdapter = new CustomAdapter(getApplicationContext(), title, cover);
        simpleList.setAdapter(customAdapter);
        simpleList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 0) {
                    Intent intent = new Intent(getApplication(), DescriptionBook.class);
                    startActivity(intent);
                } else if (i == 1) {
                    Intent intent = new Intent(getApplication(), DescriptionBookAlice.class);
                    startActivity(intent);
                } else if (i == 2) {
                    Intent intent = new Intent(getApplication(), DescriptionBookMilan.class);
                    startActivity(intent);
                } else if (i == 3) {
                    Intent intent = new Intent(getApplication(), DescriptionBookMariposa.class);
                    startActivity(intent);
                } else if (i == 4) {
                    Intent intent = new Intent(getApplication(), DescriptionBookHope.class);
                    startActivity(intent);
                } else if (i == 5) {
                    Intent intent = new Intent(getApplication(), DescriptionBookBintang.class);
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

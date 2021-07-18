package com.dev_pd.alchemy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.GridView;
import android.widget.LinearLayout;

import com.dev_pd.alchemy.data.Data;

public class MainActivity extends AppCompatActivity {

    private Context context;
    private LinearLayout ll_groups;
    private LinearLayout ll_controls;
    private GridView gv_elements;

    private Data data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = this;

        ll_groups = findViewById(R.id.ll_groups);
        ll_controls = findViewById(R.id.ll_controls);
        gv_elements = findViewById(R.id.gv_elements);

        int logos[] = {R.drawable.ic_launcher_background, R.drawable.ic_launcher_foreground};

        ElementAdapter customAdapter = new ElementAdapter(getApplicationContext(), logos);
        gv_elements.setAdapter(customAdapter);


        data = new Data();
        System.out.println("--------------------------------------------------");
        System.out.println(data.elements);
        System.out.println("--------------------------------------------------");
        System.out.println(data.groups);
        System.out.println("--------------------------------------------------");
        System.out.println(data.combinations);
        System.out.println("--------------------------------------------------");
    }

}
package com.dev_pd.alchemy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import com.dev_pd.alchemy.data.Data;
import com.dev_pd.alchemy.data.ElementUI;

public class MainActivity extends AppCompatActivity {

    private Context context;
    private LinearLayout ll_groups;
    private LinearLayout ll_controls;
    private GridView gv_elements;

    private ImageButton btn_decrease_elements_window_size;
    private ImageButton btn_increase_elements_window_size;

    int MAX_COLUMNS = 3;

    private Data data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = this;

        ll_groups = findViewById(R.id.ll_groups);
        ll_controls = findViewById(R.id.ll_controls);
        gv_elements = findViewById(R.id.gv_elements);
        btn_decrease_elements_window_size = findViewById(R.id.btn_decrease_elements_window_size);
        btn_increase_elements_window_size = findViewById(R.id.btn_increase_elements_window_size);

        int px = (int) MainActivity.dpToPx(context, 50);

        btn_decrease_elements_window_size.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int numColumns = gv_elements.getNumColumns();
                if(numColumns>1){
                    numColumns--;
                }

                int i = numColumns * px;
                gv_elements.getLayoutParams().width = i;
                gv_elements.setNumColumns(numColumns);
//                GridView.LayoutParams lp=new GridView.LayoutParams(i,i);
//                gv_elements.setLayoutParams(lp);
            }
        });

        btn_increase_elements_window_size.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int numColumns = gv_elements.getNumColumns();
                if(numColumns < MAX_COLUMNS){
                    numColumns++;
                }

                int i = numColumns * px;
                gv_elements.getLayoutParams().width = i;
                gv_elements.setNumColumns(numColumns);
//                GridView.LayoutParams lp=new GridView.LayoutParams(i,i);
//                gv_elements.setLayoutParams(lp);
            }
        });

        int logos[] = {R.drawable.ic_launcher_background, R.drawable.ic_launcher_foreground};
        String names[] = {"Gfh", "dgfger"};
        ElementUI[] elementUIS = new ElementUI[] {
                new ElementUI("air", R.drawable.ic_launcher_background),
                new ElementUI("fire", R.drawable.ic_baseline_),
                new ElementUI("water", R.drawable.ic_launcher_foreground)
        };

        ElementAdapter customAdapter = new ElementAdapter(getApplicationContext(), elementUIS);
        gv_elements.setAdapter(customAdapter);
        gv_elements.setNumColumns(2);
//        gv_elements.set

        data = new Data();
        System.out.println("--------------------------------------------------");
        System.out.println(data.elements);
        System.out.println("--------------------------------------------------");
        System.out.println(data.groups);
        System.out.println("--------------------------------------------------");
        System.out.println(data.combinations);
        System.out.println("--------------------------------------------------");
    }

    // Converts DP to pixels
    public static float dpToPx(Context context, int dp){
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, context.getResources().getDisplayMetrics());
    }
}
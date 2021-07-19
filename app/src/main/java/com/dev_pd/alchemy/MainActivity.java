package com.dev_pd.alchemy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.view.WindowInsetsController;
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
    private ImageButton btn_quest;
    private ImageButton btn_clear;
    private ImageButton btn_undo;
    private ImageButton btn_info;
    private ImageButton btn_add;

    int MAX_COLUMNS = 3;

    private Data data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
//            getWindow().setDecorFitsSystemWindows(false);
//        }
//        else{
////            window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
//            getWindow().getDecorView().setSystemUiVisibility(getWindow().getDecorView().getSystemUiVisibility());
//            getWindow().setStatusBarColor(Color.TRANSPARENT);
//        }

        setFullScreen();

        context = this;

        ll_groups = findViewById(R.id.ll_groups);
        ll_controls = findViewById(R.id.ll_controls);
        gv_elements = findViewById(R.id.gv_elements);
        btn_decrease_elements_window_size = findViewById(R.id.btn_decrease_elements_window_size);
        btn_increase_elements_window_size = findViewById(R.id.btn_increase_elements_window_size);
        btn_quest = findViewById(R.id.btn_quest);
        btn_clear = findViewById(R.id.btn_clear);
        btn_undo = findViewById(R.id.btn_undo);
        btn_info = findViewById(R.id.btn_info);
        btn_add = findViewById(R.id.btn_add);

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
                setElementsButtonState(numColumns);
            }
        });

        btn_increase_elements_window_size.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int numColumns = gv_elements.getNumColumns();
                if(numColumns < MAX_COLUMNS) {
                    numColumns++;
                }

                int i = numColumns * px;
                gv_elements.getLayoutParams().width = i;
                gv_elements.setNumColumns(numColumns);
                setElementsButtonState(numColumns);
            }
        });

        btn_quest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        btn_clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        btn_undo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        btn_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        ElementUI[] elementUIS = new ElementUI[] {
                new ElementUI("air", R.drawable.ic_launcher_background),
                new ElementUI("fire", R.drawable.ic_baseline_),
                new ElementUI("air", R.drawable.ic_launcher_background),
                new ElementUI("fire", R.drawable.ic_baseline_),
                new ElementUI("air", R.drawable.ic_launcher_background),
                new ElementUI("fire", R.drawable.ic_baseline_),
                new ElementUI("air", R.drawable.ic_launcher_background),
                new ElementUI("fire", R.drawable.ic_baseline_),
                new ElementUI("air", R.drawable.ic_launcher_background),
                new ElementUI("fire", R.drawable.ic_baseline_),
                new ElementUI("air", R.drawable.ic_launcher_background),
                new ElementUI("fire", R.drawable.ic_baseline_),
                new ElementUI("water", R.drawable.ic_launcher_foreground)
        };

        ElementAdapter customAdapter = new ElementAdapter(getApplicationContext(), elementUIS);
        gv_elements.setAdapter(customAdapter);
        gv_elements.setNumColumns(2);

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

    private void setElementsButtonState(int numColumns){
        if(numColumns == 1){
            btn_decrease_elements_window_size.setAlpha(.5f);
        }
        else{
            btn_decrease_elements_window_size.setAlpha(1f);
        }

        if(numColumns == MAX_COLUMNS){
            btn_increase_elements_window_size.setAlpha(.5f);
        }
        else{
            btn_increase_elements_window_size.setAlpha(1f);
        }

    }

    private void setFullScreen(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            getWindow().setDecorFitsSystemWindows(false);
            WindowInsetsController controller = getWindow().getInsetsController();
            if(controller != null) {
                controller.hide(WindowInsets.Type.statusBars() | WindowInsets.Type.navigationBars());
                controller.setSystemBarsBehavior(WindowInsetsController.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE);
            }
        }
        else {
            //noinspection deprecation
            getWindow().getDecorView().setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_IMMERSIVE
                            | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                            | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION);
        }
    }

}

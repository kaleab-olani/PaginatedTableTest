package com.app.kol.paginatedtabletest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import github.hotstu.sasuke.SasukeAdapter;
import github.hotstu.sasuke.SasukeView;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {


    private SasukeView sasuke;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sasuke = findViewById(R.id.sasuke);

        sasuke.setStickColumnHead(true);
        sasuke.setStickRowHead(true);

        sasuke.setAdapter(new MySasukeAdapter());
    }

//
//    public void stickRow(View view) {
//        boolean checked = ((CheckBox) view).isChecked();
//        sasuke.setStickRowHead(checked);
//    }
//
//    public void stickColumn(View view) {
//        boolean checked = ((CheckBox) view).isChecked();
//        sasuke.setStickColumnHead(checked);
//    }

    static class VH extends RecyclerView.ViewHolder {
        TextView t;
        public VH(TextView itemView) {
            super(itemView);
            t = itemView;
        }
    }

    class MySasukeAdapter extends SasukeAdapter {
        @Override
        public int getRowCount() {
            return 50;
        }

        @Override
        public int getColumnCount() {
            return 10;
        }

        @SuppressLint("SetTextI18n")
        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int row, int column) {
            TextView t = ((VH) holder).t;
            ViewGroup.LayoutParams layoutParams = t.getLayoutParams();
            if (row == 0) {
                t.setText(String.valueOf(column));
                layoutParams.height = 100;
                t.setLayoutParams(layoutParams);
            }
            if (column == 0) {
                layoutParams.width = 100;
                layoutParams.height = 50;
                t.setText(String.valueOf(row));
            }
            if (row!=0 && column!=0){
                if ((row+column)%2==0)
                    t.setText("" + row + "long long long long long long long long long long" + column);
                else
                    t.setText("" + row + "-" + column);
            }
        }

        @Override
        public int getItemViewType(int row, int column) {
            return (row == 0|| column == 0 ? 1: 0);
        }

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            TextView tv = new TextView(parent.getContext());
            tv.setLayoutParams(new ViewGroup.LayoutParams(200, 100));
            tv.setBackgroundColor(Color.WHITE);
            return new VH(tv);
        }

    };
}
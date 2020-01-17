package com.juniarstudio.kuissantai;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class GamePlayActivity extends AppCompatActivity implements View.OnClickListener {

    private Button b1, b2, b3, b4, b5, b6, b7, b8, b9, b10, b11, b12;
    private TextView tvCoins, tvPertanyaan;
    private ImageButton ibClose, ibLamp;
    private RecyclerView recyclerView;
    private ArrayList<ItemJawabanModel> dataset;
    private ItemJawabanAdapter ija;
    private int coins = 0;
    private boolean lamp = true;
    private boolean bantu = true;
    private KuisModel kuisModel = new KuisModel(1, "Julukan aku yang lebih sopan?", "terkemudian");
    private char[] pos = new char[kuisModel.getJawaban().length()];

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_play);
        recyclerView = findViewById(R.id.recyclerview);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.HORIZONTAL);
        recyclerView.setLayoutManager(layoutManager);
        b1 = findViewById(R.id.b1);
        b2 = findViewById(R.id.b2);
        b3 = findViewById(R.id.b3);
        b4 = findViewById(R.id.b4);
        b5 = findViewById(R.id.b5);
        b6 = findViewById(R.id.b6);
        b7 = findViewById(R.id.b7);
        b8 = findViewById(R.id.b8);
        b9 = findViewById(R.id.b9);
        b10 = findViewById(R.id.b10);
        b11 = findViewById(R.id.b11);
        b12 = findViewById(R.id.b12);
        tvCoins = findViewById(R.id.tvCoins);
        tvPertanyaan = findViewById(R.id.tvPertanyaan);
        ibClose = findViewById(R.id.ibClose);
        ibClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        ibLamp = findViewById(R.id.ibLamp);
        coins = 55;
        setLamp();
        ibLamp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (coins - 10 > 0) {
                    coins = coins - 10;
                    if (bantu) {

                    }
                } else {
                    lamp = false;
                }
                if (coins<10){
                    lamp = false;
                }
                setLamp();
            }
        });
        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
        b4.setOnClickListener(this);
        b5.setOnClickListener(this);
        b6.setOnClickListener(this);
        b7.setOnClickListener(this);
        b8.setOnClickListener(this);
        b9.setOnClickListener(this);
        b10.setOnClickListener(this);
        b11.setOnClickListener(this);
        b12.setOnClickListener(this);
        setWidget();
        //EditText[] editTexts = new EditText[6];
        dataset = new ArrayList<>();

        for (int i = 0; i < pos.length; i++) {
            dataset.add(new ItemJawabanModel(i, ' '));
        }
        ija = new ItemJawabanAdapter(this, dataset);
        recyclerView.setAdapter(ija);
        //editTexts[0].setText('A');

    }

    private void msg_warninglamp(String msg) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
    }

    @SuppressLint("SetTextI18n")
    private void setLamp() {
        if (!lamp) {
            ibLamp.setImageResource(R.drawable.ic_lamp_off);
            ibLamp.setEnabled(false);
        } else {
            ibLamp.setImageResource(R.drawable.ic_lamp_on);
            ibLamp.setEnabled(true);
        }
        tvCoins.setText("Koin : " + coins);
    }

    @SuppressLint("SetTextI18n")
    private void setWidget() {
        tvCoins.setText("" + kuisModel.getLevel());
        tvPertanyaan.setText(kuisModel.getPertanyaan());
        String jwbn = new AcakKata(kuisModel.getJawaban()).getResult().toUpperCase();
        b1.setText("" + jwbn.charAt(0));
        b2.setText("" + jwbn.charAt(1));
        b3.setText("" + jwbn.charAt(2));
        b4.setText("" + jwbn.charAt(3));
        b5.setText("" + jwbn.charAt(4));
        b6.setText("" + jwbn.charAt(5));
        b7.setText("" + jwbn.charAt(6));
        b8.setText("" + jwbn.charAt(7));
        b9.setText("" + jwbn.charAt(8));
        b10.setText("" + jwbn.charAt(9));
        b11.setText("" + jwbn.charAt(10));
        b12.setText("" + jwbn.charAt(11));
    }

    public void reset(View view) {
        pos = new char[kuisModel.getJawaban().length()];
        setWidget();
        b1.setVisibility(View.VISIBLE);
        b2.setVisibility(View.VISIBLE);
        b3.setVisibility(View.VISIBLE);
        b4.setVisibility(View.VISIBLE);
        b5.setVisibility(View.VISIBLE);
        b6.setVisibility(View.VISIBLE);
        b7.setVisibility(View.VISIBLE);
        b8.setVisibility(View.VISIBLE);
        b9.setVisibility(View.VISIBLE);
        b10.setVisibility(View.VISIBLE);
        b11.setVisibility(View.VISIBLE);
        b12.setVisibility(View.VISIBLE);
        p = -1;
        c = ' ';
        setRecyclerView();
    }


    public void check(View view) {
        dialog("Ok", "Gak ada pesan", R.drawable.ic_lamp_on);
    }

    private void dialog(String title, String body, int icon) {
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LayoutInflater inflater = this.getLayoutInflater();
        @SuppressLint("InflateParams") View v = inflater.inflate(R.layout.alert_dialog, null);
        TextView tvTitle = v.findViewById(R.id.tvTitle);
        TextView tvMessage = v.findViewById(R.id.tvBody);
        ImageView ivIcon = v.findViewById(R.id.ivIcon);
        tvTitle.setText(title);
        tvMessage.setText(body);
        ivIcon.setImageResource(icon);
        Button bn = v.findViewById(R.id.btnNegative);
        Button by = v.findViewById(R.id.btnPositive);
        //by.setVisibility(View.GONE);
        bn.setVisibility(View.GONE);
        builder.setView(v);
        final AlertDialog alertDialog = builder.create();
        v.findViewById(R.id.btnPositive).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.cancel();
            }
        });
        alertDialog.show();
    }

    private void setRecyclerView() {
        dataset = new ArrayList<>();
        if (bantu){
            dataset.add(new ItemJawabanModel(0, kuisModel.getJawaban().charAt(0)));
            for (int a=1;a<pos.length-1; a++){
                dataset.add(new ItemJawabanModel(0, pos[a]));
            }
            dataset.add(new ItemJawabanModel(0, kuisModel.getJawaban().charAt(kuisModel.getJawaban().length())));
        }else {
            for (char po : pos) {
                dataset.add(new ItemJawabanModel(0, po));
            }
        }
        ija.clear();
        recyclerView.removeAllViewsInLayout();
        recyclerView.setAdapter(new ItemJawabanAdapter(this, dataset));
    }

    int p = -1;
    char c = ' ';

    @Override
    public void onClick(View v) {
        p++;
        switch (v.getId()) {
            case R.id.b1:
                c = b1.getText().charAt(0);
                b1.setVisibility(View.INVISIBLE);
                break;
            case R.id.b2:
                c = b2.getText().charAt(0);
                b2.setVisibility(View.INVISIBLE);
                break;
            case R.id.b3:
                c = b3.getText().charAt(0);
                b3.setVisibility(View.INVISIBLE);
                break;
            case R.id.b4:
                c = b4.getText().charAt(0);
                b4.setVisibility(View.INVISIBLE);
                break;
            case R.id.b5:
                c = b5.getText().charAt(0);
                b5.setVisibility(View.INVISIBLE);
                break;
            case R.id.b6:
                c = b6.getText().charAt(0);
                b6.setVisibility(View.INVISIBLE);
                break;
            case R.id.b7:
                c = b7.getText().charAt(0);
                b7.setVisibility(View.INVISIBLE);
                break;
            case R.id.b8:
                c = b8.getText().charAt(0);
                b8.setVisibility(View.INVISIBLE);
                break;
            case R.id.b9:
                c = b9.getText().charAt(0);
                b9.setVisibility(View.INVISIBLE);
                break;
            case R.id.b10:
                c = b10.getText().charAt(0);
                b10.setVisibility(View.INVISIBLE);
                break;
            case R.id.b11:
                c = b11.getText().charAt(0);
                b11.setVisibility(View.INVISIBLE);
                break;
            case R.id.b12:
                c = b12.getText().charAt(0);
                b12.setVisibility(View.INVISIBLE);
                break;
        }
        if (p > -1 && p < kuisModel.getJawaban().length()) {
            pos[p] = c;
            setRecyclerView();
        }
    }
}

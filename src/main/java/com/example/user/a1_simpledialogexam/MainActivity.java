package com.example.user.a1_simpledialogexam;

import android.content.DialogInterface;
import android.preference.DialogPreference;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements
        View.OnClickListener{

    Button button1,button2,button3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button1:
                showAlertDialog();
                break;
            case R.id.button2:
                showConfirmDialog();
                break;
            case R.id.button3:
                showLIstDialog();
                break;
        }
    }
    public void showAlertDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("알림");
        builder.setMessage("알림 대화상자 입니다.");
        builder.setIcon(R.mipmap.ic_launcher);
        builder.setCancelable(false);//취소기능을 쓰지않겠다

        builder.setPositiveButton("확인", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplication(),"확인을 눌렀습니다.",Toast.LENGTH_LONG).show();
            }
        });
        builder.create();
        builder.show();
    }
    public void showConfirmDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("확인");
        builder.setMessage("확인 대화상자 입니다.");
        builder.setIcon(R.mipmap.ic_launcher);
        builder.setCancelable(false);

        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplication(),"OK을 눌렀습니다.",Toast.LENGTH_LONG).show();
            }
        });
        builder.setNegativeButton("CANCEL",new DialogInterface.OnClickListener(){
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Toast.makeText(getApplication(),"CANCEL을 눌렀습니다.",Toast.LENGTH_LONG).show();
                }
            });

        builder.create();
        builder.show();
    }

    public void showLIstDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("확인");
        builder.setIcon(android.R.drawable.ic_lock_idle_alarm);
        builder.setCancelable(false);

        final String[] items = {"축구","농구","배구"};

        builder.setItems(items,new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplication(),items[which],Toast.LENGTH_LONG).show();
            }
        });
        builder.setNegativeButton("CANCEL",new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplication(),"CANCEL을 눌렀습니다.",Toast.LENGTH_LONG).show();
            }
        });

        builder.create();
        builder.show();

    }
}

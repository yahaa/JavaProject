package com.example.zihua.myapplication;

import android.content.DialogInterface;
import android.os.CountDownTimer;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Dialog_box extends AppCompatActivity {
    private String title="请输入验证密码     ";
    private MyTimer myTimer=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog_box);

        View view = LayoutInflater.from(Dialog_box.this).inflate(R.layout.confirm_main,null);

        final AlertDialog.Builder builder = new AlertDialog.Builder(Dialog_box.this);
        builder.setTitle(title);
        builder.setView(view);
        builder.setPositiveButton("确定", null);
        builder.setCancelable(false);
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {}
        });


        final AlertDialog alertDialog= builder.create();
        alertDialog.show();
        myTimer=new MyTimer(60000,1000,alertDialog);
        myTimer.start();
        Button button=alertDialog.getButton(AlertDialog.BUTTON_POSITIVE);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText confirmMessage = (EditText)findViewById(R.id.confirmMessage);

                if(confirmMessage==null || confirmMessage.getText().toString().length() == 0 ){
                    alertDialog.setTitle("密码为空，请重新输入。");
                }
                else if(confirmMessage.getText().equals("123456")){
                    myTimer.onFinish();
                    alertDialog.dismiss();
                }
                else
                    alertDialog.setTitle("密码错误，请重新输入。");
            }
        });

    }
}

class MyTimer extends CountDownTimer {

    private AlertDialog alertDialog=null;
    private String title="请输入验证密码     ";

    public MyTimer(long millisInFuture, long countDownInterval, AlertDialog alertDialog) {
        super(millisInFuture, countDownInterval);
        this.alertDialog=alertDialog;
    }

    @Override
    public void onFinish() {
        alertDialog.setTitle("over......");
    }

    @Override
    public void onTick(long millisUntilFinished) {
        long t=millisUntilFinished / 1000;
        alertDialog.setTitle(title+t);
    }
}



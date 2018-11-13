package com.service.letinvr.servicemoudle;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import static com.service.letinvr.servicemoudle.api.API.RECEIVER_RADIO;
import static com.service.letinvr.servicemoudle.api.API.SEND_BROADCAST;

public class MainActivity extends AppCompatActivity {
    private TextView mTx;
    private int MAX = 0;
    private int MAS = 0;


    private BroadcastReceiver receiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {

            String action = intent.getAction();

            if (!action.isEmpty() && action.equals(RECEIVER_RADIO)) {
                MAS++;
                String send = intent.getStringExtra("send");
                SLog.e("收到回复信息：" + send);
                mTx.setText(mTx.getText().toString() + "---接收：" + MAS);
            }
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTx = findViewById(R.id.mTe);


        IntentFilter filter = new IntentFilter();
        filter.addAction(RECEIVER_RADIO);//收到回复
        registerReceiver(receiver, filter);


        //模拟向LetinService发送广播
        mTx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MAX++;
                Intent intent = new Intent();
                intent.setAction(SEND_BROADCAST);
                intent.putExtra("date", "ServiceMoidle发送-" + MAX);
                sendBroadcast(intent);
                mTx.setText("发送：" + MAX);
            }
        });
    }
}

package com.rosid.throwaway;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public Intent intent_send;
    private EditText inMsg;
    private String strMsg;
    private TextView txtReplyObj;

    public static final int TEXT_REQUEST = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inMsg =(EditText) findViewById(R.id.editPesan);

        txtReplyObj = (TextView) findViewById(R.id.textView2);
    }
    public void sendMsg (View v) {
        intent_send = new Intent(this, projek2.class);
        intent_send.putExtra("msg", inMsg.getText().toString());

        startActivityForResult(intent_send, TEXT_REQUEST);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode,resultCode,data);

        if (requestCode == TEXT_REQUEST) {
            if (resultCode == RESULT_OK) {
                String replyMsg = data.getStringExtra("replyMsg");

                txtReplyObj.setText(replyMsg);
                txtReplyObj.setVisibility(View.VISIBLE);
            }
        }
    }
}

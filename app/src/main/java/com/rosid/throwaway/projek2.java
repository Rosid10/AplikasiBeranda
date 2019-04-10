package com.rosid.throwaway;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class projek2 extends AppCompatActivity {
    private String pesan;
    private TextView txtMsgOP;
    private EditText inReplyObj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_projek2);


        Intent intent = getIntent();
        pesan = intent.getStringExtra("msg");

        txtMsgOP = (TextView) findViewById(R.id.textView);
        txtMsgOP.setText(pesan);
        inReplyObj = (EditText) findViewById(R.id.editText);


    }

    public void reply(View v){
        Intent intent_reply = new Intent();
        String reply = inReplyObj.getText().toString();
        intent_reply.putExtra("replyMsg", reply);

        setResult(RESULT_OK, intent_reply);
        finish();
    }
}

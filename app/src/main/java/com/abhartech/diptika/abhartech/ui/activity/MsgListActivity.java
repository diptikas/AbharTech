package com.abhartech.diptika.abhartech.ui.activity;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;
import android.widget.Toast;


import com.abhartech.diptika.abhartech.R;
import com.abhartech.diptika.abhartech.ui.adapter.MsgListAdapter;
import com.abhartech.diptika.abhartech.ui.viewmodel.Constant;
import com.abhartech.diptika.abhartech.ui.viewmodel.Message;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Diptika on 06/09/16.
 */
public class MsgListActivity extends AppCompatActivity{

    private List<Message> messageList = new ArrayList<>();
    private RecyclerView mMessageRecyclerView;
    private MsgListAdapter mMsgListAdapter;
    private Paint p = new Paint();
    private String[] mLocation;
    private String[] mTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        mMessageRecyclerView = (RecyclerView) findViewById(R.id.msg_list);
        getMessageLst();
        initView();

    }

    private void initView() {
        if(messageList.size()>0 && !messageList.isEmpty()) {
            mMessageRecyclerView.setLayoutManager(new LinearLayoutManager(MsgListActivity.this));
            mMsgListAdapter = new MsgListAdapter(MsgListActivity.this, messageList);
            mMessageRecyclerView.setItemAnimator(new DefaultItemAnimator());
            mMessageRecyclerView.setAdapter(mMsgListAdapter);
        }else {
            Toast.makeText(getApplicationContext(),"No Data",Toast.LENGTH_SHORT).show();
        }
    }


    private void getMessageLst() {
        mLocation = getResources().getStringArray(R.array.popular_city);
        mTitle=getResources().getStringArray(R.array.title);
        for(int i=0;i<mTitle.length;i++){
            Message message=new Message(i,Constant.ICON[i],mTitle[i],mLocation[i]);
            messageList.add(message);
        }

    }


    @Override
    protected void onResume() {
        super.onResume();
        mMsgListAdapter = new MsgListAdapter(MsgListActivity.this, messageList);
        mMsgListAdapter.notifyDataSetChanged();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }


}



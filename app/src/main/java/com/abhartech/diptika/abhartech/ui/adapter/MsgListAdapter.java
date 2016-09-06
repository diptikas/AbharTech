package com.abhartech.diptika.abhartech.ui.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.abhartech.diptika.abhartech.R;
import com.abhartech.diptika.abhartech.ui.viewmodel.Message;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by Diptika on 06/09/16.
 */
public class MsgListAdapter extends RecyclerView.Adapter<MsgListAdapter.ViewHolder> {
    private List<Message> messageList;
    private Context mContext;

    public MsgListAdapter(Context context, List<Message> messageList) {
        mContext = context;
        this.messageList = messageList;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, null);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Message message = messageList.get(position);
        holder.titleName.setText(message.getTitle());
        holder.locationText.setText("Location : " + message.getLocation());
        holder.idText.setText("S.No. : "+message.getId());
        holder.thumbnailIcon.setImageResource(message.getIconId());
        holder.setTag(R.string.tag_msg_id, message.getId());
        calculateDate(holder);

    }

    private void calculateDate(ViewHolder holder) {
        String currentDateTimeString = DateFormat.getDateInstance().format(new Date());
        holder.dateText.setText("CreatedOn: "+currentDateTimeString);
    }

    @Override
    public int getItemCount() {
        return messageList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView titleName;
        public TextView locationText;
        public TextView dateText;
        public TextView idText;
        public ImageView thumbnailIcon;
        public View view;

        /**
         * @param view
         */
        public ViewHolder(View view) {
            super(view);
            this.view = view;
            titleName = (TextView) view.findViewById(R.id.title_text);
            locationText = (TextView) view.findViewById(R.id.location_text);
            dateText = (TextView) view.findViewById(R.id.date_text);
            idText = (TextView) view.findViewById(R.id.id_text);
            thumbnailIcon = (ImageView) view.findViewById(R.id.thumbnail);
                    }

        public void setTag(int id, int tag) {
            view.setTag(id, tag);
        }

        @Override
        public void onClick(View v) {
            int id = (Integer) v.getTag(R.string.tag_msg_id);
            Toast.makeText(mContext.getApplicationContext(),"Id:"+id,Toast.LENGTH_SHORT).show();

        }
    }
}

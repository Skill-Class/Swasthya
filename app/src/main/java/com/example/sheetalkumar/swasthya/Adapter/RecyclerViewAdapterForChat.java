package com.example.sheetalkumar.swasthya.Adapter;

import android.annotation.SuppressLint;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sheetalkumar.swasthya.Model.ChatData;
import com.example.sheetalkumar.swasthya.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;


public class RecyclerViewAdapterForChat extends RecyclerView.Adapter<RecyclerViewAdapterForChat.ViewHolder> {

    private static final String TAG = "RecyclerViewAdapter";
    //vars

    private List<ChatData> mMessageList;
    private FirebaseAuth mAuth;
    private FirebaseUser mUser;

    public RecyclerViewAdapterForChat(List<ChatData> mMessageList) {
        //this.mChat = mChat;
        // this.userId = userId;
        //this.mContext = mContext;
        this.mMessageList = mMessageList;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        //  int VIEW_TYPE;
        //  if (viewType == 1) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_send_message, parent, false);
        return new ViewHolder(view);
        // } else {
        //    View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_received_message, parent, false);
        //  return new ViewHolder(view);
        //   }

        //  return new ViewHolder(view,viewType);
        //}
    }

    @SuppressLint("ResourceAsColor")
    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        Log.d(TAG, "onBindViewHolder: called.");

        ChatData c = mMessageList.get(position);
        mAuth = FirebaseAuth.getInstance();

        // Bundle bundle = ;
        //String message = bundle.getString("Top Bar Value");
        // holder.SenderName.setText(message);


        DateFormat dateFormat = DateFormat.getDateInstance();
        String formattedDate = dateFormat.format(new Date(Long.valueOf(c.getTimestamp())).getTime());


        String current_user_id = mAuth.getCurrentUser().getUid();

        String from_user = c.getUserId();
        if (from_user.equals(current_user_id)) {
            holder.chattext.setBackgroundResource(R.drawable.chatrighttext);
            holder.chattext.setText(c.getChatMessage());
            holder.SenderName.setText(c.getUserName());
            holder.timeTextView.setText(formattedDate);
        } else {
            holder.chattext.setBackgroundResource(R.drawable.chatrighttextone);
            holder.chattext.setText(c.getChatMessage());
            holder.SenderName.setText(c.getUserName());
            holder.timeTextView.setText(formattedDate);
        }
        //   holder.chattext.setText(c.getChatMessage());

    }

    /*
        @Override
        public int getItemViewType(int position) {
    //        mUser = mAuth.getCurrentUser();
            String current_user_id = mAuth.getCurrentUser().getUid();
            ChatData chatData = mMessageList.get(position);
            String from_user = chatData.getUserId();
            if(from_user.equals(current_user_id)){
                return 1;
            }else {
                return 0;
            }

        }
    */
    @Override
    public int getItemCount() {
        return mMessageList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        // ImageView image;
        ImageView left_image, right_image;
        TextView chattext;
        TextView SenderName;
        TextView timeTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            left_image = itemView.findViewById(R.id.image_right);
            chattext = itemView.findViewById(R.id.textView19);
            //     right_image = itemView.findViewById(R.id.image_right);
            SenderName = itemView.findViewById(R.id.sender_name);
            timeTextView = itemView.findViewById(R.id.time_textView);
        }
    }
}


package com.example.sheetalkumar.swasthya.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.sheetalkumar.swasthya.Adapter.RecyclerViewAdapterForChat;
import com.example.sheetalkumar.swasthya.Model.ChatData;
import com.example.sheetalkumar.swasthya.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static android.content.Context.INPUT_METHOD_SERVICE;

public class ChatFragment extends Fragment {





    private EditText mInputMessageView;
    private ImageView imageView;
    private ImageView backimg;
    private RecyclerView recyclerView;
    private ImageButton sendchatbtn;
    private FirebaseAuth mAuth;
    private FirebaseUser mUser;
    private String chatuserid;
    private ImageView sendname;

    private EditText userName;

    private DatabaseReference mRootRef;
    private FirebaseDatabase firebaseDatabase;
    private ArrayList<String> mchat = new ArrayList<>();
    // private List<ChatData> chatDataList;
    private String mCurrentUserId;
    private List<ChatData> mMessagesList = new ArrayList<>();
    private LinearLayoutManager linearLayoutManager;
    private RecyclerViewAdapterForChat mAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        mAuth = FirebaseAuth.getInstance();
        mUser = mAuth.getCurrentUser();
        mCurrentUserId = mAuth.getCurrentUser().getUid();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootview =  inflater.inflate(R.layout.fragment_chat, container, false);

        mRootRef = FirebaseDatabase.getInstance().getReference();
        backimg = rootview.findViewById(R.id.imageView9);
        mInputMessageView = rootview.findViewById(R.id.chatText);
        userName = rootview.findViewById(R.id.textView8);
        userName = rootview.findViewById(R.id.textView8);



        mAdapter = new RecyclerViewAdapterForChat(mMessagesList);
        recyclerView = rootview.findViewById(R.id.recyclerView);
        linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(mAdapter);

        int resId = R.anim.layout_animation_fall_down;
        LayoutAnimationController animation = AnimationUtils.loadLayoutAnimation(getActivity(), resId);
        recyclerView.setLayoutAnimation(animation);
        recyclerView.setLayoutManager(linearLayoutManager);



        sendchatbtn = rootview.findViewById(R.id.imageButton2);
        sendchatbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // String chatMessage = mInputMessageView.getText().toString();
                // mchat.add(chatMessage);
                sendMessage();
                mInputMessageView.setText(" ");
                // hiding keyboard after message is send.
                InputMethodManager inputMethodManager = (InputMethodManager) getActivity().getSystemService(INPUT_METHOD_SERVICE);
                inputMethodManager.hideSoftInputFromWindow(getActivity().getCurrentFocus().getWindowToken(), 0);


            }
        });


        loadmessages();


        return rootview;
    }


    private void loadmessages() {

        mRootRef.child("messages").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                mMessagesList.add(dataSnapshot.getValue(ChatData.class));
                mAdapter.notifyDataSetChanged();
                recyclerView.scrollToPosition(mMessagesList.size() - 1);
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }



    private void sendMessage() {
        String message = mInputMessageView.getText().toString();
        if (!TextUtils.isEmpty(message)) {

            DatabaseReference user_message_push = mRootRef.child("messages").push();
            String push_id = user_message_push.getKey();

            //   DatabaseReference current_user_emailid = mRootRef.child("Users").child(mCurrentUserId);
            //  DatabaseReference u

            ChatData chatData = new ChatData("chatMessage", "userId", "userName", "timestamp");

            DatabaseReference newPost = user_message_push;

            Map<String, String> DataToSave = new HashMap<>();
            DataToSave.put("chatMessage", message);
            DataToSave.put("userId", mUser.getUid());
            DataToSave.put("userName",  userName.getText().toString());
            DataToSave.put("timestamp", String.valueOf(java.lang.System.currentTimeMillis()));

            user_message_push.setValue(DataToSave);
            Toast.makeText(getActivity(), "Message Sent", Toast.LENGTH_LONG).show();

        }
    }


}

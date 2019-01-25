package com.example.sheetalkumar.swasthya.Fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.sheetalkumar.swasthya.Model.JsonPlaceHolderAPI;
import com.example.sheetalkumar.swasthya.Model.Post;
import com.example.sheetalkumar.swasthya.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CheckMeFragment extends Fragment {


    /*
        @Dev - Sheetal Kumar
        Date - 23 Jan 2019
     */


    private TextView textResult;
    private ListView listView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //  getImages();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_check_me, container, false);

       // textResult = rootView.findViewById(R.id.text_view_json);

        listView = rootView.findViewById(R.id.listView);

        // adding the base url.
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        JsonPlaceHolderAPI jsonPlaceHolderAPI = retrofit.create(JsonPlaceHolderAPI.class);

        Call<List<Post>> call = jsonPlaceHolderAPI.getPosts();

        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {

                // Checking if response is null or not. server may cause 404 error.
                if (!response.isSuccessful()) {
                    textResult.setText("Code : " + response.code());
                    return;
                }

                List<Post> posts = response.body();

                // getting all the post with id, userid, title and text.
                /*for (Post post : posts) {

                    String content = "";

                    content += "ID:" + post.getId() + "\n";
                    content += "UserId:" + post.getUserId() + "\n";
                    content += "Title" + post.getTitle() + "\n";
                    content += "Text : " + post.getText() + "\n\n";

                    // using append  so that it does not override value.
                    textResult.append(content);
                }*/

                // getting only title and showing into listView
                String[] titile_text = new String[posts.size()];

                for (int i = 0; i < posts.size(); i++) {
                    titile_text[i] = posts.get(i).getTitle();
                }

                //displaying the string array into listview
                listView.setAdapter(new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, titile_text));

            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                textResult.setText(t.getMessage());

            }
        });


        return rootView;
    }
}

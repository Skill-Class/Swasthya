package com.example.sheetalkumar.swasthya.Adapter;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sheetalkumar.swasthya.R;

import java.util.ArrayList;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder> {

    /*
        @Dev - Sheetal Kumar
        Date - 23 Jan 2019
     */
    private static final String TAG = "RecyclerViewAdapter";
    //private static final Date LayoutInflater = ;

    //vars
    //  private ArrayList<String> mNames = new ArrayList<>();
    private ArrayList<Integer> ItemImages = new ArrayList<>();
    private ArrayList<String> ItemName = new ArrayList<>();
    //private ArrayList<String> mTime = new ArrayList<>();
    private Context mContext;

    public ItemAdapter(Context context, ArrayList<Integer> imageUrls,ArrayList<String> itemname) {
        // mNames = names;
        ItemImages = imageUrls;
        //  mTime = time;
        ItemName=itemname;
        mContext = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_layout_for_items, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        Log.d(TAG, "onBindViewHolder: called.");

        holder.image.setImageResource(ItemImages.get(position));
        holder.image.setAnimation(AnimationUtils.loadAnimation(mContext,R.anim.fade_transition_animation));

        holder.constraintLayout.setAnimation(AnimationUtils.loadAnimation(mContext,R.anim.fade_scale_animation));
        holder.itemName.setText(ItemName.get(position));

        // holder.name.setText(mNames.get(position));
        // holder.time.setText(mTime.get(position));

        //   Glide.with(mContext).asBitmap().load(mImageUrls.get(position)).into(holder.image);
        // holder.image.setImageResource(mImageUrls.get(position));


    }

    @Override
    public int getItemCount() {
        return ItemImages.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView image;
        TextView itemName;
        private ConstraintLayout constraintLayout;
        // TextView name;
        // TextView time;

        public ViewHolder(View itemView) {
            super(itemView);
            constraintLayout = itemView.findViewById(R.id.constraintLayout2);
            image = itemView.findViewById(R.id.custom_itemImages);
            itemName = itemView.findViewById(R.id.item_name);

            //    name = itemView.findViewById(R.id.textView2);
            //  time = itemView.findViewById(R.id.textView3);
        }
    }
}
package com.example.sheetalkumar.swasthya.Adapter;


import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sheetalkumar.swasthya.Model.ItemsWithImage;
import com.example.sheetalkumar.swasthya.R;

import java.util.ArrayList;
import java.util.List;



/*
      @author - Sheetal Kumar
 */


public class AdapterForFollowFragment extends RecyclerView.Adapter<AdapterForFollowFragment.MyViewHolder> {

    private Context mContext;
    private List<ItemsWithImage> mData;



    public AdapterForFollowFragment(Context mContext, List<ItemsWithImage> mData) {
        this.mContext = mContext;
        this.mData = mData;

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view;
        LayoutInflater mInflater = LayoutInflater.from(mContext);
        view = mInflater.inflate(R.layout.custom_layout_follow, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {

        holder.productImage.setImageResource(mData.get(position).getProductImage());
        holder.itemDetailsText.setText("Writes about : " + mData.get(position).getItemType());

        holder.followButton.setText(mData.get(position).getPrize()); //prize = follow or following status
        holder.productImage.setAnimation(AnimationUtils.loadAnimation(mContext, R.anim.fade_transition_animation));
        holder.constraintLayout.setAnimation(AnimationUtils.loadAnimation(mContext, R.anim.fade_scale_animation));

        holder.productName.setText(mData.get(position).getCompanyName());

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }



    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView itemDetailsText, productName;
        ImageView productImage;
        Button followButton;
        private ConstraintLayout constraintLayout;

        // CardView cardView ;

        public MyViewHolder(View itemView) {
            super(itemView);

            constraintLayout = itemView.findViewById(R.id.constraintLayout16);
            itemDetailsText = (TextView) itemView.findViewById(R.id.productDetails);
            productName = itemView.findViewById(R.id.productname);
            productImage = itemView.findViewById(R.id.productImage);
            followButton = itemView.findViewById(R.id.productDate);
        }
    }
}

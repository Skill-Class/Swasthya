package com.example.sheetalkumar.swasthya.Adapter;


import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
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


public class RecyclerViewAdapterForUpcomingProducts extends RecyclerView.Adapter<RecyclerViewAdapterForUpcomingProducts.MyViewHolder> implements Filterable {

    private Context mContext;
    private List<ItemsWithImage> mData;
    private List<ItemsWithImage> mDataFiltered;


    public RecyclerViewAdapterForUpcomingProducts(Context mContext, List<ItemsWithImage> mData) {
        this.mContext = mContext;
        this.mData = mData;
        this.mDataFiltered = mData;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view;
        LayoutInflater mInflater = LayoutInflater.from(mContext);
        view = mInflater.inflate(R.layout.upcoming_product_layout, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {

        holder.productImage.setImageResource(mData.get(position).getProductImage());

        holder.productImage.setAnimation(AnimationUtils.loadAnimation(mContext, R.anim.fade_transition_animation));
        holder.constraintLayout.setAnimation(AnimationUtils.loadAnimation(mContext, R.anim.fade_scale_animation));

      /*  holder.productImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, UpcomingProductsDetailsAcitivity.class);
                ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(
                        (Activity) mContext, holder.productImage, ViewCompat.getTransitionName(holder.productImage));
                mContext.startActivity(intent, options.toBundle());
            }
        }); */

        holder.productName.setText(mData.get(position).getCompanyName());  // productname = company name
        holder.produtTime.setText(mData.get(position).getPrize());  // prize = time
        holder.itemDetailsText.setText(mData.get(position).getItemType());  //itemtype = product details


    }

    @Override
    public int getItemCount() {
        return mDataFiltered.size();
    }

    @Override
    public Filter getFilter() {

        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {

                String Key = constraint.toString();
                if (Key.isEmpty()) {

                    mDataFiltered = mData;

                } else {
                    List<ItemsWithImage> lstFiltered = new ArrayList<>();
                    for (ItemsWithImage row : mData) {

                        if (row.getCompanyName().toLowerCase().contains(Key.toLowerCase())) {
                            lstFiltered.add(row);
                        }

                    }

                    mDataFiltered = lstFiltered;

                }


                FilterResults filterResults = new FilterResults();
                filterResults.values = mDataFiltered;
                return filterResults;

            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {


                mDataFiltered = (List<ItemsWithImage>) results.values;
                notifyDataSetChanged();

            }
        };

    }


    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView itemDetailsText, productName, produtTime;
        ImageView productImage;
        private ConstraintLayout constraintLayout;

        // CardView cardView ;

        public MyViewHolder(View itemView) {
            super(itemView);

            constraintLayout = itemView.findViewById(R.id.constraintLayout16);
            itemDetailsText = (TextView) itemView.findViewById(R.id.productDetails);
            productName = itemView.findViewById(R.id.productname);
            produtTime = itemView.findViewById(R.id.productDate);
            productImage = itemView.findViewById(R.id.productImage);
        }
    }
}

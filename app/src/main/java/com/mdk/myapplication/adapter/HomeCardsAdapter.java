package com.mdk.myapplication.adapter;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.mdk.myapplication.R;
import com.mdk.myapplication.model.HomeCardsItem;

import java.util.ArrayList;
import java.util.List;

public class HomeCardsAdapter extends RecyclerView.Adapter<HomeCardsAdapter.ViewHolder> {
    private Context context;
    private List<HomeCardsItem> homeCardsItemList;
    private LayoutInflater layoutInflater;
    private HomeCardsAdapter.ItemClickListener itemClickListener;

    public HomeCardsAdapter(Context context, ArrayList<HomeCardsItem> homeCardsItemArrayList){
        this.layoutInflater = LayoutInflater.from(context);
        this.context = context;
        this.homeCardsItemList = homeCardsItemArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.item_home_cardview, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        HomeCardsItem homeCardsItem = homeCardsItemList.get(position);
        String cardImageUrl = homeCardsItem.getParent_category_image();
        String cardTitleText = homeCardsItem.getParent_category_name();

        if (homeCardsItemList.size() != 0){
            holder.cardTitle.setText(cardTitleText);

            Glide.with(context).load(Uri.parse(cardImageUrl)).into(holder.cardImageView);

        } else {
            Toast.makeText(context,"gelmedi :(", Toast.LENGTH_LONG).show();
        }

    }

    @Override
    public int getItemCount() {
        return homeCardsItemList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView cardImageView;
        TextView cardTitle;

        ViewHolder(View itemView){
            super(itemView);
            cardImageView = itemView.findViewById(R.id.image_cv);
            cardTitle = itemView.findViewById(R.id.title_cv);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (itemClickListener != null){
                itemClickListener.onItemClick(view, getAdapterPosition(), getItem(getAdapterPosition()));
            }
        }
    }

    public HomeCardsItem getItem(int position){
        return homeCardsItemList.get(position);
    }

    public void setItemClickListener(HomeCardsAdapter.ItemClickListener itemClickListener){
        this.itemClickListener = itemClickListener;
    }

    public interface ItemClickListener{
        void onItemClick(View view, int position, HomeCardsItem selectedCard);
    }
}

package com.rameshwor.agronepal.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.rameshwor.agronepal.R;
import com.rameshwor.agronepal.object.CashCrop;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class CashCropAdapter extends RecyclerView.Adapter<CashCropAdapter.CashCropViewHolder> {
    Context context;
    ArrayList<CashCrop> cashCrops;

    public CashCropAdapter(Context context, ArrayList<CashCrop> cashCrops) {
        this.context = context;
        this.cashCrops = cashCrops;
    }

    @Override
    public CashCropAdapter.CashCropViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new CashCropViewHolder(LayoutInflater.from(context).inflate(R.layout.each_cashcrop, parent, false));

    }

    @Override
    public void onBindViewHolder(CashCropAdapter.CashCropViewHolder holder, int position) {

        CashCrop cashCrop = cashCrops.get(position);

        holder.nameView.setText(cashCrop.name);
        holder.climateView.setText(cashCrop.climate);
        holder.placeView.setText(cashCrop.place);

        Picasso.with(context)
                .load(cashCrop.image_link)
                .into(holder.pictureView);

    }

    @Override
    public int getItemCount() {
        return cashCrops.size();
    }

    public class CashCropViewHolder extends RecyclerView.ViewHolder {
        TextView nameView,climateView,placeView;
        ImageView pictureView;
        public CashCropViewHolder(View itemView)
        {
            super(itemView);
            nameView= (TextView) itemView.findViewById(R.id.name);
            climateView= (TextView) itemView.findViewById(R.id.climate);
            placeView= (TextView) itemView.findViewById(R.id.place);
            pictureView= (ImageView) itemView.findViewById(R.id.picture);
        }
    }
}

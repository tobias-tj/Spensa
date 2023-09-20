package com.tj.spensa.Adapter;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.tj.spensa.Domain.UserWallet;
import com.tj.spensa.R;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class UserWalletAdapter extends RecyclerView.Adapter<UserWalletAdapter.UserWalletHolder> {

    ArrayList<UserWallet> userWalletList;
    DecimalFormat formatter;

    public UserWalletAdapter(ArrayList<UserWallet> userWalletList){
        this.userWalletList = userWalletList;
        formatter = new DecimalFormat("#,###,###,###");
    }

    @NonNull
    @Override
    public UserWalletHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.items_wallets,parent,false);
        return new UserWalletHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull UserWalletHolder holder, int position) {
        holder.titleItemWallet.setText(userWalletList.get(position).getTitleItemWallet());
        holder.priceItemWallet.setText(formatter.format(userWalletList.get(position).getPriceItemWallet()));
        holder.dateItemWallet.setText(userWalletList.get(position).getDateItemWallet());
        holder.typeMoney.setText(userWalletList.get(position).getTypeMoney());

        int drawableResourceId = holder.itemView.getContext().getResources()
                .getIdentifier(userWalletList.get(position).getIconWallet(), "drawable", holder.itemView.getContext().getPackageName());
        holder.iconWallet.setImageResource(drawableResourceId);

        String typeAction = userWalletList.get(position).getTitleItemWallet();
       if("Compra".equals(typeAction) || "Compra Online".equals(typeAction)){
           holder.priceItemWallet.setTextColor(Color.RED);
           holder.typeMoney.setTextColor(Color.RED);
       }

    }


    @Override
    public int getItemCount() {
        return userWalletList.size();
    }

    public class UserWalletHolder extends RecyclerView.ViewHolder{
        TextView titleItemWallet,priceItemWallet,dateItemWallet, typeMoney;
        ImageView iconWallet;

        public UserWalletHolder(@NonNull View itemView) {
            super(itemView);
            titleItemWallet = itemView.findViewById(R.id.titleItemWallet);
            priceItemWallet = itemView.findViewById(R.id.priceItemWallet);
            dateItemWallet = itemView.findViewById(R.id.dateItemWallet);
            iconWallet = itemView.findViewById(R.id.iconWallet);
            typeMoney = itemView.findViewById(R.id.typeMoney);
        }
    }
}

package com.example.android_member.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android_member.R;
import com.example.android_member.model.SanPham;
import com.squareup.picasso.Picasso;

import java.util.List;

public class Adapter_Sanpham extends RecyclerView.Adapter<Adapter_Sanpham.ViewHolder> {
    private List<SanPham> sanPhamList;
    private Context context;

    public Adapter_Sanpham(List<SanPham> sanPhamList,Context context){
        this.sanPhamList = sanPhamList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.cardview_sanpham,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
         SanPham sanPham = sanPhamList.get(position);
        try {
            Picasso.with(context)
                    .load("http://192.168.1.5:3000/" + sanPham.getImageSP())
                    .into(holder.img_sanpham);
        } catch (Exception e){

        }
        holder.txt_tensp.setText(sanPham.getTenSP());
        holder.txt_masp.setText("Mã Sản Phẩm :" + " " + sanPham.getMaSP());
        holder.txt_giasp.setText("Giá Sản Phẩm :" + " " + sanPham.getGiaSP());

    }

    @Override
    public int getItemCount() {
        return sanPhamList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView img_sanpham;
        TextView txt_tensp,txt_giasp,txt_masp;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img_sanpham = itemView.findViewById(R.id.img_sanpham);
            txt_tensp = itemView.findViewById(R.id.txt_tensp);
            txt_giasp = itemView.findViewById(R.id.txt_giasp);
            txt_masp = itemView.findViewById(R.id.txt_masp);
        }
    }
}

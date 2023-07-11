package com.mayaanugrahsyafira202102344.login;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MahasiswaViewHolder extends RecyclerView.ViewHolder {
    public ImageView _jkImageView;
    public TextView _jkTextView;
    public TextView _jpTextView;
    public TextView _namaTextView;
    public TextView _nimTextView;

    public MahasiswaViewHolder(@NonNull View itemView)
    {
        super(itemView);
        _jkImageView = (ImageView) itemView.findViewById(R.id.jkImageView);
        _jkTextView = (TextView) itemView.findViewById(R.id.jkTextView);
        _jpTextView = (TextView) itemView.findViewById(R.id.jpTextView);
        _namaTextView = (TextView) itemView.findViewById(R.id.namaTextView);
        _nimTextView = (TextView) itemView.findViewById(R.id.nimTextView);
    }
}
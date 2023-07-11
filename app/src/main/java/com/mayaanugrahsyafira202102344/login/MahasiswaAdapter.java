package com.mayaanugrahsyafira202102344.login;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MahasiswaAdapter extends RecyclerView.Adapter<MahasiswaViewHolder> {
    private List<MahasiswaModel> _mahasiswaModelList;

    public MahasiswaAdapter(TampilMahasiswaActivity tampilMahasiswaActivity, List<MahasiswaModel> mahasiswaModels)
    {
        this._mahasiswaModelList = mahasiswaModels;
    }


    @NonNull
    @Override
    public
    MahasiswaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.list_mahasiswa, parent, false);
        return new MahasiswaViewHolder(v);
    }

    @Override
    public
    void onBindViewHolder(@NonNull MahasiswaViewHolder holder, int position)
    {
        MahasiswaModel mm = _mahasiswaModelList.get(position);

        holder._jkImageView.setImageResource(R.drawable.img);

        if (mm.getJenisKelamin().toLowerCase().equals("perempuan"))
        {
            holder._jkImageView.setImageResource(R.drawable.img_1);
        }

        holder._nimTextView.setText(mm.getNIM());
        holder._namaTextView.setText(mm.getNama());
        holder._jkTextView.setText(mm.getJenisKelamin());

        String jp = mm.getJP();
        jp = jp.substring(0, 2);
        holder._jpTextView.setText(jp);
    }

    @Override
    public int getItemCount()
    {
        int count = 0;

        if (_mahasiswaModelList != null)
        {
            count = _mahasiswaModelList.size();
        }
        return count;
    }
}
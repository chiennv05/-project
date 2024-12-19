package fpoly.chiennvph50713_duanmau.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;



import fpoly.chiennvph50713_duanmau.R;
import fpoly.chiennvph50713_duanmau.model.Sach;

public class Top10muonsachAdapter extends RecyclerView.Adapter<Top10muonsachAdapter.viewHoldel> {
    ArrayList<Sach> list_sachTop10;
    Context context;

    public Top10muonsachAdapter(ArrayList<Sach> list_sachTop10, Context context) {
        this.list_sachTop10 = list_sachTop10;
        this.context = context;
    }

    @NonNull
    @Override
    public viewHoldel onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = ((Activity) context).getLayoutInflater();
        View view = inflater.inflate(fpoly.chiennvph50713_duanmau.R.layout.item_top10muonsach, parent, false);

        return new viewHoldel(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHoldel holder, int position) {
        holder.txt_masachTop10.setText("Mã sách :" + String.valueOf(list_sachTop10.get(position).getMasach()));
        holder.txt_tensachTop10.setText("Tên sách:" + list_sachTop10.get(position).getTensach());
        holder.txt_soluongsachTop10.setText("Số lượng :" + String.valueOf(list_sachTop10.get(position).getSoluongdamuon()));

    }

    @Override
    public int getItemCount() {
        return list_sachTop10.size();
    }

    public class viewHoldel extends RecyclerView.ViewHolder {
        TextView txt_masachTop10, txt_tensachTop10, txt_soluongsachTop10;

        public viewHoldel(@NonNull View itemView) {
            super(itemView);

            txt_masachTop10 = itemView.findViewById(R.id.txt_masach_top10);
            txt_tensachTop10 = itemView.findViewById(R.id.txt_tensach_top10);
            txt_soluongsachTop10 = itemView.findViewById(R.id.txt_soluongsach_top10);
        }
    }
}

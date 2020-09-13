package com.shegi.gson.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.shegi.gson.ProvensiActivity;
import com.shegi.gson.R;
import com.shegi.gson.Value.ModelAttributes;
import com.shegi.gson.Value.Modelobject;

import java.util.List;

/**
 * created by shegi-developer on 07/07/20
 */
public class Provensi_adapter extends RecyclerView.Adapter<Provensi_adapter.ViewHolder> {
    Context context;
    List<Modelobject> objects;

    public Provensi_adapter(Context context, List<Modelobject> objects) {
        this.context = context;
        this.objects = objects;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_item_provensi,parent,false);


        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ModelAttributes attributes = objects.get(position).getAttributes();
        holder.txt_cardprovensi.setText(attributes.getProvinsi());
        holder.positif.setText(attributes.getKasus_posi());
        holder.sembuh.setText(attributes.getKasus_semb());
        holder.meninggal.setText(attributes.getKasus_meni());
    }

    @Override
    public int getItemCount() {
        return objects.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView txt_cardprovensi,positif,sembuh,meninggal;
        CardView card_provensi;

        public ViewHolder(final View view) {
            super(view);

            txt_cardprovensi = view.findViewById(R.id.txt_provensii);
            positif = view.findViewById(R.id.positif);
            sembuh = view.findViewById(R.id.sembuh);
            meninggal = view.findViewById(R.id.meninggal);

            card_provensi = view.findViewById(R.id.card_provensi);

            card_provensi.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, ProvensiActivity.class);
                    intent.putExtra("Kota",txt_cardprovensi.getText().toString().trim());
                    intent.putExtra("Positif",positif.getText().toString().trim());
                    intent.putExtra("Sembuh",sembuh.getText().toString().trim());
                    intent.putExtra("Meninggal",meninggal.getText().toString().trim());
                    context.startActivity(intent);
                }
            });

        }
    }
}

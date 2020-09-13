package com.shegi.gson.Fragment_;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.shegi.gson.API.Apiservice;
import com.shegi.gson.API.Retroserver;
import com.shegi.gson.Adapter.Provensi_adapter;
import com.shegi.gson.R;
import com.shegi.gson.Value.Modelobject;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * created by shegi-developer on 04/07/20
 */
public class Wilayah_frag extends Fragment {

    RecyclerView list;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view =  inflater.inflate(R.layout.frag_wilayah_indo,container,false);
        list = view.findViewById(R.id.rcl_cardviewprovensi);
        list.setLayoutManager(new LinearLayoutManager(getActivity()));
        Getdataprovensi();

        return view;
    }

    public void Getdataprovensi(){
        final ProgressDialog loading = ProgressDialog.show(getActivity(),"Menganalisa Data Covid",null,false,false);
        loading.setContentView(R.layout.progressloadingprovensi);
        loading.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        Apiservice api = Retroserver.GetClient().create(Apiservice.class);
        Call<List<Modelobject>> call = api.getDataProvensi();
        call.enqueue(new Callback<List<Modelobject>>() {
            @Override
            public void onResponse(Call<List<Modelobject>> call, Response<List<Modelobject>> response) {
                list.setAdapter(new Provensi_adapter(getActivity(),response.body()));
                loading.dismiss();
            }

            @Override
            public void onFailure(Call<List<Modelobject>> call, Throwable t) {
                loading.dismiss();

            }
        });

    }



}

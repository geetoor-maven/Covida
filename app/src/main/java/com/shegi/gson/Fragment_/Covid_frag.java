package com.shegi.gson.Fragment_;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.fragment.app.Fragment;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.shegi.gson.API.Apiservice;
import com.shegi.gson.API.Retroserver;
import com.shegi.gson.R;
import com.shegi.gson.Value.DataCovid;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * created by shegi-developer on 04/07/20
 */
public class Covid_frag extends Fragment {
    TextView txt_positif, txt_sembuh, txt_meninggal, txt_dirawat,txt_positifglobal,txt_sembuhglobal,txt_meninggalglobal;
    AdView adView;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_covid_19, container, false);

        txt_positif = view.findViewById(R.id.txt_totalpositifindonesia);
        txt_sembuh = view.findViewById(R.id.txt_totalsembuhindonesia);
        txt_meninggal = view.findViewById(R.id.txt_totalmeninggalindonesia);
        txt_dirawat = view.findViewById(R.id.txt_totaldirawatindonesia);

        txt_positifglobal = view.findViewById(R.id.txt_totalpositifglobal);
        txt_sembuhglobal = view.findViewById(R.id.txt_totalsembuhglobal);
        txt_meninggalglobal = view.findViewById(R.id.txt_totalmeninggalglobal);

        adView = view.findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);

        MobileAds.initialize(getContext(), new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {

            }
        });

        GetMeninggal();
        GetSembuh();
        GetPositif();
        GetDataIndonesia();

        return view;

    }


    public void GetDataIndonesia(){
        final ProgressDialog loading = ProgressDialog.show(getActivity(),"Menganalisa Data Covid",null,false,false);
        loading.setContentView(R.layout.progressloading);
        // Memberikan transparant
        loading.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        Apiservice api = Retroserver.GetClient().create(Apiservice.class);

        Call<List<DataCovid>> call = api.Getdata();
        call.enqueue(new Callback<List<DataCovid>>() {
            @Override
            public void onResponse(Call<List<DataCovid>> call, Response<List<DataCovid>> response) {
                List<DataCovid> data = response.body();

                for (DataCovid dataCovid : data){

                    txt_positif.setText(dataCovid.getPositif());
                    txt_sembuh.setText(dataCovid.getSembuh());
                    txt_meninggal.setText(dataCovid.getMeninggal());
                    txt_dirawat.setText(dataCovid.getDirawat());

                    loading.dismiss();


                }
            }

            @Override
            public void onFailure(Call<List<DataCovid>> call, Throwable t) {

            }
        });

    }

    public void GetPositif(){

        Apiservice api = Retroserver.GetClient().create(Apiservice.class);


        Call<DataCovid> call = api.GetPositifGlobal();
        call.enqueue(new Callback<DataCovid>() {
            @Override
            public void onResponse(Call<DataCovid> call, Response<DataCovid> response) {
                String name = response.body().getName();
                String total = response.body().getValue();
                Log.d("Global ",name);
                txt_positifglobal.setText(total);
            }

            @Override
            public void onFailure(Call<DataCovid> call, Throwable t) {

            }
        });
    }


    public void GetSembuh() {

        Apiservice api = Retroserver.GetClient().create(Apiservice.class);


        Call<DataCovid> call = api.GetSembuhGlobal();
        call.enqueue(new Callback<DataCovid>() {
            @Override
            public void onResponse(Call<DataCovid> call, Response<DataCovid> response) {
                String name = response.body().getName();
                String total = response.body().getValue();
                Log.d("Global ", name);
                txt_sembuhglobal.setText(total);
            }

            @Override
            public void onFailure(Call<DataCovid> call, Throwable t) {

            }
        });
    }

    public void GetMeninggal() {

        Apiservice api = Retroserver.GetClient().create(Apiservice.class);


        Call<DataCovid> call = api.GetMeninggalGlobal();
        call.enqueue(new Callback<DataCovid>() {
            @Override
            public void onResponse(Call<DataCovid> call, Response<DataCovid> response) {
                String name = response.body().getName();
                String total = response.body().getValue();
                Log.d("Global ", name);
                txt_meninggalglobal.setText(total);
            }

            @Override
            public void onFailure(Call<DataCovid> call, Throwable t) {

            }
        });
    }

}
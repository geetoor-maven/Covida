package com.shegi.gson.API;

import com.shegi.gson.Value.DataCovid;
import com.shegi.gson.Value.Modelobject;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * created by shegi-developer on 05/07/20
 */
public interface Apiservice {

    @GET("indonesia")
    Call<List<DataCovid>> Getdata();

    @GET("positif")
    Call<DataCovid> GetPositifGlobal();

    @GET("sembuh")
    Call<DataCovid> GetSembuhGlobal();

    @GET("meninggal")
    Call<DataCovid> GetMeninggalGlobal();

    @GET("indonesia/provinsi")
    Call<List<Modelobject>> getDataProvensi();

}

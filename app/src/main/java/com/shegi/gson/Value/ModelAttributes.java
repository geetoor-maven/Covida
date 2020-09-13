package com.shegi.gson.Value;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * created by shegi-developer on 06/07/20
 */
public class ModelAttributes {
    @SerializedName("Provinsi")
    private String provinsi;
    @SerializedName("Kasus_Posi")
    private String kasus_posi;
    @SerializedName("Kasus_Semb")
    private String kasus_semb;
    @SerializedName("Kasus_Meni")
    private String kasus_meni;

    public String getProvinsi() {
        return provinsi;
    }

    public void setProvinsi(String provinsi) {
        this.provinsi = provinsi;
    }

    public String getKasus_posi() {
        return kasus_posi;
    }

    public void setKasus_posi(String kasus_posi) {
        this.kasus_posi = kasus_posi;
    }

    public String getKasus_semb() {
        return kasus_semb;
    }

    public void setKasus_semb(String kasus_semb) {
        this.kasus_semb = kasus_semb;
    }

    public String getKasus_meni() {
        return kasus_meni;
    }

    public void setKasus_meni(String kasus_meni) {
        this.kasus_meni = kasus_meni;
    }
}

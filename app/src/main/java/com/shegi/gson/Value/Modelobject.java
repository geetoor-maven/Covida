package com.shegi.gson.Value;

import com.google.gson.annotations.SerializedName;

/**
 * created by shegi-developer on 07/07/20
 */
public class Modelobject {
    @SerializedName("attributes")
    ModelAttributes Attributes;

    public ModelAttributes getAttributes() {
        return Attributes;
    }
}

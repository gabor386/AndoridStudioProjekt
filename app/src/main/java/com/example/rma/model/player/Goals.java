package com.example.rma.model.player;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Goals {

    @SerializedName("total")
    @Expose
    private Long total;
    @SerializedName("conceded")
    @Expose
    private Long conceded;
    @SerializedName("assists")
    @Expose
    private Long assists;
    @SerializedName("saves")
    @Expose
    private Long saves;

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public Long getConceded() {
        return conceded;
    }

    public void setConceded(Long conceded) {
        this.conceded = conceded;
    }

    public Long getAssists() {
        return assists;
    }

    public void setAssists(Long assists) {
        this.assists = assists;
    }

    public Long getSaves() {
        return saves;
    }

    public void setSaves(Long saves) {
        this.saves = saves;
    }

}
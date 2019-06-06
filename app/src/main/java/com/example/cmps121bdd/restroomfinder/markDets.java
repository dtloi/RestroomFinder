package com.example.cmps121bdd.restroomfinder;

import com.google.android.gms.internal.maps.zzt;
import com.google.android.gms.maps.model.Marker;

public class markDets {
    private Boolean unisexB, papertowelsB, airdryerB, handicapB, vendingMachineB, changingTableB;
    private Marker marker;

    public markDets(Marker m, Boolean a,Boolean b,Boolean c,Boolean d,Boolean e,Boolean f){
        marker = m;
        unisexB = a;
        papertowelsB = b;
        airdryerB = c;
        handicapB = d;
        vendingMachineB = e;
        changingTableB = f;
    }


    public Boolean getPapertowelsB() {
        return papertowelsB;
    }

    public void setPapertowelsB(Boolean papertowelsB) {
        this.papertowelsB = papertowelsB;
    }

    public Boolean getUnisexB() {
        return unisexB;
    }

    public void setUnisexB(Boolean unisexB) {
        this.unisexB = unisexB;
    }

    public Boolean getAirdryerB() {
        return airdryerB;
    }

    public void setAirdryerB(Boolean airdryerB) {
        this.airdryerB = airdryerB;
    }

    public Boolean getHandicapB() {
        return handicapB;
    }

    public void setHandicapB(Boolean handicapB) {
        this.handicapB = handicapB;
    }

    public Boolean getVendingMachineB() {
        return vendingMachineB;
    }

    public void setVendingMachineB(Boolean vendingMachineB) {
        this.vendingMachineB = vendingMachineB;
    }

    public Boolean getChangingTableB() {
        return changingTableB;
    }

    public void setChangingTableB(Boolean changingTableB) {
        this.changingTableB = changingTableB;
    }

    public Marker getMarker() {
        return marker;
    }

    public void setMarker(Marker marker) {
        this.marker = marker;
    }
}

package kr.ac.sookmyung.snowi;


import android.widget.Switch;

public class BeaconItemVO {
    private String b_name_str;
    private String b_distance_str;
    private String b_uuid_str;
    private Boolean b_onoff_bln;
    private Switch b_onoff_swi;

    public BeaconItemVO(String b_name_str, String b_distance_str, String b_uuid_str, boolean b_onoff_bln) {
        this.b_name_str = b_name_str;
        this.b_distance_str = b_distance_str;
        this.b_uuid_str = b_uuid_str;
        this.b_onoff_bln = b_onoff_bln;
    }

    public BeaconItemVO setBB_distance(String distance){
        this.b_distance_str = distance;
        return this;
    }

    public String getB_name_str() {
        return b_name_str;
    }

    public void setB_name_str(String b_name_str) {
        this.b_name_str = b_name_str;
    }

    public String getB_distance_str() {
        return b_distance_str;
    }

    public void setB_distance_str(String b_distance_str) {
        this.b_distance_str = b_distance_str;
    }

    public String getB_uuid_str() {
        return b_uuid_str;
    }

    public void setB_uuid_str(String b_uuid_str) {
        this.b_uuid_str = b_uuid_str;
    }

    public Boolean getB_onoff_bln() {
        return b_onoff_bln;
    }

    public void setB_onoff_bln(Boolean b_onoff_bln) {
        this.b_onoff_bln = b_onoff_bln;
    }

    public Switch getB_onoff_swi() {
        return b_onoff_swi;
    }

    public void setB_onoff_swi(Switch b_onoff_swi) {
        this.b_onoff_swi = b_onoff_swi;
    }

}
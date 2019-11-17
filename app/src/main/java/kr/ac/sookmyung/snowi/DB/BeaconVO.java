package kr.ac.sookmyung.snowi.DB;

public class BeaconVO {
    private int beacon_no;
    private String beacon_name;
    private String beacon_place;
    private int beacon_prefix;
    private String beacon_uuid;
    private int beacon_major;
    private int beacon_minor;

    public BeaconVO() {
    }

    public int getBeacon_no() {
        return beacon_no;
    }

    public void setBeacon_no(int beacon_no) {
        this.beacon_no = beacon_no;
    }

    public String getBeacon_name() {
        return beacon_name;
    }

    public void setBeacon_name(String beacon_name) {
        this.beacon_name = beacon_name;
    }

    public String getBeacon_place() {
        return beacon_place;
    }

    public void setBeacon_place(String beacon_place) {
        this.beacon_place = beacon_place;
    }

    public int getBeacon_prefix() {
        return beacon_prefix;
    }

    public void setBeacon_prefix(int beacon_prefix) {
        this.beacon_prefix = beacon_prefix;
    }

    public String getBeacon_uuid() {
        return beacon_uuid;
    }

    public void setBeacon_uuid(String beacon_uuid) {
        this.beacon_uuid = beacon_uuid;
    }

    public int getBeacon_major() {
        return beacon_major;
    }

    public void setBeacon_major(int beacon_major) {
        this.beacon_major = beacon_major;
    }

    public int getBeacon_minor() {
        return beacon_minor;
    }

    public void setBeacon_minor(int beacon_minor) {
        this.beacon_minor = beacon_minor;
    }

    @Override
    public String toString() {
        return "BeaconVO{" +
                "beacon_no=" + beacon_no +
                ", beacon_name='" + beacon_name + '\'' +
                ", beacon_place='" + beacon_place + '\'' +
                ", beacon_prefix=" + beacon_prefix +
                ", beacon_uuid='" + beacon_uuid + '\'' +
                ", beacon_major=" + beacon_major +
                ", beacon_minor=" + beacon_minor +
                '}';
    }
}

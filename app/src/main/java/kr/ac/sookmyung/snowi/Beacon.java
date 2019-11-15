package kr.ac.sookmyung.snowi;

public class Beacon {
    private String address;
    private int rssi;
    private String now;

    public Beacon(String address, int rssi, String Txpower) {
        this.address = address;
        this.rssi = rssi;
        this.now = now;
    }

    public String getAddress() {
        return address;
    }

    public int getRssi() {
        return rssi;
    }

    public String getNow() {
        return now;
    }
}

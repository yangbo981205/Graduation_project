package com.graduationproject.entity;

public class Node {
    private String macaddr;
    private String name;
    private String paraddr;
    private String nwkaddr;

    public String getMacaddr() {
        return macaddr;
    }

    public void setMacaddr(String macaddr) {
        this.macaddr = macaddr;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParaddr() {
        return paraddr;
    }

    public void setParaddr(String paraddr) {
        this.paraddr = paraddr;
    }

    public String getNwkaddr() {
        return nwkaddr;
    }

    public void setNwkaddr(String nwkaddr) {
        this.nwkaddr = nwkaddr;
    }
}

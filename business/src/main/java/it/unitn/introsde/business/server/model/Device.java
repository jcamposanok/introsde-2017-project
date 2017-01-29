package it.unitn.introsde.business.server.model;

import java.util.Date;

/**
 * Created by JC on 29/01/2017.
 */
public class Device {

    private String name;
    private Date lastSync;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getLastSync() {
        return lastSync;
    }

    public void setLastSync(Date lastSync) {
        this.lastSync = lastSync;
    }

}

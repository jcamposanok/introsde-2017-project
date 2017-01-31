package integration.server.model;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;


@Entity
@Table(name = "Device")
@XmlRootElement
public class Device implements Serializable {

    @Id
    @GeneratedValue(generator = "Device", strategy = GenerationType.TABLE)
    @TableGenerator(name = "Device",
            table = "Sequence",
            pkColumnName = "name",
            pkColumnValue = "Device",
            valueColumnName = "seq",
            initialValue = 1,
            allocationSize = 10)
    private int deviceId;

    @ManyToOne
    @JoinColumn(name = "owner", referencedColumnName = "userId")
    private User owner;

    @Column(name = "deviceType")
    private String deviceType;

    private int batteryLevel;

    private String serialNumber;

    private String firmwareVersion;

    private String lastSyncDate;


    public int getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(int deviceId) {
        this.deviceId = deviceId;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    public int getBatteryLevel() {
        return batteryLevel;
    }

    public void setBatteryLevel(int batteryLevel) {
        this.batteryLevel = batteryLevel;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getFirmwareVersion() {
        return firmwareVersion;
    }

    public void setFirmwareVersion(String firmwareVersion) {
        this.firmwareVersion = firmwareVersion;
    }

    public String getLastSyncDate() {
        return lastSyncDate;
    }

    public void setLastSyncDate(String lastSyncDate) {
        this.lastSyncDate = lastSyncDate;
    }
}

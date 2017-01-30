package integration.server.model;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;


@Entity
@Table(name = "Device")
@XmlRootElement
public class DeviceModel implements Serializable {

    @Id
    @GeneratedValue(generator = "DeviceModel", strategy = GenerationType.TABLE)
    @TableGenerator(name = "DeviceModel",
            table = "Sequence",
            pkColumnName = "name",
            pkColumnValue = "DeviceModel",
            valueColumnName = "seq",
            initialValue = 1,
            allocationSize = 10)
    private int deviceId;

    @ManyToOne
    @JoinColumn(name = "owner", referencedColumnName = "userId")
    private UserModel owner;

    @Column(name = "deviceType")
    private String deviceType;


    public int getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(int deviceId) {
        this.deviceId = deviceId;
    }

    public UserModel getOwner() {
        return owner;
    }

    public void setOwner(UserModel owner) {
        this.owner = owner;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

}

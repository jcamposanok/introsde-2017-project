package it.unitn.introsde.business.client.model;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="User")
@XmlRootElement
public class UserModel implements Serializable {

    @Id
    @GeneratedValue(generator = "UserModel", strategy = GenerationType.TABLE)
    @TableGenerator(name = "UserModel",
            table = "Sequence",
            pkColumnName = "name",
            pkColumnValue = "UserModel",
            valueColumnName = "seq",
            initialValue = 1,
            allocationSize = 10)
    private int userId;

    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<DeviceModel> deviceList;

    @Column(name = "realName")
    private String realName;

    @Column(name = "height")
    private Double height;

    @Column(name = "weight")
    private Double weight;

    @Column(name = "birthdate")
    private Date birthdate;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public List<DeviceModel> getDeviceList() {
        return deviceList;
    }

    public void setDeviceList(List<DeviceModel> deviceList) {
        this.deviceList = deviceList;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }
}

package snippets.jee.entity;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import java.util.List;


/**
 * The persistent class for the tb_user database table.
 * 
 */
@Entity
@Table(name="tb_user")
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="userid")
    private int id;

    @Column(name = "isadmin")
    private Boolean admin;

    @Size(min = 6, max = 20)
    private String password;

    private String realname;

    private String tel;

    @Pattern(regexp = "\\w{6,20}")
    private String username;

    //bi-directional many-to-one association to House
    @OneToMany(mappedBy="user")
    private List<House> houses;

    //bi-directional many-to-one association to LoginLog
    @OneToMany(mappedBy="user")
    private List<LoginLog> loginLogs;

    @Transient
    private String ipAddress;

    public User() {
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean getAdmin() {
        return this.admin;
    }

    public void setAdmin(Boolean admin) {
        this.admin = admin;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRealname() {
        return this.realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getTel() {
        return this.tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<House> getHouses() {
        return this.houses;
    }

    public void setHouses(List<House> houses) {
        this.houses = houses;
    }

    public House addHous(House house) {
        getHouses().add(house);
        house.setUser(this);

        return house;
    }

    public House removeHous(House hous) {
        getHouses().remove(hous);
        hous.setUser(null);

        return hous;
    }

    public List<LoginLog> getLoginLogs() {
        return this.loginLogs;
    }

    public void setLoginLogs(List<LoginLog> loginLogs) {
        this.loginLogs = loginLogs;
    }

    public LoginLog addLoginLog(LoginLog loginLog) {
        getLoginLogs().add(loginLog);
        loginLog.setUser(this);

        return loginLog;
    }

    public LoginLog removeLoginLog(LoginLog loginLog) {
        getLoginLogs().remove(loginLog);
        loginLog.setUser(null);

        return loginLog;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

}

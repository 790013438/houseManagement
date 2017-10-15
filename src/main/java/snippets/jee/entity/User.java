package snippets.jee.entity;

import java.io.Serializable;
import javax.persistence.*;
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

    private byte isadmin;

    private String password;

    private String realname;

    private String tel;

    private String username;

    //bi-directional many-to-one association to House
    @OneToMany(mappedBy="tbUser")
    private List<House> tbHouses;

    //bi-directional many-to-one association to LoginLog
    @OneToMany(mappedBy="tbUser")
    private List<LoginLog> tbLoginLogs;

    public User() {
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public byte getIsadmin() {
        return this.isadmin;
    }

    public void setIsadmin(byte isadmin) {
        this.isadmin = isadmin;
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

    public List<House> getTbHouses() {
        return this.tbHouses;
    }

    public void setTbHouses(List<House> tbHouses) {
        this.tbHouses = tbHouses;
    }

    public House addTbHous(House tbHous) {
        getTbHouses().add(tbHous);
        tbHous.setTbUser(this);

        return tbHous;
    }

    public House removeTbHous(House tbHous) {
        getTbHouses().remove(tbHous);
        tbHous.setTbUser(null);

        return tbHous;
    }

    public List<LoginLog> getTbLoginLogs() {
        return this.tbLoginLogs;
    }

    public void setTbLoginLogs(List<LoginLog> tbLoginLogs) {
        this.tbLoginLogs = tbLoginLogs;
    }

    public LoginLog addTbLoginLog(LoginLog tbLoginLog) {
        getTbLoginLogs().add(tbLoginLog);
        tbLoginLog.setTbUser(this);

        return tbLoginLog;
    }

    public LoginLog removeTbLoginLog(LoginLog tbLoginLog) {
        getTbLoginLogs().remove(tbLoginLog);
        tbLoginLog.setTbUser(null);

        return tbLoginLog;
    }

}

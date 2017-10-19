package snippets.jee.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the tb_login_log database table.
 * 
 */
@Entity
@Table(name="tb_login_log")
@NamedQuery(name="LoginLog.findAll", query="SELECT l FROM LoginLog l")
public class LoginLog implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="loginid")
    private int id;

    @Column(name = "ipaddr")
    private String ipaddr;

    @Temporal(TemporalType.TIMESTAMP)
    private Date logdate;

    //bi-directional many-to-one association to User
    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    public LoginLog() {
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIpaddr() {
        return this.ipaddr;
    }

    public void setIpaddr(String ipaddr) {
        this.ipaddr = ipaddr;
    }

    public Date getLogdate() {
        return this.logdate;
    }

    public void setLogdate(Date logdate) {
        this.logdate = logdate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}

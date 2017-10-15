package snippets.jee.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the tb_house_photo database table.
 * 
 */
@Entity
@Table(name="tb_house_photo")
@NamedQuery(name="HousePhoto.findAll", query="SELECT h FROM HousePhoto h")
public class HousePhoto implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="photoid")
    private int id;

    @Column(name="photoname")
    private String name;

    //bi-directional many-to-one association to House
    @ManyToOne
    @JoinColumn(name="house_id")
    private House tbHouse;

    public HousePhoto() {
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public House getTbHouse() {
        return this.tbHouse;
    }

    public void setTbHouse(House tbHouse) {
        this.tbHouse = tbHouse;
    }

}

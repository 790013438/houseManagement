package snippets.jee.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tb_district database table.
 * 
 */
@Entity
@Table(name="tb_district")
@NamedQuery(name="District.findAll", query="SELECT d FROM District d")
public class District implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="distid")
    private int id;

    @Column(name="distname")
    private String name;

    //bi-directional many-to-one association to City
    @ManyToOne
    @JoinColumn(name="city_id")
    private City tbCity;

    //bi-directional many-to-one association to House
    @OneToMany(mappedBy="tbDistrict")
    private List<House> tbHouses;

    public District() {
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

    public City getTbCity() {
        return this.tbCity;
    }

    public void setTbCity(City tbCity) {
        this.tbCity = tbCity;
    }

    public List<House> getTbHouses() {
        return this.tbHouses;
    }

    public void setTbHouses(List<House> tbHouses) {
        this.tbHouses = tbHouses;
    }

    public House addTbHous(House tbHous) {
        getTbHouses().add(tbHous);
        tbHous.setTbDistrict(this);

        return tbHous;
    }

    public House removeTbHous(House tbHous) {
        getTbHouses().remove(tbHous);
        tbHous.setTbDistrict(null);

        return tbHous;
    }

}

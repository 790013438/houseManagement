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
    private City city;

    //bi-directional many-to-one association to House
    @OneToMany(mappedBy="district")
    private List<House> houses;

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

    public City getCity() {
        return this.city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public List<House> getHouses() {
        return this.houses;
    }

    public void setHouses(List<House> houses) {
        this.houses = houses;
    }

    public House addHous(House house) {
        getHouses().add(house);
        house.setDistrict(this);

        return house;
    }

    public House removeHous(House hous) {
        getHouses().remove(hous);
        hous.setDistrict(null);

        return hous;
    }

}

package snippets.jee.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tb_province database table.
 * 
 */
@Entity
@Table(name="tb_province")
@NamedQuery(name="Province.findAll", query="SELECT p FROM Province p")
public class Province implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="provid")
    private int id;

    @Column(name="provname")
    private String name;

    //bi-directional many-to-one association to City
    @OneToMany(mappedBy="tbProvince")
    private List<City> tbCities;

    public Province() {
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

    public List<City> getTbCities() {
        return this.tbCities;
    }

    public void setTbCities(List<City> tbCities) {
        this.tbCities = tbCities;
    }

    public City addTbCity(City tbCity) {
        getTbCities().add(tbCity);
        tbCity.setTbProvince(this);

        return tbCity;
    }

    public City removeTbCity(City tbCity) {
        getTbCities().remove(tbCity);
        tbCity.setTbProvince(null);

        return tbCity;
    }

}

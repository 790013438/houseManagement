package snippets.jee.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * The persistent class for the tb_city database table.
 * 
 */
@Entity
@Table(name="tb_city")
@NamedQuery(name="City.findAll", query="SELECT c FROM City c")
public class City implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="cityid")
    private int id;

    @Column(name="cityname")
    private String name;

    //bi-directional many-to-one association to Province
    @ManyToOne
    @JoinColumn(name="prov_id")
    private Province tbProvince;

    //bi-directional many-to-one association to District
    @OneToMany(mappedBy="tbCity")
    private List<District> tbDistricts;

    public City() {
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

    public Province getTbProvince() {
        return this.tbProvince;
    }

    public void setTbProvince(Province tbProvince) {
        this.tbProvince = tbProvince;
    }

    public List<District> getTbDistricts() {
        return this.tbDistricts;
    }

    public void setTbDistricts(List<District> tbDistricts) {
        this.tbDistricts = tbDistricts;
    }

    public District addTbDistrict(District tbDistrict) {
        getTbDistricts().add(tbDistrict);
        tbDistrict.setTbCity(this);

        return tbDistrict;
    }

    public District removeTbDistrict(District tbDistrict) {
        getTbDistricts().remove(tbDistrict);
        tbDistrict.setTbCity(null);

        return tbDistrict;
    }

}

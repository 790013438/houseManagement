package snippets.jee.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tb_house_type database table.
 * 
 */
@Entity
@Table(name="tb_house_type")
@NamedQuery(name="HouseType.findAll", query="SELECT h FROM HouseType h")
public class HouseType implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="typeid")
    private int id;

    @Column(name="typename")
    private String name;

    //bi-directional many-to-one association to House
    @OneToMany(mappedBy="tbHouseType")
    private List<House> tbHouses;

    public HouseType() {
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

    public List<House> getTbHouses() {
        return this.tbHouses;
    }

    public void setTbHouses(List<House> tbHouses) {
        this.tbHouses = tbHouses;
    }

    public House addTbHous(House tbHous) {
        getTbHouses().add(tbHous);
        tbHous.setTbHouseType(this);

        return tbHous;
    }

    public House removeTbHous(House tbHous) {
        getTbHouses().remove(tbHous);
        tbHous.setTbHouseType(null);

        return tbHous;
    }

}

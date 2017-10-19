package snippets.jee.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the tb_house database table.
 * 
 */
@Entity
@Table(name="tb_house")
@NamedQuery(name="House.findAll", query="SELECT h FROM House h")
public class House implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="houseid")
    private int id;

    private int area;

    private String contacterEmail;

    private String contacterName;

    private String contacterQQ;

    private String contacterTel;

    private String detail;

    private int floor;

    private String mainPhoto;

    private float price;

    @Temporal(TemporalType.TIMESTAMP)
    private Date pubDate;

    private String street;

    private String title;

    private int totalFloor;

    //bi-directional many-to-one association to District
    @ManyToOne
    @JoinColumn(name="district_id")
    private District district;

    //bi-directional many-to-one association to HouseType
    @ManyToOne
    @JoinColumn(name="house_type_id")
    private HouseType houseType;

    //bi-directional many-to-one association to User
    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    //bi-directional many-to-one association to HousePhoto
    @OneToMany(mappedBy="house")
    private List<HousePhoto> housePhotos;

    public House() {
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getArea() {
        return this.area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public String getContacterEmail() {
        return this.contacterEmail;
    }

    public void setContacterEmail(String contacterEmail) {
        this.contacterEmail = contacterEmail;
    }

    public String getContacterName() {
        return this.contacterName;
    }

    public void setContacterName(String contacterName) {
        this.contacterName = contacterName;
    }

    public String getContacterQQ() {
        return this.contacterQQ;
    }

    public void setContacterQQ(String contacterQQ) {
        this.contacterQQ = contacterQQ;
    }

    public String getContacterTel() {
        return this.contacterTel;
    }

    public void setContacterTel(String contacterTel) {
        this.contacterTel = contacterTel;
    }

    public String getDetail() {
        return this.detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public int getFloor() {
        return this.floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public String getMainPhoto() {
        return this.mainPhoto;
    }

    public void setMainPhoto(String mainPhoto) {
        this.mainPhoto = mainPhoto;
    }

    public float getPrice() {
        return this.price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Date getPubDate() {
        return this.pubDate;
    }

    public void setPubDate(Date pubDate) {
        this.pubDate = pubDate;
    }

    public String getStreet() {
        return this.street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getTotalFloor() {
        return this.totalFloor;
    }

    public void setTotalFloor(int totalFloor) {
        this.totalFloor = totalFloor;
    }

    public District getDistrict() {
        return this.district;
    }

    public void setDistrict(District district) {
        this.district = district;
    }

    public HouseType getHouseType() {
        return this.houseType;
    }

    public void setHouseType(HouseType houseType) {
        this.houseType = houseType;
    }

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<HousePhoto> getHousePhotos() {
        return this.housePhotos;
    }

    public void setHousePhotos(List<HousePhoto> housePhotos) {
        this.housePhotos = housePhotos;
    }

    public HousePhoto addHousePhoto(HousePhoto housePhoto) {
        getHousePhotos().add(housePhoto);
        housePhoto.setHouse(this);

        return housePhoto;
    }

    public HousePhoto removeHousePhoto(HousePhoto housePhoto) {
        getHousePhotos().remove(housePhoto);
        housePhoto.setHouse(null);

        return housePhoto;
    }

}

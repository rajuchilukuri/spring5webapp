package guru.springframework.spring5webapp.domain;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
@Entity
public class Address {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String address1;
    private String city;
    private String state;
    private String zip;
    @ManyToMany()
    @JoinTable(name="name_Address",joinColumns = @JoinColumn(name="address_id"),inverseJoinColumns = @JoinColumn(name="name.id"))
    private Set<Name> name=new HashSet<>();

    public Address() {

    }

    public Address(String address1, String city, String state, String zip) {
        this.address1 = address1;
        this.city = city;
        this.state = state;
        this.zip = zip;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public Set<Name> getName() {
        return name;
    }

    public void setName(Set<Name> name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", address1='" + address1 + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zip='" + zip + '\'' +
                ", name=" + name +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return id == address.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

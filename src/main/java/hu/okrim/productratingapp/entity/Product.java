package hu.okrim.productratingapp.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "brand")
    private Brand brand;
    private String name;
    @ManyToOne
    @JoinColumn(name = "category")
    private Category category;
    private boolean isDrink;
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProductFlavour> flavours = new ArrayList<>();

    public Product() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public boolean isDrink() {
        return isDrink;
    }

    public void setIsDrink(boolean drink) {
        isDrink = drink;
    }

    public void removeFlavours() {
        this.flavours.forEach(flavour -> flavour.setProduct(null));
        this.flavours.clear();
    }
}

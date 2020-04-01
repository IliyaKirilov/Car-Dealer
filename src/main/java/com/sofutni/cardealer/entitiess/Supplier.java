package com.sofutni.cardealer.entitiess;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "suppliers")
public class Supplier extends BaseEntity{
    private String name;
    private boolean isImporter;
    private List<Part> parts;


    @OneToMany(mappedBy = "supplier", fetch = FetchType.EAGER,cascade = CascadeType.PERSIST)
    public List<Part> getParts() {
        return parts;
    }

    public void setParts(List<Part> parts) {
        this.parts = parts;
    }

    @Column
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "is_importer")
    public boolean isImporter() {
        return isImporter;
    }

    public void setImporter(boolean importer) {
        isImporter = importer;
    }

    public Supplier() {
    }
}

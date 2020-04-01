package com.sofutni.cardealer.Dtos;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;
@XmlRootElement(name = "suppliers")
@XmlAccessorType(XmlAccessType.FIELD)
public class SupplierSeedRootDto {


    @XmlElement(name = "supplier")
    private List<SupplierSeedDto> supplierSeedDtoList;

    public List<SupplierSeedDto> getSupplierSeedDtoList() {
        return supplierSeedDtoList;
    }

    public void setSupplierSeedDtoList(List<SupplierSeedDto> supplierSeedDtoList) {
        this.supplierSeedDtoList = supplierSeedDtoList;
    }

    public SupplierSeedRootDto() {
    }
}

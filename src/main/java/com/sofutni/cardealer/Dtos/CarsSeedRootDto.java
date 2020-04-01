package com.sofutni.cardealer.Dtos;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;


@XmlRootElement(name = "cars")
@XmlAccessorType(XmlAccessType.FIELD)
public class CarsSeedRootDto {

    @XmlElement(name = "car")
    private List<CarsSeedDto> carsSeedDtoList;

    public CarsSeedRootDto() {
    }

    public List<CarsSeedDto> getCarsSeedDtoList() {
        return carsSeedDtoList;
    }

    public void setCarsSeedDtoList(List<CarsSeedDto> carsSeedDtoList) {
        this.carsSeedDtoList = carsSeedDtoList;
    }
}

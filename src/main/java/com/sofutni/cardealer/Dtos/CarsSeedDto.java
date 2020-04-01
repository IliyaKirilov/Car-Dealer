package com.sofutni.cardealer.Dtos;



import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "car")
@XmlAccessorType(XmlAccessType.FIELD)
public class CarsSeedDto {

    @XmlElement
    private String make;
    @XmlElement
    private String model;
    @XmlElement(name = "travelled-distance")
    private Long travelledDistance;

    public CarsSeedDto() {
    }
    @NotNull(message = "Make cannot be nothing!")
    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }
    @NotNull(message = "Every car should have a model!")
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Max(value = 2000000, message = "This is a totaly junk car! Over that 2milions kilometers!")
    @NotNull(message = "Distance cannot be null!")
    public Long getDistance() {
        return travelledDistance;
    }



    public void setDistance(Long distance) {
        this.travelledDistance  = distance;
    }
}

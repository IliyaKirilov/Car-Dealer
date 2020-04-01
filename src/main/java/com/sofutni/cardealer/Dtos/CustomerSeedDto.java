package com.sofutni.cardealer.Dtos;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.*;
import javax.xml.datatype.XMLGregorianCalendar;
import java.time.LocalDate;
import java.time.LocalDateTime;

@XmlRootElement(name = "customer")
@XmlAccessorType(XmlAccessType.FIELD)
public class CustomerSeedDto {


    @XmlAttribute
    private String name;
    @XmlElement(name = "birth-date",required = true)
    private XMLGregorianCalendar dateOfBirth;
    @XmlElement(name = "is-young-driver")
    private boolean isYoungDriver;

    @NotNull(message = "Customer cannot be null!?")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @NotNull(message = "Customer`s birth date cannot be null! He is alive!")
    public XMLGregorianCalendar getBirthDate() {
        return dateOfBirth;
    }

    public void setBirthDate(XMLGregorianCalendar birthDate) {
        this.dateOfBirth = birthDate;
    }

    public boolean isYoungDriver() {
        return isYoungDriver;
    }

    public void setYoungDriver(boolean youngDriver) {
        isYoungDriver = youngDriver;
    }

    public CustomerSeedDto() {
    }
}

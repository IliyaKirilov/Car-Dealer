package com.sofutni.cardealer.Dtos;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "parts")
@XmlAccessorType(XmlAccessType.FIELD)
public class PartSeedRootDto {


    @XmlElement(name = "part")
    List<PartSeedDto> partsSeedDtos;

    public List<PartSeedDto> getPartsSeedDtos() {
        return partsSeedDtos;
    }

    public void setPartsSeedDtos(List<PartSeedDto> partsSeedDtos) {
        this.partsSeedDtos = partsSeedDtos;
    }

    public PartSeedRootDto() {
    }
}

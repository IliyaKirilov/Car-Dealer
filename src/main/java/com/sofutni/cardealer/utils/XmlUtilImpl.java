package com.sofutni.cardealer.utils;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class XmlUtilImpl implements XmlUtil {


    public XmlUtilImpl() {
    }

    @Override
    public <E> E unmarshalFromFile(String filepath, Class<E> tClass) throws JAXBException, FileNotFoundException {
        JAXBContext jaxbContext = JAXBContext.newInstance(tClass);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

        return (E) unmarshaller.unmarshal(new FileReader(filepath));

    }
}

package com.sofutni.cardealer.utils;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;

public interface XmlUtil {
    <E> E unmarshalFromFile(String filepath,Class<E> tClass) throws JAXBException, FileNotFoundException;
}

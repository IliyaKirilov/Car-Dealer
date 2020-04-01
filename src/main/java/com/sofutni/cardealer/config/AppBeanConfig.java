package com.sofutni.cardealer.config;

import com.sofutni.cardealer.utils.ValidationUtil;
import com.sofutni.cardealer.utils.ValidationUtilImpl;
import com.sofutni.cardealer.utils.XmlUtil;
import com.sofutni.cardealer.utils.XmlUtilImpl;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.validation.Validation;
import java.util.Random;

@Configuration
public class AppBeanConfig {

    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }


    @Bean
    public ValidationUtil validationUtil(){
        return new ValidationUtilImpl();
    }

    @Bean
    public XmlUtil xmlUtil (){
        return new XmlUtilImpl();
    }


    @Bean
    public Random random(){
        return new Random();
    }
}

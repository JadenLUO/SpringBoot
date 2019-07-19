package com.acxiom.springboot.boot001.test;


import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

import javax.swing.*;

public class Test {

    @Autowired
    private propertyTest p;

    @org.junit.Test
    public void getTitle(){

        System.out.println(p.getTitle1());
        System.out.println(p.getTitle2());
    }
}

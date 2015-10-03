package com.shivang.helloworld;

import java.awt.List;
import java.util.ArrayList;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
    	IGreeter objG = (IGreeter) context.getBean("greeter");

    	System.out.println(objG );
    }
}

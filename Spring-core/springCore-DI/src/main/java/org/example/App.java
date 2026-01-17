package org.example;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
//import org.springframework.core.io.ClassPathResource;

public class App
{
    public static void main( String[] args )
    {
//        PetrolEngine petrolEngine = new PetrolEngine();
//        Car car = new Car();
//        car.setEngine(petrolEngine);
//        car.drive();

        ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
        Car car=context.getBean(Car.class);   // Give me the bean whose class is Car
//        Car car1=context.getBean(Car.class);
        //Car car = (Car) context.getBean("car");
        car.drive();


        /*
        ClassPathResource resource= new ClassPathResource("Bean.xml");
        BeanFactory factory = new XmlBeanFactory(resource);
                        or
        BeanFactory factory = new XmlBeanFactory(new ClassPathResource("Bean.xml"));

         This will not work , deprecated , work in the lowest version of spring 5

*/
        System.out.println(car);
//        System.out.println(car1);   // for understanding scope
    }
}



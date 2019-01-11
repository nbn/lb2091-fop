package dk.lundogbendsen.foundation;

import dk.lundogbendsen.foundation.dynamic.Hello;
import dk.lundogbendsen.foundation.standard.*;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;

public class ManualLoad {

    public static void main(String... args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
//
//
//        List<Die> dice = new ArrayList<>();
//        for (int i = 0; i < 6; i++) {
//            Class<Die> myClass = (Class<Die>) Class.forName("dk.lundogbendsen.foundation.standard.MultiDie");
//            Die die = myClass.newInstance();
//            dice.add(die);
//        }
//
//        DiceCup diceCup = new DiceCup(dice);
//        System.out.println(diceCup.sum());


//        BeanFactory bf = new ClassPathXmlApplicationContext("/hello.xml");

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("dk.lundogbendsen.foundation.config");

        Die terning1 = context.getBean("terning1", Die.class);

        DiceCup bean = context.getBean(DiceCup.class);

        System.out.println("Terning1 er " + terning1);
        System.out.println("Dicecup er " + bean);


//        DiceCup mycup = bf.getBean("mycup", DiceCup.class);
//        System.out.println(mycup);

//        Hello bean = bf.getBean(Hello.class);
//        System.out.println(bean);

//        Object myex = bf.getBean("myex");
//        System.out.print(myex);


//        Class<Die> aClass = (Class<Die>) Class.forName("dk.lundogbendsen.foundation.standard.BasicDie");
//        Annotation[] annotations = aClass.getAnnotations();
//        for(Annotation a: annotations) {
//            if (a instanceof MyAnnotation) {
//                MyAnnotation myAnnotation = (MyAnnotation) a;
//
//                String value = myAnnotation.greeting();
//                System.out.println("Klassen " + aClass.getSimpleName() + " har en @MyAnnotation med værdien " + value);
//            }
//        }
    }
}

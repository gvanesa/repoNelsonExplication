package com.company;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {

    public static void foo() {
        System.out.println("invocando foo");
    }

    public void bar() {
        System.out.println("invocando bar");
    }

    public static void main(String[] args) throws NoSuchMethodException {


        Class<String> x = String.class;
        for (Method m : x.getMethods()) {

            System.out.println(m.getName());

        }
        x.getMethod("").getAnnotations();



        for (String arg : args) {
            try {
                Main.class.getMethod(arg).invoke(null);
                //Main.foo();
            } catch (ReflectiveOperationException ex) {
                System.out.println("exception running " + arg + " : " + ex.getClass().getSimpleName());

            }catch (NullPointerException ex) {
                System.out.println("se intento invocar el metodo de instancia " + arg);
            }
        }

        Auto auto1 = new Auto(2);
        Auto auto2 = new Auto(4);

        System.out.println(auto1.getCantidadPuertas());
        System.out.println(auto2.getCantidadPuertas());


        try {
            Method m = Auto.class.getMethod("getCantidadPuertas");
            System.out.println(m.invoke(auto1));
            System.out.println(m.invoke(auto2));
        } catch (ReflectiveOperationException e) {
            System.out.println("exception running " + e.getClass().getSimpleName());

        }

    }


}

class Auto{

    private int cantidadPuertas;

    public Auto(int cantidadPuertas) {
        this.cantidadPuertas = cantidadPuertas;
    }

    public int getCantidadPuertas() {
        return cantidadPuertas;
    }

    public void setCantidadPuertas(int cantidadPuertas) {
        this.cantidadPuertas = cantidadPuertas;
    }
}

package task1;

import javafx.beans.property.SimpleIntegerProperty;

public class Main
{

    public static void main(String[] args)
    {

        // Teilaufgabe a)
        SimpleIntegerProperty p1 = new SimpleIntegerProperty();
        SimpleIntegerProperty p2 = new SimpleIntegerProperty();
        SimpleIntegerProperty p3 = new SimpleIntegerProperty();
        SimpleIntegerProperty p4 = new SimpleIntegerProperty();

        p4.bind(p3);
        p3.bind(p2);
        p2.bind(p1);

        p1.set(11);
        // p2.set(2); A bound value cannot be set.
        // p3.set(3); A bound value cannot be set.
        // p4.set(4); A bound value cannot be set.

        System.out.println(p4.get());

        // Teilaufgabe b)
        SimpleIntegerProperty p5 = new SimpleIntegerProperty();
        SimpleIntegerProperty p6 = new SimpleIntegerProperty();
        SimpleIntegerProperty p7 = new SimpleIntegerProperty();

        p7.bind(p6);
        p7.bind(p5);

        p6.set(66); // 0, da nur ein binding bestehen kann, und dieses mit p5
                    // überschrieben wurde
        p5.set(55);

        System.out.println(p7.get());

        // Teilaufgabe c)
        SimpleIntegerProperty p8 = new SimpleIntegerProperty();
        SimpleIntegerProperty p9 = new SimpleIntegerProperty();
        SimpleIntegerProperty p10 = new SimpleIntegerProperty();

        p9.bind(p8);
        p10.bind(p8);

        p8.set(88);

        System.out.println(p9.get() + " und " + p10.get());

        // Teilaufgabe d)
        // SimpleIntegerProperty p11 = new SimpleIntegerProperty();
        // SimpleIntegerProperty p12 = new SimpleIntegerProperty();
        // SimpleIntegerProperty p13 = new SimpleIntegerProperty();
        // SimpleIntegerProperty p14 = new SimpleIntegerProperty();

        // p14.bind(p13);
        // p13.bind(p12);
        // p12.bind(p11);
        // p11.bind(p14);
        // Exception in thread "main" java.lang.StackOverflowError

        // Teilaufgabe e)
        SimpleIntegerProperty p15 = new SimpleIntegerProperty();
        SimpleIntegerProperty p16 = new SimpleIntegerProperty();
        SimpleIntegerProperty p17 = new SimpleIntegerProperty();

        p15.bindBidirectional(p16);
        p16.bindBidirectional(p17);

        p15.set(155);
        System.out.println(p17.get()); // funktioniert
        p17.set(177);
        System.out.println(p15.get()); // funktioniert

        // Teilaufgabe f)
        SimpleIntegerProperty p18 = new SimpleIntegerProperty();
        SimpleIntegerProperty p19 = new SimpleIntegerProperty();
        SimpleIntegerProperty p20 = new SimpleIntegerProperty();
        SimpleIntegerProperty p21 = new SimpleIntegerProperty();

        p18.bindBidirectional(p19);
        p19.bindBidirectional(p20);
        p20.bindBidirectional(p21);
        p21.bindBidirectional(p18);

        p19.set(199);

        System.out.println(p18.get());
        System.out.println(p19.get());
        System.out.println(p20.get());
        System.out.println(p21.get());
    }

}

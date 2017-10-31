package task4;

import java.util.ArrayList;
import java.util.LinkedList;

public class Main
{
    public static void main(String[] args)
    {
        timekeeper t1 = new timekeeper();
        ArrayList<Integer> alist = new ArrayList<Integer>();
        LinkedList<Integer> llist = new LinkedList<Integer>();

        // ArrayListe:
        // Einfügen am Anfang einer Liste
        t1.start();
        for (int i = 0; i <= 100000; i++)
        {
            alist.add(0, i);
        }
        t1.end();
        System.out.println("Arraylist - Einfügen am Anfang: " + t1.pastTime() + " Millisekunden");

        // Einfügen am Ende einer Liste
        t1.start();
        for (int i = 0; i <= 100000; i++)
        {
            alist.add(i);
        }
        t1.end();
        System.out.println("Arraylist - Einfügen am Ende: " + t1.pastTime() + " Millisekunden");

        // Zugreifen am Anfang einer Liste
        t1.start();
        for (int i = 0; i <= 100000; i++)
        {
            alist.get(0);
        }
        t1.end();
        System.out.println("Arraylist - Zugreifen am Anfang: " + t1.pastTime() + " Millisekunden");

        // Zugreifen in der Mitte einer Liste
        t1.start();
        for (int i = 0; i <= 100000; i++)
        {
            alist.get(100000);
        }
        t1.end();
        System.out.println("Arraylist - Zugreifen in der Mitte: " + t1.pastTime() + " Millisekunden");

        // Zugreifen am Ende einer Liste
        t1.start();
        for (int i = 0; i <= 100000; i++)
        {
            alist.get(200000);
        }
        t1.end();
        System.out.println("Arraylist - Zugreifen am Ende: " + t1.pastTime() + " Millisekunden");

        // Löschen am Anfang einer Liste
        t1.start();
        for (int i = 0; i <= 100000; i++)
        {
            alist.remove(0);
        }
        t1.end();
        System.out.println("Arraylist - Löschen am Anfang: " + t1.pastTime() + " Millisekunden");

        // Löschen am Ende einer Liste
        t1.start();
        for (int i = 100000; i >= 0; i--)
        {
            alist.remove(i);
        }
        t1.end();
        System.out.println("Arraylist - Löschen am Ende: " + t1.pastTime() + " Millisekunden");
        
        
        
        
        //LinkedList
        //Einfügen am Anfang einer Liste
        t1.start();
        for (int i = 0; i <= 100000; i++)
        {
            llist.add(0, i);
        }
        t1.end();
        System.out.println("Linkedlist - Einfügen am Anfang: " + t1.pastTime() + " Millisekunden");

        // Einfügen am Ende einer Liste
        t1.start();
        for (int i = 0; i <= 100000; i++)
        {
            llist.add(i);
        }
        t1.end();
        System.out.println("Linkedlist - Einfügen am Ende: " + t1.pastTime() + " Millisekunden");

        // Zugreifen am Anfang einer Liste
        t1.start();
        for (int i = 0; i <= 100000; i++)
        {
            llist.get(0);
        }
        t1.end();
        System.out.println("Linkedlist - Zugreifen am Anfang: " + t1.pastTime() + " Millisekunden");

        // Zugreifen in der Mitte einer Liste
        t1.start();
        for (int i = 0; i <= 100000; i++)
        {
            llist.get(100000);
        }
        t1.end();
        System.out.println("Linkedlist - Zugreifen in der Mitte: " + t1.pastTime() + " Millisekunden");

        // Zugreifen am Ende einer Liste
        t1.start();
        for (int i = 0; i <= 100000; i++)
        {
            llist.get(200000);
        }
        t1.end();
        System.out.println("Linkedlist - Zugreifen am Ende: " + t1.pastTime() + " Millisekunden");

        // Löschen am Anfang einer Liste
        t1.start();
        for (int i = 0; i <= 100000; i++)
        {
            llist.remove(0);
        }
        t1.end();
        System.out.println("Linkedlist - Löschen am Anfang: " + t1.pastTime() + " Millisekunden");

        // Löschen am Ende einer Liste
        t1.start();
        for (int i = 100000; i >= 0; i--)
        {
            llist.remove(i);
        }
        t1.end();
        System.out.println("Linkedlist - Löschen am Ende: " + t1.pastTime() + " Millisekunden");
        
        
        
    }
}

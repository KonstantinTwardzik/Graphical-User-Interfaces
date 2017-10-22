package task6;

public class Main
{

    public static void main(String[] args)
    {
        VerySimpleIntegerProperty propertyObject = new VerySimpleIntegerProperty();
        VerySimpleChangeListener listenerObject1 = new VerySimpleChangeListener();
        VerySimpleChangeListener listenerObject2 = new VerySimpleChangeListener();

        propertyObject.addListener(listenerObject1);
        propertyObject.addListener(listenerObject2);

        for (int i = 1; i <= 10; i++)
        {
            int newValue = (int)(Math.random()*100)-50;
            System.out.println("set: " + newValue);
            propertyObject.setValue(newValue);
        }
    }

}

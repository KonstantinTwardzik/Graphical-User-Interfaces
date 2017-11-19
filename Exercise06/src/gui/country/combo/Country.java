package gui.country.combo;

public class Country
{

    private String name;

    private String capital;

    private long people;

    private long area;

    private short density;

    public Country(String name, String capital, long people, long area)
    {
        this.name = name;
        this.capital = capital;
        this.people = people;
        this.area = area;
        this.density = (short) Math.round((float)people / (float)area);
    }

    public String getName()
    {
        return name;
    }

    public String getCapital()
    {
        return capital;
    }

    public long getPeople()
    {
        return people;
    }

    public long getArea()
    {
        return area;
    }

    public short getDensity()
    {
        return density;
    }

    @Override
    public String toString()
    {
        return name;
    }

}
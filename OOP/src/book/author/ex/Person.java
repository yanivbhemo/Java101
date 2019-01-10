package book.author.ex;

public class Person {
    private String name;
    private long id;

    public Person(String name, long id)
    {
        this.name = name;
        this.id = id;
    }

    public void SetName(String name)
    {
        this.name = name;
    }
    public void SetId(long id)
    {
        this.id = id;
    }
    public String GetName()
    {
        return name;
    }
    public long GetId()
    {
        return id;
    }
}

package book.author.ex;

public class Book {
    private String title;
    private Person author;
    private int pages;
    private double price;

    public Book(String title, Person author, int pages, double price)
    {
        this.title = title;
        this.author = author;
        this.pages = pages;
        this.price = price;
    }

    public void SetTitle(String title)
    {
        this.title = title;
    }
    public void SetAuthor(Person author)
    {
        this.author = author;
    }
    public void SetPages(int pages)
    {
        this.pages = pages;
    }
    public void SetPrice(double price)
    {
        this.price = price;
    }
    public String GetTitle()
    {
        return this.title;
    }
    public Person GetAuthor()
    {
        return this.author;
    }
    public int GetPages()
    {
        return this.pages;
    }
    public double GetPrice()
    {
        return this.price;
    }
}

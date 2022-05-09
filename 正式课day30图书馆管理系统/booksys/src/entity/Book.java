package entity;

public class Book {
    private int id;//编号
    private String name;//书名
    private String author;//作者
    private double price;//价格
    private int stock;//库存
    private String state;//上架/下架

    public Book() {
    }


    public Book(int id, String name, String author, double price, int stock, String state) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.price = price;
        this.stock = stock;
        this.state = state;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return id+"\t"+name+"\t"+author+"\t"+price+"\t"+stock+"\t"+state;
    }
}

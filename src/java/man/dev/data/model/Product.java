package man.dev.data.model;

import man.dev.data.DatabaseDao;

public class Product {

    private int id;
    private String name;
    private String description;
    private String image;
    private double price;
    private int quantity;
    private int view;
    private int categoryId;

    public Product(String name, String description, String image, double price, int quantity, int view,
            int categoryId) {
        super();
        this.name = name;
        this.description = description;
        this.image = image;
        this.price = price;
        this.quantity = quantity;
        this.view = view;
        this.categoryId = categoryId;
    }

    public Product(int id, String name, String description, String image, double price, int quantity, int view,
            int categoryId) {
        super();
        this.id = id;
        this.name = name;
        this.description = description;
        this.image = image;
        this.price = price;
        this.quantity = quantity;
        this.view = view;
        this.categoryId = categoryId;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getView() {
        return view;
    }

    public void setView(int view) {
        this.view = view;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public Category getCategory(){
        return DatabaseDao.getInstance().getCategoryDao().find(categoryId);
    }
}

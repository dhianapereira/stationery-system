package domain.models.product;

public class Product {
    private String id;
    private String description;
    private double price;
    private boolean isActive;
    private String type;
    private int quantity ;
    private String userCpf;

    public Product(String id, String description, double price, boolean isActive, String type, int quantity, String userCpf) {
        this.id = id;
        this.description = description;
        this.price = price;
        this.isActive = isActive;
        this.type = type;
        this.quantity = quantity;
        this.userCpf = userCpf;
    }

    public String getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public boolean getIsActive() {
        return isActive;
    }

    public String getType() {
        return type;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getUserCpf() {
        return userCpf;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}

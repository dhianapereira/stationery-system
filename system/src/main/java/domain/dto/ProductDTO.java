package domain.dto;

public class ProductDTO {
    private String userCpf;
    private String description;
    private double price;
    private String type;

    public ProductDTO(String userCpf, String description, double price, String type) {
        this.userCpf = userCpf;
        this.description = description;
        this.price = price;
        this.type = type;
    }

    public String getUserCpf() {
        return userCpf;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public String getType() {
        return type;
    }
}

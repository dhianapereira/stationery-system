package services;


import domain.dto.ProductDTO;
import domain.models.product.Product;
import repositories.ProductRepository;
import java.util.Scanner;

public class ProductService {
    public static boolean addProduct(){
        Scanner input = new Scanner(System.in);
        try {
            System.out.println("Informe o cpf do usuário que irá cadastrar o produto: ");
            String userCpf  = input.next();
            System.out.println("Informe a descrição do produto: ");
            String desc  = input.next();
            System.out.println("Informe o preço do produto: ");
            double price  = input.nextDouble();
            System.out.println("Informe o tipo do produto: ");
            String type  = input.next();
            ProductDTO dto = new ProductDTO(userCpf, desc, price, type);
            return ProductRepository.addProduct(dto);
        } catch(Exception exception){
            System.out.println(exception.getMessage());
            return false;
        }
    }
}

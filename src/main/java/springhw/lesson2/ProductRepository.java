package springhw.lesson2;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Component
public class ProductRepository implements Repository {


    private List<Product> product;

    @PostConstruct
    public void init() {
        product = new ArrayList<>(Arrays.asList(
                new Product(1l, "milk", 60),
                new Product(2l, "Bread", 25),
                new Product(3l, "Apple", 90),
                new Product(4l, "Orange", 120),
                new Product(5l, "Butter", 80)
        ));

    }

    @Override
    public Product findById(Long id) {
        return product.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst()
                .orElseThrow(RuntimeException::new);
    }

    public void printProduct(){
        System.out.println("Католог продуктов");
        for (int i = 0; i < product.size(); i++) {
            System.out.println(product.get(i));
        }

    }
}


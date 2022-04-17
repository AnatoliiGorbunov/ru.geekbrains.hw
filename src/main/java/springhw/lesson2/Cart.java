package springhw.lesson2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
@Scope("prototype")
public class Cart {

    private ProductService productService;
    private List<Product> product;

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    public List<Product> getAllProducts() {
        return product;
    }
    @PostConstruct
    private void init(){
        product = new ArrayList<>();
    }

    public void addProduct(Long id){
        product.add(productService.getProduct(id));
    }

    public void removeProduct(Long id){
        product.removeIf(p -> p.getId().equals(id));
    }


}

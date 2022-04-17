package springhw.lesson2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductService {

    @Autowired
    private Repository repository;

    public Product getProduct(Long id) {
        return repository.findById(id);
    }
}

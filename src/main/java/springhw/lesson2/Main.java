package springhw.lesson2;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        ProductRepository productRepository = context.getBean(ProductRepository.class);
        productRepository.printProduct();

        Cart cart = context.getBean(Cart.class);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Выбор действия:");
            System.out.println("Добавление продукта в корзину: введите 1.");
            System.out.println("Удаление продукта из корзины: введите 2.");
            System.out.println("Просмотр товаров корзины: введите 3.");
            System.out.println("Выход : ведите 4.");
            int number = scanner.nextInt();
            if (number == 1) {
                System.out.println("Введите id продукта");
                Long id = scanner.nextLong();
                cart.addProduct(id);
                System.out.println("Товар добавлен в корзину");
            } else if (number == 2) {
                System.out.println("Введите id продукта");
                Long id = scanner.nextLong();
                cart.removeProduct(id);
            } else if (number == 3) {
                System.out.println("Товары в корзине");
                System.out.println(cart.getAllProducts());
            } else if (number == 4) {
                scanner.close();
                break;
            } else {
                System.out.println("Некорректный ввод данных");
            }
        }
    }
}
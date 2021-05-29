package ru.first.spring.beans;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class Cart {
    private final List<Product> cartProductList = new ArrayList<>();

    public void addProduct(Product product) {
        if (product != null) {
            cartProductList.add(product);
            System.out.println("Продукт успешно добавлен в корзину");
        }
    }

    public void delProduct(Product product) {
        if (product != null) {
            cartProductList.remove(product);
            System.out.println("Продукт успешно удален из корзины");
        }
    }

    public void clearCart() {
        cartProductList.clear();
        System.out.println("Корзина пуста");
    }

    @Override
    public String toString() {
        return "Корзина {" +
                cartProductList.toString() +
                "} Всего " + cartProductList.size() + " шт";
    }
}

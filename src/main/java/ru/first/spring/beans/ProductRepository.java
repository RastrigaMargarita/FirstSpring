package ru.first.spring.beans;

import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository {

    private final List<Product> productList = new ArrayList<>();

    @PostConstruct
    public void fillProductList() {
        for (int i = 0; i < 5; i++) {
            productList.add(new Product(i, "name" + 1, (Math.round(Math.random() * 1000)) / 100.00));
        }
    }

    public String returnAll() {
        return productList.toString();
    }

    public Product getByID(String id) {
        try {
            return productList.get(Integer.parseInt(id));
        } catch (Exception e) {
            System.out.println("Упс, не нашел такого товара");
            return null;
        }
    }
}

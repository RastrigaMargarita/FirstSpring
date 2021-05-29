package ru.first.spring.beans;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@Component
public class CartHandler {
    private final ProductRepository repository;
    private final CartFactory cartFactory;


    public CartHandler(ProductRepository repository, CartFactory cartFactory) {
        this.repository = repository;
        this.cartFactory = cartFactory;
    }

    @PostConstruct
    public void start() {
        //Print all store
        System.out.println("В наличии товар: " + repository.returnAll().toString());
        System.out.println("Добавить: 'a'+id, Удалить: 'd'+id, Очистить: 'c'");
        final Cart cart = cartFactory.createCart();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            while (true) {

                //Listen to user
                String userQuest = br.readLine();
                switch (userQuest.charAt(0)) {
                    //Adding to cart
                    case ('a'):
                        cart.addProduct(repository.getByID(userQuest.substring(1).trim()));
                        break;
                    //Deleting from cart
                    case ('d'):
                        cart.delProduct(repository.getByID(userQuest.substring(1).trim()));
                        break;
                    //Crearing cart
                    case ('c'):
                        cart.clearCart();
                        break;
                }
                System.out.println(cart.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

package com.example.spring.singleton;

/**
 * 무상태로 설계해야 한다!!!
 */
public class StatefulService {

    // private int price; // 상태를 유지하는 필드

    public int order(String name, int price) {
        System.out.println("name = " + name + "price" + price);
        return price;
    }

    //public int getPrice(){
     //   return price;
    //}
}

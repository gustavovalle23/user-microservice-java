package com.churros.infrastructure;

import com.churros.application.UseCase;

public class Main {
    public static void main(String[] args) {
        System.out.println(new UseCase().perform());
    }
}
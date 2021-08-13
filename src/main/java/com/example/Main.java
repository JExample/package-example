package com.example;

import org.apache.commons.lang3.StringUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

public class Main {
    public static void main(String[] args) throws IOException {
        //для демонстрации того, что зависимость указанная в pom подтянулась
        System.out.println(StringUtils.isAllBlank("asd", ""));

        System.out.println();
        System.out.println();
        System.out.println("application.properties");
        Properties p = new Properties();
        p.load(Main.class.getClassLoader().getResourceAsStream("application.properties"));
        System.out.println(p);

        System.out.println();
        System.out.println();
        System.out.println("folder1/props2.properties");
        try (InputStream fis = Main.class.getClassLoader().getResourceAsStream("folder1/props2.properties");
             InputStreamReader isr = new InputStreamReader(fis);
             BufferedReader br = new BufferedReader(isr)) {

            br.lines().forEach(System.out::println);
        }

        System.out.println();
        System.out.println();
        System.out.println("include.txt");
        try (InputStream fis = Main.class.getClassLoader().getResourceAsStream("include.txt");
             InputStreamReader isr = new InputStreamReader(fis);
             BufferedReader br = new BufferedReader(isr)) {

            br.lines().forEach(System.out::println);
        }
    }
}

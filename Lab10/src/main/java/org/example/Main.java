package org.example;

import org.apache.commons.io.FileUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        ShapeCalculator calculator = new ShapeCalculator();
        calculator.start();

        fileExample();
        jacksonExample();
    }

    private static void fileExample() {
        try {
            File file = new File("example.txt");
            String data = "Пример записи в файл с использованием Apache Commons IO.";
            FileUtils.writeStringToFile(file, data, "UTF-8");
            System.out.println("Данные успешно записаны в файл.");

            String content = FileUtils.readFileToString(file, "UTF-8");
            System.out.println("Содержимое файла: " + content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void jacksonExample() {
        Person person = new Person("Иван", 30);

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            String jsonString = objectMapper.writeValueAsString(person);
            System.out.println("Сериализованный объект в JSON: " + jsonString);

            Person deserializedPerson = objectMapper.readValue(jsonString, Person.class);
            System.out.println("Десериализованный объект: " + deserializedPerson);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class Person {
        private String name;
        private int age;

        public Person() {}

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return "Person{name='" + name + "', age=" + age + '}';
        }
    }
}
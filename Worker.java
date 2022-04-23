package com.data.classes;

import com.data.enums.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.ZonedDateTime;
import java.util.Locale;
import java.util.Random;

public class Worker {
    private Integer id;//Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private java.time.ZonedDateTime creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private Double salary; //Поле может быть null, Значение поля должно быть больше 0
    private java.time.ZonedDateTime startDate; //Поле не может быть null
    private java.time.ZonedDateTime endDate; //Поле может быть null
    private Position position; //Поле не может быть null
    private Person person; //Поле может быть null

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    boolean answer = false;

    public boolean Named(){
        return true;
    }

    public Worker() throws IOException {

        //ID сотрудника
        Random random = new Random();
        this.id = Integer.valueOf(random.nextInt(999999)+100000);
        if (this.id > 0) {
            System.out.println("ID работника: " + id);
        }

        //Имя сотрудника
        do{
            System.out.print("Введите имя сотрудника: ");
            String name = br.readLine();

            if (name.equals(" ")) {
                System.out.println("Вы ввели пробел вместо имени!\n ");
                continue;
            }

            this.name = name;
            answer = Named();

        } while (!answer);

        //Координаты места работы
        System.out.println("Введите координаты места работы сотрудника: ");
        Coordinates coordinates = new Coordinates();
        this.coordinates = coordinates;

        //Дата создания "работника"
        ZonedDateTime time = ZonedDateTime.now();
        this.creationDate = time;
        System.out.println("Дата создания анкеты работника: " + time);

        //Зарплата работника
        while (true) {
            System.out.print("Введите зарплату: ");
            salary = Double.parseDouble(br.readLine());
            if (salary > 0){
                this.salary = salary;
                break;
            }
            else {
                System.out.println("Неверное значение! Не скупитесь и введите значение больше 0!\n ");
            }
        }

        //Позиция в компании


        do {
            try {
                    System.out.println("Выберите свою позицию в компании (BAKER, LEAD_DEVELOPER, HEAD_OF_DEPARTMENT): ");
                    String input = br.readLine().toUpperCase();
                    Position position = Enum.valueOf(Position.class, input);

                    if (position == Position.BAKER) {
                        this.position = position;
                        break;
                    } else if (position == Position.LEAD_DEVELOPER) {
                        this.position = position;
                        break;
                    } else if (position == Position.HEAD_OF_DEPARTMENT) {
                        this.position = position;
                        break;
                    }

            } catch (IllegalArgumentException e) {
                System.out.println("Неверно введена позиция! Проверьте написание и точно ли ваша позиция есть в списке! \n");
                continue;
            }
            Named();
        } while (answer);


        //Личные характеристики работника
        System.out.println("Время заполнить личные данные о работнике! ");
        Person person = new Person();
        this.person = person;

    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public ZonedDateTime getCreationDate() {
        return creationDate;
    }

    public Double getSalary() {
        return salary;
    }

    public Position getPosition() {
        return position;
    }

    public Person getPerson() {
        return person;
    }
}

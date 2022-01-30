package projektpo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;


import java.io.IOException;


import projektpo.java.*;
import projektpo.models.LibraryDB;
/*
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        List libraryDB = new ArrayList();
        String name;
        String lastName;
        String manufacturer;
        String model;
        int numOfPages;


        Scanner scanner = new Scanner(System.in);
        scanner.useDelimiter("\n");
        System.out.println("Wpisz polecenie: add - aby dodać obiekt, showAll - aby wypisać informacje o wszytkich obiektach, exit - aby wyjść");
        String command = scanner.next();

        while (!command.equals("exit")) {

            switch (command) {
                case "add":
                    System.out.println("Wybierz rodzaj obiektu do dodania: 1 - użytkownik, 2 - pracownik, 3 - stacja robocza, 4 - drukarka, 5 - książka, 6 - czasopismo");
                    short x = scanner.nextShort();

                    switch (x) {
                        case 1:
                            System.out.println("Podaj imię:");
                            name = scanner.next();

                            System.out.println("Podaj nazwisko:");
                            lastName = scanner.next();

                            System.out.println("Wybierz typ: 1 - dziecko, 2 - uczeń, 3 - dorosły");
                            short type = scanner.nextShort();
                            UserType userType;


                            if (type == 1) {
                                userType = UserType.CHILD;
                            } else if (type == 2) {
                                userType = UserType.STUDENT;
                            } else if (type == 3) {
                                userType = UserType.ADULT;
                            } else {
                                System.out.println("Podano niepoprawną wartość");
                                break;
                            }

                            libraryDB.add(new User(name, lastName, userType));
                            break;

                        case 2:
                            System.out.println("Podaj imię:");
                            name = scanner.next();

                            System.out.println("Podaj nazwisko:");
                            lastName = scanner.next();

                            System.out.println("Wybierz stanowisko: 1 - bibliotekarz, 2 - starszy bibliotekarz, 3 - kustosz");
                            short pos = scanner.nextShort();
                            Position position;

                            if (pos == 1) {
                                position = Position.BIBLIOTEKARZ;
                            } else if (pos == 2) {
                                position = Position.STARSZY_BIBLIOTEKARZ;
                            } else if (pos == 3) {
                                position = Position.KUSTOSZ;
                            } else {
                                System.out.println("Podano niepoprawną wartość");
                                break;
                            }

                            System.out.println("Podaj wynagrodzenie:");
                            int salary = scanner.nextInt();

                            libraryDB.add(new Employee(name, lastName, position, salary));
                            break;

                        case 3:
                            System.out.println("Podaj nazwę:");
                            name = scanner.next();

                            System.out.println("Podaj producenta:");
                            manufacturer = scanner.next();

                            System.out.println("Podaj model:");
                            model = scanner.next();

                            System.out.println("Wybierz markę procesora: 1 - Intel, 2 - AMD");
                            short proc = scanner.nextShort();
                            ProcessorBrand processorBrand;

                            if (proc == 1) {
                                processorBrand = ProcessorBrand.INTEL;
                            } else if (proc == 2) {
                                processorBrand = ProcessorBrand.AMD;
                            } else {
                                System.out.println("Podano niepoprawną wartość");
                                break;
                            }

                            System.out.println("Wybierz markę karty graficznej: 1 - Nvidia, 2 - AMD, 3 - Intel");
                            short card = scanner.nextShort();
                            GraphicCardBrand graphicCardBrand;

                            if (card == 1) {
                                graphicCardBrand = GraphicCardBrand.NVIDIA;
                            } else if (card == 2) {
                                graphicCardBrand = GraphicCardBrand.AMD;
                            }  else if (card == 3) {
                                graphicCardBrand = GraphicCardBrand.INTEL;
                            } else {
                                System.out.println("Podano niepoprawną wartość");
                                break;
                            }

                            libraryDB.add(new Workstation(name, manufacturer, model, processorBrand, graphicCardBrand));
                            break;

                        case 4:
                            System.out.println("Podaj nazwę:");
                            name = scanner.next();

                            System.out.println("Podaj producenta:");
                            manufacturer = scanner.next();

                            System.out.println("Podaj model:");
                            model = scanner.next();

                            System.out.println("Wybierz typ drukarki: 1 - atramentowa, 2 - laserowa monochromatyczna, 3 - laserowa kolorowa");
                            short pri = scanner.nextShort();
                            PrinterType printerType;

                            if (pri == 1) {
                                printerType = PrinterType.INKJET;
                            } else if (pri == 2) {
                                printerType = PrinterType.MONOCHROMATIC_LASER;
                            } else if (pri == 3) {
                                printerType = PrinterType.COLOR_LASER;
                            } else {
                                System.out.println("Podano niepoprawną wartość");
                                break;
                            }

                            System.out.println("Czy drukarka ma wbudowany skaner?: y - tak, n - nie");
                            String sc = scanner.next();
                            boolean integratedScanner;

                            if (sc.equals("y")) {
                                integratedScanner = true;
                            } else if (sc.equals("n")) {
                                integratedScanner = false;
                            } else {
                                System.out.println("Podano niepoprawną wartość");
                                break;
                            }

                            libraryDB.add(new Printer(name, manufacturer, model, printerType, integratedScanner));
                            break;

                        case 5:
                            System.out.println("Podaj nazwę:");
                            name = scanner.next();

                            System.out.println("Podaj liczbę stron:");
                            numOfPages = scanner.nextInt();

                            System.out.println("Podaj autora:");
                            String author = scanner.next();

                            System.out.println("Podaj gatunek:");
                            String genre = scanner.next();

                            libraryDB.add(new Book(name, numOfPages, author, genre));
                            break;

                        case 6:
                            System.out.println("Podaj nazwę:");
                            name = scanner.next();

                            System.out.println("Podaj liczbę stron:");
                            numOfPages = scanner.nextInt();

                            System.out.println("Wybierz interwał publikacji: 1 - dziennik, 2 - tygodnik, 3 - dwutygodnik, 4 - miesięcznik");
                            short per = scanner.nextShort();
                            PeriodOfPublication periodOfPublication;

                            if (per == 1) {
                                periodOfPublication = PeriodOfPublication.DAILY;
                            } else if (per == 2) {
                                periodOfPublication = PeriodOfPublication.WEEKLY;
                            } else if (per == 3) {
                                periodOfPublication = PeriodOfPublication.BIWEEKLY;
                            } else if (per == 4) {
                                periodOfPublication = PeriodOfPublication.MONTHLY;
                            } else {
                                System.out.println("Podano niepoprawną wartość");
                                break;
                            }

                            System.out.println("Podaj kategorię:");
                            String category = scanner.next();

                            libraryDB.add(new Magazine(name, numOfPages, periodOfPublication, category));
                            break;

                    }
                    break;
                case "showAll":
                    for (Object obj : libraryDB) {
                        System.out.println(obj.toString());
                        System.out.println("\n");
                    }
                    break;
                default:
                    System.out.println("Podano nieprawidłowe polecenie");
            }

            System.out.println("Wpisz polecenie: add - aby dodać obiekt, showAll - aby wypisać informacje o wszytkich obiektach, exit - aby wyjść");
            command = scanner.next();
        }

    } */

public class Main extends Application{

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("mainView.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("LibraryDB");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}
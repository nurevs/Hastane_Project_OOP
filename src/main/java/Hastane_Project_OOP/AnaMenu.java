package Hastane_Project_OOP;

import java.util.Locale;
import java.util.Scanner;

public class AnaMenu {

    static Scanner scan = new Scanner(System.in);
    public  static void AnaMenu() {
        AnaMenu object = new AnaMenu();

        System.out.println("QA-11 Hastanesine Hosgeldiniz");
        System.out.println("***************ANAMENU***************");
        System.out.println("\t 1)Hasta Menusu\n" +
                           " \t 2)Doktor Menusu\n" +
                            "\t 0) CIKIS");


        String scm=scan.next().toLowerCase();


        switch (scm) {

            case "1":
                object.hastaIslemler();
                break;
            case "2":
                object.doktorIslemler();
                break;
            case "0":
                object.cikis();
                break;
            default:
                System.out.println("Lutfen gecerli bir deger giriniz");
                AnaMenu();
        }

    }

    public void hastaIslemler() {
        Islemler.IslemlerMenu(1);
    }

    public void doktorIslemler() {
        Islemler.IslemlerMenu(2);
    }
    public void cikis() {
        System.out.println("Saglikli gunler dileriz...");

    }
}

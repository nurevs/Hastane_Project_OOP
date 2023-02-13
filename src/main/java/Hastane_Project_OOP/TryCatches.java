package Hastane_Project_OOP;

import java.util.Scanner;

public class TryCatches {
    public static int integerGiris() {
        Scanner scan =new Scanner(System.in);
        int giris =0;
        boolean flag=false;

        do {
            System.out.println("Lutfen islem seciniz");
            if (flag==true){
                scan.nextLine();
                flag=false;
            }                                     //ctrl +alt +t
            try {
                giris =scan.nextInt();
                scan.nextLine();
            } catch (Exception e) {
                System.out.println("Hatalı islem yaptınız");
                flag =true;
                integerGiris();

            }
        }while(flag);


        return giris;
    }
}

package Hastane_Project_OOP;

import javax.print.Doc;
import java.util.Iterator;
import java.util.Map;
import java.util.PropertyPermission;
import java.util.Scanner;

public class Islemler implements IslemlerInterface {

    static Scanner scan = new Scanner(System.in);
    static int secim = 0;

    public static void IslemlerMenu(int i) {
        secim = i;
        Islemler obj = new Islemler();


        System.out.println("***************HASTANE MENUSU*************** ");
        System.out.println("\t1)EKLEME \n" +
                "\t2)LISTELEME \n" +
                "\t3)ARAMA\n" +
                "\t4)SILME\n" +
                "\t5)ANAMENU\n " +
                "\t6)CIKIS ");


        int scm = TryCatches.integerGiris();


        switch (scm) {
            case 1:
                obj.ekleme();
                IslemlerMenu(secim);
                break;
            case 2:
                obj.listeleme();
                IslemlerMenu(secim);
                break;
            case 3:
                obj.arama();
                IslemlerMenu(secim);
                break;
            case 4:
                obj.silme();
                IslemlerMenu(secim);
                break;
            case 5:
                obj.anaMenu();

                break;
            case 6:
                obj.cikis();
                IslemlerMenu(secim);
                break;
            default:
                System.out.println("Lutfen gecerli bir islem giriniz...");
                IslemlerMenu(secim);
        }


    }


    @Override
    public void ekleme() {

        System.out.println("\t ***************KISI EKLEME MENUSU*************** ");
        System.out.println("Lutfen kimlik numarası giriniz...");
        String kimlikId = scan.next();
        kimlikIDKontrol(kimlikId);
        if (secim == 1) {
            hastaBilgiKaydet(kimlikId);
        } else
            doktorBilgiKaydet(kimlikId);

        listeleme();

    }


    public void hastaBilgiKaydet(String kimlikId) {
        System.out.println("\t ***************HASTA BILGI KAYDET*************** ");

        System.out.println("Lutfen Ad-Soyad giriniz...");
        Scanner input = new Scanner(System.in);
        String adsoyad = input.nextLine();
        System.out.println("Lutfen gitmek istediginiz bolumu seciniz...");
        System.out.println("\t1-Allerji\n" +
                "\t2-Bas Agrisi\n" +
                "\t3-Cocuk Hastaliklari\n" +
                "\t4-Migren\n" +
                "\t5-Kalp Hastaliklari");
        String bolum = scan.next();

        switch (bolum) {
            case "1":
                System.out.println("Allergist doktoruna gidiniz...");
                break;
            case "2":
                System.out.println("Norolog doktoruna gidiniz... ");
                break;
            case "3":
                System.out.println("Cocuk hastaliklari doktoruna gidiniz... ");
                break;
            case "4":
                System.out.println("Norolog doktoruna gidiniz... ");
                break;
            case "5":
                System.out.println("Kardiyolog doktoruna gidiniz... ");
                break;
            default:
                System.out.println("Lutfen gecerli bir islem giriniz...");
                hastaBilgiKaydet(kimlikId);
        }
        Patient obj = new Patient(adsoyad, bolum);
        Patient.patientMap.put(kimlikId, obj);
       

    }

    public void doktorBilgiKaydet(String kimlikId) {
        System.out.println("\t ***************DOKTOR BILGI KAYDET*************** ");
        System.out.println("Lutfen Ad-Soyad giriniz...");
        Scanner input = new Scanner(System.in);
        String adsoyad = input.nextLine();
        System.out.println("Lutfen doktorun unvani giriniz...");
        String unvan = scan.next();

        Doctor obj = new Doctor(adsoyad, unvan);
        Doctor.doctorMap.put(kimlikId, obj);

    }


    private void kimlikIDKontrol(String kimlikID) {
        if (Patient.patientMap.containsKey(kimlikID) || Doctor.doctorMap.containsKey(kimlikID)) {
            System.out.println("Bu ID kayıt yapılmış");
            //AnaMenu.giris();
        }


    }

    @Override
    public void arama() {

        System.out.println("\t ***************KISI EKLEME*************** ");
        System.out.println("Lutfen kimlik ID giriniz...");
        String kimlikID = scan.next();

        if (secim == 1) {
            if (Patient.patientMap.containsKey(kimlikID)) {
                System.out.println(Patient.patientMap.get(kimlikID));
            } else
                System.out.println("Bu hasta kayitli degil...");
        } else if (secim == 2) {
            if (Doctor.doctorMap.containsKey(kimlikID)) {
                System.out.println(Doctor.doctorMap.get(kimlikID));
            } else
                System.out.println("Bu doktor kayitli degil...");
        }

    }

    @Override
    public void listeleme() {
        System.out.println("\t ***************LISTELEME*************** ");
        Iterator i = Patient.patientMap.entrySet().iterator();
        Iterator j = Doctor.doctorMap.entrySet().iterator();

  if (secim == 1) {

            while (i.hasNext()) {
                Map.Entry me = (Map.Entry) i.next();
                System.out.println(me.getKey() + " : " + me.getValue());
            }
        }else if (secim == 2) {
            while (j.hasNext()) {
                Map.Entry me = (Map.Entry) j.next();
                System.out.println(me.getKey() + " : " + me.getValue());
            }

        }






    }

    @Override
    public void silme() {
        System.out.println("\"***************SILME ISLEMLERI***************\"");
        System.out.println("1) Hasta sil\n"+
                "2) Doktor sil\n");

        secim=scan.nextInt();
        System.out.println("Silmek istediginiz kisinin kimlik Id'sini giriniz...");
        String kimlikID = scan.next();
        if (secim == 1) {
            Patient.patientMap.remove(kimlikID);
            System.out.println("Kayit silindi");
        } else if (secim == 2) {
            Doctor.doctorMap.remove(kimlikID);
            System.out.println("Kayit silindi");
        }

        listeleme();

    }

    @Override
    public void anaMenu() {
        AnaMenu.AnaMenu();

    }

    @Override
    public void cikis() {
        System.out.println("***************** Saglikli gunler dileriz... *****************");

    }
}
package Hastane_Project_OOP;

import java.util.HashMap;
import java.util.Map;

public class Patient {


    static Map<String,Patient> patientMap=new HashMap<>();
    private String bolum;
    private String nameSurname;
  //  private String aktuelDurum;

    public Patient(String adSoyad,String bolum) {
        this.bolum = bolum;
        this.nameSurname = adSoyad;
      //  this.aktuelDurum = aktuelDurum;
    }

    public static Map<String, Patient> getPatientMap() {
        return patientMap;
    }

    public static void setPatientMap(Map<String, Patient> patientMap) {
        Patient.patientMap = patientMap;
    }

    public String getAdSoyad() {
        return nameSurname;
    }

    public void setAdSoyad(String adSoyad) {
        this.nameSurname = adSoyad;
    }

    public String getBolum() {
        return bolum;
    }

    public void setBolum(String bolum) {
        this.bolum = bolum;
    }


    @Override
    public String toString() {
        return
                  nameSurname + '\'' +
                   bolum + '\''
                ;
    }
}

//    public String getAktuelDurum() {
//        return aktuelDurum;
//    }

//    public void setAktuelDurum(String aktuelDurum) {
//        this.aktuelDurum = aktuelDurum;
//    }





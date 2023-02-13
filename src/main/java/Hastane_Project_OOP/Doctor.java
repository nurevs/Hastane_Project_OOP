package Hastane_Project_OOP;

import java.util.HashMap;
import java.util.Map;

public class Doctor {
    static Map<String,Doctor> doctorMap=new HashMap<>();
    private String unvan;
    private String nameSurname;

    public Doctor(String nameSurname,String unvan) {
        this.unvan = unvan;
        this.nameSurname = nameSurname;
    }


    public String getNameSurname() {
        return nameSurname;
    }

    public void setNameSurname(String nameSurname) {
        this.nameSurname = nameSurname;
    }

    public Doctor() {

    }

    public String getUnvan() {
        return unvan;
    }

    public void setUnvan(String unvan) {
        this.unvan = unvan;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "nameSurname='" + nameSurname + '\'' +
                ",unvan ='" + unvan + '\'' +
                '}';
    }
}

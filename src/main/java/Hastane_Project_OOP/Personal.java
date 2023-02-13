package Hastane_Project_OOP;

public class Personal {

    private String nameSurname;

    public Personal() {
    }

    public String getNameSurname() {
        return nameSurname;
    }

    public void setNameSurname(String nameSurname) {
        this.nameSurname = nameSurname;
    }


    public Personal(String nameSurname) {
        this.nameSurname = nameSurname;

    }

    @Override
    public String toString() {
        return "Personal{" +
                "nameSurname='" + nameSurname + '\'' +
                '}';
    }
}

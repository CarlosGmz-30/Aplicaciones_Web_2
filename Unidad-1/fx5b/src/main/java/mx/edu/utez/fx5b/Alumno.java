package mx.edu.utez.fx5b;

public class Alumno {
    private String name;
    private String surname;
    private String lastname;
    private String age;

    public Alumno(String name, String surname, String lastname, String age) {
        this.name = name;
        this.surname = surname;
        this.lastname = lastname;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}

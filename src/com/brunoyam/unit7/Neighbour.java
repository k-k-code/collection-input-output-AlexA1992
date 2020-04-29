package com.brunoyam.unit7;

import java.io.Serializable;
import java.util.Objects;

/**
 * Модель жителя района.
 */
public class Neighbour {

    /**
     * Фамилия.
     */
    private String surname;
    /**
     * Имя.
     */
    private String name;
    /**
     * Отчество.
     */
    private String secondName;
    /**
     * Возраст.
     */
    private byte age;
    /**
     * Женат/замужем или нет.
     */
    private String married;
    /**
     * Номер документа удостоверяющего личность.
     */
    private String docNumber;

    /**
     * Конструктор.
     * @param name имя.
     * @param surname фамилия.
     * @param secondName отчество.
     * @param docNumber номер документа, удостоверяющего личность.
     */
    public Neighbour (String surname, String name, String secondName, byte age, String married, String docNumber) {

        this.surname = surname;
        this.name = name;
        this.secondName = secondName;
        this.age = age;
        this.married = married;
        this.docNumber = docNumber;
    }


    /**
     * Конструктор.
     * @param name имя.
     * @param surname фамилия.
     * @param secondName отчество.
     * @param age возраст.
     * @param docNumber номер документа, удостоверяющего личность.
     */
    /*
    public Neighbour(String name, String surname, String secondName, byte age, String docNumber) {
        this(name, surname, secondName, docNumber);
        this.age = age;
    }
*/
    /**
     * Геттер.
     * @return имя.
     */
    public String getName() {
        return name;
    }

    /**
     * Геттер.
     * @return фамилия.
     */
    public String getSurname() {
        return surname;
    }

    /**
     * Геттер.
     * @return отчество.
     */
    public String getSecondName() {
        return secondName;
    }

    /**
     * Геттер.
     * @return номер документа.
     */
    public String getDocNumber() {
        return docNumber;
    }

    /**
     * Геттер.
     * @return возраст.
     */
    public byte getAge() {
        return age;
    }

    /**
     * Сеттер.
     * @return возраст.
     */
    public void setAge(byte age) {
        this.age = age;
    }

    /**
     * Геттер.
     * @return женат/замужем.
     */
    public String isMarried() {
        return married;
    }

    /**
     * Сеттер.
     * @return женат/замужем.
     */
    public void setMarried(String married) {
        this.married = married;
    }

    /**
     * Сравнивает текущий объект с предложенным.
     * @param o объект с которым сравнивать текущий.
     * @return <code>true</code> если объекты равны, в противном случае <code>false</code>.
     */
  /*  @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Neighbour neighbour = Neighbour o;
        return docNumber.equals(neighbour.docNumber);
    }*/

    /**
     * Возвращает хэш объекта.
     * @return хэш объекта.
     */
    /*@Override
    public int hashCode() {
        return Objects.hash(docNumber);
    }*/

    /**
     * Возвращает текстовое представление объекта.
     * @return текстовое представление объекта.
     */
    @Override
    public String toString() {
        return "Neighbour{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", secondName='" + secondName + '\'' +
                ", age='" + age + '\'' +
                ", docNumber='" + docNumber + '\'' +
                '}';
    }

    /**
     * Сравнивает текущий объект с предложенным.
     * @param o объект для сравнения.
     * @return положительное число, если текущий объект больше, отрицательно число, если текущий объект меньше, ноль,
     * если объекты равны.
     */
  /*  @Override
    public int compareTo(Neighbour o) {
        String fullName = surname + " " + name + " " + secondName;
        String fullName2 = o.getSurname() + " " + o.getName() + " " + o.getSecondName();
        return fullName.compareTo(fullName2);
    }*/

}

package com.brunoyam.unit7;

import java.io.*;
import java.util.Scanner;

/**
 * Класс-пример чтения из файлов и записи в файлы используя различные потоки ввода-вывода.
 */
public class NeighbourReader {

    /**
     * Массив предопределенных объектов типа {@link com.brunoyam.unit7.Neighbour Neighbour}.
     */
    private Neighbour[] neighbours = {
            new Neighbour("Yakov", "Ivanov", "Ivanovich", (byte) 46, "1220"),
            new Neighbour("Ivan", "Ivanov", "Ivanovich", (byte) 35,"1245"),
            new Neighbour("Petr", "Petrov", "Petrovich", (byte) 22,"1250"),
            new Neighbour("Ilona", "Ilonova", "Il'ina", (byte) 57,"1245"),
            new Neighbour("Petr", "Abakin", "Petrovich", (byte) 10,"1255"),
    };

    /**
     * Счетчик отданных объектов из предопределенного массива.
     */
    private int counter = -1;

    /**
     * Возвращает по очереди объекты {@link com.brunoyam.unit7.Neighbour Neighbour}
     * из масссива {@link #neighbours neighbours}.
     * @return
     */
    public Neighbour nextNeighbour() {
        if (counter + 1 < neighbours.length) {
            counter++;
            return neighbours[counter];
        }
        return null;
    }

    /**
     * Читает данные из одного файла и записывает в другой, используя байтовые потоки ввода-выводаю.
     */
    public void readWrite() {
        FileInputStream in = null;
        FileOutputStream out = null;
        try {
            in = new FileInputStream("test.txt");
            out = new FileOutputStream("copy_test.txt");

            byte[] values = new byte[100];

            int readed = in.read(values);
            in.skip(50);
            while (readed > 0) {
                out.write(values, 0, readed);
                readed = in.read(values);
                in.skip(50);
            }

        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден");
        } catch (IOException e) {
            System.out.println("Не удалось прочитать данные");
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (out != null) {
                    out.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Читает данные из одного файла и записывает в другой, используя потоки ввода-выводаю с буфером.
     */
    public void readWriteBuffered() {
        BufferedInputStream in = null;
        BufferedOutputStream out = null;
        try {
            in = new BufferedInputStream(new FileInputStream("test.txt"));
            out = new BufferedOutputStream(new FileOutputStream("copy_test.txt"));

            byte[] values = new byte[100];

            int readed = in.read(values);
            while (readed > 0) {
                out.write(values, 0, readed);
                readed = in.read(values);
            }

        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден");
        } catch (IOException e) {
            System.out.println("Не удалось прочитать данные");
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (out != null) {
                    out.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Читает данные из одного файла и записывает в другой, используя символьные потоки ввода-выводаю.
     */
    public void readWriteChars() {
        FileReader in = null;
        FileWriter out = null;
        try {
            in = new FileReader("test.txt");
            out = new FileWriter("copy_test.txt");

            char[] values = new char[100];

            int readed = in.read(values);
            in.skip(50);
            while (readed > 0) {
                out.write(values, 0, readed);
                readed = in.read(values);
                in.skip(50);
            }

        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден");
        } catch (IOException e) {
            System.out.println("Не удалось прочитать данные");
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (out != null) {
                    out.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Читает данные из одного файла и записывает в другой, используя символьные потоки ввода-выводаю с буфером.
     */
    public void readWriteCharsBuffered() {
        BufferedReader in = null;
        BufferedWriter out = null;
        try {
            in = new BufferedReader(new FileReader("test.txt"));

            FileWriter fileWriter = new FileWriter("copy_test.txt");
            out = new BufferedWriter(fileWriter);

            String str = in.readLine();
            out.write(str);

        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден");
        } catch (IOException e) {
            System.out.println("Не удалось прочитать данные");
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (out != null) {
                    out.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Читает пользовательский ввод и выводит ответ используя консольные потоки ввода вывода.
     */
    public void consoleReadWrite() {
        System.out.println("Укажите значение");
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        try {
            MyEnum enumValue = MyEnum.valueOf(input.toUpperCase());
            System.out.println("Вы ввели \"" + enumValue + "\"");
        } catch (IllegalArgumentException ex) {
            System.out.println("Введи что-то умнее чем \"" + input + "\"");
        }
    }

    /**
     * Перечисление, используемое для демонстрационных целей.
     */
    private enum MyEnum {
        MIN,
        AVG,
        MAX;
    }

    /**
     * Записывает значения полей объекта в файл и читает из файла, используя потоки ввода-вывода данных.
     * Для записи использует метод {@link #writeData(Neighbour)}, для чтения - {@link #readData(String)}.
     */
    public void dataReadWrite() {
        Neighbour neighbour = new Neighbour("Sergey", "Gerasimov", "Venyamonivich", "567422");
        neighbour.setAge((byte) 45);
        neighbour.setMarried(true);

        writeData(neighbour);

        Neighbour newNeighbour = readData(neighbour.getName() + ".nbr");

    }

    /**
     * Записывает значения полей объекта {@link com.brunoyam.unit7.Neighbour Neighbour} в файл, используя потоки
     * ввода-вывода данных.
     * @param neighbour объект для записи.
     */
    private void writeData(Neighbour neighbour) {
        DataOutputStream out = null;
        try (FileOutputStream fos = new FileOutputStream(neighbour.getName() + ".nbr")){
            BufferedOutputStream bos = new BufferedOutputStream(fos);
            out = new DataOutputStream(bos);
            out.writeUTF(neighbour.getName());
            out.writeUTF(neighbour.getSurname());
            out.writeUTF(neighbour.getSecondName());
            out.writeByte(neighbour.getAge());
            out.writeBoolean(neighbour.isMarried());
            out.writeUTF(neighbour.getDocNumber());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Создает новый объект {@link com.brunoyam.unit7.Neighbour Neighbour} и заполняет его поля значениями,
     * прочитанными из файла с помощью потока ввода-вывода данных.
     * @param filename имя файла для чтения.
     * @return новый объект {@link com.brunoyam.unit7.Neighbour}, заполненный данными из файла.
     */
    private Neighbour readData(String filename) {
        File file = new File(filename);
        if (!file.exists() || !file.getName().endsWith(".nbr")) {
            return null;
        }

        try (FileInputStream fis = new FileInputStream(file);
             BufferedInputStream bis = new BufferedInputStream(fis);
             DataInputStream in = new DataInputStream(bis)){

            String name = in.readUTF();
            String surname = in.readUTF();
            String secondName = in.readUTF();
            byte age = in.readByte();
            boolean married = in.readBoolean();
            String docNumber = in.readUTF();

            Neighbour neighbour = new Neighbour(name, surname, secondName, docNumber);
            neighbour.setMarried(married);
            neighbour.setAge(age);
            return neighbour;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Сериализует объект и записывает в файл используя потоки ввода-вывода объектов.
     */
    public void objectReadWrite() {
        Neighbour neighbour = new Neighbour("Sergey", "Gerasimov", "Venyamonivich", "567422");
        neighbour.setAge((byte) 45);
        neighbour.setMarried(true);

        String filename = neighbour.getName() + ".nbo";

        try (ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(filename)))) {
            out.writeObject(neighbour);
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(filename)))) {
            System.out.println("object was written");
            Neighbour newNeighbour = (Neighbour) in.readObject();
            System.out.println(newNeighbour);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

}

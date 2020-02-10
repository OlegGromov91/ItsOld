package stud.OD;


import java.io.IOException;

public class Main {
    /*
    Телефонная книга
    1) Если пишем новое имя, просит вввести номер телефона и запоминает его,
    если телефон то просит ввести имя.

    2) Если вводим существующее имя или номер телефона,
    программа должна выводить всю инфу о контакте.

    3) При ввводе команды LIST программа печатает всех абонентов
    в алфавитном порядке.
     */
    public static void main(String[] args) throws IOException
    {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.mainCycle();
    }

}
package stud.OD;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class PhoneBook {


    /*
    НЕКОРРЕКТНОЕ ОТОБРАЖЕНИЕ КНИГИ КОГДА ЛИСТ

    КОГДА НЕКОРРЕКТНЫЙ ВВОД ПИШЕТСЯ ДОБАВЛЕНО В СИСОК
     */

        private final String REGEX_NUMBER = "^(\\+7|8)\\d{10}";
        private final String REGEX_NAME = "^[A-Я,A-Z][аА-яЯ,aA-zZ]+\\s[A-Я,A-Z][аА-яЯ,aA-zZ]+\\s[A-Я,A-Z][аА-яЯ,aA-zZ]+";
        private final String LIST = "LIST";
        private final String EXIT = "EXIT";

        private String phoneBookName;
        private String phoneBookNumber;

        private BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        private Map<String, String> phoneBook = new TreeMap<String, String>();

        public void mainCycle () throws IOException
        {//Основной метод программы
            describe();
            for(;;)
            {
                String input = bufferedReader.readLine();
                if(input.matches(REGEX_NUMBER))
                {   //Если пользователь ввел номер, просим ввести имя и добавляем все в тел.Книгу
                    getNubberThenName(input);
                    mapPutIn();
                }

                else if (input.matches(REGEX_NAME))
                {//Если пользователь ввел имя, просим ввести номер и добавляем все в тел.Книгу
                    getNameThenNumber(input);
                    mapPutIn();
                }

                else if (input.matches(LIST))
                {//Печатаем тел.Книгу
                    list();
                }

                else if (input.matches(EXIT))
                {//Выходим из программы
                    System.out.println("Вы вышли из программы");
                    break;
                }
                else {
                    System.out.println("Команда не распознана");
                }

            }
        }

        private void mapPutIn ()
        {// Метод записывает имя и телефон в книгу
            if(phoneBookNumber.matches(REGEX_NUMBER) && phoneBookName.matches(REGEX_NAME)){
                phoneBook.put(phoneBookName, phoneBookNumber);}
            else {
                System.out.println("Некорректный ввод");}
        }

        private void getNubberThenName (String input) throws IOException
        {   //Метод добавляет сначало номер, потом имя.

            if (phoneBook.containsValue(input)){
                checkCoincidence(input);      //Если номер уже есть выводим информацию о контакте
            }
            else{
                setNumber(input);   //Сохраняем номер
                System.out.println("Введите имя");
                String inputName = bufferedReader.readLine();
                setName(inputName);  //Сохраняем имя
                System.out.println("Добавленно в телефонную книгу");
            }}

        private void getNameThenNumber (String input) throws IOException
        {   //Метод добавляет сначало имя, потом номер.

            if(phoneBook.containsKey(input))
            {
                checkCoincidence(input);  //Если имя уже есть выводим информацию о контакте
            }
            else {
                setName(input);   //Сохраняем имя
                System.out.println("Введите номер");
                String inputNumbr = bufferedReader.readLine();
                setNumber(inputNumbr);   //Сохраняем номер
                System.out.println("Добавленно в телефонную книгу");
            }}

        private void setName (String input)
        {

            this.phoneBookName = input;
        }

        private void setNumber (String input)
        {
            this.phoneBookNumber = input;
        }

        private void checkCoincidence (String input)
        {      //Итератор для поиска совпадений

            Iterator<Map.Entry<String, String>> iterator = phoneBook.entrySet().iterator();
            while (iterator.hasNext())
            {
                Map.Entry<String, String> pair = iterator.next();
                String key = pair.getKey();
                String value = pair.getValue();
                if(key.equals(input)|| value.equals(input)){
                    System.out.println("ФИО: " + key + " Номер: " + value);
                }}

        }

        private void list ()
        {//Метод печатает книгу
            System.out.println("-------------------------Телефонная книга---------------------------------");
            for (Map.Entry<String, String> entry : phoneBook.entrySet()) {
                System.out.println("--------------------------------------------------------------------------");
                System.out.println("|| ФИО: || "  + entry.getKey()  + " || Номер: || "  + entry.getValue() + " || ");
                System.out.println("--------------------------------------------------------------------------");
            }
        }

        private void describe ()
        {
            System.out.println("Пользователь может вводить имя, либо номер.\n" +
                    "Номер разрешается вводить в формате как +7... так и 8...(номер может быть максимум 11-значным)." +
                    " Пример: +71234567890 или 81234567890.\n" +
                    "Фамилия имя и отчество разрешается вводить только с большой буквы, английскими или русскими буквами" +
                    " через пробел. Пример: Иванов Иван Иванович или Ivanov Ivan Ivanovich.\n" +
                    "Чтобы посмотреть телефонную книгу целиком набери LIST.\n" +
                    "Для выхода из программы введите EXIT.");
        }
    }






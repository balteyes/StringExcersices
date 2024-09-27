import java.io.File;
import java.io.IOException;
import java.util.*;



public class Main {
    public static void main(String[] args) {
        List<String> txt = readFile("input.txt");
        System.out.println(txt);

        List<String> unique = new ArrayList<>(new HashSet<>(txt));
        System.out.println(unique);
        List<String> unique2 = new ArrayList<>(new TreeSet<>(txt));
        System.out.println(unique2);
        //System.out.println(getUniqueNames(txt));
        txt.stream().distinct().forEach(s -> System.out.println(s));
        // txt.stream().distinct().collect();

        // int k = countVasyaPupkin(txt, "Вася Пупкин");
        // System.out.println("Cколько раз содержится строка Вася Пупкин: " +k);
        int k = startsWithVasyaP(txt, "Вася Пупкин");
        var shortLines = lineLess15Symb(txt);
        shortLines.sort(String::compareTo);

        System.out.println("Строк, начинающихся с Вася Пупкин = " + k);
        System.out.println("Список строк короче 15 символов: " + lineLess15Symb(txt));
        System.out.println("сортированный список: " +sortString(txt));
        replaceSymbolsInLines(txt, 'В', 'V');
        System.out.println("txt = " + txt);


    }
    private static void replaceSymbolsInLines(List<String> txt, char oldC, char newC){
        for (int i = 0; i < txt.size(); i++) {
            String s = txt.get(i);
            s = s.replace(oldC, newC);
            txt.set(i, s);
        }
    }

    public static List<String> sortString(List<String> lines) {
        List<String> shortLines = lineLess15Symb(lines);
        Collections.sort(shortLines); // Сортировка списка
        return shortLines;
    }

        //1 прочитать строки из файла в список строк
        public static List<String> readFile (String filename){
            List<String> txt = new ArrayList<>();
            try {
                Scanner scanner = new Scanner(new File(filename));
                while (scanner.hasNextLine()) {
                    txt.add(scanner.nextLine());


                }

            } catch (IOException e) {
                System.out.println("что-то не так с записью в файл");
                System.out.println(e.getMessage());
                ;
            }
            return txt;
        }

        //2 получить список уникальных имен, прочитанный из файла
        public static Set<String> getUniqueNames (List < String > txt) {
            return new HashSet<>(txt);


        }

        //3 подсчитать, сколько раз в файле содержится строка "Вася Пупкин"

        public static int countVasyaPupkin (List < String > txt, String x){
            int counter = 0;
            for (String s : txt)
                if (s.equals(x))
                    counter++;
            return counter;
        }


        //4 подсчитать, сколько в файле строк, которые начинаются на "Вася"
        public static int startsWithVasyaP (List < String > txt, String x){
            int counter = 0;
            for (String s : txt)
                if (s.startsWith(x))
                    counter++;
            return counter;
        }
        //5 Взять из списка всех строк только строки короче 15 символов
        public static List<String> lineLess15Symb (List < String > txt) {
            List<String> shortLines = new ArrayList<>();
            for (String s : txt)
                if (s.length() < 15)
                    shortLines.add(s);

            return shortLines;




        }

        //6 Отсортировать список строк, которые короче 15 символов


        //7 Заменить в списке строк все буквы В на V

    }






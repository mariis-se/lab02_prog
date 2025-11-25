import java.util.List;
import java.util.Scanner;

public class MainApp{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
//        System.out.println("enter text parhfile: ");
        boolean firstTry = true;

        while (true) {
//            if (firstTry) {System.out.println("enter text parhfile: ");}
            System.out.print("\nВведите путь к файлу или exit для выхода: ");
            String input = scanner.nextLine().trim();

            if (input.equalsIgnoreCase("exit")){
                System.out.println("Завершение программы");
                break;
            }
            if (input.isEmpty()){
                continue;
            }
            System.out.println("Вы ввели: " + input);

            run(input);
//            firstTry = false;
        }
        scanner.close();
    }

    private static void run(String filePath){
        long timerStart = System.currentTimeMillis();

        try {
            Csv parser = new Csv();
            List<Addresses> addresses = parser.parseFile(filePath);

            System.out.println("Конец, размер: " + addresses.size());

            System.out.println("\nПервые пять строк (проверка): ");
            for (int i = 0; i < Math.min(5, addresses.size()); i++) {
                System.out.println(addresses.get(i));
            }
            System.out.println("\n");
            dublicatesStatistics.findDubles(addresses);
            dublicatesStatistics.floorStatistics(addresses);


        } catch (java.io.FileNotFoundException e) {
            System.out.println("Ошибка: Файл не найден - " + e.getMessage());
        } catch (java.io.IOException e) {
            System.out.println("Ошибка чтения файла: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Ошибка: Неверный формат числа в файле - " + e.getMessage());
        }

        long timerEnd = System.currentTimeMillis();
        System.out.printf("Время обработки: %d мс%n", (timerEnd - timerStart));

    }

}


import java.util.List;
import java.util.Scanner;

public class MainApp{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter text parhfile: ");

        while (true) {
            String input = scanner.nextLine().trim();

            if (input.equalsIgnoreCase("exit")){
                System.out.println("exit");
                break;
            }
            if (input.isEmpty()){
                continue;
            }
            System.out.println("your enter: " + input);

            run(input);
        }
        scanner.close();
    }

    private static void run(String filePath){
        long timerStart = System.currentTimeMillis();

        try {
            Csv parser = new Csv();
            List<Addresses> addresses = parser.parseFile(filePath);

            System.out.println("Done, amount: " + addresses.size());

            System.out.println("\nfirst 5 lines:");
            for (int i = 0; i < Math.min(5, addresses.size()); i++) {
                System.out.println(addresses.get(i));
            }


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


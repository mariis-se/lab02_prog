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
        long Timer = System.currentTimeMillis();

        try {
            Csv parser = new Csv();
            List<Addresses> addresses = parser.parseFile(filePath);

            System.out.println("Done, amount: " + addresses.size());



        }

    }

}


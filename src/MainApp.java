import java.util.Scanner;

class MainApp{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter text: ");

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
        }
        scanner.close();
    }

}
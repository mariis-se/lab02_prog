import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;

public class CsvParser implements FileParser{
    public List<Addresses> parseFile(String filePath) throws FileNotFoundException, IOException, NumberFormatException {
        List<Addresses> addresses = new ArrayList<>();
        BufferedReader bufferedReader = null;

        try {
            bufferedReader = new BufferedReader(new FileReader(filePath));
            String line;
            boolean lineFirst = true;

            while ((line = bufferedReader.readLine()) != null) {
                if (lineFirst) {
                    lineFirst = false;
                    continue;
                }


                String[] info = line.split(";");
                if (info.length == 4) {
                    String city = info[0].replace("\"", "");
                    String street = info[1].replace("\"", "");
                    String house = info[2].replace("\"", "");
                    int floor = Integer.parseInt(info[3]); // form str in int

                    addresses.add(new Addresses(city, street, house, floor));
                }
            }
        } finally {
            if (bufferedReader != null) {
                bufferedReader.close();
            }
        }
        return addresses;
    }
}

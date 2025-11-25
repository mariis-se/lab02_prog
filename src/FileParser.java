import java.io.IOException;
import java.util.List;

public interface FileParser {
    List<Addresses> parseFile(String filePath) throws IOException, IllegalArgumentException;
}

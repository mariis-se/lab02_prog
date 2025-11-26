import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class XmlParser implements FileParser {
    public List<Addresses> parseFile(String filePath) throws IOException, IllegalArgumentException {
        List<Addresses> addresses = new ArrayList<>();

        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance(); //создаем хмл парсер
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new File(filePath));// читаем и разбираем хмл парсер
            // все элементы item из хмл
            NodeList itemList = document.getElementsByTagName("item");

            //работаем с каждым элементом
            for (int i = 0; i < itemList.getLength(); i++) {
                Element item = (Element) itemList.item(i);
                String city = item.getAttribute("city");
                String street = item.getAttribute("street");
                String house = item.getAttribute("house");
                int floor = Integer.parseInt(item.getAttribute("floor"));

                addresses.add(new Addresses(city, street, house, floor));
            }

        } catch (ParserConfigurationException | SAXException e) {
            throw new IllegalArgumentException("Ошибка разбора XML: " + e.getMessage());
        }

        return addresses;
    }
}
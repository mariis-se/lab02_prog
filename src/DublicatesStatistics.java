import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DublicatesStatistics {
    public static void findDubles(List<Addresses> addresses){
        System.out.println("Dublicates");
        Map<Addresses, Long> addressCounts = addresses.stream() //<key, value>; list превращаем в поток данных
                .collect(Collectors.groupingBy( //группировка по опред признаку --> все одинаковые адреса попадут в однку группу
                        address -> address,
                        Collectors.counting() //колво эл-ов в каждой группе
                ));
        // фильтруем только дубликаты
        boolean hasDublicates = false;
        for (Map.Entry<Addresses, Long> entry : addressCounts.entrySet()) { //проход циклом по элементам мапы
            if (entry.getValue() > 1) {
                System.out.println(entry.getKey() + " - Dublicates: " + entry.getValue());
                hasDublicates = true;
            }
        }
        if (!hasDublicates) {System.out.println("Dublicatis is not found eeeee!)");}
    }
}

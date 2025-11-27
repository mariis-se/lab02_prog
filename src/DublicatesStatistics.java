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

    public static void floorStatistics (List<Addresses> addresses){
        // группируем по городам, а внутри по этажам
        Map<String, Map<Integer, Long>> cityFloorStats = addresses.stream()
                .collect(Collectors.groupingBy(
                        Addresses::getCity,
                        Collectors.groupingBy(
                                Addresses::getFloor,
                                Collectors.counting()
                        )
                ));
        for (String city : cityFloorStats.keySet()){
            System.out.println("\nCity: " + city);
            Map<Integer, Long> floorMap = cityFloorStats.get(city);

            for (int floor = 1 ; floor < 6 ; floor++){
                long count = floorMap.getOrDefault(floor, 0L);
                System.out.printf("  %d-этажных: %d%n", floor, count);
            }
        }
    }
}

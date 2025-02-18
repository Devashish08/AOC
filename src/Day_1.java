import java.io.File;
import java.util.*;

class Day_1 {
    public static void main(String[] args) {
        List<Integer> left = new ArrayList<>();
//        List<Integer> right = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();

        try (Scanner scanner = new Scanner(new File("input.txt"))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim();
                if (line.isEmpty()) continue;
                String[] parts = line.split("\\s+");
                if (parts.length != 2) {
                    System.err.println("Invalid line: " + line);
                    continue;
                }
                left.add(Integer.parseInt(parts[0]));
                map.put(Integer.parseInt(parts[1]), map.getOrDefault(Integer.parseInt(parts[1]), 0) + 1);
            }
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            return;
        }
//        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
//            System.out.println(entry.getKey() + " " + entry.getValue());
//        }
        int dist = 0;
        for(int num : left) {
            if(!map.containsKey(num)) {
                continue;
            } else {
                int val = map.get(num);
                System.out.println(val);
                dist += (num * val);
            }
        }
        System.out.println("Total distance: " + dist);
    }
}
import java.io.File;
import java.util.*;

public class Day_2 {
    public static void main(String[] args) {
        int safeCount = 0;

        try (Scanner scanner = new Scanner(new File("input.txt"))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim();
                if (line.isEmpty()) continue;

                String[] parts = line.split("\\s+");
                List<Integer> numbers = new ArrayList<>();
                for (String part : parts) {
                    numbers.add(Integer.parseInt(part));
                }

                if (canBeMadeSafe(numbers)) {
                    safeCount++;
                }
            }
            System.out.println("Total safe reports: " + safeCount);
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
    private static boolean canBeMadeSafe(List<Integer> nums) {
        if (helper(nums)) {
            return true;
        }
        for (int i = 0; i < nums.size(); i++) {
            List<Integer> modified = new ArrayList<>(nums);
            modified.remove(i);
            if (helper(modified)) {
                return true;
            }
        }

        return false;
    }

    private static boolean helper(List<Integer> nums) {
        if (nums.size() < 2) return false;

        int firstDiff = nums.get(1) - nums.get(0);
        if (firstDiff == 0) return false;
        int direction = Integer.signum(firstDiff);

        for (int i = 1; i < nums.size(); i++) {
            int diff = nums.get(i) - nums.get(i - 1);
            if (diff == 0) return false;
            if (Integer.signum(diff) != direction) return false;
            int absDiff = Math.abs(diff);
            if (absDiff < 1 || absDiff > 3) return false;
        }

        return true;
    }
}
import java.util.*;

public class CoinChange {

    /**
     * Calculates all possible combinations of coins to represent the given amount.
     *
     * @param amount the total amount to represent
     * @return a set of coin combinations
     */
    public static Set<int[]> makeChange(int amount) {
        Set<int[]> combinations = new HashSet<>();
        makeChangeRecursive(amount, new int[]{0, 0, 0, 0}, combinations);
        return combinations;
    }

    private static void makeChangeRecursive(int remaining, int[] currentCombination, Set<int[]> combinations) {
        if (remaining == 0) {
            combinations.add(currentCombination.clone());
            return;
        }

        int[] coinValues = {25, 10, 5, 1};
        for (int i = 0; i < coinValues.length; i++) {
            if (remaining >= coinValues[i]) {
                currentCombination[i]++;
                makeChangeRecursive(remaining - coinValues[i], currentCombination, combinations);
                currentCombination[i]--;
            }
        }
    }

    public static void main(String[] args) {
        int amount = 12;
        Set<int[]> combinations = makeChange(amount);
        for (int[] combination : combinations) {
            System.out.println(Arrays.toString(combination));
        }
    }
}
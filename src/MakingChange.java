import java.util.Arrays;

/**
 * The class Making Change solves a classic problem:
 * given a set of coins, how many ways can you make change for a target amount?
 *
 * @author Zach Blick
 * @author [DamianVillarreal-Ayala]
 */

public class MakingChange {
    /**
     * TODO: Complete this function, countWays(), to return the number of ways to make change
     *  for any given total with any given set of coins.
     *
     *  - Good idea to sort list from least to greatest coin?
     *  int[] coins is the array filled with the given different coins we can use to find returnChange.
     *  target is the number we
     *
     *  To avoid returning a repeated form of coins to make the same target (1 + 1 + 2, 2 + 1 + 1),
     *  keep track of number of times coins appear?
     *  - Use a hash map?
     *  - Hold every prior WayToMakeChange
     *
     *  - Does it make sense to create a list that holds different sums of the coins?
     *    And then use that list to use modulo on the sums?
     *   - or does it make sense ot look for sums/multiples of coins to fill in space even if coin[i]
     *   doesn't cleanly fit into target? (target mod coin[i] DOESN'T equal 0).
     *
     *   **Any form of list to go back and compare against would be best done using a hash map**
     *
     *   For recursive:
     *   - not sure yet...
     *   - change target as you go thru base cases, then recurse using changed target
     *   explain more in depth what this means/could look like after class
     *   for this though, it would lwk be helpful to have that list of
     *   - start with first coin, recurse with each consecutive coin?
     *   i.e. [1, 3, 5, 10]
     *   (1, 3), (1, 5), (1, 10)
     *
     *   not sure what the time or space complexity would be, but i imagine I will need a way to speed it up
     *   if using a recursive route
     *
     *
     *  Ideas:
     *  simple idea - Just start trying things
     *  First simple idea:
     *  - Start by finding the easy ways such as adding the coins given
     *
     *  Probably dumb idea:
     *  - Would it make sense to keep track/a copy of each way find to return change, and then compare
     *    against those copies to ensure no duplicate methods when returning countWays?
     *
     *    Mr. Blick mentioned idea:
     *    - Consider the problem by thinking of ways to minimize/make the problem smaller
     *    --> Think of the problem by changing the amount of coins
     *    i.e. [5,2,1] -> [2,1] -> [1]
     *    1. relationship between n & n -1
     *    2. memoizing/tabulating
     *
     *    Mr. Blick talked about divying up the problem by looking at it as either including or excluding the next coin
     *    EX.
     *    count(10, {5, 2, 1})
     *      Including 5 means that the sum will decrease by 5, and the number of coins will remain the same.
     *      By excluding the 5, the sum stays the same bu the number of coins decrease.
     *
     *   **NOTE** Not sure if it's important, best to use a sorted list and go greatest to least.
     *   count(10, {5, 2, 1}) should return:
     *   The number of ways we can make change for 5 with {5, 2, 1} (include the 5)
     *   +
     *   The number of ways we can make change for 10 with {2, 1} (exclude the 5).
     *
     *   base cases should be:
     *   sum/target is 0
     *    - return 1
     *   i is out of bounds
     *    - return 0
     *   sum/target is negative
     *    - return 0
     *
     *    The idea behind incorporating memoization is:
     *    any time we do a recursive call with target t and n coins, we will save its answer.
     *    We should use a 2D int array to save the answer for the numbers of ways to get a particular sum considering the coins from index 0 to index i.
     */
    public static long countWays(int target, int[] coins) {
        long numWaysToReturnChange = 0;
        int[][] pathsForChange = new int[][];
        //This is currently from least to greatest; switch eventually? or work around
        Arrays.sort(coins);

        // super basic idea: add the number of times the coins can make change
        for(int i = 0; i < coins.length; i++)
        {
            System.out.println(coins[i]);
            numWaysToReturnChange += returnNumWaysBasic(target, coins[i]);
        }


        return numWaysToReturnChange;
    }

    public static int returnNumWaysBasic(int target, int coin)
    {
        int basicNum = 0;
        //base case
        if (target == 0)
        {
            return 1;
        }
        //base case:i is out of bounds
        //base case
        if(target < 0)
        {
            return 0;
        }

        return basicNum;
    }
}

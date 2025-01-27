import java.util.Arrays;

/**
 * The class Making Change solves a classic problem:
 * given a set of coins, how many ways can you make change for a target amount?
 *
 * @author Zach Blick
 * @author [DamianVillarreal-Ayala]
 */.

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
     *
     *  Ideas:
     *  simple idea - Just start trying things
     *  First simple idea:
     *  - Start by finding the easy ways such as adding the coins given
     *
     *  Probably dumb idea:
     *  - Would it make sense to keep track/a copy of each way find to return change, and then compare
     *    against those copies to ensure no duplicate methods when returning countWays?
     */
    public static long countWays(int target, int[] coins) {
        long numWaysToReturnChange = 0;
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
        //if the target can be cleanly divided into the target coin, we know a way to return
        //change is by using a multiple of coin
        //another step? begin finding what numbers can be added together and still be cleanly divisible.
        //base case (?)
        if(target % coin == 0)
        {
            basicNum++;
        }
        return basicNum;
    }
}

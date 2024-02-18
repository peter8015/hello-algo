package chapter_greedy;

/**
 * @author zhanghaibing
 * @date 2024-02-04
 */
import org.junit.Assert;
import org.junit.Test;

public class MaxProfitTest {
    @Test
    public void testMaxProfitWithNullInput() {
        MaxProfit maxProfit = new MaxProfit();
        Assert.assertEquals(0, maxProfit.maxProfit(null));
    }

    @Test
    public void testMaxProfitWithSingleDay() {
        MaxProfit maxProfit = new MaxProfit();
        int[] prices = new int[]{1};
        Assert.assertEquals(0, maxProfit.maxProfit(prices));
    }

    @Test
    public void testMaxProfitWithNoChange() {
        MaxProfit maxProfit = new MaxProfit();
        int[] prices = new int[]{1, 1, 1, 1, 1};
        Assert.assertEquals(0, maxProfit.maxProfit(prices));
    }

    @Test
    public void testMaxProfitWithIncreasingPrices() {
        MaxProfit maxProfit = new MaxProfit();
        int[] prices = new int[]{1, 2, 3, 4, 5};
        Assert.assertEquals(4, maxProfit.maxProfit(prices));
    }

    @Test
    public void testMaxProfitWithDecreasingPrices() {
        MaxProfit maxProfit = new MaxProfit();
        int[] prices = new int[]{5, 4, 3, 2, 1};
        Assert.assertEquals(0, maxProfit.maxProfit(prices));
    }

    @Test
    public void testMaxProfitWithDifferentPrices() {
        MaxProfit maxProfit = new MaxProfit();
        int[] prices = new int[]{7, 1, 5, 3, 6, 4};
        Assert.assertEquals(5, maxProfit.maxProfit(prices));
    }
}


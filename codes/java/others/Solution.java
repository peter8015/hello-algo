package others;

import org.junit.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author zhanghaibing
 * @date 2024-03-28
 */
public class Solution {

    @Test
    public void test() {
        int expected = 0;
        String node = "D";
        int actual = restart(node);

        assertEquals(expected, actual);
    }

    private int restart(String node) {
        System.out.println("得到依赖节点xxx及数据！");
        getDependencyNodes(node, "up");
        System.out.println("得到下级节点xxx及数据！");
        getDependencyNodes(node, "down");
        System.out.println("处理得到的数据！");

        return 0;
    }

    private void getDependencyNodes(String node, String target) {
        if ("up".equals(target)) {

        } else {

        }
    }

    @Test
    public void test1() {
        UUID uuid = UUID.randomUUID();
        System.out.println(uuid.toString().substring(0, 8));
    }
}
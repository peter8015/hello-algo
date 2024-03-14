package others.jiqiao;

import java.util.*;

/**
 * @author zhanghaibing
 * @date 2024-03-13
 */
public class Solution {

    /**
     * retry node data handle.
     * map(node, tables)
     */
    public void handleNodes(String node) {
        // 1. get depneds
        List<String> depends = nodeDepends(node);
        System.out.println("node depends on nodes " + depends.size());

        // 2. for each handle data
        for (String depend : depends) {
            handData(depend);
        }
    }

    /**
     * handle data
     *
     * @param node
     */
    public void handData(String node) {
        // tables from config or db
        Map<String, List<Table>> tables = new HashMap<>();
        tables.put("a", Arrays.asList(new Table(1)));

        List<Table> tbs = tables.get(node);

        for (Table table : tbs) {
            table.execute(node);
        }
    }

    /**
     * b - acd
     * a - c
     *
     * @param node
     * @return
     */
    public List<String> nodeDepends(String node) {
        // 1. find depends
        Map<String, List<String>> nodeMaps = new HashMap();
        nodeMaps.put("b", Arrays.asList("a", "c", "d"));

        return nodeMaps.get("b");
    }


    public static void main(String[] args) {

    }


}

class Table {
    Integer id;
    String name;
    Date date;

    public Table(Integer id) {
    }

    public void execute(String id) {
        System.out.println("execute table id");
    }
}


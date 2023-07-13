public class MostStonesRemoved {
    public static int removeStones(int[][] stones){
        int offset = 100000;
        UnionFindMap stone = new UnionFindMap();

        for(int[] s : stones){
            int x = s[0];
            int y = s[1];
            stone.union(x, y + offset);
        }

        Set<Integer> groups = new HashSet<>();
        Map<Integer, Integer> parents = stone.getParents();
        for(Map.Entry<Integer, Integer> entry : parents.entrySet()){
            groups.add(stone.find(entry.getKey()));
        }

        return stones.length - groups.size();
    }
}

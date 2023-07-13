import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AccountsMerge {
    class UnionFind{
        private int[] parents;

        public UnionFind(int n){
            parents = new int[n];
            for(int i = 0; i <n; i++){
                parents[i] = i;
            }


        }

        public int find(int node){
            if(parents[node] == node){
                return node;
            }

            return find(parents[node]);
        }

        public void union(int node1, int node2){
            int rootNode1 = find(node1);
            int rootNode2 = find(node2);
            if(rootNode1 != rootNode2){
                parents[rootNode2] = rootNode1;
            }
        }
    }

    public static List<List<String>> accountsMerge(List<List<String>> accounts){
        UnionFind unionFind = new UnionFind(accounts.size());
        Map<String, Integer> emailMapping = new HashMap<>();
        for(int i = 0; i < accounts.size(); i++){
            List<String> emails = accounts.get(i);
            for(int j = 1; j < emails.size(); ++j){
                if(emailMapping.containsKey(emails.get(j))){
                    if(!accounts.get(i).get(0).equals(accounts.get(emailMapping.get(emails.get(j))).get(0))){
                        return new ArrayList<>();
                    }
                    unionFind.union(emailMapping.get(emails.get(j)), i);
                }

                emailMapping.put(emails.get(j), i);
            }
        }

        Map<Integer, List<String>> mergedAccounts = new HashMap<>();
        for(Map.Entry<String, Integer> entry : emailMapping.entrySet()){
            int root = unionFind.find(entry.getValue());
            mergedAccounts.computeIfAbsent(root, k -> new ArrayList<>()).add(entry.getKey());
        }

        List<List<String>> finalMerged = new ArrayList<>();
        for(Map.Entry<Integer, List<String>> entry: mergedAccounts.entrySet()) {
            int parent = entry.getKey();
            List<String> emails = entry.getValue();
            Collections.sort(emails);
            List<String> merged = new ArrayList<>();
            merged.add(accounts.get(parent).get(0));
            merged.addAll(emails);
            finalMerged.add(merged);
        }

        return finalMerged;
    }
}

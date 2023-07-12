import java.util.ArrayList;
import java.util.List;

public class UnionFindGrid {
    private List<Integer> parent;
    private List<Integer> rank;
    private int count;

    public UnionFindGrid(ArrayList<ArrayList<Character>> grid){
        int m = grid.size();
        int n = grid.get(0).size();

        this.parent = new ArrayList<Integer>();
        this.rank = new ArrayList<Integer>();
        this.count = 0;

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid.get(i).get(j) == '1'){
                    parent.add(i * n + j);
                    this.count += 1;
                } else {
                    this.parent.add(-1);
                }
                this.rank.add(1);
            }
        }
    }

    public List<Integer> getParent(){
        return this.parent;
    }

    public int getCount(){
        return this.count;
    }

    public void union(int v1, int v2){
        int p1 = find(v1);
        int p2 = find(v2);
        if(p1 != p2){
            if(this.rank.get(p1) > this.rank.get(p2)){
                this.parent.set(p2, p1);
            } else if (this.rank.get(p1) < this.rank.get(p2)){
                this.parent.set(p1, p2);
            } else {
                this.parent.set(p2, p1);
                this.rank.set(p1, this.rank.get(p1) + 1);
            }
            count -- ;
        }

    }

    public int find(int v){
        if(this.parent.get(v) != v){
            this.parent.set(v, this.find(this.parent.get(v));
        }

        return this.parent.get(v);
    }
}

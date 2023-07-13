package CustomDS;

import java.util.HashMap;
import java.util.Map;

public class SnapshotArray {
    private int snapid;
    private Map<Integer, Map<Integer, Integer>> nodeValue;
    private int ncount;
    
    // Constructor
    public SnapshotArray(int length) {
        snapid = 0;
        nodeValue = new HashMap<Integer, Map<Integer, Integer>>();
        nodeValue.put(0, new HashMap<Integer, Integer>());
        ncount = length;
    }
    
    // Function setValue sets the value at a given index idx to val.
    public void setValue(int idx, int val) {
        if (idx < ncount) {
            nodeValue.get(snapid).put(idx, val);
        }
    }
    
    // This function takes no parameters and returns the snapid.
    // snapid is the number of times that the snapshot() function was called minus 1.
    public int snapshot() {
        nodeValue.put(snapid + 1, new HashMap<Integer, Integer>(nodeValue.get(snapid)));
        snapid++;
        return snapid - 1;
    }
    // Function getValue returns the value at the index idx with the given snapid.
    public int getValue(int idx, int snapshotId1) {
        if (snapshotId1 < snapid && snapshotId1 >= 0) {
            if (nodeValue.get(snapshotId1).containsKey(idx)) {
                return nodeValue.get(snapshotId1).get(idx);
            } else {
                return 0;
            }
        } else {
            return -1;
        }
    }
}

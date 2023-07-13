import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Triplet {
    public String course;
    public String cName;
    public int id;

    public Triplet(String course, String cName, int id) {
        this.course = course;
        this.cName = cName;
        this.id = id;
    }

}

class TimeStamp {
    HashMap<String, List<String>> valuesDict;
    HashMap<String, List<Integer>> timestampDict;

    public TimeStamp() {
        valuesDict = new HashMap<String, List<String>>();
        timestampDict = new HashMap<String, List<Integer>>();

    }

    public void setValue(String key, String value, int timestamp) {
        if (valuesDict.containsKey(key)) {
            if (timestamp < timestampDict.get(key).get(timestampDict.get(key).size() - 1)) {
                int val = timestampDict.get(key).get(timestampDict.get(key).size() - 1);
            }

            else if (value != valuesDict.get(key).get(valuesDict.get(key).size() - 1)) {
                valuesDict.get(key).add(value);
                timestampDict.get(key).add(timestamp);
            }
        } else {
            valuesDict.put(key, new ArrayList<String>());
            valuesDict.get(key).add(value);
            timestampDict.put(key, new ArrayList<Integer>());
            timestampDict.get(key).add(timestamp);
        }
    }

    public int searchIndex(int n, String key, int timeStamp) {

        int left = 0;
        int right = n;
        int mid = 0;

        while (left < right) {
            mid = left + (right - left) / 2;
            if (!(timestampDict.get(key).get(mid) > timeStamp)) {
                left = mid + 1;
            } else {
                right = mid;
            }

        }
        return left - 1;
    }

    public String getValue(String key, int timeStamp) {
        int index = 0;
        if (!valuesDict.containsKey(key)) {
            return " ";
        } else {
            index = searchIndex(timestampDict.get(key).size(), key, timeStamp);
        }

        if (index > -1) {
            return valuesDict.get(key).get(index);
        }

        return " ";
    }
    
}
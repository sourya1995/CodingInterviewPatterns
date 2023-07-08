package KWayMerge;

public class MergeSorted {
    public static String printArraywithMarkers(int[] arr, int pValue) {
    String out = "[";
    for (int i = 0; i < arr.length - 1; i++) {
      if (i == pValue) {
        out += "«";
        out += String.valueOf(arr[i]) + "»" + ", ";
      }
      else {
        out += String.valueOf(arr[i]) + ", ";
      }
    }
    if (pValue == arr.length - 1) {
      out += "«" + arr[arr.length - 1];
      out += "»]";
    }
    else {
      out += arr[arr.length - 1];
      out += "]";
    }
    return out;
  }
  public static void mergeSorted(int[] nums1, int m, int[] nums2, int n) {
    int p1 = m - 1; // set p1 to the last initialised element of nums1
    int p2 = n - 1; // set p2 to the last element of nums2
    System.out.println("\n\t\tInitialising p1 to the last data element of nums1:");
    System.out.println("\t\t\t" + printArraywithMarkers(nums1, p1));
    System.out.println("\t\t\tp1: " + p1 + ", value: " + nums1[p1]);
    System.out.println("\n\t\tInitialising p2 to the last data element of nums2:");
    System.out.println("\t\t\t" + printArraywithMarkers(nums2, p2));
    System.out.println("\t\t\tp1: " + p2 + ", value: " + nums2[p2]);

  }
}

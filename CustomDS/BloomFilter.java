import java.util.BitSet;
import java.util.HashSet;
import java.util.Random;

class BloomFilter {
    private int m; // Size of the Bloom Filter (number of bits)
    private int k; // Number of hash functions
    private BitSet bitSet;
    private HashSet<String> elements;

    public BloomFilter(int capacity, double falsePositiveRate) {
        this.m = (int) Math.ceil(capacity * Math.log(1.0 / falsePositiveRate) / Math.log(2.0));
        this.k = (int) Math.ceil((m / capacity) * Math.log(2.0));
        this.bitSet = new BitSet(m);
        this.elements = new HashSet<>();
    }

    public void add(String element) {
        elements.add(element);
        for (int i = 0; i < k; i++) {
            int hash = hash(element, i);
            bitSet.set(hash);
        }
    }

    public boolean contains(String element) {
        if (!elements.contains(element)) {
            return false;
        }
        for (int i = 0; i < k; i++) {
            int hash = hash(element, i);
            if (!bitSet.get(hash)) {
                return false;
            }
        }
        return true;
    }

    private int hash(String element, int seed) {
        Random random = new Random(seed);
        byte[] elementBytes = element.getBytes();
        int hash = 0;
        for (byte b : elementBytes) {
            hash ^= random.nextInt(256) ^ b;
        }
        return Math.abs(hash % m);
    }
}

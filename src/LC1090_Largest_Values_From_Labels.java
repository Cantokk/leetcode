import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class LC1090_Largest_Values_From_Labels {
    class Node {
        int value;
        int label;
        Node(int value, int label) {
            this.value = value;
            this.label = label;
        }
    }
    public int largestValsFromLabels(int[] values, int[] labels, int num_wanted, int use_limit) {
        // key : label
        // Map<Integer, PriorityQueue<Node>> map = new HashMap<>();
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> {
            if (o1.value == o2.value) {
                return o1.label - o2.label;
            }
            return o2.value - o1.value;
        });
        Map<Integer, Integer> limit = new HashMap<>();

        for (int i = 0; i < values.length; i++) {
            if (!limit.containsKey(labels[i])) {
                limit.put(labels[i], 0);
            }
            Node cur = new Node(values[i], labels[i]);
            pq.offer(cur);
        }

        int count = 0;
        int result = 0;
        while (count < num_wanted && !pq.isEmpty()) {
            Node tmp = pq.poll();
            // System.out.println("size : " + pq.size());
            // System.out.println("Polled" + tmp.label + " " + tmp.value);
            if (limit.get(tmp.label) < use_limit) {
                // System.out.println(tmp.label + " " + tmp.value);
                result = result + tmp.value;
                limit.put(tmp.label, limit.get(tmp.label) + 1);
                count++;
            }
        }

        return result;

    }
}

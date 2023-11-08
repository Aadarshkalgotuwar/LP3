import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Node {
    int freq;
    String symbol;
    Node left;
    Node right;
    String huff;

    Node(int freq, String symbol, Node left, Node right) {
        this.freq = freq;
        this.symbol = symbol;
        this.left = left;
        this.right = right;
        this.huff = "";
    }
}

public class HuffmanTree {
    public static void printNodes(Node node, String val) {
        String newVal = val + node.huff;

        if (node.left != null) {
            printNodes(node.left, newVal);
        }
        if (node.right != null) {
            printNodes(node.right, newVal);
        }
        if (node.left == null && node.right == null) {
            System.out.println(node.symbol + " -> " + newVal);
        }
    }

    public static void main(String[] args) {
        String[] chars = { "a", "b", "c", "d", "e", "f", "g" };
        int[] freq = { 4, 7, 12, 14, 17, 43, 54 };
        List<Node> nodes = new ArrayList<>();

        for (int x = 0; x < chars.length; x++) {
            nodes.add(new Node(freq[x], chars[x], null, null));
        }

        while (nodes.size() > 1) {
            Collections.sort(nodes, (a, b) -> Integer.compare(a.freq, b.freq));
            Node left = nodes.get(0);
            Node right = nodes.get(1);
            left.huff = "0";
            right.huff = "1";

            Node newNode = new Node(left.freq + right.freq, left.symbol + right.symbol, left, right);
            nodes.remove(left);
            nodes.remove(right);
            nodes.add(newNode);
        }

        // Huffman Tree is ready!
        printNodes(nodes.get(0), "");
    }
}

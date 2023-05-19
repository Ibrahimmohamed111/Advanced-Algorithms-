Task 1
import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicates {
    public static char[] removeDuplicates(char[] arr) {
        Set<Character> set = new HashSet<>();
        StringBuilder uniqueChars = new StringBuilder();

        for (char c : arr) {
            if (!set.contains(c)) {
                set.add(c);
                uniqueChars.append(c);
            }
        }

        return uniqueChars.toString().toCharArray();
    }

    public static void main(String[] args) {
        char[] arr = {'a', 'b', 'c', 'a', 'd', 'b', 'e', 'c'};
        char[] uniqueArr = removeDuplicates(arr);
        System.out.println(uniqueArr); // Output: abcde
    }
}


Task 2

mport java.util.HashSet;
import java.util.Set;

public class SameSetArrays {
    public static boolean sameSet(int[] arr1, int[] arr2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        // Add all elements from arr1 to set1
        for (int num : arr1) {
            set1.add(num);
        }

        // Add all elements from arr2 to set2
        for (int num : arr2) {
            set2.add(num);
        }

        // Check if the sets have the same elements
        return set1.equals(set2);
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {3, 2, 5, 1, 4};
        boolean result = sameSet(arr1, arr2);
        System.out.println(result); // Output: true
    }
}


Task 3

public class TwoColorDoubleStack<T> {
    private T[] array;
    private int redTop;
    private int blueTop;

    public TwoColorDoubleStack(int capacity) {
        array = (T[]) new Object[capacity];
        redTop = -1;
        blueTop = capacity;
    }

    public void redPush(T item) {
        if (redTop + 1 >= blueTop) {
            throw new IllegalStateException("Stack overflow");
        }
        array[++redTop] = item;
    }

    public T redPop() {
        if (isRedEmpty()) {
            throw new IllegalStateException("Red stack underflow");
        }
        return array[redTop--];
    }

    public boolean isRedEmpty() {
        return redTop == -1;
    }

    public void bluePush(T item) {
        if (blueTop - 1 <= redTop) {
            throw new IllegalStateException("Stack overflow");
        }
        array[--blueTop] = item;
    }

    public T bluePop() {
        if (isBlueEmpty()) {
            throw new IllegalStateException("Blue stack underflow");
        }
        return array[blueTop++];
    }

    public boolean isBlueEmpty() {
        return blueTop == array.length;
    }

    public static void main(String[] args) {
        TwoColorDoubleStack<Integer> stack = new TwoColorDoubleStack<>(5);

        stack.redPush(1);
        stack.bluePush(2);
        stack.redPush(3);
        stack.bluePush(4);
        stack.redPush(5);

        System.out.println(stack.redPop()); // Output: 5
        System.out.println(stack.bluePop()); // Output: 4
    }


    Task 4
    import java.util.ArrayList;
    import java.util.List;
    
    class Job {
        int priority;
        int duration;
    
        public Job(int priority, int duration) {
            this.priority = priority;
            this.duration = duration;
        }
    }
    
    public class CPUScheduler {
        private List<Job> jobs;
        private int currentJobIndex;
    
        public CPUScheduler() {
            jobs = new ArrayList<>();
            currentJobIndex = 0;
        }
    
        public void addJob(Job job) {
            jobs.add(job);
        }
    
        public Job getNextJobFCFS() {
            if (currentJobIndex >= jobs.size()) {
                return null;
            }
    
            Job nextJob = jobs.get(currentJobIndex);
            currentJobIndex++;
            return nextJob;
        }
    
        public Job getNextJobPriority() {
            if (jobs.isEmpty()) {
                return null;
            }
    
            Job highestPriorityJob = jobs.get(0);
            int highestPriority = highestPriorityJob.priority;
    
            for (int i = 1; i < jobs.size(); i++) {
                Job job = jobs.get(i);
                if (job.priority > highestPriority) {
                    highestPriority = job.priority;
                    highestPriorityJob = job;
                }
            }
    
            jobs.remove(highestPriorityJob);
            return highestPriorityJob;
        }
    
        public Job getNextJobSRTF() {
            if (jobs.isEmpty()) {
                return null;
            }
    
            Job shortestRemainingTimeJob = jobs.get(0);
            int shortestRemainingTime = shortestRemainingTimeJob.duration;
    
            for (int i = 1; i < jobs.size(); i++) {
                Job job = jobs.get(i);
                if (job.duration < shortestRemainingTime) {
                    shortestRemainingTime = job.duration;
                    shortestRemainingTimeJob = job;
                }
            }
    
            jobs.remove(shortestRemainingTimeJob);
            return shortestRemainingTimeJob;
        }
    
        public static void main(String[] args) {
            CPUScheduler scheduler = new CPUScheduler();
    
            // Add jobs to the scheduler
            Job job1 = new Job(1, 10);
            Job job2 = new Job(2, 5);
            scheduler.addJob(job1);
            scheduler.addJob(job2);
    
            System.out.println("First Come First Served:");
            Job nextJobFCFS = scheduler.getNextJobFCFS();
            while (nextJobFCFS != null) {
                System.out.println("Processing job with priority " + nextJobFCFS.priority);
                // Perform job processing logic here
                nextJobFCFS = scheduler.getNextJobFCFS();
            }
    
            System.out.println("Highest priority:");
            Job nextJobPriority = scheduler.getNextJobPriority();
            while (nextJobPriority != null) {
                System.out.println("Processing job with priority " + nextJobPriority.priority);
                // Perform job processing logic here
                nextJobPriority = scheduler.getNextJobPriority();
            }
    
            System.out.println("Shortest Remaining Time First:");
            Job nextJobSRTF = scheduler.getNextJobSRTF();
            while (nextJobSRTF != null) {
                System.out.println("Processing job with priority " + nextJobSRTF.priority);
                // Perform job processing logic here
                nextJobSRTF = scheduler.getNextJobSRTF();
            }
        }
    }
    
    

Task 5
import java.util.*;

class Node {
    char data;
    Node left, right;

    Node(char data) {
        this.data = data;
        left = right = null;
    }
}

class ExpressionTree {
    Node root;

    ExpressionTree() {
        root = null;
    }

    Node constructTree(char[] postfix) {
        Stack<Node> stack = new Stack<Node>();

        for (int i = 0; i < postfix.length; i++) {
            if (Character.isLetterOrDigit(postfix[i])) {
                Node node = new Node(postfix[i]);
                stack.push(node);
            } else {
                Node right = stack.pop();
                Node left = stack.pop();
                Node node = new Node(postfix[i]);
                node.left = left;
                node.right = right;
                stack.push(node);
            }
        }
        return stack.pop();
    }

    void inorder(Node node) {
        if (node != null) {
            inorder(node.left);
            System.out.print(node.data + " ");
            inorder(node.right);
        }
    }

    void updateLeaf(Node node, char variable, int value) {
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null && node.data == variable) {
            node.data = (char) (value + '0');
        }
        updateLeaf(node.left, variable, value);
        updateLeaf(node.right, variable, value);
    }

    int evaluate(Node node) {
        if (node == null) {
            return 0;
        }
        if (node.left == null && node.right == null) {
            return node.data - '0';
        }
        int leftValue = evaluate(node.left);
        int rightValue = evaluate(node.right);
        switch (node.data) {
            case '+':
                return leftValue + rightValue;
            case '-':
                return leftValue - rightValue;
            case '*':
                return leftValue * rightValue;
            case '/':
                return leftValue / rightValue;
        }
        return 0;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a fully parenthesized arithmetic expression: ");
        String expression = scanner.nextLine();
        char[] postfix = expression.toCharArray();
        ExpressionTree tree = new ExpressionTree();
        tree.root = tree.constructTree(postfix);
        System.out.print("Inorder traversal of the expression tree: ");
        tree.inorder(tree.root);
        System.out.println();
        System.out.print("Enter a variable to update (or 0 to exit): ");
        char variable = scanner.next().charAt(0);
        while (variable != '0') {
            System.out.print("Enter a value for " + variable + ": ");
            int value = scanner.nextInt();
            tree.updateLeaf(tree.root, variable, value);
            System.out.print("Inorder traversal of the updated expression tree: ");
            tree.inorder(tree.root);
            System.out.println();
            System.out.print("Enter a variable to update (or 0 to exit): ");
            variable = scanner.next().charAt(0);
        }
        System.out.println("Value of the root of the expression tree: " + tree.evaluate(tree.root));
    }
}



Task 6
import java.util.*;

class SpellChecker {
    Set<String> lexicon;

    SpellChecker(Set<String> lexicon) {
        this.lexicon = lexicon;
    }

    List<String> check(String s) {
        List<String> result = new ArrayList<String>();
        if (lexicon.contains(s)) {
            result.add(s);
            return result;
        }
        for (int i = 0; i < s.length(); i++) {
            for (char c = 'a'; c <= 'z'; c++) {
                String candidate = s.substring(0, i) + c + s.substring(i + 1);
                if (lexicon.contains(candidate)) {
                    result.add(candidate);
                }
            }
        }
        for (int i = 0; i < s.length() - 1; i++) {
            String candidate = s.substring(0, i) + s.charAt(i + 1) + s.charAt(i) + s.substring(i + 2);
            if (lexicon.contains(candidate)) {
                result.add(candidate);
            }
        }
        for (int i = 0; i < s.length(); i++) {
            for (char c = 'a'; c <= 'z'; c++) {
                String candidate = s.substring(0, i) + c + s.substring(i + 1);
                if (lexicon.contains(candidate)) {
                    result.add(candidate);
                }
                for (char d = 'a'; d <= 'z'; d++) {
                    if (c != d) {
                        candidate = s.substring(0, i) + d + s.substring(i + 1);
                        if (lexicon.contains(candidate)) {
                            result.add(candidate);
                        }
                    }
                }
            }
        }
        return result;
    }
}

public class Main {
    public static void main(String[] args) {
        Set<String> lexicon = new HashSet<String>();
        lexicon.add("hello");
        lexicon.add("world");
        lexicon.add("java");
        SpellChecker spellChecker = new SpellChecker(lexicon);
        System.out.println(spellChecker.check("helo"));
        System.out.println(spellChecker.check("wrold"));
        System.out.println(spellChecker.check("jaba"));
    }
}

Task 7
import java.util.*;

public class Main {
    public static void main(String[] args) {
        int[] arr = { 3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5 };
        heapsort(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void heapsort(int[] arr) {
        int n = arr.length;
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }
        for (int i = n - 1; i >= 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            heapify(arr, i, 0);
        }
    }

    static void heapify(int[] arr, int n, int i) {
        int smallest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        if (left < n && arr[left] < arr[smallest]) {
            smallest = left;
        }
        if (right < n && arr[right] < arr[smallest]) {
            smallest = right;
        }
        if (smallest != i) {
            int temp = arr[i];
            arr[i] = arr[smallest];
            arr[smallest] = temp;
            heapify(arr, n, smallest);
        }
    }
}


Task 8
import java.util.*;

class Node {
    char address;
    Map<Node, Integer> neighbors;
    Map<Node, Node> routingTable;

    Node(char address) {
        this.address = address;
        neighbors = new HashMap<Node, Integer>();
        routingTable = new HashMap<Node, Node>();
    }

    void addNeighbor(Node neighbor, int distance) {
        neighbors.put(neighbor, distance);
        routingTable.put(neighbor, neighbor);
    }

    void updateRoutingTable() {
        Set<Node> visited = new HashSet<Node>();
        visited.add(this);
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(this);
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            for (Node neighbor : current.neighbors.keySet()) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
                int distance = current.neighbors.get(neighbor);
                if (distance + 1 < neighbors.getOrDefault(neighbor, Integer.MAX_VALUE)) {
                    neighbors.put(neighbor, distance + 1);
                    routingTable.put(neighbor, routingTable.get(current));
                }
            }
        }
    }

    void printRoutingTable() {
        System.out.println("Routing table for node " + address + ":");
        for (Node destination : routingTable.keySet()) {
            System.out.println(destination.address + " " + routingTable.get(destination).address);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Node a = new Node('A');
        Node b = new Node('B');
        Node c = new Node('C');
        Node d = new Node('D');
        a.addNeighbor(b, 1);
        a.addNeighbor(c, 1);
        a.addNeighbor(d, 1);
        b.addNeighbor(a, 1);
        b.addNeighbor(c, 1);
        c.addNeighbor(a, 1);
        c.addNeighbor(b, 1);
        d.addNeighbor(a, 1);
        a.updateRoutingTable();
        b.updateRoutingTable();
        c.updateRoutingTable();
        d.updateRoutingTable();
        a.printRoutingTable();
        b.printRoutingTable();
        c.printRoutingTable();
        d.printRoutingTable();
    }
}

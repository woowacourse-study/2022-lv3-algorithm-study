import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Pair implements Comparable<Pair> {
    int age;
    int order;
    String name;

    public Pair(int age, int order, String name) {
        this.age = age;
        this.order = order;
        this.name = name;
    }

    @Override
    public int compareTo(Pair other) {
        if (age == other.age) {
            return order - other.order;
        }
        return age - other.age;
    }

    @Override
    public String toString() {
        return age + " " + name;
    }
}

public class josh_java_10814 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        List<Pair> pairs = new ArrayList<>();
        for (int order = 0; order<num; ++order) {
            String[] inputs = br.readLine().split(" ");
            int age = Integer.parseInt(inputs[0]);
            String name = inputs[1];
            pairs.add(new Pair(age, order, name));
        }
        Collections.sort(pairs);
        for (Pair pair : pairs) {
            System.out.println(pair);
        }
    }
}

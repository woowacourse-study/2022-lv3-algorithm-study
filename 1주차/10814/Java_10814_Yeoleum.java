import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Main {

    final static BufferedReader r = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        final int n = Integer.parseInt(r.readLine());

        List<User> users = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(r.readLine(), " ");
            final int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            users.add(new User(age, name));
        }

        final List<User> sortedUsers = users.stream()
                .sorted(Comparator.comparingInt(User::getAge))
                .collect(Collectors.toList());

        sortedUsers.forEach(user -> System.out.println(user.age + " " + user.name));
    }

    public static class User {
        private int age;
        private String name;

        public User(int age, String name) {
            validateAge(age);
            validateName(name);
            this.age = age;
            this.name = name;
        }

        private void validateAge(int age) {
            if( age < 1 || age > 200){
                throw new IllegalArgumentException("나이");
            }
        }

        private void validateName(String name){
            if( !Pattern.matches("^[a-zA-Z]*$", name)){
                throw new IllegalArgumentException("이름 대소문자");
            }

            if(name.length() > 100){
                throw new IllegalArgumentException("이름 길이");
            }
        }


        public int getAge() {
            return age;
        }

        public String getName() {
            return name;
        }
    }

}

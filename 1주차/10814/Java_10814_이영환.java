import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final MemberCount memberCount = new MemberCount(Integer.parseInt(scanner.nextLine()));

        final List<Member> members = new ArrayList<>();
        for (int i = 0; i < memberCount.getValue(); i++) {
            final String[] rawMemberInput = scanner.nextLine().split("\\s+");
            final Member member = Member.of(rawMemberInput[0], rawMemberInput[1]);
            members.add(member);
        }

        final List<Member> sortedMembers = members.stream()
                .sorted(Comparator.comparingInt(Member::getAge))
                .collect(Collectors.toList());

        sortedMembers.forEach(member -> System.out.println(member.getMemberInfo()));
    }

    private static class MemberCount {

        private static final int MIN_VALUE = 1;
        private static final int MAX_VALUE = 100_000;

        private final int value;

        public MemberCount(final int value) {
            validateValue(value);
            this.value = value;
        }

        private void validateValue(final int value) {
            if (!isValidMemberCount(value)) {
                throw new IllegalArgumentException("가입자 수 입력 오류! memberCount = " + value);
            }
        }

        private boolean isValidMemberCount(final int value) {
            return value >= MIN_VALUE && value <= MAX_VALUE;
        }

        public int getValue() {
            return value;
        }
    }

    private static class Member {

        private final Age age;
        private final Name name;

        private Member(final Age age, final Name name) {
            this.age = age;
            this.name = name;
        }

        public static Member of(final String rawAge, final String rawName) {
            return new Member(Age.of(rawAge), new Name(rawName));
        }

        public int getAge() {
            return age.getValue();
        }

        public String getMemberInfo() {
            return age.getValue() + " " + name.getValue();
        }
    }

    private static class Age {

        private static final int MIN_AGE = 1;
        private static final int MAX_AGE = 200;

        private final int value;

        private Age(final int value) {
            validateAge(value);
            this.value = value;
        }

        public static Age of(final String rawAge) {
            return new Age(Integer.parseInt(rawAge));
        }

        private void validateAge(final int value) {
            if (!isValidAge(value)) {
                throw new IllegalArgumentException("나이 오류! age = " + value);
            }
        }

        private boolean isValidAge(final int value) {
            return value >= MIN_AGE && value <= MAX_AGE;
        }

        public int getValue() {
            return value;
        }
    }

    private static class Name {

        private final String value;

        public Name(final String value) {
            validateName(value);
            this.value = value;
        }

        private void validateName(final String name) {
            for (int i = 0; i < name.length(); i++) {
                final char c = name.charAt(i);
                if (!isValidAlphabet(c)) {
                    throw new IllegalArgumentException("잘못된 이름입니다! name = " +  name);
                }
            }
        }

        private boolean isValidAlphabet(final char c) {
            return isUpperCase(c) || isLowerCase(c);
        }

        private boolean isLowerCase(final char c) {
            return c >= 97 && c <= 122;
        }

        private boolean isUpperCase(final char c) {
            return c >= 65 && c <= 90;
        }

        public String getValue() {
            return value;
        }
    }
}

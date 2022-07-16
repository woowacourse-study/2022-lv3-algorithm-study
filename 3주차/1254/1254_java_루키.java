public class 1254_java_루키 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String str = st.nextToken();

        int cnt = 0;
        int left = 0;
        while (true) {
            boolean flag = isPalindrome(left, str.length() - 1, str.toCharArray());
            if (flag) {
                cnt = left + str.length();
                break;
            }
            left++;
        }
        System.out.println(cnt);
    }

    public static boolean isPalindrome(int left, int right, char[] arr) {
        while (left < right) {
            if (arr[left] != arr[right]) {
                break;
            }
            left++;
            right--;
        }

        if (left >= right) {
            return true;
        }
        return false;
    }
}

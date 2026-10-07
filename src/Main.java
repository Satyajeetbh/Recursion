//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        int ans = fact(5);
        System.out.println(ans); 
    }
    static int fact(int n) {
        if (n<=1) {
            return 1;
        }
        return n* fact(n-1);
    }
}
public class JosephusProblem {

    public static int josephus(int n, int m) {
        if (n == 1) {
            return 1;
        } else {
            return (josephus(n - 1, m) + m - 1) % n + 1;
        }
    }

    public static void main(String[] args) {
        int n = 7; // Anzahl der Personen im Kreis
        int m = 155; // Personen, die übersprungen werden

        int safePosition = josephus(n, m);
        System.out.println("Die sicherste Position ist: " + safePosition);
    }
}

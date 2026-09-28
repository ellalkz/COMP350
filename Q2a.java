public class Q2a {
    public static void main(String[] args) {
        double p = 2.0 * Math.sqrt(2.0);

        for (int n = 2; n <= 34; n++) {
            double power = Math.pow(2.0, n);

            p = power * Math.sqrt(
                    2.0 * (
                            1.0 - Math.sqrt(
                                    1.0 - Math.pow(p / power, 2)
                            )
                    )
            );

            System.out.printf("p_%d = %.16f%n", n + 1, p);
        }
    }
}

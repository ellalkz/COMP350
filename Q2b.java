public class Q2b {
    public static void main(String[] args) {
        double p = 2.0 * Math.sqrt(2.0);
        double s = Math.pow(2.0, 2);

        for (int n = 2; n <= 34; n++) {
            double t = p / s;

            p = p * Math.sqrt(
                    2.0 / (
                            1.0 + Math.sqrt(1.0 - t * t)
                    )
            );

            System.out.printf("p_%d = %.16f%n", n + 1, p);

            s = 2.0 * s;
        }
    }
}

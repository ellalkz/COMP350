public class Q1b {
    public static void main(String[] args) {
        float p = 0.1f;
        int k = 200;
        int N = 2000;

        float B = (float) Math.pow(2, 100);
        float S = 1.0f / B;

        int I = 0;
        float X = 1.0f;

        // Compute N(N-1)...(N-k+1)
        for (int j = 1; j <= k; j++) {
            X = X * (N + 1 - j);

            // Check for overflow
            if (X > B) {
                X = X / B;
                I = I + 1;
            }
        }

        // Divide by k!
        for (int j = 1; j <= k; j++) {
            X = X / j;

            // Check for underflow
            if (X < S) {
                X = X * B;
                I = I - 1;
            }
        }

        // Multiply by p^k
        for (int j = 1; j <= k; j++) {
            X = X * p;

            // Check for underflow
            if (X < S) {
                X = X * B;
                I = I - 1;
            }
        }

        float q = 1.0f - p;

        // Multiply by (1-p)^(N-k)
        for (int j = k + 1; j <= N; j++) {
            X = X * q;

            // Check for underflow
            if (X < S) {
                X = X * B;
                I = I - 1;
            }
        }

        // Recover the true value
        float result = X * (float) Math.pow(B, I);

        System.out.printf("%.8e%n", result);
    }
}

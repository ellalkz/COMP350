public class Q1a {
    public static void main(String[] args) {
        float p = 0.1f;   // probability p
        int k = 200;      // number of successes
        int N = 2000;     // total number of trials

        float X = 1.0f;

        // Compute N(N-1)...(N-k+1)
        for (int j = 1; j <= k; j++) {
            X = X * (N + 1 - j);
        }

        // Divide by k! = 1*2*...*k
        for (int j = 1; j <= k; j++) {
            X = X / j;
        }

        // Multiply by p^k
        for (int j = 1; j <= k; j++) {
            X = X * p;
        }

        float q = 1.0f - p;

        // Multiply by (1-p)^(N-k)
        for (int j = k + 1; j <= N; j++) {
            X = X * q;
        }

        System.out.println(X);
    }
}

package StringArray;

public class LicenseKeyFormatting {
    public static void main(String[] args) {
        String S = "5F3Z-2e-9-w";
        int K = 4;
//		String S = "2-5g-3-J";
//        int K = 2;

        System.out.println(licenseKeyFormatting(S, K));
    }

    /**
     * @param S: a string
     * @param K: a integer
     * @return: return a string
     */
    private static String licenseKeyFormatting(String S, int K) {
        S = S.replace("-", "");
        S = S.toUpperCase();

        System.out.println("S : " + S);

        int size = S.length();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i<size; i++){
            sb.append(S.charAt(i));
        }

        for (int i = K; i<size; i=i+K){
            sb.insert(size-i, "-");
        }

        return String.valueOf(sb);
    }
}

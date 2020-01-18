package StringArray;

import java.util.HashSet;
import java.util.Set;

public class UniqueEmailAddress {
    public static void main(String[] args) {
        String[] emails = {"test.email+alex@leetcode.com", "test.e.mail+bob.cathy@leetcode.com", "testemail+david@lee.tcode.com"};
        System.out.println(numUniqueEmails(emails));
    }

    /**
     * @param emails: list of non-unique email address list
     * @return: how many of the unique email address
     */
    public static int numUniqueEmails(String[] emails) {
        Set<String> setEmail = new HashSet<>();

        for (String email:emails){
            String[] parts = email.split("@");
            String[] local = parts[0].split("\\+");
            local[0] = local[0].replace(".", "");

            setEmail.add(local[0] + "@" + parts[1]);
        }

        return setEmail.size();
    }
}

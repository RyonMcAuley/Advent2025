public class Day2 {

    // private static long idSum = 0;
    private static long part2Sum = 0;

    public static void main(String[] args) {
        String input = "853-1994,1919078809-1919280414,1212082623-1212155811,2389-4173,863031-957102,9393261874-9393318257,541406-571080,1207634-1357714,36706-61095,6969667126-6969740758,761827-786237,5516637-5602471,211490-235924,282259781-282327082,587606-694322,960371-1022108,246136-353607,3-20,99-182,166156087-166181497,422-815,82805006-82876926,14165-30447,4775-7265,83298136-83428425,2439997-2463364,44-89,435793-511395,3291059-3440895,77768624-77786844,186-295,62668-105646,7490-11616,23-41,22951285-23017127";
        // String input = "22951285-23017127";
        // String input = "11-22,95-115";

        for (String s : input.split(",")) {
            loop(s);
        }

        System.out.println("Total: " + part2Sum);
    }

    private static void loop(String nums) {

        // System.out.println("Nums : " + nums);
        long startValue = Long.parseLong(nums.substring(0, nums.indexOf('-')).trim());
        long endValue = Long.parseLong(nums.substring(nums.indexOf('-') + 1).trim());

        // System.out.println("Starting: " + startValue);
        // System.out.println("Until: " + endValue);
        for (long i = startValue; i <= endValue; i++) {
            // if (dupePart1(i))
            // idSum += i;
            if (isInvalidId(i))
                part2Sum += i;
        }
    }

    private static boolean dupePart1(long checking) {
        String check = Long.toString(checking);

        // check half
        String first = check.substring(0, check.length() / 2);
        String second = check.substring(check.length() / 2);

        if (first.equals(second))
            return true;

        return false;
    }

    private static boolean isInvalidId(long checking) {
        String check = Long.toString(checking);
        int n = check.length();
        for (int k = 1; k <= check.length() / 2; k++) {
            if (n % k != 0)
                continue;

            String pattern = check.substring(0, k);
            int repeats = n / k;

            StringBuilder rebuilt = new StringBuilder();
            for (int j = 0; j < repeats; j++) {
                rebuilt.append(pattern);
            }

            if (rebuilt.toString().equals(check)) {
                return true;
            }
        }
        return false;
    }
}

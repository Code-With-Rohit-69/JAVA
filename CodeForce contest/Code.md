# Two Strings are Equal

`````

        String s1 = "aakima", s2 = "makima";
        int m = s1.length();
        int n = s2.length();

        if (m != n) {
            System.out.println("No");
        }

        int[] freq1 = new int[26];
        int[] freq2 = new int[26];

        for (int i = 0; i < m; i++) {
            freq1[s1.charAt(i) - 'a']++;
            freq2[s2.charAt(i) - 'a']++;
        }

        boolean isValid = true;

        for (int i = 0; i < 26; i++) {
            if (freq1[i] != freq2[i]) {
                isValid = false;
                break;
            }
        }

        if (isValid) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }

`````

package pl.edu.agh.dronka.shop.model.categories;

public enum GatunekMuzyki {
    HIPHOP("HIPHOP"), ROCK("ROCK");

    private String displayName;

    public String getDisplayName() {
        return displayName;
    }

    GatunekMuzyki(String displayName) {
        this.displayName = displayName;
    }

    public static GatunekMuzyki parseGatunekMuzyki(String gatunek){
        if(stringCompare(gatunek,"HIPHOP"))return HIPHOP;
        if(stringCompare(gatunek,"ROCK"))return ROCK;
        return null;
    }

    private static boolean stringCompare(String str1, String str2)
    {

        int l1 = str1.length();
        int l2 = str2.length();
        int lmin = Math.min(l1, l2);

        for (int i = 0; i < lmin; i++) {
            int str1_ch = (int)str1.charAt(i);
            int str2_ch = (int)str2.charAt(i);

            if (str1_ch != str2_ch) {
                return false;
            }
        }
        if (l1 != l2) {
            return false;
        }

        else {
            return true;
        }
    }
}

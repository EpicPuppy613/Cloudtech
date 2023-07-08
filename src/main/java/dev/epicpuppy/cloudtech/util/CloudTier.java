package dev.epicpuppy.cloudtech.util;

public enum CloudTier {
    T0("t0", "#ffffff", 16777215, "white", 0), T1("t1", "#BFBFBF", 12566463, "light_gray", 1),
    T2("t2", "#808080", 8421504, "gray", 2), T3("t3", "#D92C26", 14232614, "red", 3),
    T4("t4", "#F97306", 16347910, "orange", 4), T5("t5", "#FAC31E", 16433950, "yellow", 5),
    T6("t6", "#7DD411", 8246289, "lime", 6), T7("t7", "#4D8217", 5079575, "green", 7),
    T8("t8", "#0D98A5", 891045, "cyan", 8), T9("t9", "#3CCFDD", 3985373, "light_blue", 9),
    T10("t10", "#3359CC", 3365324, "blue", 10), T11("t11", "#7322C3", 7545539, "purple", 11),
    T12("t12", "#CB4DCB", 13323723, "magenta", 12), T13("t13", "#EC799F", 15497631, "pink", 13),
    T14("t14", "#86522D", 8802861, "brown", 14), T15("t15", "#404040", 4210752, "black", 15);

    //"#ffffff", "#b2b2b2",
    //"#666666", "#252525",
    //"#D92C26", "#F97306",
    //"#FAC31E", "#7DD411",
    //"#4D8217", "#0D98A5",
    //"#3CCFDD", "#3359CC",
    //"#7322C3", "#CB4DCB",
    //"#EC799F", "#86522D"

    public final String tierName;
    public final String hexColor;
    public final int intColor;
    public final String colorName;
    public final int tierMagnitude;

    CloudTier(String pName, String pColor, int tColor, String colorName, int magnitude) {
        this.tierName = pName;
        this.hexColor = pColor;
        this.intColor = tColor;
        this.colorName = colorName;
        this.tierMagnitude = magnitude;
    }
}

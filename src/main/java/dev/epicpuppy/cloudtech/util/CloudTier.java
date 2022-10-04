package dev.epicpuppy.cloudtech.util;

public enum CloudTier {
    T0("t0", "#ffffff", 16777215), T1("t1", "#BFBFBF", 12566463),
    T2("t2", "#808080", 8421504), T3("t3", "#D92C26", 14232614),
    T4("t4", "#F97306", 16347910), T5("t5", "#FAC31E", 16433950),
    T6("t6", "#7DD411", 8246289), T7("t7", "#4D8217", 5079575),
    T8("t8", "#0D98A5", 891045), T9("t9", "#3CCFDD", 3985373),
    T10("t10", "#3359CC", 3365324), T11("t11", "#7322C3", 7545539),
    T12("t12", "#CB4DCB", 13323723), T13("t13", "#EC799F", 15497631),
    T14("t14", "#86522D", 8802861), T15("t15", "#404040", 4210752);

    //"#ffffff", "#b2b2b2",
    //"#666666", "#252525",
    //"#D92C26", "#F97306",
    //"#FAC31E", "#7DD411",
    //"#4D8217", "#0D98A5",
    //"#3CCFDD", "#3359CC",
    //"#7322C3", "#CB4DCB",
    //"#EC799F", "#86522D"

    public final String pName;
    public final String pColor;
    public final int tColor;

    private CloudTier(String pName, String pColor, int tColor) {
        this.pName = pName;
        this.pColor = pColor;
        this.tColor = tColor;
    }
}

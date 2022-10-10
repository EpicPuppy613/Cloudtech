const fs = require('fs')

const COLORS = [
    "white", "light_gray", "gray", "black", "red", "orange", "yellow", "lime",
    "green", "cyan", "light_blue", "blue", "purple", "magenta", "pink", "brown"];

const COLORS_NAME = [
    "White", "Light Gray", "Gray", "Black", "Red", "Orange", "Yellow", "Lime",
    "Green", "Cyan", "Light Blue", "Blue", "Purple", "Magenta", "Pink", "Brown"
]

const langfile = fs.readFileSync("en_us_prev.json");
const lang = JSON.parse(langfile);

for (var c = 0; c < COLORS.length; c++) {
    lang["item.cloudtech." + COLORS[c] + "_cloud_helmet"] = COLORS_NAME[c] + " Cloud Helmet";
    lang["item.cloudtech." + COLORS[c] + "_cloud_chestplate"] = COLORS_NAME[c] + " Cloud Chestplate";
    lang["item.cloudtech." + COLORS[c] + "_cloud_leggings"] = COLORS_NAME[c] + " Cloud Leggings";
    lang["item.cloudtech." + COLORS[c] + "_cloud_boots"] = COLORS_NAME[c] + " Cloud Boots";
}

fs.writeFileSync("en_us.json", JSON.stringify(lang, null, 4));
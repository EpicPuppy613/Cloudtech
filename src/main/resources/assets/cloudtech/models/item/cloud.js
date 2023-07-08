const fs = require("fs");
const COLORS = [
    "white", "light_gray", "gray", "black", "red", "orange", "yellow", "lime",
    "green", "cyan", "light_blue", "blue", "purple", "magenta", "pink", "brown"];

const HEX = [
    "#ffffff", "#b2b2b2", "#666666", "#252525",
    "#A12722", "#F17613", "#F9C628", "#70B919",
    "#556D1B", "#158A92", "#3AAFDA", "#35399E",
    "#792AAC", "#BE44B4", "#ED8DAD", "#724728"
]

for (const color of COLORS) {
    fs.writeFileSync(color + "_cloud_solidifier.json", fs.readFileSync("white_cloud_solidifier.json"));
}
const fs = require('fs');

const COLORS = [
    "white", "light_gray", "gray", "black", "red", "orange", "yellow", "lime",
    "green", "cyan", "light_blue", "blue", "purple", "magenta", "pink", "brown"];

for (const color of COLORS) {
    fs.writeFileSync(color + "_layer_1.png", fs.readFileSync("white_cloud_armor_1.png"));
    fs.writeFileSync(color + "_layer_2.png", fs.readFileSync("white_cloud_armor_2.png"));
}
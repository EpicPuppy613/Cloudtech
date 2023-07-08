const fs = require('fs');
const COLORS = [
    "white", "light_gray", "gray", "black", "red", "orange", "yellow", "lime",
    "green", "cyan", "light_blue", "blue", "purple", "magenta", "pink", "brown"];

const lang = JSON.parse(fs.readFileSync('en_us.json'));

for (const color of COLORS) {
    lang["item.cloudtech." + color + "_cloud_sword"] = color[0].toUpperCase() + color.slice(1) + " Cloud Sword";
    lang["item.cloudtech." + color + "_cloud_pickaxe"] = color[0].toUpperCase() + color.slice(1) + " Cloud Pickaxe";
    lang["item.cloudtech." + color + "_cloud_axe"] = color[0].toUpperCase() + color.slice(1) + " Cloud Axe";
    lang["item.cloudtech." + color + "_cloud_shovel"] = color[0].toUpperCase() + color.slice(1) + " Cloud Shovel";
    lang["item.cloudtech." + color + "_cloud_hoe"] = color[0].toUpperCase() + color.slice(1) + " Cloud Hoe";
}


const COLORS = [
    "white", "light_gray", "gray", "black", "red", "orange", "yellow", "lime",
    "green", "cyan", "light_blue", "blue", "purple", "magenta", "pink", "brown"];
const fs = require('fs');


for (const color of COLORS) {
    const loot = JSON.parse(fs.readFileSync("white_cloud_block.json"));
    loot.pools[0].entries[0].children[0].name = "cloudtech:" + color + "_cloud_block";
    loot.pools[0].entries[0].children[1].name = "cloudtech:" + color + "_cloud";
    fs.writeFileSync(color + "_cloud_block.json", JSON.stringify(loot, null, 2));
}
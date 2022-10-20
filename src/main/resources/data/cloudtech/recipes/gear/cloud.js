const fs = require('fs');
const COLORS = [
    "white", "light_gray", "gray", "red", "orange", "yellow", "lime",
    "green", "cyan", "light_blue", "blue", "purple", "magenta", "pink", "brown", "black"];

for (let i = 1; i < COLORS.length; i++) {
    let recipe = {};
    recipe.type = "minecraft:smithing";
    recipe.base = {item: "cloudtech:" + COLORS[i-1] + "_cloud_sword"};
    recipe.addition = {item: "cloudtech:" + COLORS[i] + "_cloud_core"};
    recipe.result = {item: "cloudtech:" + COLORS[i] + "_cloud_sword"};
    fs.writeFileSync("..\\gear\\" + COLORS[i] + "_cloud_sword.json", JSON.stringify(recipe, null, 4));
}
const fs = require('fs');
const COLORS = [
    "white", "light_gray", "gray", "red", "orange", "yellow", "lime",
    "green", "cyan", "light_blue", "blue", "purple", "magenta", "pink", "brown", "black"];

for (let i = 1; i < COLORS.length; i++) {
    let recipe = {};
    recipe.type = "minecraft:crafting_shaped";
    recipe.pattern = ["xx","xx"]
    recipe.key = {};
    recipe.key.x = {item:"cloudtech:"+COLORS[i]+"_solid_cloud"};
    recipe.result = {item: "cloudtech:" + COLORS[i] + "_solid_cloud_bricks",count:4};
    fs.writeFileSync(COLORS[i] + "_solid_cloud_bricks.json", JSON.stringify(recipe, null, 4));
}
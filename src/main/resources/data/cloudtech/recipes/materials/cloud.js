const fs = require('fs');
const COLORS = [
    "white", "light_gray", "gray", "red", "orange", "yellow", "lime",
    "green", "cyan", "light_blue", "blue", "purple", "magenta", "pink", "brown", "black"];

for (let i = 1; i < COLORS.length; i++) {
    let recipe = {};
    recipe.type = "minecraft:crafting_shaped";
    recipe.pattern = ["xxx","yxz","xxx"]
    recipe.key = {};
    recipe.key.x = {item:"cloudtech:"+COLORS[i]+"_cloud_ingot"};
    recipe.key.y = {item:"cloudtech:"+COLORS[i]+"_cloud_core"};
    recipe.key.z = {item:"cloudtech:"+COLORS[i-1]+"_cloud_frame"};
    recipe.result = {item: "cloudtech:" + COLORS[i] + "_cloud_frame"};
    fs.writeFileSync(COLORS[i] + "_cloud_frame.json", JSON.stringify(recipe, null, 4));
}
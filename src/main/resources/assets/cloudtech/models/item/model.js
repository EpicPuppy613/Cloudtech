const COLORS = [
    "white", "light_gray", "gray", "black", "red", "orange", "yellow", "lime",
    "green", "cyan", "light_blue", "blue", "purple", "magenta", "pink", "brown"];
const fs = require('fs');


for (const color of COLORS) {
    var model = {};
    model.parent = "item/generated";
    model.textures = {};
    model.textures.layer0 = "cloudtech:item/" + color + "_cloud";
    fs.writeFileSync(color + "_cloud.json", JSON.stringify(model, null, 4));
}
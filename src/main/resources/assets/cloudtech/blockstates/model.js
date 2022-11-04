const COLORS = [
    "white", "light_gray", "gray", "black", "red", "orange", "yellow", "lime",
    "green", "cyan", "light_blue", "blue", "purple", "magenta", "pink", "brown"];

const fs = require('fs');

for (const color of COLORS) {
    var model = {};
    model.variants = {};
    model.variants[""] = {};
    model.variants[""].model = "cloudtech:block/" + color + "_cloud_frame";
    fs.writeFileSync(color + "_cloud_frame.json", JSON.stringify(model, null, 4));
}
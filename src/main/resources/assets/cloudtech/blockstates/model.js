const COLORS = [
    "white", "light_gray", "gray", "black", "red", "orange", "yellow", "lime",
    "green", "cyan", "light_blue", "blue", "purple", "magenta", "pink", "brown"];

const fs = require('fs');

for (const color of COLORS) {
    var model = {};
    model.variants = {};
    model.variants["facing=north"] = {};
    model.variants["facing=north"].model = "cloudtech:block/" + color + "_cloud_solidifier";
    model.variants["facing=south"] = {};
    model.variants["facing=south"].model = "cloudtech:block/" + color + "_cloud_solidifier";
    model.variants["facing=south"].y = 180;
    model.variants["facing=east"] = {};
    model.variants["facing=east"].model = "cloudtech:block/" + color + "_cloud_solidifier";
    model.variants["facing=east"].y = 90;
    model.variants["facing=west"] = {};
    model.variants["facing=west"].model = "cloudtech:block/" + color + "_cloud_solidifier";
    model.variants["facing=west"].y = 270;
    fs.writeFileSync(color + "_cloud_solidifier.json", JSON.stringify(model, null, 4));
}
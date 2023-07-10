const COLORS = [
    "white", "light_gray", "gray", "black", "red", "orange", "yellow", "lime",
    "green", "cyan", "light_blue", "blue", "purple", "magenta", "pink", "brown"];
const fs = require('fs');


for (const color of COLORS) {
    const model = {};
    model.type = "minecraft:block";
    model.pools = [];
    model.pools.push({});
    model.pools[0].rolls = 1;
    model.pools[0].bonus_rolls = 0;
    model.pools[0].entries = [];
    model.pools[0].entries.push({});
    model.pools[0].entries[0].type = "minecraft:item";
    model.pools[0].entries[0].name = "cloudtech:" + color + "_cloud_solidifier";
    model.pools[0].conditions = [];
    model.pools[0].conditions.push({});
    model.pools[0].conditions[0].condition = "minecraft:survives_explosion";
    fs.writeFileSync(color + "_cloud_solidifier.json", JSON.stringify(model, null, 4));
}
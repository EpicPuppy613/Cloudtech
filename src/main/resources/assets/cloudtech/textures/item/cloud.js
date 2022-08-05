const canvas = require('canvas');
const fs = require("fs");
const draw = canvas.createCanvas(16, 16);
const ctx = draw.getContext('2d');
const COLORS = [
    "white", "light_gray", "gray", "black", "red", "orange", "yellow", "lime",
    "green", "cyan", "light_blue", "blue", "purple", "magenta", "pink", "brown"];

const HEX = [
    "#ffffff", "#b2b2b2", "#666666", "#252525",
    "#A12722", "#F17613", "#F9C628", "#70B919",
    "#556D1B", "#158A92", "#3AAFDA", "#35399E",
    "#792AAC", "#BE44B4", "#ED8DAD", "#724728"
]

for (let c = 0; c < COLORS.length; c++) {
    ctx.clearRect(0, 0, 16, 16);
    ctx.drawImage("white_cloud.png", 0, 0);
    ctx.globalCompositeOperation = "multiply";
    ctx.fillStlye = HEX[c];
    ctx.fillRect(0, 0, 16, 16);
    fs.writeFileSync(COLORS[c] + "_cloud.png", draw.toBuffer());
    ctx.globalCompositeOperation = "source-over";
}
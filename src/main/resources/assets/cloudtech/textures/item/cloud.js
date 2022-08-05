const canvas = require('canvas');
const process = require('process');
const path = require('path');
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

const dir = path.relative(process.cwd(), __dirname);
const image = new Image();
image.src = dir + "/white_cloud.png";
image.onload = function () {
    for (let c = 0; c < COLORS.length; c++) {
        ctx.clearRect(0, 0, 16, 16);
        ctx.drawImage(image, 0, 0);
        ctx.globalCompositeOperation = "multiply";
        ctx.fillStlye = HEX[c];
        ctx.fillRect(0, 0, 16, 16);
        fs.writeFileSync(dir +"/" + COLORS[c] + "_cloud.png", draw.toBuffer());
        ctx.globalCompositeOperation = "source-over";
    }
}
const fs = require('fs');
const canvas = require('canvas');

const draw = canvas.createCanvas(16, 16);
const color = canvas.createCanvas(16, 16);
/** @type {CanvasRenderingContext2D} */
const dtx = draw.getContext('2d');
/** @type {CanvasRenderingContext2D} */
const ctx = color.getContext('2d');

//load images

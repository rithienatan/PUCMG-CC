param a;
param b;

var x >= 0;
var y >= 0;

minimize F: 50*(((cos(0.15*3.14*(x-a))+1)/(2+0.0025*(x-a)^2)) + ((cos(0.15*3.14*(y-b))+1)/(2+0.0025*(y-b)^2)));
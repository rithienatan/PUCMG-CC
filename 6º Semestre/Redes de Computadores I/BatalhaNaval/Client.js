/*---------- Imports ----------*/
import net from 'net';


/*---------- Handle with arguments ----------*/
let IP = process.argv[2];
let PORT = process.argv[3];


/*---------- Setup Connection With Server ----------*/
const client = net.createConnection({ port: PORT, host: IP }, () => {
    console.log('connected to server!');
});

client.on('data', (data) => {
    console.log(data.toString());
    client.end();
});

client.on('end', () => {
    console.log('disconnected from server!');
});
/*
const client = net.connect({port: PORT}, () => {
    console.log('connect to server!');
});

client.on('data', (data) => {
    console.log(data.toString());
    client.end();
});

client.on('end', () => {
    console.log('disconnected from server!');
});
*/
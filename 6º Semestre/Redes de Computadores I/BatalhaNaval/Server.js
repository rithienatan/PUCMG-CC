/*---------- Imports ----------*/
import net from 'net';
import fs from 'fs';


/*---------- Custom Imports ----------*/
import { Tabuleiro } from '../BatalhaNaval/Game/Tabuleiro.js';
import { Contratorpedeiros } from '../BatalhaNaval/Game/Peças/Contratorpedeiros.js';
import { NaviosTanque } from '../BatalhaNaval/Game/Peças/NaviosTanque.js';
import { PortaAvioes } from '../BatalhaNaval/Game/Peças/PortaAvioes.js';
import { Submarinos } from '../BatalhaNaval/Game/Peças/Submarinos.js';
const configuracao =  JSON.parse(fs.readFileSync('configurarTabuleiro.json'));


/*---------- Handle with arguments ----------*/
let port = process.argv[2];
const host = '127.0.0.1';


/*---------- Handle with game issues ----------*/
/**
 * Configure game
 */
function loadingGame()
{

}//end loadingGame()


/*---------- Setup Server ----------*/
const server = net.createServer((socket) => {
    console.log('client connected!');

    //Loading game
    socket.write('Loading game...\n');

    const newGame = new Tabuleiro();
    newGame.initTabuleiro();

    //const arrayForCTorpedeiros = ;
    //const ;
    //const ;
    //const ;

    console.log(newGame.tabuleiro);

    //inserir peças no tabuleiro



    //Start game
    socket.write('Start game!\n');

    socket.on('end', () => {
        console.log('client disconnected!');
    });

    socket.pipe(socket);
});

server.on('error', (err) => {
    throw err;
});

server.listen(port, host, () => {
    console.log(`TPC Server running on http://${host}:${port}`);
});
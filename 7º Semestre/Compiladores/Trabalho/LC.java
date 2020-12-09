/**
 * @author Breno Aroeira Consenza
 * @author Guilherme de Andrade Moura
 * @author Rithie Nathan Carvalhaes Prado
 * 
 * @desc compilador desenvolvido para a disciplina 
 * 
 * @version 1.0.0
 */

//------ imports -----//

import java.io.*;
import java.util.*;




public class LC{
    
    
    
    public static void main(String[] args) throws IOException{
        GeradorArquivo ga = new GeradorArquivo();
        AnalisadorSintatico analisadorSintatico = new AnalisadorSintatico("teste", ga);
        analisadorSintatico.analisa();
    }
}

class AnalisadorLexico{
    public BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public int contadorLinhas = 1;
    public int tempCounter = 0;
    public TabelaDeSimbolos tabelaDeSimbolos;
    public int estadoAtual = 0;
    public boolean isCONS;
    public char charAtual;
    public String charLido;
    public boolean tokenLido;
    public String lexema;
    public int tipo;
    public GeradorArquivo geradorArquivo;

    public final char EOF = (char)65535;
    public char valid[] = {'$', '^', '@', '!', '?', ' ', '_', '.', ',', ';', ':', '(', ')', '[', ']', '{', '}', '+', '-', '*', '"', '\'', '/', '%', '>', '<', '=', '\n', '\r', '\t', EOF};
    public boolean isEOF;
    public final int erroEOF = 0;
    public final int erroChar = 1;
    public final int erroLexema = 2;


    /**
     * Construtor padrão, apenas inicializa seus atributos.
     */
    public AnalisadorLexico(GeradorArquivo ga) {
        this.charLido = "";
        this.estadoAtual = 0;
        this.tabelaDeSimbolos = new TabelaDeSimbolos();
        this.isCONS = false;
        this.tokenLido = false;
        this.isEOF = false;
        this.geradorArquivo = ga;
    }

    /**
     * Verifica se o caractere lido é permitido na linguagem.
     * @param input
     * @return resp
     */
    public boolean isPermitido(char input)
    {
        boolean resp = false;

        for(int i = 0; i < valid.length; i++)
        {
            if((input >= 'A' && input <= 'Z') || (input >= 'a' && input <= 'z') || (input >= '0' && input <= '9')){
                resp = true;
            }
            else if(input == valid[i])
            { resp = true; i = valid.length; }
        }//end for

        return(resp);
    }//end if

    /**
     * Metodo recebe o código da mensagem de erro, e após apresentá-la na tela, finaliza a execução do compilador.
     * @param codigo
     */
    public void mensagemErro(int codigo){
        if(codigo == erroEOF){
            System.out.print(contadorLinhas + "\nfim de arquivo nao esperado.");
        }else if(codigo == erroLexema){
            System.out.print(contadorLinhas +"\nlexema nao identificado [" + lexema + "].");
        }else{
            System.out.print(contadorLinhas+"\ncaractere invalido.");
        }
        System.exit(0);
    }

    /**
     * Verifica se o caractere atual é um end of file, se não for, armazena-o para ser utilizado na próxima leitura.
     */
    public void retornaC(){
        if (charAtual == EOF){
            isEOF = true;
        }
        estadoAtual = 1;
        charLido += charAtual;
    }

    /**
     * Método principal no analisador léxico, aqui é percorrido o autômato, são verificados possíveis erros e, 
     * caso o lexema seja válido, gera um token
     * @return token
     * @throws IOException
     */
    public Token getToken() throws IOException{
        tipo = Token.NOTYPE;
        lexema = "";
        tokenLido = false;
        isCONS = false;
        estadoAtual = 0;
        while (tokenLido == false){
            if (estadoAtual != 1){
                if (charLido != ""){
                    charAtual = charLido.charAt(0);
                    charLido = "";
                }else {
                    charAtual = (char)br.read();
                    if(charAtual != EOF && charAtual != '\n' && charAtual != '\r' && charAtual != ' '){
                        //System.out.println("Char Atual: " + charAtual + " = Contador Linhas: " + contadorLinhas + " - Contador Secundário: " + tempCounter);
                        contadorLinhas += tempCounter;
                        //System.out.println("Char Atual: " + charAtual + " = Contador Linhas: " + contadorLinhas + " - Contador Secundário: " + tempCounter);
                        tempCounter = 0;
                    }
                    if (!isPermitido(charAtual)){
                        mensagemErro(erroChar);
                    }
                }
            }
            switch (estadoAtual){
                case (0):
                    s0();
                    break;
                case (1):
                    s1();
                    charAtual = '\n';
                    break;
                case (2):
                    s2();
                    break;
                case (3):
                    s3();
                    break;
                case (4):
                    s4();
                    break;
                case (5):
                    s5();
                    break;
                case (6):
                    s6();
                    break;
                case (7):
                    s7();
                    break;
                case (8):
                    s8();
                    break;
                case (9):
                    s9();
                    break;
                case (10):
                    s10();
                    break;
                case (11):
                    s11();
                    break;
                case (12):
                    s12();
                    break;
                case (13):
                    s13();
                    break;
                case (14):
                    s14();
                    break;
                case (15):
                    s15();
                    break;
                case (16):
                    s16();
                    break;
            }
        }
        Token token;
        if (isCONS){
            token = new Token(tipo, TokenID.CONSTANTE, lexema);
        }else{
            token = tabelaDeSimbolos.addID(lexema);
        }
        return token;

    }

    /**
     * Estado inicial do autômato, verifica baseado no caractere atual para qual estado o autômato deve ir,
     * enquando checa por possíveis erros.
     */
    public void s0 (){
        if(charAtual == ' '){
            lexema = "";
            estadoAtual = 0;
        }else if(charAtual == '<'){
            lexema += charAtual;
            estadoAtual = 2;
        }else if (charAtual == '>'){
            lexema += charAtual;
            estadoAtual = 3;
        }else if (charAtual >= '1' && charAtual <= '9'){
            isCONS = true;
            lexema += charAtual;
            estadoAtual = 4;
            tipo = Token.INTEGER;
        }else if (charAtual == '0'){
            isCONS = true;
            lexema += charAtual;
            estadoAtual = 5;
        }else if (charAtual == '/'){
            lexema += charAtual;
            estadoAtual = 8;
        }else if (charAtual == '=' || charAtual == '(' || charAtual == ')' || charAtual == ',' || charAtual == '+' 
                 || charAtual == '-' || charAtual == '*' || charAtual == ';' || charAtual == '{' || charAtual == '}' 
                 || charAtual == '[' || charAtual == ']' || charAtual == '%')
        {
            lexema += charAtual;
            //System.out.println(lexema);
            estadoAtual = 1;
            if(charAtual == ';'){
                geradorArquivo.addLinha();
            }
        }else if (charAtual == '_'){
            lexema += charAtual;
            estadoAtual = 11;
        }else if (charAtual == '.'){
            lexema += charAtual;
            estadoAtual = 12;
        }else if ((charAtual >= 'a' && charAtual <= 'z') || (charAtual >= 'A' && charAtual <= 'Z')){
            lexema += charAtual;
            estadoAtual = 13;
        }else if (charAtual == '\"'){
            isCONS = true;
            tipo = Token.STRING;
            lexema += charAtual;
            estadoAtual = 14;
        }else if (charAtual == '\''){
            isCONS = true;
            tipo = Token.CHAR;
            lexema += charAtual;
            estadoAtual = 15;
        }else if (charAtual == '\n'){
            tempCounter += 1;
        }else if (charAtual == EOF){
            isEOF = true;
            estadoAtual = 1;
        }else if (charAtual != '\r'){
            lexema += charAtual;
            mensagemErro(erroLexema);
        }
    }

    /**
     * Estado final, altera o estado da variável tokenLido para true, sinalizando assim o fim do loop do analisador léxico.
     */
    public void s1 (){
        geradorArquivo.adicionarTermo(lexema);
        tokenLido = true;
    }

    /**
     * s2 (>) -> s1
     * s2 (=) -> s1
     * s2 (diferente de (> e =) retorna C) -> s1
     */
    public void s2 (){
        if (charAtual == '>'){
            lexema += charAtual;
            estadoAtual = 1;
        }else if (charAtual == '=') {
            lexema += charAtual;
            estadoAtual = 1;
        }else{
            retornaC();
        }
    }

    /**
     * s3 (=) -> s1
     * s3 (diferente de (=) retorna C) -> s1
     */
    public void s3 (){
        if (charAtual == '='){
            lexema += charAtual;
            estadoAtual = 1;
        }else{
            retornaC();
        }
    }

    /**
     * s4 (n) -> s4
     * s4 (diferente de (n) retorna C) -> s1
     */
    public void s4 (){
        tipo = Token.INTEGER;
        if (charAtual >= '0' && charAtual <= '9'){
            lexema += charAtual;
        }else{
            retornaC();
        }
    }

    /**
     * s5 (n) -> s4
     * s5 ('x') -> s6
     * s5 (diferente de (n e 'x') retorna C)
     */
    public void s5 (){
        if (charAtual >= '0' && charAtual <= '9'){
            lexema += charAtual;
            estadoAtual = 4;
            tipo = Token.INTEGER;
        }else if (charAtual >= 'x'){
            lexema += charAtual;
            estadoAtual = 6;
            tipo = Token.HEX;
        }else{
            tipo = Token.INTEGER;
            retornaC();
        }
    }

    /**
     * s6 (h) -> s7
     * Caso contrário, verifica se é EOF, se não for, apresenta erro de lexema inválido.
     */
    public void s6 (){
        if ((charAtual >= 'A' && charAtual <= 'F') || (charAtual >= 'a' && charAtual <= 'f') || (charAtual >= '0' && charAtual <= '9')){
            lexema += charAtual;
            estadoAtual = 7;
        }else{
            if (charAtual == EOF){
                mensagemErro(erroEOF);
            }else{
                mensagemErro(erroLexema);
            }
        }
    }

    /**
     * s7 (h) -> s1
     * caso contrário, verifica se é EOF, se não for, apresenta erro de lexema inválido.
     */
    public void s7 (){
        if ((charAtual >= 'A' && charAtual <= 'F') || (charAtual >= 'a' && charAtual <= 'f') || (charAtual >= '0' && charAtual <= '9')){
            lexema += charAtual;
            estadoAtual = 1;
        }else{
            if (charAtual == EOF){
                mensagemErro(erroEOF);
            }else{
                mensagemErro(erroLexema);
            }
        }
    }

    /**
     * s8 (*) -> s9
     * s8 (diferente de (*) retorna C)
     */
    public void s8 (){
        if (charAtual == '*'){
            lexema = "";
            estadoAtual = 9;
        }else{
            charLido += charAtual;
            estadoAtual = 1;
        }
    }

    /**
     * s9 (diferente de (*)) -> s9
     * s9 (*) -> s10
     * Se receber EOF, apresenta erro de end of file não esperado.
     * Se receber \n aumenta a quantidade de linhas lidas.
     */
    public void s9 (){
        if ( charAtual == '*'){
            estadoAtual = 10;
        } else if (charAtual == EOF){
            mensagemErro(erroEOF);
        } else if (charAtual == '\n'){
            contadorLinhas++;
        }
    }

    /**
     * s10 (*) -> s10
     * s10 (/) -> s0
     * s10 (diferente de (* e /)) -> s9
     * Se receber EOF, apresenta erro de end of file não esperado.
     * Se receber \n aumenta a quantidade de linhas lidas.
     */
    public void s10 (){
        if(charAtual == '/'){
            estadoAtual = 0;
        }else if (charAtual != '*' && charAtual != '/'){
            if (charAtual == EOF){
                mensagemErro(erroEOF);
            }
            estadoAtual = 9;
        } else if (charAtual == '\n'){
            contadorLinhas++;
        }
    }

    /**
     * s11 (_) -> s11
     * s11 (.) -> s12
     * s11 (n ou l) -> s13
     * Caso contrário, verifica se o caractere lido é EOF, caso for apresenta erro de fim de arquivo não esperado, se não,
     * apresenta erro de lexema inválido.
     */
    public void s11 (){
        if (charAtual == '_'){
            lexema += charAtual;
        }else if (charAtual == '.'){
            lexema += charAtual;
            estadoAtual = 12;
        }else if ((charAtual >= 'a' && charAtual <= 'z') || (charAtual >= 'A' && charAtual <= 'Z') || (charAtual >= '0' && charAtual <= '9')){
            lexema += charAtual;
            estadoAtual = 13;
        }else if(charAtual == EOF){
            mensagemErro(erroEOF);
        }else{
            lexema += charAtual;
            mensagemErro(erroLexema);
        }
    }

    /**
     * s12 (_) -> s11
     * s12 (.) -> s12
     * s12 (n ou l) -> s13
     * Caso contrário, verifica se o caractere lido é EOF, caso for apresenta erro de fim de arquivo não esperado, se não,
     * apresenta erro de lexema inválido.
     */
    public void s12 (){
        if (charAtual == '.'){
            lexema += charAtual;
        }else if (charAtual == '_'){
            lexema += charAtual;
            estadoAtual = 11;
        }else if ((charAtual >= 'a' && charAtual <= 'z') || (charAtual >= 'A' && charAtual <= 'Z') || (charAtual >= '0' && charAtual <= '9')){
            lexema += charAtual;
            estadoAtual = 13;
        }else if(charAtual == EOF){
            mensagemErro(erroEOF);
        }else{
            lexema += charAtual;
            mensagemErro(erroLexema);
        }
    }

    /**
     * s13 (_ ou . ou l ou n) -> s13
     * s13 (diferente de (_ ou . ou l ou n) retorna C)
     */
    public void s13 (){ 
        if ((charAtual >= 'a' && charAtual <= 'z') || (charAtual >= 'A' && charAtual <= 'Z') || (charAtual >= '0' && charAtual <= '9') || charAtual == '_' || charAtual == '.'){
            lexema += charAtual;
        }else{
            retornaC();
        }
    }

    /**
     * s14 (") -> s1;
     * s14 (diferente de (\n, $ e ")) -> s14
     */
    public void s14 (){
        tipo = Token.STRING;
        if(charAtual == '\"'){
            lexema += charAtual;
            estadoAtual = 1;
        }else if (charAtual == '\n' || charAtual == '$'){
            lexema += charAtual;
            mensagemErro(erroLexema);
        }else if (charAtual == EOF){
            mensagemErro(erroEOF);
        }else{
            lexema += charAtual;
        }
    }

    /**
     * s15 (diferente de (')) -> s16;
     * Caso contrário verifica se é EOF, se for, apresenta o erro de fim de arquivo não esperado.
     */
    public void s15 (){
        tipo = Token.CHAR;
        if (charAtual == EOF){
            mensagemErro(erroEOF);
        }else{
            lexema += charAtual;
            estadoAtual = 16;
        }
    }

    /**
     * s16 (') -> s1
     * Caso contrário, verifica se o caractere lido é EOF, caso for apresenta erro de fim de arquivo não esperado, se não,
     * apresenta erro de lexema inválido.
     */
    public void s16 (){
        if(charAtual == '\''){
            lexema += charAtual;
            estadoAtual = 1;
        }else if (charAtual == EOF){
            mensagemErro(erroEOF);
        }else{
            mensagemErro(erroLexema);
        }
    }
}

//-------------------------------------=----------------------------TOKEN ID----------------------------------------------------------------------
class TokenID
{
    static final byte CONSTANTE = 0;
    static final byte VAR = 1;
    static final byte INTEGER = 2;
    static final byte CHAR = 3;
    static final byte FOR = 4;
    static final byte IF = 5;
    static final byte ELSE = 6;
    static final byte AND = 7;
    static final byte OR = 8;
    static final byte NOT = 9;
    static final byte IGUAL = 10;
    static final byte TO = 11;
    static final byte A_PARENTESES = 12;
    static final byte F_PARENTESES = 13;
    static final byte MENOR = 14;
    static final byte MAIOR = 15;
    static final byte DIFERENTE = 16;
    static final byte MAIOR_IGUAL = 17;
    static final byte MENOR_IGUAL = 18;
    static final byte VIRGULA = 19;
    static final byte MAIS = 20;
    static final byte MENOS = 21;
    static final byte ASTERISCO = 22;
    static final byte BARRA = 23;
    static final byte PONTO_E_VIRGULA = 24;
    static final byte A_CHAVE = 25;
    static final byte F_CHAVE = 26;
    static final byte THEN = 27;
    static final byte READLN = 28;
    static final byte STEP = 29;
    static final byte WRITE = 30;
    static final byte WRITELN = 31;
    static final byte PORCENTAGEM = 32;
    static final byte A_COLCHETE = 33;
    static final byte F_COLCHETE = 34;
    static final byte DO = 35;
    static final byte ID = 36;
    static final byte CONST = 37;
}//end class

/**
 * ------------------------------ classe Token ------------------------------//
 * 01 - Classe Token que contem o id, lexema, tipo, classe e tamanho
 */

class Token
{
    byte id;
    String lexema;
    int tipo;
    int classe;
    int tamanho;
    
    //Tipos possíveis que o token pode receber.
    public static final int NOTYPE = 0;
    public static final int INTEGER = 1;
    public static final int CHAR = 2;
    public static final int HEX = 3;
    public static final int STRING = 4;

    //Classes possíveis do token.
    public static final int VAZIO = 0;
    public static final int VAR = 1;
    public static final int CONST = 2;
    

    /**
     * Construtor padrão, recebe id e lexema para a geração do Token.
     * 
     * @param id
     * @param lexema
     */ 
     
    public Token(byte id, String lexema) { 
        this.id = id; 
        this.lexema = lexema; 
        this.tipo = NOTYPE;
        this.classe = VAZIO;
    }

    public Token(int tipo, byte id, String lexema) { 
        this.id = id; 
        this.lexema = lexema; 
        this.tipo = tipo;
        this.classe = VAZIO;
    }

    /**
     * Construtor padrão, recebe id, lexema e tipo para a geração do Token.
     * 
     * @param id
     * @param lexema
     * 
     *
     public Token(byte id, String lexema) { 
        this.id = id; 
        this.lexema = lexema; 
        this.tipo = null; 
    }*/

    /**
     * Retorna o id do Token.
     * 
     * @return id;
     */
    public byte getToken() {
        return id;
    }

    /**
     * Define o id do Token.
     * 
     * @param id;
     */
    public void setToken(byte id) {
        this.id = id;
    }

    /**
     * Retorna o lexema do Token.
     * 
     * @return lexema;
     */
    public String getLexema() {
        return lexema;
    }

    /**
     * Define o lexema do Token.
     * 
     * @param lexema;
     */
    public void setLexema(String lexema) {
        this.lexema = lexema;
    }

    /**
     * Retorna o tipo do Token.
     * 
     * @return tipo;
     */
    public int getTipo() {
        return tipo;
    }

    /**
     * Define o tipo do Token.
     * 
     * @param tipo;
     */

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }
    
    public String retornarToken(){
        return "id: " + id + " - lexema:" + lexema /*+ " - tipo:" + tipo*/;
    } 
}//end class

//--------------------------------------------------------------TABELA DE SIMBOLOS------------------------------------------------------------------

class TabelaDeSimbolos
{
    public Map<String, Token> tabelaSimbolo = new HashMap<String, Token>();

    /**
     * Construtor padrão, gera a tabela de símbolos com todas suas palavras reservadas.
     */
    public TabelaDeSimbolos()
    {
        tabelaSimbolo.put( "var"    , new Token(TokenID.VAR             , "var"    ));
        tabelaSimbolo.put( "const"  , new Token(TokenID.CONST           , "const"  ));
        tabelaSimbolo.put( "integer", new Token(TokenID.INTEGER         , "integer"));
        tabelaSimbolo.put( "char"   , new Token(TokenID.CHAR            , "char"   ));
        tabelaSimbolo.put( "for"    , new Token(TokenID.FOR             , "for"    ));
        tabelaSimbolo.put( "if"     , new Token(TokenID.IF              , "if"     ));
        tabelaSimbolo.put( "else"   , new Token(TokenID.ELSE            , "else"   ));
        tabelaSimbolo.put( "and"    , new Token(TokenID.AND             , "and"    ));
        tabelaSimbolo.put( "or"     , new Token(TokenID.OR              , "or"     ));
        tabelaSimbolo.put( "not"    , new Token(TokenID.NOT             , "not"    ));
        tabelaSimbolo.put( "="      , new Token(TokenID.IGUAL           , "="      ));
        tabelaSimbolo.put( "to"     , new Token(TokenID.TO              , "to"     ));
        tabelaSimbolo.put( "("      , new Token(TokenID.A_PARENTESES    , "("      ));
        tabelaSimbolo.put( ")"      , new Token(TokenID.F_PARENTESES    , ")"      ));
        tabelaSimbolo.put( "<"      , new Token(TokenID.MENOR           , "<"      ));
        tabelaSimbolo.put( ">"      , new Token(TokenID.MAIOR           , ">"      ));
        tabelaSimbolo.put( "<>"     , new Token(TokenID.DIFERENTE       , "<>"     ));
        tabelaSimbolo.put( ">="     , new Token(TokenID.MAIOR_IGUAL     , ">="     ));
        tabelaSimbolo.put( "<="     , new Token(TokenID.MENOR_IGUAL     , "<="     ));
        tabelaSimbolo.put( ","      , new Token(TokenID.VIRGULA         , ","      ));
        tabelaSimbolo.put( "+"      , new Token(TokenID.MAIS            , "+"      ));
        tabelaSimbolo.put( "-"      , new Token(TokenID.MENOS           , "-"      ));
        tabelaSimbolo.put( "*"      , new Token(TokenID.ASTERISCO       , "*"      ));
        tabelaSimbolo.put( "/"      , new Token(TokenID.BARRA           , "/"      ));
        tabelaSimbolo.put( ";"      , new Token(TokenID.PONTO_E_VIRGULA , ";"      ));
        tabelaSimbolo.put( "{"      , new Token(TokenID.A_CHAVE         , "{"      ));
        tabelaSimbolo.put( "}"      , new Token(TokenID.F_CHAVE         , "}"      ));
        tabelaSimbolo.put( "then"   , new Token(TokenID.THEN            , "then"   ));
        tabelaSimbolo.put( "readln" , new Token(TokenID.READLN          , "readln" ));
        tabelaSimbolo.put( "step"   , new Token(TokenID.STEP            , "step"   ));
        tabelaSimbolo.put( "write"  , new Token(TokenID.WRITE           , "write"  ));
        tabelaSimbolo.put( "writeln", new Token(TokenID.WRITELN         , "writeln"));
        tabelaSimbolo.put( "%"      , new Token(TokenID.PORCENTAGEM     , "%"      ));
        tabelaSimbolo.put( "["      , new Token(TokenID.A_COLCHETE      , "["      ));
        tabelaSimbolo.put( "]"      , new Token(TokenID.F_COLCHETE      , "]"      ));
        tabelaSimbolo.put( "do"     , new Token(TokenID.DO            , "do"     ));
    }//end construtor()


    /**
     * Verifica se um token já existe na tabela, caso não exista, o cria e o insere. Retorna o token encontrado / gerado.
     * 
     * @param lexema recebe um lexema
     * 
     * @return retorna o endereço do token criado.
     */
    public Token addID(String lexema)
    {
        lexema = lexema.toLowerCase();
        Token token = tabelaSimbolo.get(lexema.toLowerCase());
        
        if(token == null)
        { 
            token = new Token (TokenID.ID, lexema);
            tabelaSimbolo.put(lexema , token); 
        }//end if

        return token;
    }//end addID()

    /**
     * Busca lexema que está na tabela de simbolo
     * 
     * @param lexema
     * 
     * @return retorna o endereço do token inserido na tabela
     */
    public Token buscarLexema(String lexema)
    {
        Token token = null;

        if(tabelaSimbolo.get(lexema) != null )
        { token = tabelaSimbolo.get(lexema); }

        return(token);
    }//end buscarLexema()

    /**
     * Mostra os elementos da tabela
     */
    public void mostrarTabela()
    {
        for (String i : tabelaSimbolo.keySet()) 
        { System.out.println("Token: " + tabelaSimbolo.get(i).getToken() + " | Lexema: " + tabelaSimbolo.get(i).getLexema()); }
    }//end mostrarTabela()
}//end class

//-------------------------------------------------------------ANALISADOR SINTATICO----------------------------------------------------------------------
class AnalisadorSintatico {

    Token tokenAtual;
    AnalisadorLexico analisadorLexico;
    Token tokenAnterior;
    String lexemaErro;
    GeradorArquivo ga;

    public int MENSAGEM_ERRO = 0;
    public static final int NOTYPE = 0;
    public static final int INTEGER = 1;
    public static final int CHAR = 2;
    public static final int HEX = 3;
    public static final int STRING = 4;
    public static final int BOOLEAN = 5;

    public final int IDENTIFICADOR_NAO_DECLARADO = 1;
    public final int IDENTIFICADOR_JA_DECLARADO = 2;
    public final int CLASSE_INCOMPATIVEL = 3;
    public final int TIPOS_INCOMPATIVEIS = 4;
    public final int TAMANHO_MAX_EXCEDIDO = 5;

    /**
     * Construtor padrão, inicializa o analisador léxico
     * 
     * @param nome_programa_fonte;
     */
    public AnalisadorSintatico(String nome_programa_fonte, GeradorArquivo g){
        this.ga = g;
        analisadorLexico = new AnalisadorLexico(ga);  
    }

    public void comparaTipo (int tipo){
        
    }

    /**
     * Verifica se o token atual é o token esperado no analisador sintático.
     * @param id
     * @throws IOException
     */
    public void casaToken (int id)throws IOException{
        //System.out.println ("----------> Lexema: " + tokenAtual.lexema + "\t Classe: " + tokenAtual.classe + "\t Tipo: " + tokenAtual.tipo);
        //System.out.println (tokenAtual.lexema + " " + tokenAtual.token + " tenho esse mas quero esse " + id);
        if (tokenAtual.id == id){
            if (tokenAtual.classe == Token.VAR || tokenAtual.classe == Token.CONST){
                tokenAnterior = tokenAtual;
            }
            errosSemanticos();
            tokenAtual = analisadorLexico.getToken();
            
        }else{
            if (analisadorLexico.isEOF){ 
                System.out.print(analisadorLexico.contadorLinhas + "\nfim de arquivo nao esperado.");
                System.exit(0);
            }else{
                System.out.print(analisadorLexico.contadorLinhas + "\ntoken nao esperado ["+ analisadorLexico.lexema +"].");
                System.exit(0);
            }
        }
    }

    /**
    *Função de apresentação de erros semânticos
    *Apresenta os erros de acordo com o estado atual da variável MENSAGEM_ERRO
    */
    public void errosSemanticos(){
        if(MENSAGEM_ERRO > 0) System.out.println(analisadorLexico.contadorLinhas +"");
        switch(MENSAGEM_ERRO){
            case IDENTIFICADOR_NAO_DECLARADO : System.out.print("identificador nao declarado [" + lexemaErro + "]."); break;
            case IDENTIFICADOR_JA_DECLARADO : System.out.print("identificador ja declarado [" + lexemaErro + "]."); break;
            case CLASSE_INCOMPATIVEL : System.out.print("classe de identificador incompativel [" + lexemaErro + "]."); break;
            case TIPOS_INCOMPATIVEIS : System.out.print("tipos incompativeis."); break;
            case TAMANHO_MAX_EXCEDIDO : System.out.print("tamanho do vetor excede o maximo permitido."); break;
            default: break;
        }
        if(MENSAGEM_ERRO > 0) System.exit(0);
    }

    /**
     * Inicia a passagem pela gramática do analisador sintático.
     * @throws IOException
     */
    public void analisa () throws IOException{
        tokenAtual = analisadorLexico.getToken();
        inicial_S();
    }

    /**
     * Estado inicial da gramática, verifica qual o token atual e baseado nisso, decide qual caminho deve tomar.
     * S - > {DECLARACAO} {CMD}+ EOF
     * @throws IOException
     */
    public void inicial_S () throws IOException{
        while (tokenAtual.id == TokenID.VAR || tokenAtual.id == TokenID.CONST){
            declaracao();
        }

        if(analisadorLexico.isEOF)
        { System.out.print(analisadorLexico.contadorLinhas + "\nfim de arquivo nao esperado."); System.exit(0); }

        /*if (tokenAtual.token != TokenID.ID && tokenAtual.token != TokenID.FOR && tokenAtual.token != TokenID.IF &&
        tokenAtual.token != TokenID.PONTO_E_VIRGULA && tokenAtual.token != TokenID.READLN && 
        tokenAtual.token != TokenID.WRITE && tokenAtual.token != TokenID.WRITELN){
           System.out.print(analisadorLexico.contadorLinhas + "\ntoken nao esperado ["+ analisadorLexico.lexema +"]");
           System.exit(0);
        }*/

        while(!analisadorLexico.isEOF){
            cmd();     
        }

        System.out.print (analisadorLexico.contadorLinhas + " linhas compiladas.");
        ga.gerarArquivo();
    }

    /**
     * DECLARACAO -> Var {DEC_VAR}+ | DEC_CONST
     * @throws IOException
     */
    public void declaracao() throws IOException{
        if (tokenAtual.id == TokenID.VAR){
            casaToken(TokenID.VAR);
            do{
                decVar();
                casaToken (TokenID.PONTO_E_VIRGULA);
            }while (tokenAtual.id == TokenID.INTEGER ||
                    tokenAtual.id == TokenID.CHAR);
        }else{
            decConst();
        }
    }

    /**
     * DEC_CONST -> CONST ID = CONSTANTE;
     * @throws IOException
     */
    public void decConst()  throws IOException{
        boolean isNegativo = false;
        casaToken(TokenID.CONST);
        if (tokenAtual.classe == Token.VAZIO){
            tokenAtual.classe = Token.CONST;
        }else{
            lexemaErro = analisadorLexico.lexema;
            MENSAGEM_ERRO = IDENTIFICADOR_JA_DECLARADO;
        }
        casaToken(TokenID.ID);
        casaToken(TokenID.IGUAL);
        if (tokenAtual.id == TokenID.MENOS){
            casaToken (TokenID.MENOS);
            isNegativo = true;
        }
        tokenAnterior.tipo = tokenAtual.tipo;
        if (tokenAtual.tipo == STRING || (isNegativo && tokenAtual.tipo != INTEGER)){
            MENSAGEM_ERRO = TIPOS_INCOMPATIVEIS;
        }
        casaToken(TokenID.CONSTANTE);
        casaToken(TokenID.PONTO_E_VIRGULA);
    }

    /**
     * DEC_VAR -> ( Integer | Char ) ID OPT_VAR {,ID OPT_VAR };
     * @throws IOException
     */
    public void decVar() throws IOException{
        int tipo = NOTYPE;
        if(tokenAtual.id == TokenID.INTEGER){
            casaToken(TokenID.INTEGER);
            tipo = INTEGER;
        }else{
            casaToken(TokenID.CHAR);
            tipo = CHAR;
        }
        tokenAtual.tipo = tipo;
        if (tokenAtual.classe == Token.VAZIO){
            tokenAtual.classe = Token.VAR;
        }else{
            lexemaErro = analisadorLexico.lexema;
            MENSAGEM_ERRO = IDENTIFICADOR_JA_DECLARADO;
        }
        casaToken(TokenID.ID);
        
        optVar();
        while (tokenAtual.id == TokenID.VIRGULA){
            casaToken(TokenID.VIRGULA);
            tokenAtual.tipo = tipo;
            if (tokenAtual.classe == Token.VAZIO){
                tokenAtual.classe = Token.VAR;
            }else{
                lexemaErro = analisadorLexico.lexema;
                MENSAGEM_ERRO = IDENTIFICADOR_JA_DECLARADO;
            }
            casaToken(TokenID.ID);
            optVar();
        }
        
    }

    /**
     * OPT_VAR -> [("[" CONSTANTE "]" | = CONSTANTE)]
     * @throws IOException
     */
    public void optVar() throws IOException{
        Token auxToken = tokenAnterior;
        if(tokenAtual.id == TokenID.A_COLCHETE){
            casaToken(TokenID.A_COLCHETE);
            if(tokenAtual.tipo != INTEGER){
                MENSAGEM_ERRO = TIPOS_INCOMPATIVEIS;
            }
            if ((auxToken.tipo == CHAR && Integer.parseInt(tokenAtual.lexema) > 4000) || (auxToken.tipo == INTEGER && Integer.parseInt(tokenAtual.lexema) > 8000))
                MENSAGEM_ERRO = TAMANHO_MAX_EXCEDIDO;
            auxToken.tamanho = Integer.parseInt(tokenAtual.lexema);
            casaToken(TokenID.CONSTANTE);
            casaToken(TokenID.F_COLCHETE);
        }else if(tokenAtual.id == TokenID.IGUAL){
            casaToken(TokenID.IGUAL);
            if (tokenAtual.id == TokenID.MENOS){
                casaToken (TokenID.MENOS);
                if (tokenAtual.tipo != INTEGER){
                    MENSAGEM_ERRO = TIPOS_INCOMPATIVEIS;
                }
            }
            if (auxToken.tipo != tokenAtual.tipo){
                MENSAGEM_ERRO = TIPOS_INCOMPATIVEIS;
            }
            casaToken(TokenID.CONSTANTE);
        }
    }

    /**
     * CMD -> ATR | REP | TESTE | NULO | RW
     * @throws IOException
     */
    public void cmd() throws IOException{
        switch (tokenAtual.id){
            case TokenID.ID:
                atr();
                break;
            case TokenID.FOR:
                rep();
                break;
            case TokenID.IF:
                teste();
                break;
            case TokenID.PONTO_E_VIRGULA:
                nulo();
                break;
            default:
                rw();
        }
    }

    /**
     * ATR -> ID ["["EXP"]"] = EXP;
     * @throws IOException
     */
    public void atr() throws IOException{
        Token auxToken = tokenAtual;
        if (tokenAtual.classe == Token.VAZIO){
            lexemaErro = analisadorLexico.lexema;
            MENSAGEM_ERRO = IDENTIFICADOR_NAO_DECLARADO;
        }else if (tokenAtual.classe == Token.CONST){
            MENSAGEM_ERRO = CLASSE_INCOMPATIVEL;
            lexemaErro = analisadorLexico.lexema;
        }
        casaToken(TokenID.ID);
        if(tokenAtual.id == TokenID.A_COLCHETE){
            casaToken(TokenID.A_COLCHETE);
            if (exp() != INTEGER){
                MENSAGEM_ERRO = TIPOS_INCOMPATIVEIS;
                errosSemanticos();
            }
            casaToken(TokenID.F_COLCHETE);
            if (auxToken.tamanho == 0){
                MENSAGEM_ERRO = TIPOS_INCOMPATIVEIS;
                errosSemanticos();
            }
        }
        casaToken(TokenID.IGUAL);
        int tipoExp = exp();
        if(tipoExp == STRING){
            if (auxToken.classe == Token.CONST || auxToken.tipo == INTEGER || auxToken.tamanho == 0 ){
                //System.out.println ("auxToken.classe = " + auxToken.classe + "\tauxToken.tipo = " + auxToken.tipo +"\tauxToken.tamanho = " + auxToken.tamanho);
                MENSAGEM_ERRO = TIPOS_INCOMPATIVEIS;
            }
        }else if (auxToken.tipo != tipoExp){
            MENSAGEM_ERRO = TIPOS_INCOMPATIVEIS;
        }
        errosSemanticos();
        casaToken(TokenID.PONTO_E_VIRGULA);
    }
    
    /**
     * REP -> for ID ["["EXP"]"] = EXP to EXP [step EXP] do ( CMD | "{" {CMD}+ "}")
     * @throws IOException
     */
    public void rep() throws IOException{
        casaToken(TokenID.FOR);
        Token auxToken = tokenAtual;
        if (tokenAtual.classe != Token.VAR){
            lexemaErro = analisadorLexico.lexema;
            MENSAGEM_ERRO = CLASSE_INCOMPATIVEL;
        }else if (tokenAtual.tipo != INTEGER){
            MENSAGEM_ERRO = TIPOS_INCOMPATIVEIS;
        }
        casaToken(TokenID.ID);
        if(tokenAtual.id == TokenID.A_COLCHETE){
            casaToken(TokenID.A_COLCHETE);
            if (exp() != INTEGER){
                MENSAGEM_ERRO = TIPOS_INCOMPATIVEIS;
                errosSemanticos();
            }
            casaToken(TokenID.F_COLCHETE);
            if (auxToken.tamanho == 0){
                MENSAGEM_ERRO = TIPOS_INCOMPATIVEIS;
                errosSemanticos();
            }
        }
        casaToken(TokenID.IGUAL);
        //int teste = exp();
        //System.out.println (teste);
        if (exp() != INTEGER){
            MENSAGEM_ERRO = TIPOS_INCOMPATIVEIS;
            errosSemanticos();
        }
        casaToken(TokenID.TO);
        if (exp() != INTEGER){
            MENSAGEM_ERRO = TIPOS_INCOMPATIVEIS;
            errosSemanticos();
        }
        if (tokenAtual.id == TokenID.STEP){
            casaToken(TokenID.STEP);
            if (tokenAtual.tipo != INTEGER){
                MENSAGEM_ERRO = TIPOS_INCOMPATIVEIS;
            }
            casaToken(TokenID.CONSTANTE); //TODO: Verificar com o alexei se aqui pode ser um const.
        }
        casaToken(TokenID.DO);
        if(tokenAtual.id == TokenID.A_CHAVE){
            casaToken(TokenID.A_CHAVE);
            do{
                cmd();
            }while (tokenAtual.id != TokenID.F_CHAVE);
            casaToken(TokenID.F_CHAVE);
        }else{
            cmd();
        }
    }

    /**
     * TESTE -> if EXP then ( CMD | "{"{CMD}+"}" ) [ Else ( CMD | "{"{CMD}+"}"+)]
     * @throws IOException
     */
    public void teste() throws IOException{
        casaToken(TokenID.IF);
        if (exp() != BOOLEAN){
            MENSAGEM_ERRO = TIPOS_INCOMPATIVEIS;
            errosSemanticos();
        }
        casaToken(TokenID.THEN);
        if(tokenAtual.id == TokenID.A_CHAVE){
            casaToken(TokenID.A_CHAVE);
            do{
                cmd();
            }while (tokenAtual.id != TokenID.F_CHAVE);
            casaToken(TokenID.F_CHAVE);
        }else{
            cmd();
        }
        if (tokenAtual.id == TokenID.ELSE){
            casaToken(TokenID.ELSE);
            if(tokenAtual.id == TokenID.A_CHAVE){
                casaToken(TokenID.A_CHAVE);
                do{
                    cmd();
                }while (tokenAtual.id != TokenID.F_CHAVE);
                casaToken(TokenID.F_CHAVE);
            }else{
                cmd();
            }
        }
    }

    /**
     * NULO -> ;
     * @throws IOException
     */
    public void nulo() throws IOException{
        casaToken(TokenID.PONTO_E_VIRGULA);
    }

    /**
     * RW -> (readln"("ID")" | (write | writeln) "("EXP {,EXP}")");	
     * @throws IOException
     */
    public void rw() throws IOException{

        if(tokenAtual.id == TokenID.READLN){
            casaToken(TokenID.READLN);
            casaToken(TokenID.A_PARENTESES);
            if (tokenAtual.classe == Token.CONST){
                lexemaErro = analisadorLexico.lexema;
                MENSAGEM_ERRO = CLASSE_INCOMPATIVEL;
            }else if (tokenAtual.classe != Token.VAR){
                lexemaErro = analisadorLexico.lexema;
                MENSAGEM_ERRO = IDENTIFICADOR_NAO_DECLARADO;
            }
            casaToken(TokenID.ID);
            casaToken(TokenID.F_PARENTESES);
        }else{
            if(tokenAtual.id == TokenID.WRITE){
                casaToken(TokenID.WRITE);
            }else{
                casaToken(TokenID.WRITELN); 
            }
            casaToken (TokenID.A_PARENTESES);
            if (exp() == BOOLEAN){
                MENSAGEM_ERRO = TIPOS_INCOMPATIVEIS;
                errosSemanticos();
            }
            while (tokenAtual.id == TokenID.VIRGULA){
                casaToken(TokenID.VIRGULA);
                if (exp() == BOOLEAN){
                    MENSAGEM_ERRO = TIPOS_INCOMPATIVEIS;
                    errosSemanticos();
                }
            }
            casaToken (TokenID.F_PARENTESES);
        }
        casaToken(TokenID.PONTO_E_VIRGULA);
    }

    /**
     * EXP -> EXPS [( = | <> | < | > | <= | >= ) EXPS]
     * @throws IOException
     */
    public int exp() throws IOException{ //TODO fazer as comparações de erros
        int tipoExp = exps();
        boolean isEquals = false;
        if (tokenAtual.id == TokenID.IGUAL ||
        tokenAtual.id == TokenID.DIFERENTE ||
        tokenAtual.id == TokenID.MENOR ||
        tokenAtual.id == TokenID.MAIOR ||
        tokenAtual.id == TokenID.MENOR_IGUAL ||
        tokenAtual.id == TokenID.MAIOR_IGUAL){
            switch (tokenAtual.id){
                case TokenID.IGUAL:
                    casaToken(TokenID.IGUAL);
                    isEquals = true;
                    break;
                case TokenID.DIFERENTE:
                    casaToken(TokenID.DIFERENTE);
                    break;
                case TokenID.MENOR:
                    casaToken(TokenID.MENOR);
                    break;
                case TokenID.MAIOR:
                    casaToken(TokenID.MAIOR);
                    break;
                case TokenID.MENOR_IGUAL:
                    casaToken(TokenID.MENOR_IGUAL);
                    break;
                case TokenID.MAIOR_IGUAL:
                    casaToken(TokenID.MAIOR_IGUAL);
                    break;
            }
            int auxTipo = exps();
            if (isEquals){
                if ((tipoExp == STRING && auxTipo != STRING) || tipoExp == INTEGER && auxTipo != INTEGER){
                    MENSAGEM_ERRO = TIPOS_INCOMPATIVEIS;
                    errosSemanticos();
                }else if (tipoExp == CHAR || auxTipo == CHAR){
                    MENSAGEM_ERRO = TIPOS_INCOMPATIVEIS;
                    errosSemanticos();
                }
            }else{
                if (tipoExp != INTEGER || auxTipo != INTEGER){
                    MENSAGEM_ERRO = TIPOS_INCOMPATIVEIS;
                    errosSemanticos();
                }
            }
            tipoExp = BOOLEAN;
        }
        return tipoExp;
    }

    /**
     * EXPS -> [-] T {( + | - | OR ) T}
     * @throws IOException
     */
    public int exps() throws IOException{
        int tipoExps = NOTYPE; 
        boolean isOr = false;
        if (tokenAtual.id == TokenID.MENOS){
            casaToken(TokenID.MENOS);
            tipoExps = INTEGER;
        }
        int auxTipo = T();
        if (tipoExps == INTEGER){
            if (auxTipo != INTEGER){
                MENSAGEM_ERRO = TIPOS_INCOMPATIVEIS;
            }
        }else{
            tipoExps = auxTipo;
        }
        while(tokenAtual.id == TokenID.MAIS ||
        tokenAtual.id == TokenID.MENOS ||
        tokenAtual.id == TokenID.OR){
            switch (tokenAtual.id){
                case TokenID.MAIS:
                    casaToken(TokenID.MAIS);
                    break;
                case TokenID.MENOS:
                    casaToken(TokenID.MENOS);
                    break;
                case TokenID.OR:
                    isOr = true;
                    casaToken(TokenID.OR);
                    break;
            }
            auxTipo = T();
            if (isOr){
                if (tipoExps != BOOLEAN || auxTipo != BOOLEAN){
                    MENSAGEM_ERRO = TIPOS_INCOMPATIVEIS;
                    errosSemanticos();
                }
            }else if(tipoExps != INTEGER || auxTipo != INTEGER){
                MENSAGEM_ERRO = TIPOS_INCOMPATIVEIS;
                errosSemanticos(); 
            }
        }
        return tipoExps;
    }

    /**
     * T -> F {( * | / | AND | %) F}
     * @throws IOException
     */
    public int T() throws IOException{
        int tipoT = F();
        boolean isAnd = false;
        while(tokenAtual.id == TokenID.ASTERISCO ||
        tokenAtual.id == TokenID.BARRA ||
        tokenAtual.id == TokenID.AND ||
        tokenAtual.id == TokenID.PORCENTAGEM){
            switch (tokenAtual.id){
                case TokenID.ASTERISCO:
                    casaToken(TokenID.ASTERISCO);
                    break;
                case TokenID.BARRA:
                    casaToken(TokenID.BARRA);
                    break;
                case TokenID.AND: 
                    isAnd = true;
                    casaToken(TokenID.AND);
                    break;
                case TokenID.PORCENTAGEM:
                    casaToken(TokenID.PORCENTAGEM);
                    break;
            }
            int auxTipo = F();
            if (isAnd){
                if (tipoT != BOOLEAN || auxTipo != BOOLEAN){
                    MENSAGEM_ERRO = TIPOS_INCOMPATIVEIS;
                    errosSemanticos();
                }
            }else if(tipoT != INTEGER || auxTipo != INTEGER){
                MENSAGEM_ERRO = TIPOS_INCOMPATIVEIS;
                errosSemanticos();
            }
        }
        return tipoT;
    }

    /**
     * F -> NOT F | ID [ "["EXP"]" ] | CONSTANTE | "("EXP")"
     * @throws IOException
     */
    public int F() throws IOException{
        int tipoF = NOTYPE;
        switch (tokenAtual.id){
            case TokenID.NOT:
                casaToken(TokenID.NOT);
                tipoF = BOOLEAN;
                if (F() != BOOLEAN){
                    MENSAGEM_ERRO = TIPOS_INCOMPATIVEIS;
                    errosSemanticos();
                }
                break;
            case TokenID.ID:
                tipoF = tokenAtual.tipo;
                boolean isVetor = false;
                if (tokenAtual.classe == Token.VAZIO){
                    MENSAGEM_ERRO = IDENTIFICADOR_NAO_DECLARADO;
                    lexemaErro = analisadorLexico.lexema;
                }
                Token auxToken = tokenAtual;
                casaToken(TokenID.ID);
                if(tokenAtual.id == TokenID.A_COLCHETE){
                    casaToken(TokenID.A_COLCHETE);
                    isVetor = true;
                    if (auxToken.classe == Token.CONST){
                        lexemaErro = analisadorLexico.lexema;
                        MENSAGEM_ERRO = CLASSE_INCOMPATIVEL;
                    }else if (exp() != INTEGER){
                        MENSAGEM_ERRO = TIPOS_INCOMPATIVEIS;
                        errosSemanticos();
                    }
                    casaToken(TokenID.F_COLCHETE);
                }
                if (auxToken.tamanho > 0 && isVetor == false && auxToken.tipo == CHAR){
                    tipoF = STRING;
                }
                break;
            case TokenID.A_PARENTESES:
                casaToken(TokenID.A_PARENTESES);
                tipoF = exp();
                casaToken(TokenID.F_PARENTESES);
                break;
            default:
                tipoF = tokenAtual.tipo;
                casaToken(TokenID.CONSTANTE);
        }
        return tipoF;
    } 
    class InfosEXP {
        public int tipo;
        public int classe;
        public int tamanho;
        public int pos;

        public InfosEXP(){
            this.tipo = 0;
            this.classe = 0;
            this.tamanho = 0;
            this.pos = 0;
        }

        public void setInfos(int tipo, int classe, int tamanho, int pos){

        }
    }

}


class GeradorArquivo{
        
    private ArrayList<String> linhasCodigo; //linhas em Assembly
    public ArrayList<String>linhasNaoProcessadas; //todos os lexemas encontrados em uma linha separados por espa�o
    public ArrayList<String> listaEnderecos; //lista dos endere�os de cada variavel
    public String linha; // linha atual sendo processada
    
    private int contador_rotulo; //contador das labels
    private int contador_temporario; //contador temporario
    private int contador_segmento; //contador do segmento que armazena o endereco
    public int quantidadeDeclaracao; //quantidade de variaveis presentes na declaracao
    
    private final String VALOR_NAO_DECLARADO = "NON"; //valor que vai ser usado como valor n�o declarado

    //construtor do metodo
    public GeradorArquivo() {
        linhasCodigo = new ArrayList<>();
        linha = "";
        linhasNaoProcessadas = new ArrayList<>();
        listaEnderecos = new ArrayList<>();
        contador_rotulo = 0;
        contador_temporario = 0;
        contador_segmento = 0;
    }
    
    //adicionar linha do codigo para a lista de linhas nao processsadas
    public void addLinha(){
        linhasNaoProcessadas.add(linha);
        linha = "";
    }
    
    //adiciona um lexema a linha
    public void adicionarTermo(String termo){
        if(termo.equalsIgnoreCase("var") || termo.equalsIgnoreCase("const") || termo.equalsIgnoreCase("char")) quantidadeDeclaracao++;
        if(!termo.equals(";"))this.linha += termo + " ";
    }
    
    //cria o SSEG no inicio do arquivo
    public void criarSSEG(){
        linhasCodigo.add("sseg SEGMENT STACK");
        linhasCodigo.add("\tbyte 4000h DUP(?)");
        linhasCodigo.add("sseg ENDS");
    }
    
    //cria o DSEG apos o SSEG
    public void criarDSEG(){
        linhasCodigo.add("dseg SEGMENT PUBLIC");
        linhasCodigo.add("\tbyte 4000h DUP(?)");
    }
    
    //tradu��o das variaveis em L para MIPS
    public int declaracaoVariaveis(String tipo, int tamanho, String valor, String comentario){
        String declaracao = "\tbyte ";
        int aux = 1;
        if(tipo.equalsIgnoreCase("integer")){
            declaracao = "\tsword ";
            aux = 2;
        }
        
        if(valor.equals(VALOR_NAO_DECLARADO)) declaracao += " ?";
        else declaracao += valor;
        
        if(tamanho > 0 ){
             declaracao += " DUP(?)";
             aux = aux*tamanho;
        }

        linhasCodigo.add(declaracao + "\t\t;" + comentario + "- dseg: " + contador_segmento);
        int endereco = contador_segmento;
        contador_segmento += aux;
        return endereco;
    }

    public void fecharDSEG(){
        linhasCodigo.add("dseg ENDS");
    }
    
    public void criarCSEG(){
        linhasCodigo.add("cseg SEGMENT PUBLIC");
        linhasCodigo.add("\tASSUME CS:cseg, DS:dseg");
        linhasCodigo.add("strt:");
        linhasCodigo.add("\tmov AX, dseg");
        linhasCodigo.add("\tmov DS, AX");
    }
    
    public void terminarCSEG(){
        linhasCodigo.add("\tmov ah, 4Ch");
        linhasCodigo.add("\tint 21h");
        linhasCodigo.add("cseg ENDS");
        linhasCodigo.add("END strt");
    }
    
    public int converterValorHexadecimalParaInt(String valor){
        int v = Integer.parseInt(valor,16);
        return v;
    }
    
    //retorna um inteiro para o novo contador e incrementa o contador geral
    public int novo_temporario(String tipo, int tamanho){
        int aux = contador_temporario;
        int temp = 1;
        if(tipo.equals("integer"))temp = 2;
        if(tamanho > 0) temp*=tamanho;
        contador_temporario+= temp; //incremento no contador temporario aqui
        return aux;
    }
    
    public String novo_rotulo(){
        String retorno = "R"+ contador_rotulo;
        contador_rotulo++;
        return retorno;
    }
    
    public boolean isNumero(String termo){
        boolean resultado = true;
        for(int i = 0; i < termo.length(); i++){
            if(!Character.isDigit(termo.charAt(i))){
                resultado = false;
                i = termo.length();
            }
        }
        return resultado;
    }
    
    public boolean isHexadecimal(String termo){
        if(termo.length() != 4) return false;
        if(termo.charAt(0) != '0') return false;
        if(termo.charAt(1) != 'x' || termo.charAt(0) != 'X' ) return false;
        if(!Character.isDigit(termo.charAt(2)) && !Character.isDigit(termo.charAt(3)))return false;
        return true;
    }
    
    /*
    Imprime o arquivo gerado
    */
    
    public void gerarArquivo() throws IOException{
        String r = "";
        processarLinhas();
        for(int i = 0;i < linhasCodigo.size(); i++){
            r += linhasCodigo.get(i)+ "\n";
            //System.out.println(linhasCodigo.get(i));
        }
        //System.out.println(r);
        
        FileWriter fw = new FileWriter("ArquivoGerado.asm");
        PrintWriter rec = new PrintWriter(fw);
        rec.printf(r);
        rec.close();
        fw.close();
        
    }
    
    public void processarLinhas(){
        int d = 0;
        //System.out.println(quantidadeDeclaracao+"");
        criarSSEG();
        criarDSEG();
        while(d < quantidadeDeclaracao){
            escreverVariavelEmMips(d);
            d++;
        }
        //for(int i = 0; i < listaEnderecos.size(); i++) System.out.println(listaEnderecos.get(i));
        fecharDSEG();
        criarCSEG();
        //inserir aqui implementa��es de codigo
        escreverLinhasCodigo();
        terminarCSEG();
    }
    
    public void escreverVariavelEmMips(int d){
            String linhaAtual = linhasNaoProcessadas.get(d);
            String[] termos = linhaAtual.split(" ");
            //for(int i = 0; i < termos.length; i++) System.out.println(termos[i]);
            String tipo = termos[0];
            if(termos[0].equalsIgnoreCase("var")) tipo = termos[1];
            //System.out.print("\n"+ d + ": tipo: " + tipo);
            int tamanho = 0;
            if(linhaAtual.contains("[".toString())){
                int idbracket = 0;
                for(int i = 0; i < termos.length; i++){
                    if(termos[i].equalsIgnoreCase("[".toString())) idbracket = i;
                }
                if(isNumero(termos[idbracket+1])) tamanho = Integer.parseInt(termos[idbracket+1]);
            }
            //System.out.print(" - tamanho: " + tamanho);
            String valor = VALOR_NAO_DECLARADO;
            if(linhaAtual.contains("=")){
                int idequal = 0;
                for(int i = 0; i < termos.length; i++){
                    if(termos[i].equalsIgnoreCase("=")) idequal = i;
                }
                
                if(termos[idequal+1].equals("-"))  valor = termos[idequal+1] + Integer.parseInt(termos[idequal+2])+"";
                else if(isNumero(termos[idequal+1])) valor = Integer.parseInt(termos[idequal+1])+ "";
            }
            //System.out.println(" - valor: " + valor);
            int endereco = 0;
            if(tipo.equalsIgnoreCase("const")){
                if(isNumero(valor.replace("-", ""))) declaracaoVariaveis("integer", tamanho, valor, linhaAtual);
                else declaracaoVariaveis("char", tamanho, valor, linhaAtual);
            }
            else declaracaoVariaveis(tipo, tamanho, valor, linhaAtual);
            String nome = "nan";
            int i = 0;
            
            listaEnderecos.add(nome+"~~"+endereco);
            
    }

    
    public void escreverLinhasCodigo(){
        for(int i = quantidadeDeclaracao-1; i < linhasNaoProcessadas.size(); i++){
            String linhaAtual = linhasNaoProcessadas.get(i);
            linhaAtual = linhaAtual.toLowerCase();
            String[] vetor = linhaAtual.split(" ");
            for(int j = 0; j < vetor.length; j++){
                definirAcao(linhaAtual, vetor[i]);
            }
        }
    }
    
   public void definirAcao(String linhaAtual, String termo){
       
       switch(termo){
           
           case "if": escreverIF(); break;
           case "for": escreverFOR(); break;
           case "=": escreverIgualdade(); break;
           case "writeln": escreverWrite(); break;
           case "readln": escreverRead(); break;
           default: break;
       }
       
   }
   
   public void escreverIF(){
       
   }
   
   public void escreverFOR(){
       
   }
   
   public void escreverIgualdade(){
       
   }
   
   public void escreverWrite(){
       
   }
   
   public void escreverRead(){
       
   }
    
    public int retonarEnderecoTabela(String nome){
        for(int i = 0; i < listaEnderecos.size(); i++){
            if(nome.equalsIgnoreCase(listaEnderecos.get(i).split("~~")[0])){
                return Integer.parseInt(listaEnderecos.get(i).split("~~")[1]);
            }
        }
        return 0;
    }
    
}
    
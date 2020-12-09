using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class Heuristica : MonoBehaviour
{
    public GameObject controle;
    public GameObject aestrelaObjeto;
    public GameObject uniformeObjeto;

    public bool canPress;
    public bool guloso;
    public bool aestrela;
    public bool uniforme;
    public Color originalColor;
    
    public GameObject personagem;
    public GameObject irBotao;
    public float correcaoMovimento;
    public bool foundResult; // usado no guloso para encontrar o resultado
    
    

    // Start is called before the first frame update
    void Start()
    {
        originalColor = gameObject.GetComponent<SpriteRenderer>().color;
        
    }

    // Update is called once per frame
    void Update()
    {
        canPress = controle.GetComponent<ControleMapa>().canMove;

        if (canPress && !controle.GetComponent<ControleMapa>().isMoving)
        {
            gameObject.GetComponent<SpriteRenderer>().color = originalColor;
        }
        else
        {
            gameObject.GetComponent<SpriteRenderer>().color = new Color(1, 1, 1, 0.2f);
        }

        

    }

    private void OnMouseUpAsButton()
    {

        if (canPress)
        {
            controle.GetComponent<ControleMapa>().apagarPesosEOrdem();
            controle.GetComponent<ControleMapa>().caminho = new List<string>();
            

            //Debug.Log("Começar movimento:");
            if (guloso)
            {
                realizarGuloso();
            }
            else if (aestrela)
            {
                
                realizarAestrela();
            }else if (uniforme)
            {
                realizarCustoUniforme();
            }

            
        }
    }

    public void realizarGuloso()
    {
        int xo = controle.GetComponent<ControleMapa>().iatualPersoangem;
        int yo = controle.GetComponent<ControleMapa>().jatualPersoangem;
        int x = controle.GetComponent<ControleMapa>().iDesejado;
        int y = controle.GetComponent<ControleMapa>().jDesejado;
        int largura = controle.GetComponent<ControleMapa>().largura;
        int altura = controle.GetComponent<ControleMapa>().altura;
        float[,] matriz = controle.GetComponent<ControleMapa>().mapa;
        foundResult = false;
        gulosoIterativo(xo, yo, x, y, matriz, new int[largura, altura], largura, altura, new List<string>());
        for (int a = 0; a < controle.GetComponent<ControleMapa>().caminho.Count; a++)
        {
            int i = int.Parse(controle.GetComponent<ControleMapa>().caminho[a].Split(',')[0]);
            int j = int.Parse(controle.GetComponent<ControleMapa>().caminho[a].Split(',')[1]);
            Debug.Log("Caminho:"+ controle.GetComponent<ControleMapa>().caminho[a]);
            controle.GetComponent<ControleMapa>().mapaObjetos[i, j].GetComponent<Terreno>().mostrarInfo(a);
        }
        controle.GetComponent<ControleMapa>().tamanhoInicialCaminho = controle.GetComponent<ControleMapa>().caminho.Count;
    }

    public void realizarCustoUniforme()
    {
        int xo = controle.GetComponent<ControleMapa>().iatualPersoangem;
        int yo = controle.GetComponent<ControleMapa>().jatualPersoangem;
        int x = controle.GetComponent<ControleMapa>().iDesejado;
        int y = controle.GetComponent<ControleMapa>().jDesejado;
        int largura = controle.GetComponent<ControleMapa>().largura;
        int altura = controle.GetComponent<ControleMapa>().altura;
        float[,] matriz = controle.GetComponent<ControleMapa>().mapa;
        List<string> caminhos = new List<string>();
        caminhos.Add(xo + "," + yo + ";~0");
        custoUniforme(xo, yo, x, y, largura, altura, matriz, new int[largura, altura], caminhos, xo + "," + yo + ";~0", 0);
        for (int a = 0; a < controle.GetComponent<ControleMapa>().caminho.Count; a++)
        {
            int i = int.Parse(controle.GetComponent<ControleMapa>().caminho[a].Split(',')[0]);
            int j = int.Parse(controle.GetComponent<ControleMapa>().caminho[a].Split(',')[1]);
            Debug.Log("Caminho:" + controle.GetComponent<ControleMapa>().caminho[a]);
            controle.GetComponent<ControleMapa>().mapaObjetos[i, j].GetComponent<Terreno>().mostrarInfo(a);
        }
        controle.GetComponent<ControleMapa>().tamanhoInicialCaminho = controle.GetComponent<ControleMapa>().caminho.Count;
    }

    public void custoUniforme(int xo, int yo, int x, int y, int largura, int altura,
        float[,] matriz, int [,] visitado, List<string> caminhos, string cAtual, int index)
    {
        visitado[xo, yo] = 1;
        if(xo == x && yo == y)
        {
            Debug.Log("Caminho final: " + caminhos[index]);
            string passagem = caminhos[index].Split('~')[0];
            string[] coordenadas = passagem.Split(';');

            for(int i = 0; i < coordenadas.Length-1; i++)
            {
                Debug.Log("Add: " + coordenadas[i]);
                controle.GetComponent<ControleMapa>().caminho.Add(coordenadas[i]);
            }

        }
        else
        {

            if (xo - 1 >= 1)
            {
                if (visitado[xo - 1, yo] != 1 && matriz[xo - 1, yo] < 11)
                {
                    int nx = xo - 1;
                    int ny = yo;
                    string c = caminhos[index].Split('~')[0] + nx + "," + ny+";";
                    float p = float.Parse(caminhos[index].Split('~')[1]) + matriz[nx, ny];
                    c = c + "~" + p;
                    Debug.Log("Add: " + c);
                    caminhos.Add(c);
                }


            }
            if (yo - 1 >= 1)
            {
                if (visitado[xo, yo - 1] != 1 && matriz[xo, yo - 1] < 11)
                {
                    int nx = xo;
                    int ny = yo-1;
                    string c = caminhos[index].Split('~')[0] + nx + "," + ny + ";";
                    float p = float.Parse(caminhos[index].Split('~')[1]) + matriz[nx, ny];
                    c = c + "~" + p;
                    Debug.Log("Add: " + c);
                    caminhos.Add(c);
                }

            }
            if (xo + 1 < largura - 1)
            {
                if (visitado[xo + 1, yo] != 1 && matriz[xo + 1, yo] < 11)
                {
                    int nx = xo + 1;
                    int ny = yo;
                    string c = caminhos[index].Split('~')[0] + nx + "," + ny + ";";
                    float p = float.Parse(caminhos[index].Split('~')[1]) + matriz[nx, ny];
                    c = c + "~" + p;
                    Debug.Log("Add: " + c);
                    caminhos.Add(c);
                }

            }
            if (yo + 1 < altura - 1)
            {
                if (visitado[xo, yo + 1] != 1 && matriz[xo, yo + 1] < 11)
                {
                    int nx = xo;
                    int ny = yo+1;
                    string c = caminhos[index].Split('~')[0] + nx + "," + ny + ";";
                    float p = float.Parse(caminhos[index].Split('~')[1]) + matriz[nx, ny];
                    c = c + "~" + p;
                    Debug.Log("Add: " + c);
                    caminhos.Add(c);
                }

            }

            caminhos.Remove(cAtual);

            float auxiliar = float.MaxValue;
            int newIndex = 0;
            for(int i = 0; i < caminhos.Count; i++)
            {
                float temp = float.Parse(caminhos[i].Split('~')[1]);
                //Debug.Log("temp:" +temp);
                if(temp < auxiliar)
                {
                    auxiliar = temp;
                    newIndex = i;
                }
            }

            Debug.Log("indice:" + newIndex + " - Peso: " + auxiliar);
            string uc = caminhos[newIndex].Split('~')[0];
            string[]ultimo = uc.Split(';');
            uc = ultimo[ultimo.Length -2];
            //uc.Remove(';');
            Debug.Log("UC: "+uc);
            int proxI = int.Parse(uc.Split(',')[0]);
            int proxJ = int.Parse(uc.Split(',')[1]);

            custoUniforme(proxI, proxJ, x,y, largura, altura, matriz, visitado, caminhos, caminhos[newIndex], newIndex);


        }
    }


    public void realizarAestrela()
    {
        int xo = controle.GetComponent<ControleMapa>().iatualPersoangem;
        int yo = controle.GetComponent<ControleMapa>().jatualPersoangem;
        int x = controle.GetComponent<ControleMapa>().iDesejado;
        int y = controle.GetComponent<ControleMapa>().jDesejado;
        int largura = controle.GetComponent<ControleMapa>().largura;
        int altura = controle.GetComponent<ControleMapa>().altura;
        float[,] matriz = controle.GetComponent<ControleMapa>().mapa;
        List<string> caminhos = new List<string>();
        caminhos.Add(xo + "," + yo + ";~0");
        //float distancia = breseham(xo, yo, x, y, matriz);
        //Debug.Log("f(x) = " + distancia);
        aestrelaIterativo(xo, yo, x, y, largura, altura, matriz, new int[largura, altura], caminhos, xo + "," + yo + ";~0", 0);
        for (int a = 0; a < controle.GetComponent<ControleMapa>().caminho.Count; a++)
        {
            int i = int.Parse(controle.GetComponent<ControleMapa>().caminho[a].Split(',')[0]);
            int j = int.Parse(controle.GetComponent<ControleMapa>().caminho[a].Split(',')[1]);
            Debug.Log("Caminho:" + controle.GetComponent<ControleMapa>().caminho[a]);
            controle.GetComponent<ControleMapa>().mapaObjetos[i, j].GetComponent<Terreno>().mostrarInfo(a);
        }
        controle.GetComponent<ControleMapa>().tamanhoInicialCaminho = controle.GetComponent<ControleMapa>().caminho.Count;
    }


    public float breseham(int xo, int yo, int x, int y, float[,] matriz)
    {
        
        float distancia = 0;
        while(!(x == xo && y == yo))
        {
            
            if (xo > x) xo--;
            else if(xo < x) xo++;
            else if (yo > y) yo--;
            else if (yo < y) yo++;

            distancia += matriz[xo, yo];
            Debug.Log("x:" + xo + ", y: " + yo + " ~ " + distancia);
        }
        return distancia;
    }

    public void aestrelaIterativo(int xo, int yo, int x, int y, int largura, int altura,
       float[,] matriz, int[,] visitado, List<string> caminhos, string cAtual, int index)
    {
        visitado[xo, yo] = 1;
        if (xo == x && yo == y)
        {
            Debug.Log("Caminho final: " + caminhos[index]);
            string passagem = caminhos[index].Split('~')[0];
            string[] coordenadas = passagem.Split(';');

            for (int i = 0; i < coordenadas.Length - 1; i++)
            {
                Debug.Log("Add: " + coordenadas[i]);
                controle.GetComponent<ControleMapa>().caminho.Add(coordenadas[i]);
            }

        }
        else
        {

            if (xo - 1 >= 1)
            {
                if (visitado[xo - 1, yo] != 1 && matriz[xo - 1, yo] < 11)
                {
                    int nx = xo - 1;
                    int ny = yo;
                    string c = caminhos[index].Split('~')[0] + nx + "," + ny + ";";
                    float fx = breseham(nx, ny, x, y, matriz) + matriz[nx, ny];
                    c = c + "~" + fx;
                    Debug.Log("Add: " + c);
                    caminhos.Add(c);
                }


            }
            if (yo - 1 >= 1)
            {
                if (visitado[xo, yo - 1] != 1 && matriz[xo, yo - 1] < 11)
                {
                    int nx = xo;
                    int ny = yo - 1;
                    string c = caminhos[index].Split('~')[0] + nx + "," + ny + ";";
                    float fx = breseham(nx, ny, x, y, matriz) + matriz[nx, ny];
                    c = c + "~" + fx;
                    Debug.Log("Add: " + c);
                    caminhos.Add(c);
                }

            }
            if (xo + 1 < largura - 1)
            {
                if (visitado[xo + 1, yo] != 1 && matriz[xo + 1, yo] < 11)
                {
                    int nx = xo + 1;
                    int ny = yo;
                    string c = caminhos[index].Split('~')[0] + nx + "," + ny + ";";
                    float fx = breseham(nx, ny, x, y, matriz) + matriz[nx, ny];
                    c = c + "~" + fx;
                    Debug.Log("Add: " + c);
                    caminhos.Add(c);
                }

            }
            if (yo + 1 < altura - 1)
            {
                if (visitado[xo, yo + 1] != 1 && matriz[xo, yo + 1] < 11)
                {
                    int nx = xo;
                    int ny = yo + 1;
                    string c = caminhos[index].Split('~')[0] + nx + "," + ny + ";";
                    float fx = breseham(nx, ny, x, y, matriz) + matriz[nx, ny];
                    c = c + "~" + fx;
                    Debug.Log("Add: " + c);
                    caminhos.Add(c);
                }

            }

            caminhos.Remove(cAtual);

            float auxiliar = float.MaxValue;
            int newIndex = 0;
            for (int i = 0; i < caminhos.Count; i++)
            {
                float temp = float.Parse(caminhos[i].Split('~')[1]);
                //Debug.Log("temp:" +temp);
                if (temp < auxiliar)
                {
                    auxiliar = temp;
                    newIndex = i;
                }
            }

            Debug.Log("indice:" + newIndex + " - Peso: " + auxiliar);
            string uc = caminhos[newIndex].Split('~')[0];
            string[] ultimo = uc.Split(';');
            uc = ultimo[ultimo.Length - 2];
            //uc.Remove(';');
            Debug.Log("UC: " + uc);
            int proxI = int.Parse(uc.Split(',')[0]);
            int proxJ = int.Parse(uc.Split(',')[1]);

            custoUniforme(proxI, proxJ, x, y, largura, altura, matriz, visitado, caminhos, caminhos[newIndex], newIndex);


        }
    }


    void gulosoIterativo(int xo, int yo, int x, int y, float[,] matriz, int[,] matrizOcupada, int largura, int altura, List<string> caminhoTemp)
    {
        if (!foundResult)
        {
            caminhoTemp.Add(xo + "," + yo);
            matrizOcupada[xo, yo] = 1;
            if(xo == x && yo == y)
            {
                controle.GetComponent<ControleMapa>().caminho = caminhoTemp;
                foundResult = true;
            }
            else
            {
                
                List<int[]> caminhosPossiveis = new List<int[]>();
                if (xo - 1 >= 1)
                {
                    if(matrizOcupada[xo-1, yo] != 1) caminhosPossiveis.Add(new int[2] { xo - 1, yo });
                    

                }
                if (yo - 1 >= 1)
                {
                    if (matrizOcupada[xo, yo-1] != 1) caminhosPossiveis.Add(new int[2] { xo, yo - 1 });

                }
                if (xo + 1 < largura-2)
                {
                    if (matrizOcupada[xo + 1, yo] != 1) caminhosPossiveis.Add(new int[2] { xo + 1, yo });

                }
                if (yo + 1 < altura-2)
                {
                    if (matrizOcupada[xo , yo+1] != 1) caminhosPossiveis.Add(new int[2] { xo, yo + 1 });

                }


                //ordenação da melhor escolha para a maior

                for(int a = 0; a < caminhosPossiveis.Count; a++)
                {
                    for (int b = a+1; b < caminhosPossiveis.Count; b++)
                    {
                        int tempIo = caminhosPossiveis[a][0];
                        int tempJo = caminhosPossiveis[a][1];
                        int tempI = caminhosPossiveis[b][0];
                        int tempJ = caminhosPossiveis[b][1];
                        if (matriz[tempIo, tempJo] > matriz[tempI, tempJ])
                        {
                            int[] aux = caminhosPossiveis[a];
                            caminhosPossiveis[a] = caminhosPossiveis[b];
                            caminhosPossiveis[b] = aux;
                        }
                    }
                }

                

                for (int a = 0; a < caminhosPossiveis.Count; a++) {

                    if (!foundResult)
                        {
                        int xprox = caminhosPossiveis[a][0];
                        int yprox = caminhosPossiveis[a][1];
                        //Debug.Log("Testando:" + xprox + "," + yprox);
                        gulosoIterativo(xprox, yprox, x, y, matriz, matrizOcupada, largura, altura, caminhoTemp);
                        }
                    }

            }
        }
    }

  
}

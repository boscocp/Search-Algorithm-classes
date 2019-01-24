/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aulabuscas;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author adalberto.bcpereira
 */
public class AulaBuscas {
    public static List<No> mapa = new ArrayList();
    public static int linhas = 8;
    public static int colunas = 8;
    /**
     * @param args the command line arguments
     */
    
    public static void criaMapa()
    {
        int contador = 0;
        for (int i = 0; i<linhas; i++)
        {
            for (int j = 0; j<colunas; j++)
            {
                
                No no = new No(contador);
                mapa.add(no);
                
                contador++;
            }
        }
    }
    
    public static void configuraMapa()
    {
        for(No no: mapa)
        {
            //calcular linha
            int linha = (no.getId()/linhas)+1;
            //calcula coluna
            int coluna = (no.getId()%colunas)+1;
            
            //System.out.println(linha+" "+coluna);
            no.vizinhos.addAll(acharCantos(linha,coluna, no));
            no.vizinhos.addAll(acharOrtogonais(linha,coluna, no));
        }
    }
    
    public static List<No> acharCantos(int linhaDoNo, int colunaDoNo, No no)
    {
        int id = no.getId();
        List<No> list = new ArrayList();
        //pega canto superior esquerda
        if (linhaDoNo > 1 && colunaDoNo > 1) {
            list.add(mapa.get((id - colunas) - 1));
        }
        //pega canto superior direita
        if (linhaDoNo > 1 && colunaDoNo < colunas) {
            list.add(mapa.get((id - colunas) + 1));
        }
        
        //pegar canto superior esquerdo
        if (linhaDoNo < mapa.size() / linhas && colunaDoNo > 1) {
            list.add(mapa.get((id + colunas) - 1));
        }
        //pegar canto superior direito
        if (linhaDoNo < mapa.size() / linhas && colunaDoNo < colunas) {
            list.add(mapa.get((id + colunas) + 1));
        }

        return list;
    }
    
    public static List<No> acharOrtogonais (int linhaDoNo, int colunaDoNo, No no)
    {
        List<No> list = new ArrayList();
        int id = no.getId();
        //pegar vizinho esquerdo
        if (colunaDoNo > 1) {
            list.add(mapa.get(id - 1));
        }
        //pegar vizinho direito
       	if (colunaDoNo < colunaDoNo) {
            list.add(mapa.get(id + 1));
        }
        if (linhaDoNo > 1) {
            list.add(mapa.get(id - colunaDoNo));
        }
        if (linhaDoNo < mapa.size()/linhas) {
            list.add(mapa.get(id + colunas));
        }
        
        return list;
    }
   
    
    public static void main(String[] args) {
        // TODO code application logic here
        criaMapa();
        configuraMapa();
        
        for(No no: mapa){
            System.out.println("Noh: "+ no.getId());
        }
        
    }
    
}

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
    public static int linhas = 7;
    public static int colunas = 6;
    /**
     * @param args the command line arguments
     */
    
    public static void criaMapa()
    {
        int contador = 0;
        for (int i = 0; i<colunas; i++)
        {
            for (int j = 0; j<linhas; j++)
            {
                
                No no = new No(contador);
                mapa.add(no);
                
                contador++;
            }
        }
    }
    
    public static int calcularG(No noAtual, No noVizinho)
    {
        if (noVizinho.getId() % colunas == noAtual.getId() % colunas || noVizinho.getId() + 1 == noAtual.getId() || noVizinho.getId() - 1 == noAtual.getId()) {
            return noVizinho.getG() + 10;
        } else {
            return noVizinho.getG() + 14;
        }
        
    }
    
    public static int calcularH(No noAtual, No noDestino)
    {
        int posicaoDestinoX = (noDestino.getId()+1)%colunas;
        int posicaoNoAtualX = (noAtual.getId()+1)%colunas;
        int distanciaX = posicaoDestinoX > posicaoNoAtualX ? posicaoDestinoX - posicaoNoAtualX : posicaoNoAtualX - posicaoDestinoX;
        
        int posicaoDestinoY = (noDestino.getId()+1)/linhas;
        int posicaoNoAtualY = (noAtual.getId()+1)/linhas;
        int distanciaY = posicaoDestinoY > posicaoNoAtualY ? posicaoDestinoY - posicaoNoAtualY : posicaoNoAtualY - posicaoDestinoY;
        
        return distanciaX+distanciaY;
    }
    
    
    
    public static void configuraMapa()
    {
        for(No no: mapa)
        {
            no.vizinhos.addAll(acharCantos(no));
            no.vizinhos.addAll(acharOrtogonais(no));
        }
    }
    
    public static List<No> acharCantos(No no)
    {
        int id = no.getId();
        List<No> list = new ArrayList();
        
        //calcular linha
        int linhaDoNo = (no.getId()/linhas)+1;
        //calcula coluna
        int colunaDoNo = (no.getId()%colunas)+1;
            
            
        //pega canto superior esquerda
        if (linhaDoNo > 1 && colunaDoNo > 1) {
            list.add(mapa.get((id - colunas) - 1));
        }
        //pega canto superior direita
        if (linhaDoNo > 1 && colunaDoNo < colunas) {
            list.add(mapa.get((id - colunas) + 1));
        }
        
        //pegar canto infoerior esquerdo
        if (linhaDoNo < mapa.size() / linhas && colunaDoNo > 1) {
            list.add(mapa.get((id + colunas) - 1));
        }
        //pegar canto inferior direito
        if (linhaDoNo < mapa.size() / linhas && colunaDoNo < colunas) {
            list.add(mapa.get((id + colunas) + 1));
        }

        return list;
    }
    
    public static List<No> acharOrtogonais (No no)
    {   
        //calcular linha
        int linhaDoNo = (no.getId()/linhas)+1;
        //calcula coluna
        int colunaDoNo = (no.getId()%colunas)+1;
        List<No> list = new ArrayList();
        int id = no.getId();
        //pegar vizinho esquerdo
        if (colunaDoNo > 1) {
            list.add(mapa.get(id - 1));
        }
        //pegar vizinho direito
       	if (colunaDoNo < colunas) {
            list.add(mapa.get(id + 1));
        }
        //pegar vizinho cima
        if (linhaDoNo > 1) {
            list.add(mapa.get((id - linhas)+1));
        }
        //pegar vizinho baixo
        if (linhaDoNo < mapa.size()/linhas) {
            list.add(mapa.get(id + colunas));
        }
        
        return list;
    }
   
    
    public static void main(String[] args) {
        // TODO code application logic here
        criaMapa();
        configuraMapa();
        
        //System.out.println(mapa.get(0).vizinhos);
        
        for(No no: mapa){
            System.out.println("Noh: "+ no.getId());
        }
        System.out.println("--------------------------------");
        for(No no: mapa.get(37).vizinhos){
            System.out.println("Noh: "+ no.getId());
        }
        System.out.println("Noh: "+ mapa.get(37).getId()+" - G: "+ calcularG(mapa.get(37), mapa.get(36)));
        
        
    }
    
}

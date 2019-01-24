/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aulabuscas;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


/**
 *
 * @author adalberto.bcpereira
 */
public class AEstrela {
    public static List<No> listaFechada = new ArrayList();
    public static List<No> listaAberta = new ArrayList();
    public static List<No> caminho = new ArrayList();
    
    public static List<No> aEstrela(No noInicial, No noDestino)
    {
        No noAtual = noInicial;
        listaAberta.add(noInicial);
        
        while(true)
        {
            noAtual = procularMenorF();
        }
        
    }
    
    public static No procularMenorF() {
        Collections.sort(listaAberta, Comparator.comparing(No::getF));
        return listaAberta.get(0);
        
    }
    
    
       
    public static void calcularF(No noAtual)
    {
        float F = 0;
        for(No no: noAtual.getVizinhos())
        {
            F= calcularH(noAtual,no) + (float)calcularG(noAtual, no);
            no.setF(F);
        }

    }
    
    public static float calcularG(No noAtual, No noVizinho)
    {
        if (noVizinho.getId() % AulaBuscas.colunas == noAtual.getId() % AulaBuscas.colunas || noVizinho.getId() + 1 == noAtual.getId() || noVizinho.getId() - 1 == noAtual.getId()) {
            return noVizinho.getG() + 10;
        } else {
            return noVizinho.getG() + 14;
        }
        
    }
 
    
    public static float calcularH(No noAtual, No noDestino)
    {
        int posicaoDestinoX = (noDestino.getId()%AulaBuscas.colunas)+1;
        int posicaoNoAtualX = (noAtual.getId()%AulaBuscas.colunas)+1;
        
        int distanciaX = posicaoDestinoX > posicaoNoAtualX ? posicaoDestinoX - posicaoNoAtualX : posicaoNoAtualX - posicaoDestinoX;
        
        int posicaoDestinoY = (noDestino.getId()/AulaBuscas.linhas)+1;
        int posicaoNoAtualY = (noAtual.getId()/AulaBuscas.linhas)+1;
        
        int distanciaY = posicaoDestinoY > posicaoNoAtualY ? posicaoDestinoY - posicaoNoAtualY : posicaoNoAtualY - posicaoDestinoY;
        
        float distanciaTotal = (float)Math.sqrt((Math.pow(distanciaX, 2)+Math.pow(distanciaY, 2)))*10;
                
        return distanciaTotal;
    }
    
}

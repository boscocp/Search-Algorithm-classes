/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aulabuscas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author adalberto.bcpereira
 */
public class BuscaEmLargura {
    public static List<No> fila = new ArrayList();
    public static List<No> caminho = new ArrayList(); 
    public static int tamanhoDoMapa; 
    public static List<No> bucaEmLargura(No noInicial, No noDestino, Mapa mapa)
    {
        tamanhoDoMapa = mapa.getMapa().size();
        No noAtual = noInicial;
        noAtual.setVisitado(true);
        fila.add(noAtual);
        while(!fila.isEmpty())
        {
            if (noAtual.equals(noDestino)) return montaCaminho(noInicial, noDestino);
            noAtual = fila.remove(0);
            for(No no: noAtual.getVizinhos())
            {
                if(!no.isVisitado() && !no.estaBloqueado())
                {
                    no.setPai(noAtual);
                    no.setVisitado(true);
                    fila.add(no);
                }
            }
        }
        System.out.println("nao achou caminhoS");
        return montaCaminho(noInicial, noDestino);
    }
    
    private static List<No> montaCaminho(No noInicial, No noDestino) {
        List<No> listaAuxiliar = new ArrayList();
        No noAtual = noDestino;
        int contador = 0;
        while (!listaAuxiliar.contains(noInicial) || contador > tamanhoDoMapa)
        {
            listaAuxiliar.add(noAtual);
            
            noAtual = noAtual.getPai();
                        
            contador++;
        }
        Collections.reverse(listaAuxiliar);
        
        System.out.println("Caminho: ");
        for(No no: listaAuxiliar)
        {
            System.out.print(" -> " + no.getId());
        }
        System.out.println("");
        System.out.println("Fim! ");
        return listaAuxiliar;
    }
    
}

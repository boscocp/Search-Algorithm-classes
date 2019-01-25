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
    
   
    
    public static void main(String[] args) {
        // TODO code application logic here
        Mapa mapa = new Mapa(7,6);
        //System.out.println(mapa.get(0).vizinhos);
        mapa.getMapa().get(12).setBloqueado(true);
        mapa.getMapa().get(13).setBloqueado(true);
        mapa.getMapa().get(14).setBloqueado(true);
        mapa.getMapa().get(15).setBloqueado(true);
        mapa.getMapa().get(16).setBloqueado(true);
        
        System.out.println("--------------------------------");
       
        AEstrela.aEstrela(mapa.getMapa().get(0), mapa.getMapa().get(32), mapa);
        BuscaEmLargura.bucaEmLargura(mapa.getMapa().get(0), mapa.getMapa().get(32), mapa);
        
    }
    
}

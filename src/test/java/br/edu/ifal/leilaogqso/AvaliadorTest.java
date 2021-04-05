package br.edu.ifal.leilaogqso;

// import static org.junit.Assert.*;
// import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class AvaliadorTest {

    @Test
    public void testSeMenorValorEstaSendoAvaliado() {
        Usuario joao = new Usuario("Joao");
        Usuario jose = new Usuario("José");
        Usuario maria = new Usuario("Maria");
        
        Leilao leilao = new Leilao("Playstation 3 Novo");
        leilao.propoe(new Lance(joao, 100.0));
        leilao.propoe(new Lance(jose, 400.0));
        leilao.propoe(new Lance(maria, 250.0));
        
        Avaliador leiloeiro = new Avaliador();
        leiloeiro.avalia(leilao);		
        assertEquals(100.0, leiloeiro.getMenorLance(), 0.01);        
    }

    @Test
    public void testSeMaiorValorEstaSendoAvaliado() {
        Usuario joao = new Usuario("Joao");
        Usuario jose = new Usuario("José");
        Usuario maria = new Usuario("Maria");
        
        Leilao leilao = new Leilao("Playstation 3 Novo");
        leilao.propoe(new Lance(joao, 100.0));
        leilao.propoe(new Lance(jose, 400.0));
        leilao.propoe(new Lance(maria, 250.0));
        
        Avaliador leiloeiro = new Avaliador();
        leiloeiro.avalia(leilao);		
        assertEquals(400.0, leiloeiro.getMaiorLance(), 0.01);        
    }
    
}

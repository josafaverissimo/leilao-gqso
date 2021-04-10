package br.edu.ifal.leilaogqso;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class AvaliadorTest {

    @Test
    public void testSeOPrimeiroMenorValorEstaSendoAvaliado() {
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
    public void testSeOSegundoMenorValorEstaSendoAvaliado() {
        Usuario joao = new Usuario("Joao");
        Usuario jose = new Usuario("José");
        Usuario maria = new Usuario("Maria");
        
        Leilao leilao = new Leilao("Playstation 3 Novo");
        leilao.propoe(new Lance(joao, 400.0));
        leilao.propoe(new Lance(jose, 100.0));
        leilao.propoe(new Lance(maria, 250.0));
        
        Avaliador leiloeiro = new Avaliador();
        leiloeiro.avalia(leilao);		
        assertEquals(100.0, leiloeiro.getMenorLance(), 0.01);        
    }

    @Test
    public void testSeOTerceiroMenorValorEstaSendoAvaliado() {
        Usuario joao = new Usuario("Joao");
        Usuario jose = new Usuario("José");
        Usuario maria = new Usuario("Maria");
        
        Leilao leilao = new Leilao("Playstation 3 Novo");
        leilao.propoe(new Lance(joao, 250.0));
        leilao.propoe(new Lance(jose, 400.0));
        leilao.propoe(new Lance(maria, 100.0));
        
        Avaliador leiloeiro = new Avaliador();
        leiloeiro.avalia(leilao);		
        assertEquals(100.0, leiloeiro.getMenorLance(), 0.01);        
    }

    @Test
    public void testSeOPrimeiroMaiorValorEstaSendoAvaliado() {
        Usuario joao = new Usuario("Joao");
        Usuario jose = new Usuario("José");
        Usuario maria = new Usuario("Maria");
        
        Leilao leilao = new Leilao("Playstation 3 Novo");
        leilao.propoe(new Lance(joao, 400.0));
        leilao.propoe(new Lance(jose, 100.0));
        leilao.propoe(new Lance(maria, 250.0));
        
        Avaliador leiloeiro = new Avaliador();
        leiloeiro.avalia(leilao);		
        assertEquals(400.0, leiloeiro.getMaiorLance(), 0.01);        
    }

    @Test
    public void testSeOSegundoMaiorValorEstaSendoAvaliado() {
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

    @Test
    public void testSeOTerceiroMaiorValorEstaSendoAvaliado() {
        Usuario joao = new Usuario("Joao");
        Usuario jose = new Usuario("José");
        Usuario maria = new Usuario("Maria");
        
        Leilao leilao = new Leilao("Playstation 3 Novo");
        leilao.propoe(new Lance(joao, 100.0));
        leilao.propoe(new Lance(jose, 250.0));
        leilao.propoe(new Lance(maria, 400.0));
        
        Avaliador leiloeiro = new Avaliador();
        leiloeiro.avalia(leilao);		
        assertEquals(400.0, leiloeiro.getMaiorLance(), 0.01);        
    }

    @Test
    public void testMaiorValorEmCincoLances() {
        Usuario joao = new Usuario("Joao");
        Usuario jose = new Usuario("José");
        Usuario maria = new Usuario("Maria");
        Usuario josafa = new Usuario("Josafá");
        Usuario leofernandes = new Usuario("leofernandes");
        
        Leilao leilao = new Leilao("Playstation 3 Novo");
        leilao.propoe(new Lance(joao, 100.0));
        leilao.propoe(new Lance(jose, 250.0));
        leilao.propoe(new Lance(maria, 700.0));
        leilao.propoe(new Lance(josafa, 300.0));
        leilao.propoe(new Lance(leofernandes, 400.0));
        
        Avaliador leiloeiro = new Avaliador();
        leiloeiro.avalia(leilao);
        assertEquals(700.0, leiloeiro.getMaiorLance(), 0.01);
    }

    @Test
    public void testMenorValorEmCincoLances() {
        Usuario joao = new Usuario("Joao");
        Usuario jose = new Usuario("José");
        Usuario maria = new Usuario("Maria");
        Usuario josafa = new Usuario("Josafá");
        Usuario leofernandes = new Usuario("leofernandes");
        
        Leilao leilao = new Leilao("Playstation 3 Novo");
        leilao.propoe(new Lance(joao, 100.0));
        leilao.propoe(new Lance(jose, 250.0));
        leilao.propoe(new Lance(maria, 700.0));
        leilao.propoe(new Lance(josafa, 300.0));
        leilao.propoe(new Lance(leofernandes, 400.0));
        
        Avaliador leiloeiro = new Avaliador();
        leiloeiro.avalia(leilao);
        assertEquals(100.0, leiloeiro.getMenorLance(), 0.01);
    }
    
    @Test
    public void testMaiorValorComValoresRepetidos() {
        Usuario joao = new Usuario("Joao");
        Usuario jose = new Usuario("José");
        Usuario maria = new Usuario("Maria");
        
        Leilao leilao = new Leilao("Playstation 3 Novo");
        leilao.propoe(new Lance(joao, 800.0));
        leilao.propoe(new Lance(jose, 1200.0));
        leilao.propoe(new Lance(maria, 1200.0));
        
        Avaliador leiloeiro = new Avaliador();
        leiloeiro.avalia(leilao);
        assertEquals(1200.0, leiloeiro.getMaiorLance(), 0.01);
    }

    @Test
    public void testMenorValorComValoresRepetidos() {
        Usuario joao = new Usuario("Joao");
        Usuario jose = new Usuario("José");
        Usuario maria = new Usuario("Maria");
        
        Leilao leilao = new Leilao("Playstation 3 Novo");
        leilao.propoe(new Lance(joao, 800.0));
        leilao.propoe(new Lance(jose, 800.0));
        leilao.propoe(new Lance(maria, 1200.0));
        
        Avaliador leiloeiro = new Avaliador();
        leiloeiro.avalia(leilao);
        assertEquals(800.0, leiloeiro.getMenorLance(), 0.01);
    }

    @Test
    public void testMaiorValorComTodosOsLancesZerados() {
        Usuario joao = new Usuario("Joao");
        Usuario jose = new Usuario("José");
        Usuario maria = new Usuario("Maria");
        
        Leilao leilao = new Leilao("Playstation 3 Novo");
        leilao.propoe(new Lance(joao, 0.0));
        leilao.propoe(new Lance(jose, 0.0));
        leilao.propoe(new Lance(maria, 0.0));
        
        Avaliador leiloeiro = new Avaliador();
        leiloeiro.avalia(leilao);
        assertEquals(0.0, leiloeiro.getMaiorLance(), 0.01);
    }

    @Test
    public void testMenorValorComTodosOsLancesZerados() {
        Usuario joao = new Usuario("Joao");
        Usuario jose = new Usuario("José");
        Usuario maria = new Usuario("Maria");
        
        Leilao leilao = new Leilao("Playstation 3 Novo");
        leilao.propoe(new Lance(joao, 0.0));
        leilao.propoe(new Lance(jose, 0.0));
        leilao.propoe(new Lance(maria, 0.0));
        
        Avaliador leiloeiro = new Avaliador();
        leiloeiro.avalia(leilao);
        assertEquals(0.0, leiloeiro.getMenorLance(), 0.01);
    }

    @Test
    public void testMaiorValorInicial() {
        Usuario joao = new Usuario("Joao");
        Usuario jose = new Usuario("José");
        Usuario maria = new Usuario("Maria");
        
        Leilao leilao = new Leilao("Playstation 3 Novo");
        leilao.propoe(new Lance(joao, 100.0));
        leilao.propoe(new Lance(jose, 250.0));
        leilao.propoe(new Lance(maria, 400.0));
        
        Avaliador leiloeiro = new Avaliador();
        assertEquals(0.0, leiloeiro.getMaiorLance());
    }

    @Test
    public void testMenorValorInicial() {
        Usuario joao = new Usuario("Joao");
        Usuario jose = new Usuario("José");
        Usuario maria = new Usuario("Maria");
        
        Leilao leilao = new Leilao("Playstation 3 Novo");
        leilao.propoe(new Lance(joao, 100.0));
        leilao.propoe(new Lance(jose, 250.0));
        leilao.propoe(new Lance(maria, 400.0));
        
        Avaliador leiloeiro = new Avaliador();
        assertTrue(leiloeiro.getMenorLance() == Double.MAX_VALUE);
    }
}

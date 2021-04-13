package br.edu.ifal.leilaogqso;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AvaliadorTest {
    static Leilao leilao;
    static Avaliador leiloeiro;
    static Usuario joao;
    static Usuario jose;
    static Usuario maria;

    @BeforeEach
    void setUp() {
        joao = new Usuario("Joao");
        jose = new Usuario("José");
        maria = new Usuario("Maria");
        leilao = new Leilao("Playstation 3 Novo");
        leiloeiro = new Avaliador();
    }

    @Test
    public void testSeOPrimeiroMenorValorEstaSendoAvaliado() {
        leilao.propoe(new Lance(joao, 100.0));
        leilao.propoe(new Lance(jose, 400.0));
        leilao.propoe(new Lance(maria, 250.0));
        leiloeiro.avalia(leilao);
        assertEquals(100.0, leiloeiro.getMenorLance(), 0.01);
    }

    @Test
    public void testSeOSegundoMenorValorEstaSendoAvaliado() {
        leilao.propoe(new Lance(joao, 400.0));
        leilao.propoe(new Lance(jose, 100.0));
        leilao.propoe(new Lance(maria, 250.0));
        leiloeiro.avalia(leilao);
        assertEquals(100.0, leiloeiro.getMenorLance(), 0.01);
    }

    @Test
    public void testSeOTerceiroMenorValorEstaSendoAvaliado() {
        leilao.propoe(new Lance(joao, 250.0));
        leilao.propoe(new Lance(jose, 400.0));
        leilao.propoe(new Lance(maria, 100.0));
        leiloeiro.avalia(leilao);
        assertEquals(100.0, leiloeiro.getMenorLance(), 0.01);
    }

    @Test
    public void testSeOPrimeiroMaiorValorEstaSendoAvaliado() {
        leilao.propoe(new Lance(joao, 400.0));
        leilao.propoe(new Lance(jose, 100.0));
        leilao.propoe(new Lance(maria, 250.0));
        leiloeiro.avalia(leilao);
        assertEquals(400.0, leiloeiro.getMaiorLance(), 0.01);
    }

    @Test
    public void testSeOSegundoMaiorValorEstaSendoAvaliado() {
        leilao.propoe(new Lance(joao, 100.0));
        leilao.propoe(new Lance(jose, 400.0));
        leilao.propoe(new Lance(maria, 250.0));
        leiloeiro.avalia(leilao);
        assertEquals(400.0, leiloeiro.getMaiorLance(), 0.01);
    }

    @Test
    public void testSeOTerceiroMaiorValorEstaSendoAvaliado() {
        leilao.propoe(new Lance(joao, 100.0));
        leilao.propoe(new Lance(jose, 250.0));
        leilao.propoe(new Lance(maria, 400.0));
        leiloeiro.avalia(leilao);
        assertEquals(400.0, leiloeiro.getMaiorLance(), 0.01);
    }

    @Test
    public void testMaiorValorEmCincoLances() {
        Usuario josafa = new Usuario("josafa");
        Usuario leofernandes = new Usuario("leofernandes");

        leilao.propoe(new Lance(joao, 100.0));
        leilao.propoe(new Lance(jose, 250.0));
        leilao.propoe(new Lance(maria, 700.0));
        leilao.propoe(new Lance(josafa, 300.0));
        leilao.propoe(new Lance(leofernandes, 400.0));        
        leiloeiro.avalia(leilao);
        assertEquals(700.0, leiloeiro.getMaiorLance(), 0.01);
    }

    @Test
    public void testMenorValorEmCincoLances() {
        Usuario josafa = new Usuario("josafa");
        Usuario leofernandes = new Usuario("leofernandes");

        leilao.propoe(new Lance(joao, 100.0));
        leilao.propoe(new Lance(jose, 250.0));
        leilao.propoe(new Lance(maria, 700.0));
        leilao.propoe(new Lance(josafa, 300.0));
        leilao.propoe(new Lance(leofernandes, 400.0));
        leiloeiro.avalia(leilao);
        assertEquals(100.0, leiloeiro.getMenorLance(), 0.01);
    }

    @Test
    public void testMaiorValorComValoresRepetidos() {
        leilao.propoe(new Lance(joao, 800.0));
        leilao.propoe(new Lance(jose, 1200.0));
        leilao.propoe(new Lance(maria, 1200.0));
        leiloeiro.avalia(leilao);
        assertEquals(1200.0, leiloeiro.getMaiorLance(), 0.01);
    }

    @Test
    public void testMenorValorComValoresRepetidos() {
        leilao.propoe(new Lance(joao, 800.0));
        leilao.propoe(new Lance(jose, 800.0));
        leilao.propoe(new Lance(maria, 1200.0));        
        leiloeiro.avalia(leilao);
        assertEquals(800.0, leiloeiro.getMenorLance(), 0.01);
    }

    @Test
    public void testMaiorValorComTodosOsLancesZerados() {
        leilao.propoe(new Lance(joao, 0.0));
        leilao.propoe(new Lance(jose, 0.0));
        leilao.propoe(new Lance(maria, 0.0));        
        leiloeiro.avalia(leilao);
        assertEquals(0.0, leiloeiro.getMaiorLance(), 0.01);
    }

    @Test
    public void testMenorValorComTodosOsLancesZerados() {
        leilao.propoe(new Lance(joao, 0.0));
        leilao.propoe(new Lance(jose, 0.0));
        leilao.propoe(new Lance(maria, 0.0));        
        leiloeiro.avalia(leilao);
        assertEquals(0.0, leiloeiro.getMenorLance(), 0.01);
    }

    @Test
    public void testMaiorValorInicial() {
        assertEquals(0.0, leiloeiro.getMaiorLance());
    }

    @Test
    public void testMenorValorInicial() {
        assertTrue(leiloeiro.getMenorLance() == 0);
    }

    @Test
    public void testMenorValorNegativo() {
        leilao.propoe(new Lance(joao, -100.0));
        leilao.propoe(new Lance(jose, 420.0));
        leilao.propoe(new Lance(maria, 500.0));
        leiloeiro.avalia(leilao);
        assertEquals(0.0, leiloeiro.getMenorLance(), 0.01);
    }

    @Test
    public void testMenorLanceComUsuarioRepetidoComMultiplosLances() {
        leilao.propoe(new Lance(joao, 400.0));
        leilao.propoe(new Lance(joao, 300.0));
        leilao.propoe(new Lance(joao, 500.0));
        leiloeiro.avalia(leilao);
        assertEquals(300.0, leiloeiro.getMenorLance(), 0.01);
    }

    @Test
    public void testMaiorLanceComUsuarioRepetidoComMultiplosLances() {
        leilao.propoe(new Lance(joao, 430.0));
        leilao.propoe(new Lance(joao, 995.0));
        leilao.propoe(new Lance(joao, 1343.0));
        leiloeiro.avalia(leilao);
        assertEquals(1343.0, leiloeiro.getMaiorLance(), 0.01);
    }

    @Test
    public void testMaiorLanceComUsuariosRepetidosComMultiplosLances() {
        leilao.propoe(new Lance(joao, 9482.0));
        leilao.propoe(new Lance(joao, 10923.0));

        leilao.propoe(new Lance(jose, 5932.0));
        leilao.propoe(new Lance(jose, 19322.0));

        leilao.propoe(new Lance(maria, 2039.0));
        leilao.propoe(new Lance(maria, 93821.0));
        leiloeiro.avalia(leilao);
        assertEquals(93821.0, leiloeiro.getMaiorLance(), 0.01);
    }

    @Test
    public void testMenorLanceComUsuariosRepetidosComMultiplosLances() {
        leilao.propoe(new Lance(joao, 9482.0));
        leilao.propoe(new Lance(joao, 10923.0));

        leilao.propoe(new Lance(jose, 5932.0));
        leilao.propoe(new Lance(jose, 19322.0));

        leilao.propoe(new Lance(maria, 2039.0));
        leilao.propoe(new Lance(maria, 93821.0));
        leiloeiro.avalia(leilao);
        assertEquals(2039.0, leiloeiro.getMenorLance(), 0.01);
    }
}

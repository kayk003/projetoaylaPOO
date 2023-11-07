package br.ufpb.dcx.animes;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.Assert.*;

public class ProgramaAnimesTest {
    private SistemaAnimes sistema;
    private GravadorDeAnimes gravadorAnimes;

//    @Before
//    public void setUp() {
//        sistema = new AnimesKaykeGuilherme();
//        gravadorAnimes = new GravadorDeAnimes();
//    }

    @Test
    public void testCadastrarAnime() throws AnimeJaExiste {
        // Teste para cadastrar um anime
        sistema = new AnimesKaykeGuilherme();
        sistema.cadastrarAnime("Naruto", "Japão", 2002);
        List<Animes> animes = sistema.obterTodosAnimes();
        boolean animeEncontrado = false;
        for (Animes anime : animes) {
            if (anime.getNome().equals("Naruto")) {
                animeEncontrado = true;
            }
        }
        assertTrue(animeEncontrado);
    }

    @Test
    public void testApagarAnime() throws AnimeJaExiste, AnimeNaoExiste {
        // Teste para apagar um anime
        sistema = new AnimesKaykeGuilherme();
        sistema.cadastrarAnime("One Piece", "Japão", 1999);
        sistema.apagarAnime("One Piece");
        List<Animes> animes = sistema.obterTodosAnimes();
        boolean animeEncontrado = false;
        for (Animes anime : animes) {
            if (anime.getNome().equals("One Piece")) {
                animeEncontrado = true;
                break;
            }
        }
        assertFalse(animeEncontrado);
    }

    @Test
    public void testPesquisarPorNome() throws AnimeJaExiste, AnimeNaoExiste {
         //*Teste para pesquisar animes por nome
        sistema = new AnimesKaykeGuilherme();
        sistema.cadastrarAnime("Death Note", "Japão", 2006);
        List<Animes> animes = sistema.pesquisarAnimesPorNome("Death Note");
        assertEquals(1, animes.size());
        assertEquals("Death Note", animes.get(0).getNome());
    }

}

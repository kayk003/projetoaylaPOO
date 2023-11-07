package br.ufpb.dcx.animes;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GravadorDeAnimes {

    private String arquivosAnimes = "animes.txt";
    private GravadorDeDados gravador;

    public GravadorDeAnimes() {
        this.gravador = new GravadorDeDados();
    }

    public void gravaAnime(List<Animes> AnimeList) throws IOException {
        List<String> textoGravar = new ArrayList<>();
        for(Animes a : AnimeList) {
            String criarLinha = a.getNome()+"###"+a.getPais()+"###"+a.getAno();
            textoGravar.add(criarLinha);
        }
        this.gravador.gravaTextoEmArquivo(textoGravar, this.arquivosAnimes);
    }

    public List<Animes> recuperaAnimes() throws IOException {
        List<String> dadosAnime = this.gravador.recuperaTextoDeArquivo(this.arquivosAnimes);
        List<Animes> animesList = new ArrayList<>();
        for(String s : dadosAnime) {
            String [] dados = s.split("###");
            Animes produto = new Animes(dados[0],dados[1],Integer.parseInt(dados[2]));
            animesList.add(produto);
        }
        return animesList;
    }
}

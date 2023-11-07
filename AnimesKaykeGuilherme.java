package br.ufpb.dcx.animes;

import java.util.LinkedList;
import java.util.List;

public class AnimesKaykeGuilherme implements SistemaAnimes{

    private List<Animes> animes;

    public AnimesKaykeGuilherme(){
        this.animes = new LinkedList<>();
    }
    /**
     * Verifica no sistema se existe um anime com esse nome nesse país
     * deste ano.
     * @param nome O nome do anime a pesquisar.
     * @param pais A cidade do anime a pesquisar.
     * @param ano O ano do anime a pesquisar.
     * @return true se o anime existir e false, caso contrário.
     */

    public boolean ExisteAnime (String nome, String pais, int ano){
        for(Animes a: this.animes){
            if(a.getNome().equals(nome) && a.getPais().equals(pais) && a.getAno() == (ano)){
                return true;
            }
        }
        return false;
    }

    public void cadastrarAnime(String nome, String pais, int ano) throws AnimeJaExiste{
        if(this.ExisteAnime(nome,pais,ano)){
            throw new AnimeJaExiste("Já existe um anime de nome "+nome+"do país "+pais+"do ano "+ano);
        } else {
            Animes animes1 = new Animes(nome, pais, ano);
            this.animes.add(animes1);
        }

    }

    public void carregaNovosAnimes (List<Animes> novosAnimes)
        throws AnimeJaExiste{
        for(Animes animes1: novosAnimes){
            if(this.ExisteAnime(animes1.getNome(), animes1.getPais(), animes1.getAno())){
                throw new AnimeJaExiste("Já existe o anime "+animes1.toString());
            } else{
                this.animes.add(animes1);
            }
        }
    }


    public List<Animes> obterTodosAnimes(){
        return this.animes;

    }


    public void apagarAnime(String nome) throws AnimeNaoExiste{
        for (Animes a: animes){
            if (a.getNome().equals(nome)){
                animes.remove(a);
            } else {
                throw new AnimeNaoExiste("Anime não existe no sistema");
            }

        }

    }

    public List<Animes> pesquisarAnimesPorNome(String nome) throws AnimeNaoExiste {
        Animes a = this.animes.get(Integer.parseInt(nome));
        if (a==null){
            throw new AnimeNaoExiste("Não existe anime com esse nome!" +nome);
        } else {
            return a.getNome();
        }

    }
}

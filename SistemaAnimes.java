package br.ufpb.dcx.animes;


import java.util.List;

public interface SistemaAnimes {

    /**
     *
     * @param nome O nome do anime que será cadastrado.
     * @param pais País do anime.
     * @param ano Ano em que foi criado o anime.
     * @return true se foi possível cadastrar o anime e false, se o anime ja está cadastrado.
     */


    void cadastrarAnime(String nome, String pais, int ano) throws AnimeJaExiste;

    /**
     * Retorna a lista de animes cadastrados no sistema.
     * @return a lista de objetos do tipo Animes cadastradas no sistema.
     */
    List<Animes> obterTodosAnimes();


    public void carregaNovosAnimes (List<Animes> novosAnimes) throws AnimeJaExiste;


    void apagarAnime(String nome) throws AnimeNaoExiste;

    List<Animes> pesquisarAnimesPorNome(String nome) throws AnimeNaoExiste;
}

package br.ufpb.dcx.animes;

import javax.imageio.IIOException;
import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ProgramaAnimes {
    public static void main (String [] agrs){

        SistemaAnimes sistema = new AnimesKaykeGuilherme();
        GravadorDeAnimes gravadorAnimes = new GravadorDeAnimes();

        try {
            List<Animes> recuperarListAnimes = gravadorAnimes.recuperaAnimes();
            for (Animes a : recuperarListAnimes) {
                sistema.cadastrarAnime(a.getNome(),a.getPais(),a.getAno());
            }
            JOptionPane.showMessageDialog(null, "Animes Recuperados com Sucesso!");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Não foi possível recuperar dados de nenhum Anime.");
        } catch (AnimeJaExiste e) {
            JOptionPane.showMessageDialog(null,e.getMessage());
        }

        boolean continuar = true;
        while (continuar) {

            int controle = Integer.parseInt(JOptionPane.showInputDialog(null, "ESCOLHA A OPÇÃO DESEJADA!\n1 - Cadastrar anime\n2 - Apagar Anime\n3 - Pesquisar Animes\n4 - Alterar anime\n5 - Sair e salvar"));

            switch (controle) {
                case 1:
                    String nomeAnime = JOptionPane.showInputDialog("Qual nome do anime? ");
                    String paisAnime = JOptionPane.showInputDialog("Qual pais de origem do anime? ");
                    int anoAnime = Integer.parseInt(JOptionPane.showInputDialog("Qual ano do anime? "));
                    try {
                        sistema.cadastrarAnime(nomeAnime, paisAnime, anoAnime);
                    } catch (AnimeJaExiste e) {
                        JOptionPane.showMessageDialog(null, "Anime já cadastrado no sistema.");
                        e.printStackTrace();
                    }
                    break;


                case 2:
                    String nomeApagar = JOptionPane.showInputDialog("Qual nome do anime que deseja apagar do sistema? ");
                    try {
                        sistema.apagarAnime(nomeApagar);
                        JOptionPane.showMessageDialog(null, "Anime apagado com sucesso.");
                    } catch (AnimeNaoExiste a) {
                        JOptionPane.showMessageDialog(null, "Nenhum anime com esse nome foi encontrado no sistema");
                        a.printStackTrace();
                    }
                    break;


                case 3:
                    List<Animes> animesPorNome = new ArrayList<>();
                    List<Animes> animesPorAno = new ArrayList<>();
                    List<Animes> animesPorPais = new ArrayList<>();
                    int opcaoPesquisa = Integer.parseInt(JOptionPane.showInputDialog(null, "1 - Pesquisar por nome\n2 - Pesquisar por ano\n3 - Pesquisar por Pais de origem\n\nQual opção de pesquisa você deseja?\n"));
                    switch (opcaoPesquisa) {
                        case 1:
                            String nomePesquisar = JOptionPane.showInputDialog(null, "Qual nome deseja pesquisar? ");

                            for (Animes anime : sistema.obterTodosAnimes()) {
                                if (anime.getNome().equals(nomePesquisar)) {
                                    animesPorNome.add(anime);
                                }
                            }
                            if (animesPorNome.isEmpty()) {
                                JOptionPane.showMessageDialog(null, "Nenhum anime com esse nome foi achado no sistema.");
                            } else {
                                JOptionPane.showMessageDialog(null, animesPorNome);

                            }
                            break;

                        case 2:
                            int anoPesquisa = Integer.parseInt(JOptionPane.showInputDialog(null, "Qual ano do anime que deseja pesquisar? "));

                            for (Animes anime : sistema.obterTodosAnimes()) {
                                if (anime.getAno() == anoPesquisa) {
                                    animesPorAno.add(anime);
                                }
                            }
                            if (animesPorAno.isEmpty()) {
                                JOptionPane.showMessageDialog(null, "Nenhum anime desse ano foi achado no sistema.");
                            } else {
                                JOptionPane.showMessageDialog(null, animesPorAno);

                            }
                            break;

                        case 3:
                            String paisPesquisa = JOptionPane.showInputDialog(null, "Qual ano do anime que deseja pesquisar? ");

                            for (Animes anime : sistema.obterTodosAnimes()) {
                                if (anime.getPais().equals(paisPesquisa)) {
                                    animesPorPais.add(anime);
                                }
                            }
                            if (animesPorPais.isEmpty()) {
                                JOptionPane.showMessageDialog(null, "Nenhum anime desse pais foi achado no sistema.");
                            } else {
                                JOptionPane.showMessageDialog(null, animesPorPais);
                                ;
                            }
                            break;
                    }
                    break;


                case 4:
                    String nomeAlterar = JOptionPane.showInputDialog(null, "Qual nome do anime que deseja alterar os dados? ");
                    for (Animes a : sistema.obterTodosAnimes()) {
                        if (a.getNome().equals(nomeAlterar)) {
                            int opcao = Integer.parseInt(JOptionPane.showInputDialog(null, a.toString() + "\nQual dado deseja alterar desse anime? \n1 - Nome\n2 - Pais de Origem\n3 - Ano de lançamento"));
                            switch (opcao) {
                                case 1:
                                    String novoNome = JOptionPane.showInputDialog(null, "Qual o novo nome do anime? ");
                                    a.setNome(novoNome);
                                    JOptionPane.showMessageDialog(null, "Dados Alterado com sucesso.");
                                    break;
                                case 2:
                                    String paisNovo = JOptionPane.showInputDialog(null, "Qual o novo pais do anime? ");
                                    a.setPais(paisNovo);
                                    JOptionPane.showMessageDialog(null, "Dados Alterado com sucesso.");
                                    break;
                                case 3:
                                    int anoNovo = Integer.parseInt(JOptionPane.showInputDialog(null, "Qual o novo ano de lançamento do anime? "));
                                    a.setAno(anoNovo);
                                    JOptionPane.showMessageDialog(null, "Dados Alterado com sucesso.");
                                    break;
                            }

                        } else {
                            JOptionPane.showMessageDialog(null, "Nenhum anime com esse nome foi encontrado");
                        }

                    }
                    break;

                case 5:
                    continuar = false;

            }
    }

    try {
        gravadorAnimes.gravaAnime(sistema.obterTodosAnimes());
        JOptionPane.showMessageDialog(null, "Dados dos animes salvo com sucesso!");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Não foi possível gravar os dados dos animes");
        }


    }
}

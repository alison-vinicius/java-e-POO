package br.com.alura.screenmatch.modelos;

public class Filme {
    private String nome;
    private int anoDeLancamento;
    private boolean incluidonoPlano;
    private double somaDasAvaliacoes;
    private int totalAvaliacoes;
    private int duracaoEmMinutos;

    public int getTotalAvaliacoes(){
        return totalAvaliacoes;
    }

    public void exibeFichaTecnica(){
        String resumo = """
                Nome do filme: %s
                Ano de lançamento: %d
                """.formatted(nome, anoDeLancamento);
        System.out.println(resumo);
    }

    public void avalia(double nota){
         somaDasAvaliacoes += nota;
         totalAvaliacoes += 1;
    }

    public double MediaDasAvaliacoes(){
        return somaDasAvaliacoes/totalAvaliacoes;
    }


}

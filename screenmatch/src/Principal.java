import br.com.alura.screenmatch.modelos.Filme;
    public class Principal {
        public static void main(String[] args) {
            Filme meuFilme = new Filme();
            meuFilme.nome = "o poderoso chefao";
            meuFilme.anoDeLancamento = 1970;
            meuFilme.duracaoEmMinutos = 180;
            meuFilme.exibeFichaTecnica();
            meuFilme.avalia(8.0);
            meuFilme.avalia(5.0);
            meuFilme.avalia(10.0);
            System.out.println("total de avaliações " + meuFilme.getTotalAvaliacoes());
            System.out.println(meuFilme.MediaDasAvaliacoes());
        }
    }





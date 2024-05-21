import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;

public class CadastroProduto {
    static HashSet<Produto> listaProdutos = new HashSet<>();

    public static void main(String[] args) {
        // Adicionando produtos ao cadastro
        adicionarProduto(1L, "Smartphone", 1000d, 10);
        adicionarProduto(2L, "Notebook", 1500d, 5);
        adicionarProduto(1L, "Mouse", 30d, 20);
        adicionarProduto(4L, "Teclado", 50d, 15);

        System.out.println("----------------------------------------");
        exibirProdutosPorNome();
        System.out.println("----------------------------------------");
        exibirProdutosPorPreco();
        System.out.println("----------------------------------------");
    }

    static void adicionarProduto(long cod, String nome, double preco, int quantidade) {
        listaProdutos.add(new Produto(cod, nome, preco, quantidade));
    }

    static void exibirProdutosPorNome() {
        ArrayList<Produto> produtosOrdenados = new ArrayList<>(listaProdutos);
        OrdenacaoPorNome ordenacao = new OrdenacaoPorNome();
        produtosOrdenados.sort(ordenacao);
        produtosOrdenados.forEach(System.out::println);
    }

    static void exibirProdutosPorPreco() {
        ArrayList<Produto> produtosOrdenados = new ArrayList<>(listaProdutos);
        OrdenacaoPorPreco ordenacao = new OrdenacaoPorPreco();
        produtosOrdenados.sort(ordenacao);
        produtosOrdenados.forEach(System.out::println);
    }



    //Metodos de ordenacao
    static class OrdenacaoPorNome implements Comparator<Produto> {

        @Override
        public int compare(Produto produto1, Produto produto2) {
            return Integer.compare(produto1.getNome().compareTo(produto2.getNome()), 0);
        }
    }

    static class OrdenacaoPorPreco implements Comparator<Produto> {

        @Override
        public int compare(Produto produto1, Produto produto2) {
            return Double.compare(produto1.getPreco(), produto2.getPreco());
        }
    }

}
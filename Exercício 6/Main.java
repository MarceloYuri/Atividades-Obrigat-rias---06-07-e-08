public class Main {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca(5);

        ItemBiblioteca livro1 = new Livro("L001", "Harry Potter e a Pedra Filosofal");
        ItemBiblioteca livro2 = new Livro("L002", "O Senhor dos Anéis");
        ItemBiblioteca livro3 = new Livro("L003", "O Hobbit");
        ItemBiblioteca livro4 = new Livro("L004", "Star Wars");
        ItemBiblioteca revista1 = new Revista("R001", "Recreio");

        biblioteca.adicionarItem(livro1);
        biblioteca.adicionarItem(livro2);
        biblioteca.adicionarItem(livro3);
        biblioteca.adicionarItem(livro4);
        biblioteca.adicionarItem(revista1);

        Usuario aluno = new Aluno("Ana Silva");

        biblioteca.listarAcervo();

        System.out.println("--- TESTES DE EMPRÉSTIMO ---");
        biblioteca.emprestar(livro1, aluno);
        biblioteca.emprestar(livro2, aluno);
        biblioteca.emprestar(livro3, aluno);

        // Teste de empréstimo recusado por limite atingido
        biblioteca.emprestar(livro4, aluno);

        System.out.println();
        biblioteca.listarAcervo();
    }
}

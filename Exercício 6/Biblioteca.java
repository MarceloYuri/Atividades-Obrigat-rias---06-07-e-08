public class Biblioteca {
    private ItemBiblioteca[] acervo;
    private int totalItens;

    public Biblioteca(int capacidade) {
        acervo = new ItemBiblioteca[capacidade];
        totalItens = 0;
    }

    public boolean adicionarItem(ItemBiblioteca item) {
        if (totalItens < acervo.length) {
            acervo[totalItens++] = item;
            return true;
        }
        return false;
    }

    public void listarAcervo() {
        System.out.println("=== ACERVO DA BIBLIOTECA ===");
        for (int i = 0; i < totalItens; i++) {
            ItemBiblioteca item = acervo[i];
            String status = item.isDisponivel() ? "Disponível" : "Emprestado";
            System.out.println("Código: " + item.getCodigo() + 
                               " | Título: " + item.getTitulo() + 
                               " | Tipo: " + item.getClass().getSimpleName() + 
                               " | Status: " + status);
        }
        System.out.println("============================\n");
    }

    public boolean emprestar(ItemBiblioteca item, Usuario usuario) {
        if (!item.isDisponivel()) {
            System.out.println("-> Empréstimo recusado: O item '" + item.getTitulo() + "' já está emprestado.");
            return false;
        }
        if (usuario.getQuantidadeEmprestada() >= usuario.getLimiteItens()) {
            System.out.println("-> Empréstimo recusado para " + usuario.getNome() + ": Limite de itens atingido.");
            return false;
        }

        item.setDisponivel(false);
        usuario.incrementarEmprestimo();
        System.out.println("-> Empréstimo realizado: '" + item.getTitulo() + "' para " + usuario.getNome() + ".");
        return true;
    }

    public boolean devolver(ItemBiblioteca item, Usuario usuario) {
        if (item.isDisponivel()) {
            System.out.println("-> Erro: O item '" + item.getTitulo() + "' já consta como disponível.");
            return false;
        }

        item.setDisponivel(true);
        usuario.decrementarEmprestimo();
        System.out.println("-> Devolução realizada com sucesso para o item: '" + item.getTitulo() + "'.");
        return true;
    }
}
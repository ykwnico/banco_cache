package banco_cache;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        List<Pessoa> banco = new ArrayList<>();
        List<Pessoa> cache = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        banco.add(new Pessoa(1, 25, "Ana"));
        banco.add(new Pessoa(2, 30, "Carlos"));
        banco.add(new Pessoa(3, 22,"Beatriz" ));
        banco.add(new Pessoa(4, 40, "Daniel"));
        banco.add(new Pessoa(5, 19,"Eduardo" ));


        while (true) {
            System.out.print("\nDigite o ID da pessoa (ou 0 para sair): ");
            int idBusca = scanner.nextInt();

            if (idBusca == 0) {
                System.out.println("Sistema encerrado.");
                break;
            }

            Pessoa pessoaEncontrada = null;
            boolean noCache = false;

            for (Pessoa p : cache) {
                if (p.getId() == idBusca) {
                    pessoaEncontrada = p;
                    noCache = true;
                    break;
                }
            }

            if (noCache) {
                System.out.println("Pessoa encontrada no cache: " + pessoaEncontrada);
            } else {
                for (Pessoa p : banco) {
                    if (p.getId() == idBusca) {
                        pessoaEncontrada = p;
                        break;
                    }
                }

                if (pessoaEncontrada != null) {
                    if (cache.size() >= 10) {
                        cache.remove(0);
                    }
                    cache.add(pessoaEncontrada);
                    System.out.println("Pessoa buscada no banco e adicionada ao cache: " + pessoaEncontrada);
                } else {
                    System.out.println("Erro: Pessoa não encontrada no banco de dados.");
                }
            }
        }
        scanner.close();
    }
}
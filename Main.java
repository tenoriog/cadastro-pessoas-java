package cadastroDePessoas;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CadastroPessoas cadastro = new CadastroPessoas();

        int opcao = 0;

        while (opcao != 6) {
            mostrarCabecalho();
            mostrarMenu();
            System.out.print("Escolha uma opção: ");

            if (scanner.hasNextInt()) {
                opcao = scanner.nextInt();
                scanner.nextLine();
            } else {
                System.out.println("\nEntrada inválida. Digite um número de 1 a 6.");
                scanner.nextLine();
                continue;
            }

            switch (opcao) {
                case 1:
                    System.out.println("\n=========== CADASTRO DE PESSOA ===========");
                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();

                    int idade = lerIdadeValida(scanner);

                    System.out.print("E-mail: ");
                    String email = scanner.nextLine();

                    cadastro.adicionarPessoa(new Pessoa(nome, idade, email));
                    System.out.println("\nPessoa cadastrada com sucesso.");
                    break;

                case 2:
                    cadastro.listarPessoas();
                    break;

                case 3:
                    if (cadastro.estaVazio()) {
                        System.out.println("\nNenhuma pessoa cadastrada no sistema.");
                        break;
                    }

                    System.out.println("\n============= BUSCAR PESSOA =============");
                    System.out.print("Digite o nome da pessoa: ");
                    String buscarNome = scanner.nextLine();

                    Pessoa pessoaEncontrada = cadastro.buscarPorNome(buscarNome);

                    if (pessoaEncontrada == null) {
                        System.out.println("\nPessoa não encontrada.");
                    } else {
                        System.out.println("\n----------- RESULTADO DA BUSCA -----------");
                        System.out.println(pessoaEncontrada);
                        System.out.println("------------------------------------------");
                    }
                    break;

                case 4:
                    if (cadastro.estaVazio()) {
                        System.out.println("\nNenhuma pessoa cadastrada no sistema.");
                        break;
                    }

                    System.out.println("\n============= REMOVER PESSOA ============");
                    System.out.print("Digite o nome da pessoa: ");
                    String nomeRemover = scanner.nextLine();

                    boolean removido = cadastro.removerPorNome(nomeRemover);

                    if (removido) {
                        System.out.println("\nPessoa removida com sucesso.");
                    } else {
                        System.out.println("\nPessoa não encontrada.");
                    }
                    break;

                case 5:
                    if (cadastro.estaVazio()) {
                        System.out.println("\nNenhuma pessoa cadastrada no sistema.");
                        break;
                    }

                    System.out.println("\n============ ATUALIZAR PESSOA ============");
                    System.out.print("Digite o nome da pessoa que deseja atualizar: ");
                    String nomeAtual = scanner.nextLine();

                    Pessoa pessoaAtual = cadastro.buscarPorNome(nomeAtual);

                    if (pessoaAtual == null) {
                        System.out.println("\nPessoa não encontrada.");
                        break;
                    }

                    System.out.println("\nDados atuais:");
                    System.out.println(pessoaAtual);

                    System.out.print("\nNovo nome: ");
                    String novoNome = scanner.nextLine();

                    int novaIdade = lerIdadeValida(scanner);

                    System.out.print("Novo e-mail: ");
                    String novoEmail = scanner.nextLine();

                    boolean atualizado = cadastro.atualizarPessoa(nomeAtual, novoNome, novaIdade, novoEmail);

                    if (atualizado) {
                        System.out.println("\nPessoa atualizada com sucesso.");
                    } else {
                        System.out.println("\nErro ao atualizar pessoa.");
                    }
                    break;

                case 6:
                    System.out.println("\nEncerrando programa...");
                    break;

                default:
                    System.out.println("\nOpção inválida. Escolha uma opção entre 1 e 6.");
                    break;
            }
        }

        scanner.close();
    }

    public static void mostrarCabecalho() {
        System.out.println("\n=========================================");
        System.out.println("         SISTEMA DE CADASTRO");
        System.out.println("=========================================");
    }

    public static void mostrarMenu() {
        System.out.println("1 - Cadastrar pessoa");
        System.out.println("2 - Listar pessoas");
        System.out.println("3 - Buscar por nome");
        System.out.println("4 - Remover por nome");
        System.out.println("5 - Atualizar pessoa");
        System.out.println("6 - Sair");
    }

    public static int lerIdadeValida(Scanner scanner) {
        int idade;

        while (true) {
            System.out.print("Idade: ");

            if (scanner.hasNextInt()) {
                idade = scanner.nextInt();
                scanner.nextLine();

                if (idade >= 0 && idade <= 120) {
                    return idade;
                } else {
                    System.out.println("Digite uma idade válida entre 0 e 120.");
                }
            } else {
                System.out.println("Entrada inválida. Digite um número inteiro.");
                scanner.nextLine();
            }
        }
    }
}
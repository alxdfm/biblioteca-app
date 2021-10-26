package application;

import entities.BookList;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int menu = 0;
        int menu2 = 0;

        BookList bookList = new BookList();

        while (menu==0){

            System.out.println("        Biblioteca App");
            System.out.println("Por favor, insira o número da opção desejada: ");
            System.out.println("1 - Cadastrar livro;");
            System.out.println("2 - Retirar um livro;");
            System.out.println("3 - Devolver um livro;");
            System.out.println("4 - Doar um livro;");
            System.out.println("5 - Exibir lista com todos os livros;");
            System.out.println("6 - Sair;");
            menu2 = scan.nextInt();
            System.out.println();

            switch (menu2){
                case 1:
                    System.out.println("    ****CADASTRO****");
                    System.out.println("Insira os dados do livro abaixo:");
                    System.out.print("Número: ");
                    int num = scan.nextInt();
                    System.out.print("Título: ");
                    scan.nextLine();
                    String title = scan.nextLine();
                    System.out.print("Autor: ");
                    String author = scan.nextLine();
                    System.out.print("Ano: ");
                    int year = scan.nextInt();
                    String status = "Disponível";
                    String borrowedTo = "";

                    bookList.add(num,title,author,year,status,borrowedTo);

                    System.out.println();
                    break;

                case 2:
                    System.out.println("    ****RETIRAR****");
                    System.out.println("Segue a lista de livros disponíveis:");
                    System.out.println();

                    bookList.bookAvailable();

                    if (bookList.listEmpty()==0){
                        System.out.println("Digite o seu nome: ");
                        scan.nextLine();
                        String borrowedToRegister = scan.nextLine();
                        System.out.println("Digite o número do livro que quer retirar: ");
                        bookList.bookOut(scan.nextInt(),borrowedToRegister);
                    }
                    break;

                case 3:
                    System.out.println("    ****DEVOLVER****");
                    System.out.println("Digite o seu nome: ");
                    scan.nextLine();
                    String name = scan.nextLine();
                    System.out.println("Segue a lista dos livros que foram emprestados para você:");
                    System.out.println();

                    int bookUnvailable = bookList.bookUnvailable(name);

                    if(bookUnvailable==0) {
                        System.out.println("Digite o número do livro que quer devolver: ");
                        int numb = scan.nextInt();

                        int test = bookList.bookBack(numb, name);
                        if(test==0){
                            System.out.println("Esse livro não foi emprestado para você!");
                        }
                        if(test>0){
                            System.out.println("Livro devolvido com sucesso! ");
                            System.out.println();
                        }
                    }
                    break;
                case 4:
                    System.out.println("    ****DOAÇÃO****");
                    System.out.println("Insira os dados do livro abaixo:");
                    System.out.print("Número: ");
                    num = scan.nextInt();
                    System.out.print("Título: ");
                    scan.nextLine();
                    title = scan.nextLine();
                    System.out.print("Autor: ");
                    author = scan.nextLine();
                    System.out.print("Ano: ");
                    year = scan.nextInt();
                    status = "Disponível";
                    borrowedTo = "";

                    bookList.add(num,title,author,year,status,borrowedTo);

                    System.out.println();
                    break;

                case 5:
                    System.out.println("Segue a lista com todos os livros:");
                    System.out.println();
                    bookList.listEmpty();
                    bookList.bookAll();
                    break;
                case 6:
                    System.out.println("Você realmente quer sair?");
                    System.out.println("1 -  Sim");
                    System.out.println("0 -  Não");
                    menu = scan.nextInt();
                    break;

                default:
                    System.out.println("Opção inválida.");
                    System.out.println();
                    System.out.println();
                    break;
            }
        }
    }
}

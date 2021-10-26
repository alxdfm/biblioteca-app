package entities;

import java.util.ArrayList;

public class BookList {

    private ArrayList<Book> list;

    public BookList() {
        this.list = new ArrayList<Book>();
    }

    public ArrayList<Book> getList() {
        return list;
    }

    public void add(int num,String title,String author, int year, String status, String borrowedTo){
        int count = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getNum()==num){
                System.out.println("É necessário inserir um número ainda não utilizado!");
                count++;
            }
        }
            if(count==0){
                list.add(new Book(num,title,author,year,status,borrowedTo));
                System.out.println("Registro realizado com sucesso!");
        }
    }

    public int listEmpty(){
        int count = 0;
        for(int i = 0;i<list.size();i++){
            if(list.get(i).getStatus().equals("Indisponível")){
                count++;
            }
        }
        if (count==list.size()){
            System.out.println("Não há livros disponíveis.");
            System.out.println();
            return 1;
        }
        else
            return 0;
    }

    public void bookAvailable(){
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getStatus().equals("Disponível")){
                System.out.println(list.get(i));
            }
        }
    }

    public int bookUnvailable(String name) {
        int count = 0;
        int count2 = 0;
        int x = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getStatus().equals("Indisponível") && list.get(i).getBorrowedTo().equals(name)) {
                System.out.println(list.get(i));
                System.out.println();
                count++;
            }
        }
        for (int i = 0; i <= list.size(); i++){
            if (count==0){
                if(count2==0){
                    System.out.println("Não foram emprestados livros nesse nome!");
                    System.out.println();
                    count2=1241;
                }
                x++;
            }
        }
        return x;
    }

    public void bookOut(int num, String borrowedToRegister){
        int count=0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getStatus().equals("Disponível")&&num==list.get(i).getNum()) {
                count++;
                list.get(i).setStatus("Indisponível");
                list.get(i).setBorrowedTo(borrowedToRegister);
                System.out.println("Livro retirado com sucesso!");
                System.out.println();
            }
        }
        for (int i = 0; i < list.size(); i++) {
            if (num != list.get(i).getNum()) {
                if (count == 0) {
                    count++;
                    System.out.println("Livro indisponível");
                    System.out.println();
                }
            }
        }
    }

    public int bookBack(int num, String name){
        int count = 0;
        for (int i = 0; i < list.size(); i++){
            if(list.get(i).getStatus().equals("Indisponível") && list.get(i).getBorrowedTo().equals(name)&&list.get(i).getNum()==num){
                list.get(i).setStatus("Disponível");
                list.get(i).setBorrowedTo("");
                count++;
            }
        }
        return count;
    }

    public void bookAll(){
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

    @Override
    public String toString() {//toString para printar a lista inteira
        return "\n" + list + "\n";
    }
}

import arvorebinaria.ABB;

public class Main {
    public static void main(String[] args) {

        ABB arvore = new ABB();

        arvore.insere(50);
        arvore.insere(20);
        arvore.insere(10);
        arvore.insere(100);


        arvore.insere(200);
        arvore.insere(1);
        arvore.insere(25);
        arvore.insere(500);
        arvore.insere(8);

        arvore.printPrecurso();
        arvore.printIncurso();
        arvore.printPosrecurso();

        arvore.remove(50);

        arvore.printIncurso();
  }
}
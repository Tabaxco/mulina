package arvorebinaria;

public class ABB {
    private No raiz;

    public ABB() {
        this.raiz = null;
    }

    public boolean vazia() {
        return (this.raiz == null);
    }

    public boolean insere(double valor) {
        if (vazia()) {
            No temp = new No(valor);
            this.raiz = temp;
            return true;
        }
        No aux = this.raiz;
        No ant = null;
        while (aux != null) {
            if (valor > aux.getValor()) {
                ant = aux;
                aux = aux.getDireita();
            } else if (valor < aux.getValor()) {
                ant = aux;
                aux = aux.getEsquerda();
            } else {
                return false;
            }
        }
        No n = new No(valor);
        if (valor > ant.getValor()) {
            ant.setDireita(n);
        } else {
            ant.setEsquerda(n);
        }
        return true;
    }

    public void printPrecurso() {
        System.out.println("Precurso: ");
        precurso(this.raiz);
        System.out.println("");
    }

    private void precurso(No aux) {
        System.out.printf("%.2f - ", aux.getValor());
        if (aux.getEsquerda() != null) precurso(aux.getEsquerda());
        if (aux.getDireita() != null) precurso(aux.getDireita());
    }

    public void printIncurso() {
        System.out.println("Incurso: ");
        incurso(this.raiz);
        System.out.println("");
    }

    private void incurso(No aux) {
        if (aux.getEsquerda() != null) incurso(aux.getEsquerda());
        System.out.printf("%.2f - ", aux.getValor());
        if (aux.getDireita() != null) incurso(aux.getDireita());
    }

    public void printPosrecurso() {
        System.out.println("Posrecurso: ");
        posrecurso(this.raiz);
        System.out.println("");
    }

    private void posrecurso(No aux) {
        if (aux.getEsquerda() != null) posrecurso(aux.getEsquerda());
        if (aux.getDireita() != null) posrecurso(aux.getDireita());
        System.out.printf("%.2f - ", aux.getValor());
    }

    public int grau(No aux) {
        if ((aux.getDireita() == null) && (aux.getEsquerda() == null)) return 0;
        if ((aux.getDireita() != null) && (aux.getEsquerda() == null)) return 1;
        if ((aux.getDireita() == null) && (aux.getEsquerda() != null)) return 1;
        return 2;
    }

    public boolean remove(double valor) {
        No temp = this.raiz;
        No ant = null;

        while(temp != null && temp.getValor() != valor) {
            if (valor < temp.getValor()) {
                ant = temp;
                temp = temp.getEsquerda();
            } else {
                ant = temp;
                temp = temp.getDireita();
            }
        }

        if (temp == null) return false;

        if(grau(temp) == 0) {
            if(valor < ant.getValor()) {
                ant.setEsquerda(null);
            } else {
                ant.setEsquerda(null);
            }

            temp = null;
            System.gc();
        }

        if(grau(temp) == 1) {}
        if(grau(temp) == 2) {}

        return true;

    }

}
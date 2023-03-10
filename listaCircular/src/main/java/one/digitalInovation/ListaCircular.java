package one.digitalInovation;

public class ListaCircular<T> {

    private No<T> cabeca;
    private No<T> cauda;
    private int tamanhoLista;

    public ListaCircular() {
        this.cauda = null;
        this.cabeca = null;
        this.tamanhoLista = 0;
    }

    public void add(T conteudo){
        No<T> novoNo = new No<>(conteudo);
        if(this.tamanhoLista == 0) {
            this.cabeca = novoNo;
            this.cauda = this.cabeca;
            this.cabeca.setNoProxomo(cauda);
        }else{
            novoNo.setNoProxomo(this.cauda);
            this.cabeca.setNoProxomo(novoNo);
            this.cauda = novoNo;
        }
        this.tamanhoLista++;
    }

    public void remove(int index){
        if(index >= this.tamanhoLista)
            throw new IndexOutOfBoundsException("O indice é maior que o tamanho da lista");
        No<T> noAuxiliar = this.cauda;
        if(index == 0){
            this.cauda = this.cauda.getNoProxomo();
            this.cabeca.setNoProxomo(this.cauda);
        }else if(index == 1){
            this.cauda.setNoProxomo(this.cauda.getNoProxomo().getNoProxomo());
        } else {
            for(int i = 0;i < index-1;i++){
                noAuxiliar = noAuxiliar.getNoProxomo();
            }
            noAuxiliar.setNoProxomo(noAuxiliar.getNoProxomo().getNoProxomo());
        }
        this.tamanhoLista--;
    }

    public T get(int index){
        return this.getNo(index).getConteudo();
    }

    private No<T> getNo(int index){
        if(this.isEmpty())
            throw  new IndexOutOfBoundsException("A lista está vazia!");
        if (index == 0){
            return this.cauda;
        }
        No<T> noAuxiliar = this.cauda;
        for(int i = 0;(i<index) && (noAuxiliar!=null);i++){
            noAuxiliar = noAuxiliar.getNoProxomo();
        }
        return noAuxiliar;
    }

    public int size(){
        return this.tamanhoLista;
    }

    public boolean isEmpty(){
        return this.tamanhoLista ==0 ? true:false;
    }

    @Override
    public String toString() {
        String strRetorno = "";
        No<T> noAuxiliar = this.cauda;
        for (int i = 0;i<this.size();i++){
            strRetorno += "[No{conteudo= " + noAuxiliar.getConteudo() + "}]---->";
            noAuxiliar = noAuxiliar.getNoProxomo();
        }

        strRetorno += this.size() != 0 ? "(Retorna ao início)": "[]";

        return strRetorno;
    }
}

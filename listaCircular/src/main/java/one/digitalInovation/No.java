package one.digitalInovation;

public class No<T> {

    private T conteudo;
    private No<T> noProxomo;

    public No(T conteudo) {
        this.noProxomo = null;
        this.conteudo = conteudo;
    }

    public T getConteudo() {
        return conteudo;
    }

    public void setConteudo(T conteudo) {
        this.conteudo = conteudo;
    }

    public No<T> getNoProxomo() {
        return noProxomo;
    }

    public void setNoProxomo(No<T> noProxomo) {
        this.noProxomo = noProxomo;
    }

    @Override
    public String toString() {
        return "No{" +
                "conteudo=" + conteudo +
                '}';
    }
}

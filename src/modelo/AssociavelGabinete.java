package modelo;

public interface AssociavelGabinete<TGabinete extends Gabinete> {
    void associar(TGabinete gabinete);

    void desassociar(TGabinete gabinete);
}

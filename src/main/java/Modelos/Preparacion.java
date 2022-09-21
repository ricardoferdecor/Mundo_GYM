package Modelos;

/**
 * Fecha:21/09/2022
 * Versión: 1.0
 * @author ricardo
 */

public class Preparacion {
    private int idPreparacion;
    private String descripcionPreparacion;
    private int idDieta;
    private String NombreDieta;

    public Preparacion() {
    }

    public Preparacion(int idPreparacion, String descripcionPreparacion, int idDieta, String NombreDieta) {
        this.idPreparacion = idPreparacion;
        this.descripcionPreparacion = descripcionPreparacion;
        this.idDieta = idDieta;
        this.NombreDieta = NombreDieta;
    }

    public int getIdPreparacion() {
        return idPreparacion;
    }

    public void setIdPreparacion(int idPreparacion) {
        this.idPreparacion = idPreparacion;
    }

    public String getDescripcionPreparacion() {
        return descripcionPreparacion;
    }

    public void setDescripcionPreparacion(String descripcionPreparacion) {
        this.descripcionPreparacion = descripcionPreparacion;
    }

    public int getIdDieta() {
        return idDieta;
    }

    public void setIdDieta(int idDieta) {
        this.idDieta = idDieta;
    }

    public String getNombreDieta() {
        return NombreDieta;
    }

    public void setNombreDieta(String NombreDieta) {
        this.NombreDieta = NombreDieta;
    }
}

package Modelos;

/**
 * Fecha:21/09/2022
 * Versión: 1.0
 * @author ricardo
 */
public class Dieta {
    private int idDieta;
    private String nombreDieta;
    private int idTipoDieta;
    private String nombreTipoDieta;
    private int idGymDiaria;

    public Dieta() {
    }

    public Dieta(int idDieta, String nombreDieta, int idTipoDieta, String nombreTipoDieta, int idGymDiaria) {
        this.idDieta = idDieta;
        this.nombreDieta = nombreDieta;
        this.idTipoDieta = idTipoDieta;
        this.nombreTipoDieta = nombreTipoDieta;
        this.idGymDiaria = idGymDiaria;
    }

    public int getIdDieta() {
        return idDieta;
    }

    public void setIdDieta(int idDieta) {
        this.idDieta = idDieta;
    }

    public String getNombreDieta() {
        return nombreDieta;
    }

    public void setNombreDieta(String nombreDieta) {
        this.nombreDieta = nombreDieta;
    }

    public int getIdTipoDieta() {
        return idTipoDieta;
    }

    public void setIdTipoDieta(int idTipoDieta) {
        this.idTipoDieta = idTipoDieta;
    }

    public String getNombreTipoDieta() {
        return nombreTipoDieta;
    }

    public void setNombreTipoDieta(String nombreTipoDieta) {
        this.nombreTipoDieta = nombreTipoDieta;
    }

    public int getIdGymDiaria() {
        return idGymDiaria;
    }

    public void setIdGymDiaria(int idGymDiaria) {
        this.idGymDiaria = idGymDiaria;
    }
    
    
}

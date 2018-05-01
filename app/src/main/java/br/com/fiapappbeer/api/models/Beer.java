package br.com.fiapappbeer.api.models;

import java.io.Serializable;

/**
 * Created by lucasdossantos on 5/1/18.
 */

public class Beer implements Serializable {

    private String img;
    private String marca;
    private String tipoEmbalagem;
    private String unidadeMedida;
    private double valorMedida;
    private double preco;

    public Beer(String img, String marca, String tipoEmbalagem, String unidadeMedida, double valorMedida, double preco) {
        this.img = img;
        this.marca = marca;
        this.tipoEmbalagem = tipoEmbalagem;
        this.unidadeMedida = unidadeMedida;
        this.valorMedida = valorMedida;
        this.preco = preco;
    }

    public Beer() {}

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getTipoEmbalagem() {
        return tipoEmbalagem;
    }

    public void setTipoEmbalagem(String tipoEmbalagem) {
        this.tipoEmbalagem = tipoEmbalagem;
    }

    public String getUnidadeMedida() {
        return unidadeMedida;
    }

    public void setUnidadeMedida(String unidadeMedida) {
        this.unidadeMedida = unidadeMedida;
    }

    public double getValorMedida() {
        return valorMedida;
    }

    public void setValorMedida(double valorMedida) {
        this.valorMedida = valorMedida;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
}


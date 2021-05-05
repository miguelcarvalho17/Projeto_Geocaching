package Projeto_Geocaching;

import edu.princeton.cs.algs4.SeparateChainingHashST;

import java.util.ArrayList;

public class Cache {

  private String nome;

  private String tipo;

  private Point coordenadas;

  private String dificuldade;

  private ArrayList<Log> historico;

  private int nItems;


  public Cache(String tipo, Point coordenadas, String dificuldade, int nItems, String nome) {
    this.tipo = tipo;
    this.coordenadas = coordenadas;
    this.dificuldade = dificuldade;
    this.nItems = nItems;
    this.nome = nome;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getTipo() {
    return tipo;
  }

  public void setTipo(String tipo) {
    this.tipo = tipo;
  }

  public Point getCoordenadas() {
    return coordenadas;
  }

  public void setCoordenadas(Point coordenadas) {
    this.coordenadas = coordenadas;
  }

  public String getDificuldade() {
    return dificuldade;
  }

  public void setDificuldade(String dificuldade) {
    this.dificuldade = dificuldade;
  }

  public int getnItems() {
    return nItems;
  }

  public void setnItems(int nItems) {
    this.nItems = nItems;
  }

  public void inserir_item(Item i) {
  }

  public void remover_item(int id) {
  }

  public void editar_item(int id) {
  }

  public void print_items() {
  }

}
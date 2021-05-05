package Projeto_Geocaching;

import edu.princeton.cs.algs4.RedBlackBST;

import java.util.ArrayList;

public class Cache {

  private String nome;

  private String tipo;

  private Point coordenadas;

  private String dificuldade;

  private ArrayList<Log> historico;

  private int nItems;

  RedBlackBST<Integer, Item> items = new RedBlackBST<>();

  public Cache(String tipo, Point coordenadas, String dificuldade, String nome) {
    this.tipo = tipo;
    this.coordenadas = coordenadas;
    this.dificuldade = dificuldade;
    this.nItems = 0;
    this.nome = nome;
  }

  public Cache(String tipo, Point coordenadas, String dificuldade,int nitens, String nome) {
    this.tipo = tipo;
    this.coordenadas = coordenadas;
    this.dificuldade = dificuldade;
    this.nItems = nitens;
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
    if (this.items.contains(i.getID())) {
      System.out.println(" Este item ja existe: " + i);
      return;
    }
    this.items.put(i.getID(), i);
    System.out.println("Item inserido com sucesso");
    this.nItems++;
  }

  public Item remover_item(int id) {

    if (this.items.contains(id)) {
      Item i = this.items.get(id);
      System.out.println("Item Removed: " + i);
      this.items.delete(id);
      this.nItems--;
      return i;
    }
    return null;
  }

  public void editar_item(int id) {
  }

  public void print_items() {
      if (this.items.isEmpty()) {
        System.out.println("Esta cache nao tem items");
        return;
      }
      for (Integer si : this.items.keys()) {
        System.out.println("Items existentes na cache: " + this.items.get(si));
      }
  }

  @Override
  public String toString() {
    return  "nome='" + nome + '\'' + ", tipo='" + tipo + '\'' + ", coordenadas=" + coordenadas + ", dificuldade='" + dificuldade + '\'' + ", historico=" + historico + ", nItems=" + nItems + '}';
  }
}
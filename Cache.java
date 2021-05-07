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
  RedBlackBST<Integer, Travel_bugs> travelBugs = new RedBlackBST<>();

  public Cache(String tipo, Point coordenadas, String dificuldade, String nome) {
    this.tipo = tipo;
    this.coordenadas = coordenadas;
    this.dificuldade = dificuldade;
    this.nItems = 0;
    this.nome = nome;
  }

  public RedBlackBST<Integer, Item> getItems() {
    return items;
  }

  public void setItems(RedBlackBST<Integer, Item> items) {
    this.items = items;
  }

  public Cache(String tipo, Point coordenadas, String dificuldade, int nitens, String nome) {
    this.tipo = tipo;
    this.coordenadas = coordenadas;
    this.dificuldade = dificuldade;
    this.nItems = nitens;
    this.nome = nome;
  }

  public Cache(String tipo, Point coordenadas, String dificuldade, int nitens, String nome, CacheBase cbase) {
    this.tipo = tipo;
    this.coordenadas = coordenadas;
    this.dificuldade = dificuldade;
    this.nItems = nitens;
    this.nome = nome;
    cbase.getDB_caches().put(this.getNome(),this);
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

  public void inserir_item(Item i, CacheBase cbase) {
    if (this.items.contains(i.getID())) {
      System.out.println(" Este item ja existe: " + i);
      return;
    }
    cbase.getDB_caches().delete(this.getNome());

    this.items.put(i.getID(), i);
    //cbase.getDB_caches().get(this.getNome()).inserir_item(i,cbase);
    cbase.getDB_caches().put(this.getNome(),this);
    //System.out.println("Item inserido na " + this.getNome());
    this.nItems++;
  }

  public Item remover_item(int id) {

    if (this.items.contains(id)) {
      Item i = this.items.get(id);
      System.out.println("Item removido da " + this.getNome() + ": " +i);
      this.items.delete(id);
      this.nItems--;
      return i;
    }
    return null;
  }

  public void editar_item(int id, String objeto) {
    if (!this.items.contains(id)) {
      System.out.println("Impossivel editar,item inexistente!");
      return;
    }
    Item i = this.items.get(id);
    i.setObjeto(objeto);
    System.out.println("Item editado com sucesso"  + this.getNome());
  }

  public void print_items() {
      if (this.items.isEmpty() && this.travelBugs.isEmpty()) {
        System.out.println("Esta cache nao tem items");
      }
      for (Integer si : this.items.keys()) {
        System.out.println("Items existentes na " + this.getNome() +":"+ this.items.get(si));
      }
      if (!this.travelBugs.isEmpty()){
      for (Integer se: this.travelBugs.keys()){
        System.out.println("TravelBugs existentes na cache: " + this.travelBugs.get(se));
      }
      }
  }

  public void findUsersVisitedCache(UsersBase base){
    int i = 0;
    for (Basic b : base.getBasics()){
      if (b.cachesVisitadasB.contains(this)){
        System.out.println(b.toString());
        i++;
      }
    }
    for (Premium p : base.getPremiums()){
      if (p.cachesVisitadasB.contains(this)){
        System.out.println(p.toString());
        i++;
      }
    }
    for (Admin a : base.getAdmins()){
      if (a.cachesVisitadasB.contains(this)){
        System.out.println(a.toString());
        i++;
      }
    }
    if (i == 0){
      System.out.println("Nenhum user passou nesta cache");
    }
  }

  @Override
  public String toString() {

    this.print_items();
    return "Cache{" +
            "nome='" + nome + '\'' +
            ", tipo='" + tipo + '\'' +
            ", coordenadas=" + coordenadas +
            ", dificuldade='" + dificuldade + '\'' +
            ", historico=" + historico +
            ", nItems=" + nItems +
            '}';
  }
}
package Projeto_Geocaching;

import edu.princeton.cs.algs4.RedBlackBST;

import javax.xml.crypto.Data;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Random;

public class Cache {

  private String nome;

  private String tipo;

  private Point coordenadas;

  private String dificuldade;

  private ArrayList<Log> logs;

  private int nItems;

  RedBlackBST<Integer, Item> items = new RedBlackBST<>();
  //RedBlackBST<Integer, Travel_bugs> travelBugs = new RedBlackBST<>();

  public RedBlackBST<Integer, Item> getItems() {
    return items;
  }

  public void setItems(RedBlackBST<Integer, Item> items) {
    this.items = items;
  }

  public Cache(String tipo, Point coordenadas, String dificuldade, String nome) {
    this.tipo = tipo;
    this.coordenadas = coordenadas;
    this.dificuldade = dificuldade;
    this.nItems = 0;
    this.nome = nome;
  }

  public Cache(String tipo, Point coordenadas, String dificuldade, int nitens, String nome) {
    this.tipo = tipo;
    this.coordenadas = coordenadas;
    this.dificuldade = dificuldade;
    this.nItems = nitens;
    this.nome = nome;
  }

  public Cache(String tipo, Point coordenadas, String dificuldade, int nitens, String nome, CacheBase cbase, ArrayList<Log> logs) {
    this.tipo = tipo;
    this.coordenadas = coordenadas;
    this.dificuldade = dificuldade;
    this.nItems = nitens;
    this.nome = nome;
    this.logs = logs;
    cbase.getDB_caches().put(this.getNome(),this);
  }

  public Cache(String tipo, Point coordenadas, String dificuldade, int nitens, String nome, CacheBase cbase) {
    this.tipo = tipo;
    this.coordenadas = coordenadas;
    this.dificuldade = dificuldade;
    this.nItems = nitens;
    this.nome = nome;
    this.logs = new ArrayList<>();
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

  public ArrayList<Log> getLogs() {
    return logs;
  }

  public void setLogs(ArrayList<Log> logs) {
    this.logs = logs;
  }

  public void WriteCacheToFile(Cache c, String path){
    try {
      BufferedWriter writer = new BufferedWriter(new FileWriter(path, true)); //append true
      writer.write(c.getNome());
      writer.write(", ");
      writer.write(c.getTipo());
      writer.write(", ");
      writer.write(String.valueOf(c.getCoordenadas().latitude));
      writer.write(", ");
      writer.write(String.valueOf(c.getCoordenadas().longitude));
      writer.write(", ");
      writer.write(c.getDificuldade());
      writer.write(", ");
      writer.write(String.valueOf(c.getnItems()));
      for (Integer i : c.items.keys()){
        writer.write(", ");
        writer.write(c.items.get(i).getObjeto());
      }
      writer.newLine();
      writer.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public void inserir_item(Item i, CacheBase cbase) {
    if (this.items.contains(i.getID())) {
      System.out.println(" Este item ja existe: " + i);
      return;
    }
    cbase.getDB_caches().delete(this.getNome());

    this.items.put(i.getID(), i);
    LocalDateTime d = LocalDateTime.now();
    Random rand = new Random();
    int rand_int1 = rand.nextInt(1000);
    String acontecimento = "Item inserido na cache: "+ i.getObjeto();
    Log l = new Log(acontecimento,d, rand_int1);
    this.logs.add(l);
    cbase.getDB_caches().put(this.getNome(),this);
    this.nItems++;
  }

  public Item remover_item(int id, CacheBase cbase) {

    if (this.items.contains(id)) {
      Item i = this.items.get(id);
      System.out.println("Item removido da " + this.getNome() + ": " +i);
      this.items.delete(id);
      LocalDateTime d = LocalDateTime.now();
      Random rand = new Random();
      int rand_int1 = rand.nextInt(1000);
      String acontecimento = "Item removido da cache: "+ i.getObjeto();
      Log l = new Log(acontecimento,d, rand_int1);
      this.logs.add(l);
      cbase.DB_caches.get(this.getNome()).remover_item(id, cbase);
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
    LocalDateTime d = LocalDateTime.now();
    Random rand = new Random();
    int rand_int1 = rand.nextInt(1000);
    Log l = new Log("Item editado da cache!",d, rand_int1);
    this.logs.add(l);
    System.out.println("Item editado com sucesso"  + this.getNome());
  }

  public void print_items() {
      if (this.items.isEmpty()) {
        System.out.println("Esta cache nao tem items");
      }
      for (Integer si : this.items.keys()) {
        System.out.println("Items existentes na " + this.getNome() +":"+ this.items.get(si));
      }
  }

  public void print_logs(){
   for (int i = 0; i < this.logs.size();i++){
      System.out.println(this.logs.get(i));
    }
  }

  public void findUsersVisitedCache(UsersBase base){
    int i = 0;
    for (Integer si : base.getBasics().keys()){
      if (base.getBasics().get(si).cachesVisitadasB.contains(this)){
        System.out.println(base.getBasics().get(si).toString());
        i++;
      }
    }
    for (Integer se : base.getPremiums().keys()){
      if (base.getPremiums().get(se).cachesVisitadasB.contains(this)){
        System.out.println(base.getPremiums().get(se).toString());
        i++;
      }
    }
    for (Integer so : base.getAdmins().keys()){
      if (base.getAdmins().get(so).cachesVisitadasB.contains(this)){
        System.out.println(base.getAdmins().get(so).toString());
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
    this.print_logs();
    return "Cache{" +
            "nome='" + nome + '\'' +
            ", tipo='" + tipo + '\'' +
            ", coordenadas=" + coordenadas +
            ", dificuldade='" + dificuldade + '\'' +
            ", nItems=" + nItems +
            '}';
  }
}
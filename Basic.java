package Projeto_Geocaching;

import edu.princeton.cs.algs4.RedBlackBST;
import edu.princeton.cs.algs4.SeparateChainingHashST;

import java.util.ArrayList;

public class Basic {

  public int ID;

  public String nome;

  public ArrayList<Cache> cachesVisitadasB;

  public ArrayList<Item> items;

  public ArrayList<Cache> cachesEscondidasB;

   SeparateChainingHashST<String, Cache> caches = new SeparateChainingHashST<>();

  public Basic(int ID, String nome) {
    this.ID = ID;
    this.nome = nome;
  }

  public void criarUtilizador(Basic b){

  }

  public void insertCache(Cache c) {

      if (this.caches.contains(c.getNome())) {
        System.out.println(" Esta cache ja existe: " + c);
        return;
      }
      else if(c.getTipo().equals("premium")){
        System.out.println("Utilizador do tipo basic nao pode inserir caches premium");
        return;
      }
      this.caches.put(c.getNome(), c);
    }


  public void removerCache(String nome) {
    Cache c = this.caches.get(nome);
    if (c != null && !c.getTipo().equals("premium")) {
      System.out.println("Cache removed: " + c.getNome());
      this.caches.delete(nome);
      return;
    }
    System.out.println("Impossivel remover cache!");
  }

  public void editarCache(String nome, String tipo, Point coordenadas, String dificuldade) {
    Cache c = this.caches.get(nome);
    if (c != null){
      c.setCoordenadas(coordenadas);
      c.setDificuldade(dificuldade);
      c.setTipo(tipo);
      return;
    }
    System.out.println("Impossivel editar uma cache que nao existe!");
  }

  public void printCaches() {
    if (this.caches.isEmpty()) {
      System.out.println("Nao existem caches");
      return;
    }
    for (String si : this.caches.keys()) {
      System.out.println("Cache: " + this.caches.get(si));
      this.caches.get(si).print_items();
    }
  }

  public void trocar_item(){

  }

  @Override
  public String toString() {
    return "User Basic->" + "ID=" + ID + "; nome=" + nome;
  }
}
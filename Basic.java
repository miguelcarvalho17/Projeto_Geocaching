package Projeto_Geocaching;

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

  public void criarCache(Cache c) {

  }

  public void removerCache(int id) {
  }

  public void editarCache(int id) {
  }

  public void print_caches() {
  }

  public void trocar_item(){

  }

}
package Projeto_Geocaching;

import java.util.ArrayList;
import java.util.List;

public class Cache {

  enum tipo {BASIC, PREMIUM};

  public Point coordenadas;

  enum dificuldade{FACIL, MEDIO, DIFICIL};

  public ArrayList<Log> historico;

  public int nItems;

  public String nome;


  public void inserir_item(Item i) {
  }

  public void remover_item(int id) {
  }

  public void editar_item(int id) {
  }

  public void print_items() {
  }

}
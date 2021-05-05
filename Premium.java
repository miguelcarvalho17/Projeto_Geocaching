package Projeto_Geocaching;

import java.util.ArrayList;

public class Premium extends Basic {

  public ArrayList<Cache> cachesEscondidasP;

  public ArrayList<Cache> cachesVisitadasP;

  public Premium(int ID, String nome) {
    super(ID, nome);
  }

  public Premium(int ID, String nome, ArrayList<Cache> cachesEscondidasP, ArrayList<Cache> cachesVisitadasP) {
    super(ID, nome);
    this.cachesEscondidasP = cachesEscondidasP;
    this.cachesVisitadasP = cachesVisitadasP;
  }

  public void criarUtilizador(Premium p) {
    super.criarUtilizador(p);
  }

  public void criarCachePremium(Cache c) {
  }

  public void criar_travelbug(Travel_bugs t){

  }

  public void encontrar_travelBug(Travel_bugs t){

  }

}
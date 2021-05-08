package Projeto_Geocaching;

import java.util.List;

public class Travel_bugs extends Item {

  public Cache localizacao;

  public Cache Missao;

  public Travel_bugs(int ID, String objeto) {
    super(ID, objeto);
  }

  public Cache getLocalizacao() {
    return localizacao;
  }

  public void setLocalizacao(Cache localizacao) {
    this.localizacao = localizacao;
  }

  public Cache getMissao() {
    return Missao;
  }

  public void setMissao(Cache missao) {
    Missao = missao;
  }
}
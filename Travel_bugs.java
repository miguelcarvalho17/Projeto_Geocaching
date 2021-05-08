package Projeto_Geocaching;

import java.util.List;

public class Travel_bugs extends Item {

  private Cache pontopartida;

  private Cache Missao;

  private Point localizacao;

  public Travel_bugs(int ID, String objeto) {
    super(ID, objeto);
  }

  public Cache getPontopartida() {
    return pontopartida;
  }

  public void setPontopartida(Cache pontopartida) {
    this.pontopartida = pontopartida;
  }

  public Cache getMissao() {
    return Missao;
  }

  public void setMissao(Cache missao) {
    Missao = missao;
  }

  public Point getLocalizacao() {
    return localizacao;
  }

  public void setLocalizacao(Point localizacao) {
    this.localizacao = localizacao;
  }
}
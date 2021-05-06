package Projeto_Geocaching;

public class Item {

  private int ID;

  private String objeto;

  public Item(int ID, String objeto) {
    this.ID = ID;
    this.objeto = objeto;
  }

  public int getID() {
    return ID;
  }

  public void setID(int ID) {
    this.ID = ID;
  }

  public String getObjeto() {
    return objeto;
  }

  public void setObjeto(String objeto) {
    this.objeto = objeto;
  }

  @Override
  public String toString() {
    return  " ID=" + ID + ", objeto='" + objeto + '\'';
  }
}
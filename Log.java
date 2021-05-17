package Projeto_Geocaching;

import java.time.LocalDateTime;

public class Log {

  private String acontecimento;

  private LocalDateTime data;

  public static int ID = 1;

  public Log(String acontecimento, LocalDateTime data) {
    this.acontecimento = acontecimento;
    this.data = data;
    ID++;
  }

  public Log() {
  }

  public String getAcontecimento() {
    return acontecimento;
  }

  public void setAcontecimento(String acontecimento) {
    this.acontecimento = acontecimento;
  }

  public LocalDateTime getData() {
    return data;
  }

  public void setData(LocalDateTime data) {
    this.data = data;
  }

  public static int getID() {
    return ID;
  }

  public static void setID(int ID) {
    Log.ID = ID;
  }

  @Override
  public String toString() {
    return "Log{" +
            "ID=" + ID +
            ",acontecimento='" + acontecimento + '\'' +
            ", data=" + data +
            '}';
  }
}
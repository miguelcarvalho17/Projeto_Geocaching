package Projeto_Geocaching;

import java.time.LocalDateTime;

public class Log {

  private String acontecimento;

  private LocalDateTime data;

  private int ID;

  private static int counter = 1;

  public Log(String acontecimento, LocalDateTime data) {
    this.acontecimento = acontecimento;
    this.data = data;
    counter++;
    this. ID = counter;
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

  public int getID() {
    return ID;
  }

  public void setID(int ID) {
    this.ID = ID;
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
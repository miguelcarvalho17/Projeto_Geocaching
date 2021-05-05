package Projeto_Geocaching;

public class Point {

  public String regiao;

  public double latitude;

  public double longitude;

   // public List<Cache> cache;

  public Point(double latitude, double longitude, String regiao) {
    this.latitude = latitude;
    this.longitude = longitude;
    this.regiao = regiao;
  }

  public String getRegiao() {
    return regiao;
  }

  public void setRegiao(String regiao) {
    this.regiao = regiao;
  }

  public double getLatitude() {
    return latitude;
  }

  public void setLatitude(double latitude) {
    this.latitude = latitude;
  }

  public double getLongitude() {
    return longitude;
  }

  public void setLongitude(double longitude) {
    this.longitude = longitude;
  }

  @Override
  public String toString() {
    return "Point{" +
            "regiao='" + regiao + '\'' +
            ", latitude=" + latitude +
            ", longitude=" + longitude +
            '}';
  }
}
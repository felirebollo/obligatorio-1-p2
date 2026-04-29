public class Tester {
  private String nombre;
  private int edad;
  private int experiencia;
  
  public Tester(String unNombre, int unaEdad, int unaExperiencia) {
      this.setNombre(unNombre);
      this.setEdad(unaEdad);
      this.setExperiencia(unaExperiencia);
  }

  public Tester() {
      this.setNombre("Sin nombre")
      this.setEdad(18);
      this.setExperiencia(0);
  }

  
  public String getNombre() {
      return nombre;
  }
  public void setNombre(String unNombre){
      nombre = unNombre;
  }

  public int getEdad(){
      return edad;
  }
  public void setEdad(int unaEdad){
      edad = unaEdad
  }

  public int Experiencia(){
      return edad;
  }
  public void setExperiencia(int unaExperiencia){
      experiencia = unaExpriencia
  }


  @Override
  public String toString() {
      return this.getNombre() + " - Edad: " + this.getEdad() + " - Experiencia:"
  }
  

  
}

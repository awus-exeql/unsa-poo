package clasesAbstractas;

public class Alumno {
    private String apenom;

    public Alumno(String apenom) {
        this.apenom = apenom;
    }

    public String getApenom() {
        return apenom;
    }

    public void setApenom(String apenom) {
        this.apenom = apenom;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Alumno alumno){
            return apenom.equals(alumno.getApenom());
        }
        else
            return false;
    }

    @Override
    public String toString(){
        return this.getApenom();
    }
}

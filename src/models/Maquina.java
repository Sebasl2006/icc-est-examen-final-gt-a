package models;

import java.util.List;

public class Maquina {
    private String nombre ; 
    private String ip;
    List<Integer> codigos;
    public Maquina(String nombre, String ip, List<Integer> codigos) {
        this.nombre = nombre;
        this.ip = ip;
        this.codigos = codigos;
    }
    public String getNombre() {
        return nombre;
    }
    public String getIp() {
        return ip;
    }
    public List<Integer> getCodigos() {
        return codigos;
    }
    public int getSubred(){
        String [] partes = ip.split("\\");
        return Integer.parseInt(partes[2]);
    }

    public int getRiesgo(){
        


    }
    @Override
    public String toString() {
        return "Maquina [nombre=" + nombre + ", ip=" + ip + ", codigos=" + codigos + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Maquina other = (Maquina) obj;
        if (nombre == null) {
            if (other.nombre != null)
                return false;
        } else if (!nombre.equals(other.nombre))
            return false;
        return true;
    }


    @Override
    public int hashCode() {
        return Object.hash(nombre, getSubred());
        
    }
    

    


    
   
    
    

    
}

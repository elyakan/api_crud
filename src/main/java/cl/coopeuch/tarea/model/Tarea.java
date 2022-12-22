package cl.coopeuch.tarea.model;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Tarea {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id_identificador")
    Long idIdentificador ;

    @Column
    String descripcion ;

    @Column
    String fechaCreacion ;

    @Column(name = "vigente", columnDefinition="BIT")
    Boolean vigente ;

    public Long getIdIdentificador() {
        return idIdentificador;
    }

    public void setIdIdentificador(Long idIdentificador) {
        this.idIdentificador = idIdentificador;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Boolean getVigente() {
        return vigente;
    }

    public void setVigente(Boolean vigente) {
        this.vigente = vigente;
    }

    public static Tarea buildExample(){
        Tarea responseObject= new Tarea();

        responseObject.setIdIdentificador(Long.valueOf("1"));
        responseObject.setDescripcion("resumen de la tarea");
        responseObject.setFechaCreacion("24/07/2021 12:00:59");
        responseObject.setVigente(true);
        return responseObject;
    }

}

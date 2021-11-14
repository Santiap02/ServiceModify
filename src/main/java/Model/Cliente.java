package Model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * Modelo para la conexion a la base de datos "clientes".
 *
 * @author santiago.alvarezp@udea.edu.co
 *
 */
@Getter
@Setter
@Entity
@Table(name="clientes")
public class Cliente {

    @Id
    private Integer idCliente;
    private String nombres;
    private String apellidos;
    private String docType;
    private Integer edad;
    private String ciudad;

}

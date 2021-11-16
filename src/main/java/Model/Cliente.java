package Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

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
@AllArgsConstructor
@NoArgsConstructor
public class Cliente {

    @Id
    @NotNull
    private Integer idCliente;
    @NotBlank
    private String nombres;
    @NotBlank
    private String apellidos;
    private String docType;
    private Integer edad;
    private String ciudad;

}

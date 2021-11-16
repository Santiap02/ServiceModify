package Model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.bson.types.Binary;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;

/**
 * Modelo para la conexion a la base de datos "Test4" coleccion imagenes.
 *
 * @author santiago.alvarezp@udea.edu.co
 *
 */
@Getter
@NoArgsConstructor
@Document(collection = "images")
public class Photo {

    @Id
    private String id;

    @NotNull
    @Indexed(unique = true)
    private int clientId;

    @NotNull
    private Binary image;

    public Photo(int clientId) {
        this.clientId = clientId;
    }

    public void setImage(Binary image) {
        this.image = image;
    }

}
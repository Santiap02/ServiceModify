package Business;

import Domain.ResponseDto;
import Model.Cliente;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * Interface donde se definen las operaciones a implementar para el proceso modificacion de informacion de clientes
 *
 * @author santiago.alvarezp@udea.edu.co
 * @version 1.0
 */

public interface ServiceModifyBusiness {
    /**
     * Permite actualizar un cliente
     * @return Respuesta lista de objetos Cliente
     */

    ResponseDto updateClient(Cliente cliente);
    /**
     * Permite actualizar una foto asignada a un cliente
     *
     * @param clientId Identificacion del usuario
     * @param file     Archivo de imagen
     * @return Objeto de respuesta ResponseDto con
     */
    ResponseDto<String> updatePhoto(int clientId, MultipartFile file) throws IOException;


}

package business;

import domain.ResponseDto;
import Model.Cliente;
import org.springframework.web.multipart.MultipartFile;

/**
 * Interface donde se definen las operaciones a implementar para el proceso modificacion de informacion de clientes
 *
 * @author santiago.alvarezp@udea.edu.co
 * @version 1.0
 */

public interface ServiceModifyBusiness {

    /**
     * Permite actualizar un cliente existente.
     *
     * @param cliente Datos del cliente para actualizar.
     * @return Objeto de respuesta con el mensaje de log.
     */
    ResponseDto<String> updateClient(Cliente cliente);

    /**
     * Permite actualizar una foto asignada a un cliente
     *
     * @param clientId Identificacion del usuario
     * @param file     Archivo de imagen
     * @return Objeto de respuesta con el mensaje de log.
     */
    ResponseDto<String> updatePhoto(int clientId, MultipartFile file);

}

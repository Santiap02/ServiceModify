package business;

import Util.ValidationUtils;
import domain.ResponseDto;
import Model.Cliente;
import Model.Photo;
import exception.ServiceException;
import repository.ClientRepository;
import repository.PhotoRepository;
import Util.ServiceConstants;
import lombok.AllArgsConstructor;
import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


@Service
@AllArgsConstructor
public class ServiceModifyBusinessImplementation implements ServiceModifyBusiness {
    /** Logger */
    private static final Logger LOGGER = LoggerFactory.getLogger(ServiceModifyBusinessImplementation.class);
    /** Objeto para acceder a la capa de datos de clientes */
    private final ClientRepository clientRepository;
    /** Objeto para acceder a la capa de datos de fotos */
    private final PhotoRepository photoRepository;
    /** Validador*/
    private final ValidationUtils validationUtils;

    /**
     *
      * @see ServiceModifyBusiness#updateClient(Cliente)
     */
    @Override
    public ResponseDto<String> updateClient(Cliente cliente) {
        LOGGER.debug("Se inicia updateClient");
        ResponseDto<String> response;
        try {
            validationUtils.validate(cliente);
            clientRepository.save(cliente);
            response = new ResponseDto<>(HttpStatus.OK.value(), ServiceConstants.SA002, ServiceConstants.SA002M);
        }catch (ServiceException e){
            LOGGER.error("Error in updateClient", e);
            response = new ResponseDto<>(e.getStatus(), e.getCode(), e.getMessage());
        }catch (Exception e){
            LOGGER.error("Error in updateClient", e);
            response = new ResponseDto<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), ServiceConstants.SA100, ServiceConstants.SA100M);
        }
        LOGGER.debug("updateClient retorna: {}", response);
        return  response;
    }

    /**
     *
     * @see ServiceModifyBusiness#updatePhoto(int, MultipartFile)
     */
    @Override
    public ResponseDto<String> updatePhoto(int clientId, MultipartFile file) {
        LOGGER.debug("Se inicia updatePhoto");
        ResponseDto<String> response;
        try {
            var photo = photoRepository.findByClientId(clientId);
            if(photo==null){
                photo= new Photo(clientId);
            }
            photo.setImage(new Binary(BsonBinarySubType.BINARY, file.getBytes()));
            photoRepository.save(photo);
            response = new ResponseDto<>(HttpStatus.OK.value(), ServiceConstants.SA002, ServiceConstants.SA002M, "MongoId de la imagen: "+photo.getId());
        } catch (Exception e) {
            response = new ResponseDto<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), ServiceConstants.SA100, ServiceConstants.SA100M);
            LOGGER.error("Error in updatePhoto", e);
        }
        LOGGER.debug("updatePhoto retorna: {}", response);
        return  response;
    }

}

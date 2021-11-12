package Rest;

import Business.ServiceModifyBusiness;
import Domain.ResponseDto;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import Model.Cliente;
import java.io.IOException;
@CrossOrigin(origins = "*")
@AllArgsConstructor
@RestController
public class ServiceModifyRest {

    private final ServiceModifyBusiness serviceModifyBusiness;

    @PutMapping(value="clientes/actualizar/",consumes=MediaType.APPLICATION_JSON_VALUE)
    public ResponseDto updateClient(@RequestBody Cliente client) {
        return this.serviceModifyBusiness.updateClient(client);
    }


    @PutMapping("/photos/update")
    public ResponseDto<String> updatePhoto(@RequestParam("clientId") int clientId, @RequestParam("image") MultipartFile image) throws IOException {
        return this.serviceModifyBusiness.updatePhoto(clientId, image);
    }

}

package Rest;

import Business.ServiceModifyBusiness;
import Domain.ResponseDto;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
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
    public ResponseDto actualizarContacto(@RequestBody Cliente client) {
        var response= serviceModifyBusiness.updateClient(client);
        return response;
    }


    //Images MongoDB

    @PutMapping("/photos/update")
    public ResponseDto<String> actualizarFoto(@RequestParam("title") int title, @RequestParam("image") MultipartFile image, Model model) throws IOException {

        return serviceModifyBusiness.updatePhoto(title, image);
    }


}

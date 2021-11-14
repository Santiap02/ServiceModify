package rest;

import Model.Cliente;
import business.ServiceModifyBusiness;
import domain.ResponseDto;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
@CrossOrigin(origins = "*")
@AllArgsConstructor
@RestController
public class ServiceModifyRest {

    private final ServiceModifyBusiness serviceModifyBusiness;


    @Operation(summary = "Actualizar datos de un cliente", description = "Permite actualizar los datos de un cliente")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Cliente guardado exitosamente", response = ResponseDto.class),
            @ApiResponse(code = 500, message = "Error inesperado durante el proceso", response = ResponseDto.class) })
    @PutMapping(value="clientes/actualizar/",consumes=MediaType.APPLICATION_JSON_VALUE)
    public ResponseDto<String> updateClient(@Parameter(name = "cliente", required = true, description = "Nuevos datos del cliente", schema = @Schema(implementation = Cliente.class), in = ParameterIn.QUERY)@RequestBody Cliente client) {
        return this.serviceModifyBusiness.updateClient(client);
    }
    @Operation(summary = "Actualizar foto de un cliente", description = "Permite actualizar la foto de un cliente")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Cliente guardado exitosamente", response = ResponseDto.class),
            @ApiResponse(code = 500, message = "Error inesperado durante el proceso", response = ResponseDto.class) })
    @PutMapping("/photos/update")
    public ResponseDto<String> updatePhoto(@Parameter(name = "clientId", required = true, description = "Id del cliente a actualizar", schema = @Schema(implementation = int.class), in = ParameterIn.QUERY)@RequestParam("clientId") int clientId,
                                           @Parameter(name = "image", required = true, description = "Imagen nueva", schema = @Schema(implementation = MultipartFile.class), in = ParameterIn.QUERY)@RequestParam("image") MultipartFile image) {
        return this.serviceModifyBusiness.updatePhoto(clientId, image);
    }

}

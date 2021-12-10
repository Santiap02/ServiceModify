package Util;

import Model.Cliente;
import domain.ClienteDto;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface ClienteMapper {

    ClienteDto clientToClienteDto(Cliente cliente);

    Cliente clienteDtoToCliente(ClienteDto clienteDto);

}

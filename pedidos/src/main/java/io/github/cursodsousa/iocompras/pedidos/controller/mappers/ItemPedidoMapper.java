package io.github.cursodsousa.iocompras.pedidos.controller.mappers;

import io.github.cursodsousa.iocompras.pedidos.controller.dto.ItemPedidoDTO;
import io.github.cursodsousa.iocompras.pedidos.model.ItemPedido;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ItemPedidoMapper {
    ItemPedido map(ItemPedidoDTO dto);
}

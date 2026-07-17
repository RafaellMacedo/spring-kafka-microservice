package io.github.cursodsousa.iocompras.pedidos.service;

import io.github.cursodsousa.iocompras.pedidos.model.Pedido;
import io.github.cursodsousa.iocompras.pedidos.repository.ItemPedidoRepository;
import io.github.cursodsousa.iocompras.pedidos.repository.PedidoRepository;
import io.github.cursodsousa.iocompras.pedidos.validator.PedidoValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PedidoService {

    private final PedidoRepository repository;
    private final ItemPedidoRepository itemPedidoRepository;
    private final PedidoValidator validator;

    public Pedido criarPedido(Pedido pedido) {
        repository.save(pedido);
        itemPedidoRepository.saveAll(pedido.getItens());
        return pedido;
    }
}

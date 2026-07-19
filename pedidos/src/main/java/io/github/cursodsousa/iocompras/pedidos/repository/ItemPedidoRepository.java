package io.github.cursodsousa.iocompras.pedidos.repository;

import io.github.cursodsousa.iocompras.pedidos.model.ItemPedido;
import io.github.cursodsousa.iocompras.pedidos.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemPedidoRepository extends JpaRepository<ItemPedido, Long> {
    List<ItemPedido> findByPedido(Pedido pedido);
}

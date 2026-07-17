package io.github.cursodsousa.iocompras.pedidos.repository;

import io.github.cursodsousa.iocompras.pedidos.model.ItemPedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemPedidoRepository extends JpaRepository<ItemPedido, Long> {
}

package io.github.cursodsousa.iocompras.pedidos.repository;

import io.github.cursodsousa.iocompras.pedidos.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository  extends JpaRepository<Pedido, Long> {
}

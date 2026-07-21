package io.github.cursodsousa.iocompras.pedidos.subscriber.representation;

import io.github.cursodsousa.iocompras.pedidos.model.enums.StatusPedido;

public record AtualizacaoStatusPedidoRepresentation(
        Long codigo,
        StatusPedido status,
        String urlNotaFiscal,
        String codigoRastreio
) {
}

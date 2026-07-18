package io.github.cursodsousa.iocompras.pedidos.controller.dto;

import io.github.cursodsousa.iocompras.pedidos.model.enums.TipoPagamento;

public record AdicaoNovoPagamentoDTO(Long codigoPedido, String dados, TipoPagamento tipoPagamento) {
}

package io.github.cursodsousa.iocompras.pedidos.controller.dto;

import io.github.cursodsousa.iocompras.pedidos.model.enums.TipoPagamento;

public record DadosPagamentoDTO(String dados, TipoPagamento tipoPagamento) {
}

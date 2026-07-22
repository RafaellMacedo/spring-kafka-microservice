package io.github.cursodsouse.icompras.logistica.subscriber.representation;

import io.github.cursodsouse.icompras.logistica.model.StatusPedido;

public record AtualizacaoFaturamentoRepresentation(
        Long codigo, StatusPedido status, String urlNotaFiscal
) {
}

package io.github.cursodsousa.iocompras.pedidos.model;

import io.github.cursodsousa.iocompras.pedidos.model.enums.TipoPagamento;
import lombok.Data;

@Data
public class DadosPagamento {
    private String dados;
    private TipoPagamento tipoPagamento;
}

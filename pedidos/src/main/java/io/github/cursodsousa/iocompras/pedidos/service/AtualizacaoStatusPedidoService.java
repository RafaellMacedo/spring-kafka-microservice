package io.github.cursodsousa.iocompras.pedidos.service;

import io.github.cursodsousa.iocompras.pedidos.model.enums.StatusPedido;
import io.github.cursodsousa.iocompras.pedidos.repository.PedidoRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AtualizacaoStatusPedidoService {

    private final PedidoRepository repository;

    @Transactional
    public void atualizarStatus(
            Long codigo, StatusPedido status, String urlNotaFiscal, String rastreio
    ) {
        repository.findById(codigo).ifPresent(pedido -> {
            pedido.setStatus(status);
            pedido.setUrlNotaFiscal(urlNotaFiscal);
            pedido.setCodigoRastreio(rastreio);
        });
    }
}

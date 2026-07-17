package io.github.cursodsousa.iocompras.pedidos.controller;

import io.github.cursodsousa.iocompras.pedidos.controller.dto.NovoPedidoDTO;
import io.github.cursodsousa.iocompras.pedidos.controller.mappers.PedidoMapper;
import io.github.cursodsousa.iocompras.pedidos.model.ErroResposta;
import io.github.cursodsousa.iocompras.pedidos.model.exception.ValidationException;
import io.github.cursodsousa.iocompras.pedidos.service.PedidoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("pedidos")
@RequiredArgsConstructor
public class PedidoController {

    private final PedidoService service;
    private final PedidoMapper mapper;

    @PostMapping
    public ResponseEntity<Object> criar(@RequestBody NovoPedidoDTO novoPedidoDTO) {
        try {
            var pedido = mapper.map(novoPedidoDTO);
            var novoPedido = service.criarPedido(pedido);
            return ResponseEntity.ok(novoPedido.getCodigo());
        } catch (ValidationException e) {
            var erro = new ErroResposta("Erro de validação", e.getField(), e.getMessage());
            return ResponseEntity.badRequest().body(erro);
        }
    }
}

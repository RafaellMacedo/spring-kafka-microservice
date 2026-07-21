package io.github.cursodsousa.icompras.faturamento.publisher;

import io.github.cursodsousa.icompras.faturamento.model.Pedido;
import io.github.cursodsousa.icompras.faturamento.publisher.representation.AtualizacaoStatusPagamento;
import io.github.cursodsousa.icompras.faturamento.publisher.representation.StatusPedido;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import tools.jackson.databind.ObjectMapper;

@Slf4j
@Component
@RequiredArgsConstructor
public class FaturamentoPublisher {

    private final KafkaTemplate<String, String> kafkaTemplate;
    private final ObjectMapper objectMapper;

    @Value("${icompras.config.kafka.topics.pedidos-faturados}")
    private String topico;

    public void publicar(Pedido pedido, String urlNotaFiscal) {
        try {
            log.info("Enviando pedido com url da nota fiscal");

            var representation = new AtualizacaoStatusPagamento(
                    pedido.codigo(), StatusPedido.FATURADO, urlNotaFiscal);

            String json = objectMapper.writeValueAsString(representation);
            kafkaTemplate.send(topico, "dados", json);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }
}

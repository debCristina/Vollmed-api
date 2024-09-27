package med.voll.api.domain.consulta.validacoes.agendamento;

import med.voll.api.domain.ValidacaoException;
import med.voll.api.domain.consulta.DadosAgendamentoConsulta;
import med.voll.api.domain.consulta.validacoes.agendamento.ValidadorAgendamentoConsulta;
import org.springframework.stereotype.Component;

import java.time.DayOfWeek;
@Component
public class ValidadorHorarioFuncionamentoClinica implements ValidadorAgendamentoConsulta {
    public void validar (DadosAgendamentoConsulta dados) {
        var dataConsulta = dados.data();

        var domiingo = dataConsulta.getDayOfWeek().equals(DayOfWeek.SUNDAY);
        var antesDaAbertura = dataConsulta.getHour() <7;
        var depoisDoEncerramento = dataConsulta.getHour() > 18;
        if (domiingo || antesDaAbertura || depoisDoEncerramento) {
            throw new ValidacaoException("Consulta flra do horário de funcionamento da clínica");
        }
    }
}

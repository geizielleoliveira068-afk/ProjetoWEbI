package br.edu.ifs.projetowebi.service.cartao;


import br.edu.ifs.projetowebi.config.excecoes.NaoEncontradoException;
//import br.edu.ifs.projetowebi.model.CartaoModel;
import br.edu.ifs.projetowebi.model.CartaoModel;
import br.edu.ifs.projetowebi.repository.CartaoRepository;
import br.edu.ifs.projetowebi.service.cartao.dto.CartaoSaidaDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@RequiredArgsConstructor
@Service
public class CartaoService {

    private final CartaoService cartao;
    private CartaoRepository cartaoRepository;


//    public CartaoSaidaDTO salvar(CartaoModel cartao) {
//        if (cartao.getMultiplicadorPontos() == null) {
//            cartao.setMultiplicadorPontos(new java.math.BigDecimal("1.0"));
//        }
//        return new CartaoSaidaDTO();
//    }

    public List<CartaoSaidaDTO> listarTodos(){
        return cartaoRepository.findAll().stream().map(cartaoModel->
               new CartaoSaidaDTO(
                       cartaoModel.getNomeCartao(),
                       cartaoModel.getNomeCartao()
        )).toList();

    }
    public void deletar(Long id) {
        if (!cartaoRepository.existsById(id)) {
            throw new NaoEncontradoException("Programa não encontrado");
        }
        cartaoRepository.deleteById(id);
    }
}


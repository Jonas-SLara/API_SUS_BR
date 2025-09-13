package com.csi.sus.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.csi.sus.model.doenca.Doenca;
import com.csi.sus.repositories.DoencaRepository;
import com.csi.sus.service.DoencaService;

//Mockito não salva dados automaticamente → você precisa dizer o
//que o mock deve retornar.

@ExtendWith(MockitoExtension.class)
public class DoencaServiceTest {
    @Mock
    private DoencaRepository doencaRepository;

    @InjectMocks
    private DoencaService doencaService;

    @Test
    void testDoencaList(){

        Doenca doenca = new Doenca(1L, "gripe", "Gripe A");
        
        //configura o comportamento do mock
        when(doencaRepository.save(doenca)).thenReturn(doenca);
        when(doencaRepository.findByNome("gripe")).thenReturn(Optional.of(doenca));

        //act
        this.doencaService.salvarDoenca(doenca);
        Optional<Doenca> res = doencaService.buscarPorNome("gripe");
        
        //assert
        assertTrue(res.isPresent());
        assertEquals("gripe", res.get().getNome());
    }
}

package com.code.tdfeksamenbackend.service;

import com.code.tdfeksamenbackend.constant.Discipline;
import com.code.tdfeksamenbackend.dto.CountryDTO;
import com.code.tdfeksamenbackend.entity.*;
import com.code.tdfeksamenbackend.exception.ApiNotFoundException;
import com.code.tdfeksamenbackend.repository.*;
import net.bytebuddy.implementation.bind.annotation.IgnoreForBinding;
import org.junit.Ignore;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
@ActiveProfiles("test")
class StageLineItemServiceTest {


    private StageLineItemService underTest;

    @Mock
    private StageLineItemRepository stageLineItemRepository;

    @BeforeEach
    void setUp() {
        underTest = new StageLineItemService(stageLineItemRepository);
    }

    @Test
    void testExceptionThrown() {
        Assertions.assertThrows(ApiNotFoundException.class,
                () -> underTest.getCountryDTOByDiscipline(Discipline.TIME));
    }
}
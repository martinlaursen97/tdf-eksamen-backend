package com.code.tdfeksamenbackend.service;

import com.code.tdfeksamenbackend.entity.Competitor;
import com.code.tdfeksamenbackend.repository.CompetitorRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
@ActiveProfiles("test")
class CompetitorServiceTest {

    @Mock
    private CompetitorRepository competitorRepository;
    private CompetitorService underTest;

    @BeforeEach
    void setUp() {
        underTest = new CompetitorService(competitorRepository);
    }

    @Test
    void findAll() {
        when(competitorRepository.findAll()).thenReturn(Stream
                .of(new Competitor(),
                    new Competitor(),
                    new Competitor())
                .collect(Collectors.toList()));
        Assertions.assertEquals(3, underTest.findAll().size());
    }

    @Test
    void save() {
        Competitor competitor = new Competitor();
        when(competitorRepository.save(competitor))
                .thenReturn(competitor);
        Assertions.assertEquals(competitor, underTest.save(competitor));
    }
}
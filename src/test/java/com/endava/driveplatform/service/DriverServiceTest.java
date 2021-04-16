package com.endava.driveplatform.service;

import com.endava.driveplatform.api.dto.DriverRequestDto;
import com.endava.driveplatform.model.Driver;
import com.endava.driveplatform.repository.DriverRepository;
import com.endava.driveplatform.utils.exceptions.DriverNotFoundException;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static com.endava.driveplatform.utils.DriverServiceUtils.*;
import static com.endava.driveplatform.utils.TestConstants.ID_ONE;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class DriverServiceTest {

    @Mock
    private DriverRepository driverRepository;

    @InjectMocks
    private DriverService driverService;

    @AfterEach()
    void tearDown(){
        verifyNoMoreInteractions(driverRepository);
    }

    @Test
    void shouldSaveDriver(){
        final DriverRequestDto expectedSavedDriver = DRIVER_DTO_RESPONSE;

        when(driverRepository.save(any(Driver.class))).thenReturn(DRIVER_ONE);

        final DriverRequestDto actualResponseDto = driverService.save(DRIVER_DTO_REQUEST);

        Assert.assertEquals(expectedSavedDriver.toString(),actualResponseDto.toString());

    }

    @Test
    void shouldUpdate(){
        final DriverRequestDto expectedUpdatedDriver = DRIVER_DTO_UPDATED_RESPONSE;
        when(driverRepository.findById(ID_ONE)).thenReturn(Optional.of(DRIVER_ONE));

        final DriverRequestDto actualResponseDto = driverService.update(ID_ONE,DRIVER_DTO_UPDATED_RESPONSE);
        Assert.assertEquals(expectedUpdatedDriver,actualResponseDto);
    }

    @Test
    void shouldThrowDriverNotFoundException(){
         when(driverRepository.findById(ID_ONE)).thenReturn(Optional.empty());
        Assert.assertThrows(DriverNotFoundException.class, () ->driverService.update(ID_ONE,DRIVER_DTO_REQUEST));
    }
}

package com.endava.driveplatform.utils;

import com.endava.driveplatform.api.dto.DriverRequestDto;
import com.endava.driveplatform.model.Driver;

import static com.endava.driveplatform.utils.TestConstants.*;

public class DriverServiceUtils {
    public static final DriverRequestDto DRIVER_DTO_RESPONSE =
            new DriverRequestDto(
                    FIRST_NAME_ONE,
                    LAST_NAME_ONE,
                    GENDER_ONE,
                    AGE_ONE,
                    DRIVER_LICENSE_ID_ONE
            );
    public static final DriverRequestDto DRIVER_DTO_UPDATED_RESPONSE =
            new DriverRequestDto(
                    FIRST_NAME_UPDATED_ONE,
                    LAST_NAME_ONE,
                    GENDER_ONE,
                    AGE_ONE,
                    DRIVER_LICENSE_ID_ONE
            );
    public static final DriverRequestDto DRIVER_DTO_REQUEST =
            new DriverRequestDto(
                    FIRST_NAME_ONE,
                    LAST_NAME_ONE,
                    GENDER_ONE,
                    AGE_ONE,
                    DRIVER_LICENSE_ID_ONE
            );
    public static final Driver DRIVER_ONE =
            new Driver(
                    ID_ONE,
                    FIRST_NAME_ONE,
                    LAST_NAME_ONE,
                    GENDER_ONE,
                    AGE_ONE,
                    DRIVER_LICENSE_ID_ONE
            );
    public static final Driver DRIVER_RESPONSE_ONE =
            new Driver(
                    ID_ONE,
                    FIRST_NAME_ONE,
                    LAST_NAME_ONE,
                    GENDER_ONE,
                    AGE_ONE,
                    DRIVER_LICENSE_ID_ONE
            );
}

package com.findmyfriends.alpha.dao;

import com.findmyfriends.alpha.domain.device.Device;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

public class SpecDeviceDataAccessServiceTest {

    private SpecDeviceDataAccessService underTest;

    @Before
    public void setUp() {
        underTest = new SpecDeviceDataAccessService();
    }

    @Test
    public void canPerformCrud() {
        UUID idOne = UUID.randomUUID();
        Device deviceOne = new Device(idOne, "dcc6d844-750e-4d7c-9190-9c6c0df3b805", 1, "2885170c-74ab-4583-87fd-c3c5ac392b1d");

        UUID idTwo = UUID.randomUUID();
        Device deviceTwo = new Device(idTwo, "13de6478-6055-4a6a-823e-2bb3eb621060", 0, "c6caca53-5cae-405d-a420-27805e441c44");

        underTest.insertDevice(idOne, deviceOne);
        underTest.insertDevice(idTwo, deviceTwo);

        assertThat(underTest.selectDeviceById(idOne))
                .isPresent()
                .hasValueSatisfying(deviceFromDb -> assertThat(deviceFromDb).isEqualToComparingFieldByField(deviceOne));

        assertThat(underTest.selectDeviceById(idTwo))
                .isPresent()
                .hasValueSatisfying(deviceFromDb -> assertThat(deviceFromDb).isEqualToComparingFieldByField(deviceTwo));

        List<Device> people = underTest.selectAllDevices();

        assertThat(people)
                .hasSize(2)
                .usingFieldByFieldElementComparator()
                .containsExactlyInAnyOrder(deviceOne, deviceTwo);

        Device deviceUpdate = new Device(idOne, "4e08f4f1-f372-4585-9f61-6def038c783e", 1, "deeb7af6-6d3e-429d-9b7d-92a1f5da4760");


        assertThat(underTest.updateDeviceById(idOne, deviceUpdate)).isEqualTo(1);

        assertThat(underTest.selectDeviceById(idOne))
                .isPresent()
                .hasValueSatisfying(deviceFromDb -> assertThat(deviceFromDb).isEqualToComparingFieldByField(deviceUpdate));

        assertThat(underTest.deleteDeviceById(idOne)).isEqualTo(1);

        assertThat(underTest.selectDeviceById(idOne)).isEmpty();

        assertThat(underTest.selectAllDevices())
                .hasSize(1)
                .usingFieldByFieldElementComparator()
                .containsExactlyInAnyOrder(deviceTwo);
    }

    @Test
    public void willReturn0IfNoDeviceFoundToDelete() {
        // Given
        UUID id = UUID.randomUUID();

        // When
        int deleteResult = underTest.deleteDeviceById(id);

        // Then
        assertThat(deleteResult).isEqualTo(0);
    }

    @Test
    public void willReturn0IfNoDeviceFoundToUpdate() {
        // Given
        UUID id = UUID.randomUUID();
        Device device = new Device(id, "4e08f4f1-f372-4585-9f61-6def038c783e", 1, "deeb7af6-6d3e-429d-9b7d-92a1f5da4760");


        // When
        int deleteResult = underTest.updateDeviceById(id, device);

        // Then
        assertThat(deleteResult).isEqualTo(0);
    }
}
package com.findmyfriends.alpha.dao;

import com.findmyfriends.alpha.domain.user.User;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

public class SpecUserDataAccessServiceTest {

    private SpecUserDataAccessService underTest;

    @Before
    public void setUp() {
        underTest = new SpecUserDataAccessService();
    }

    @Test
    public void willReturn0IfNoUserFoundToDelete() {
        // Given
        UUID id = UUID.randomUUID();

        // When
        int deleteResult = underTest.deleteUserById(id);

        // Then
        assertThat(deleteResult).isEqualTo(0);
    }

    @Test
    public void willReturn0IfNoUserFoundToUpdate() {
        // Given
        UUID id = UUID.randomUUID();
        User user = new User(id, "Tory Not In Db", "1433");

        // When
        int deleteResult = underTest.updateUserById(id, user);

        // Then
        assertThat(deleteResult).isEqualTo(0);
    }
}
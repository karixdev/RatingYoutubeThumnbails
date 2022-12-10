package com.github.karixdev.youtubethumbnailranking.shared.payload.response;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

@JsonTest
public class SuccessResponseTest {
    @Autowired
    JacksonTester<SuccessResponse> jTester;

    @Test
    void testSerialization() throws IOException {
        SuccessResponse payload = new SuccessResponse();

        var result = jTester.write(payload);

        assertThat(result).hasJsonPathValue("$.message");
        assertThat(result).extractingJsonPathValue("$.message")
                .isEqualTo("success");
    }

}

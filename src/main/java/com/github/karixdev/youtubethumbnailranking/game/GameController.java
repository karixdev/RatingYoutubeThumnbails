package com.github.karixdev.youtubethumbnailranking.game;

import com.github.karixdev.youtubethumbnailranking.game.payload.request.GameResultRequest;
import com.github.karixdev.youtubethumbnailranking.game.payload.response.GameResponse;
import com.github.karixdev.youtubethumbnailranking.security.CurrentUser;
import com.github.karixdev.youtubethumbnailranking.security.UserPrincipal;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/game")
@RequiredArgsConstructor
public class GameController {
    private final GameService service;

    @PostMapping("/start")
    public ResponseEntity<GameResponse> start(
            @CurrentUser UserPrincipal userPrincipal
    ) {
        return new ResponseEntity<>(
                service.start(userPrincipal),
                HttpStatus.OK
        );
    }

    @PostMapping("/result/{id}")
    public ResponseEntity<GameResponse> result(
            @PathVariable(name = "id") Long id,
            @RequestBody GameResultRequest payload,
            @CurrentUser UserPrincipal userPrincipal
    ) {
        return new ResponseEntity<>(
                service.result(id, payload, userPrincipal),
                HttpStatus.OK
        );
    }
}

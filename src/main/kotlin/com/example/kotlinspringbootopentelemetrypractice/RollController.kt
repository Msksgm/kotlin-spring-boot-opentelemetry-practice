package com.example.kotlinspringbootopentelemetrypractice

import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.server.ResponseStatusException

@RestController
class RollController {
    private val logger = LoggerFactory.getLogger(RollController::class.java)

    @GetMapping("/rolldice")
    fun index(@RequestParam("player") player: String?, @RequestParam("rolls") rolls: Int?): String {
        if (rolls == null) {
            throw ResponseStatusException(HttpStatus.BAD_REQUEST, "Missing rolls parameter", null)
        }

        val result = Dice(1, 6).rollTheDice(rolls)

        if (player != null) {
            logger.info("$player is rolling the dice: $result")
        } else {
            logger.info("Anonymous player is rolling the dice: $result")
        }
        return result.toString()
    }
}

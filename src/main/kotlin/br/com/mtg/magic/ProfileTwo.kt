package br.com.mtg.magic

import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.context.annotation.Profile
import org.springframework.stereotype.Component

@Component
@Qualifier("profile")
@Profile("!dev")
class ProfileTwo: ProfileInterface {
    override fun helloWorld(): String {
        return "two"
    }
}
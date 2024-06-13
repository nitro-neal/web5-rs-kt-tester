/*
 * This source file was generated by the Gradle 'init' task
 */
package org.example

import web5.sdk.DidDht
import web5.sdk.InMemoryKeyManager

class App {
    val greeting: String
        get() {
            return "Hello World!"
        }
}

fun main() {
    val keyManager = InMemoryKeyManager()
    val jwkData = keyManager.generateKeyMaterial()

    val didDht = DidDht.fromIdentityKey(jwkData)

    val signer = keyManager.getSigner(jwkData)
    didDht.publish(signer)
    didDht.deactivate(signer)

    println(didDht.getData().did)
}

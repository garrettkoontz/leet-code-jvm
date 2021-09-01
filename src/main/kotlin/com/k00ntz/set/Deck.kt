package com.k00ntz.set

import java.util.ArrayDeque

typealias Deck = ArrayDeque<Card>

val deck: Deck = ArrayDeque(shapes.flatMap { shape ->
    colors.flatMap { color ->
        numbers.flatMap { number ->
            shades.map { shade ->
                Card(shape, color, number, shade)
            }
        }
    }
}.shuffled().toList())

fun Deck.draw(n: Int): List<Card> =
    (0 until n).map { this.pop() }

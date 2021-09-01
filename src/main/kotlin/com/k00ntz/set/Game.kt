package com.k00ntz.set

import java.util.ArrayDeque

typealias SetMatch = Triple<Card, Card, Card>

class Board(private val state: Array<Array<Card>>) {
    constructor(deck: ArrayDeque<Card>, long: Int = 4, wide: Int = 3) :
            this((1..long).map { deck.draw(wide).toTypedArray() }.toTypedArray())

    fun print(): String {
//    var l = 'A'
        return state.joinToString(separator = "\n") {
            it.map {
                it.toPrintString().padEnd(30)//.also { l++ }
            }.combineOnLine()
        }
    }

    fun containsSet(): Boolean {
        val cards = state.flatMap { it.toList() }
        val cardSet = cards.toSet()
        for (i in cards.indices) {
            val c1 = cards[i]
            for (j in (i + 1 until cards.size)) {
                val c2 = cards[j]
                val c3 = findThird(c1, c2)
                if (cardSet.contains(c3)) return true
            }
        }
        return false
    }

    private fun replace(idxs: Triple<Pair<Int, Int>, Pair<Int, Int>, Pair<Int, Int>>, deck: Deck) {
        val newCards = deck.draw(3)
        idxs.toList().mapIndexed { i, (j, k) ->
            state[j][k] = newCards[i]
        }
    }

    fun getCards(l: Triple<Pair<Int, Int>, Pair<Int, Int>, Pair<Int, Int>>) =
        l.let { (a,b,c) ->
            val (a1, a2) = a
            val (b1, b2) = b
            val (c1, c2) = c
        Triple(state[a1][a2],state[b1][b2],state[c1][c2])}

    fun SetMatch.isASet(): Boolean {
        val (a, b, c) = this
        val shapes = setOf(a.shape, b.shape, c.shape)
        val colors = setOf(a.color, b.color, c.color)
        val numbers = setOf(a.number, b.number, c.number)
        val shades = setOf(a.shade, b.shade, c.shade)
        return (shapes.size == 1 || shapes.size == 3) &&
                (colors.size == 1 || colors.size == 3) &&
                (numbers.size == 1 || numbers.size == 3) &&
                (shades.size == 1 || shades.size == 3)
    }


    private fun findThird(card1: Card, card2: Card): Card {
        val color = if (card1.color == card2.color) card1.color else colors.not(card1.color, card2.color)
        val shape = if (card1.shape == card2.shape) card1.shape else shapes.not(card1.shape, card2.shape)
        val shade = if (card1.shade == card2.shade) card1.shade else shades.not(card1.shade, card2.shade)
        val number = if (card1.number == card2.number) card1.number else numbers.not(card1.number, card2.number)
        return Card(shape, color, number, shade)
    }

    fun makeSet(idxs: Triple<Pair<Int, Int>, Pair<Int, Int>, Pair<Int, Int>>): Boolean {
        return getCards(idxs).isASet().also {
            replace(idxs, deck)
        }
    }
}


class Game(
    private val deck: Deck,
    private val board: Board = Board(deck),
    val sets: MutableMap<String, MutableSet<SetMatch>> = mutableMapOf()
) {
    fun playGame() {
        while (deck.size > 0) {
            println(board.print())
            if (board.containsSet()) {
                val r = readLine()
                val line = parseLine(r)
                if (line != null) {
                    val (name, idxs) = line
                    val potentialSetMatch = board.getCards(idxs)
                    if (board.makeSet(idxs)) {
                        sets.getOrPut(name) { mutableSetOf() }.add(potentialSetMatch)

                    }
                }
            } else {
                throw RuntimeException("Can't find a set!")
            }
        }
    }

    private fun parseLine(r: String?): Pair<String, Triple<Pair<Int, Int>,Pair<Int, Int>,Pair<Int, Int>>>? =
        if (r == null) null
        else {
            val pair = r.split(" ")
            if (pair.size != 2) null
            else {
                val name = pair[0]
                val chars = pair[1].toSet()
                if (chars.size == 3 && ('A'..'L').toSet().containsAll(chars)) {
                    Pair(name, getCardIdx(chars).let {
                        Triple(it[0], it[1], it[2])
                    })
                } else {
                    null
                }
            }
        }

    private fun getCardIdx(chars: Set<Char>): List<Pair<Int, Int>> =
        chars.map {
            val i = (it - 'A') / 3
            val j = (it - 'A') % 3
            Pair(i, j)
        }
}


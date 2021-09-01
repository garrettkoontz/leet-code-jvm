package com.k00ntz.set

enum class Shape(val str: String) {
    DIAMOND(" ^ \n|s|\n V "),
    S("/s/\n\\s\\\n/s/"),
    OVAL("   \n(s)\n   ");

    private fun makeColor(c: Color, shade: Shade): String {
        val color = c.colorCode
        return "$color${
            this.str.replace("\n", "$ANSI_RESET\n$color")
                .replace("s", shade.makeShadeString(c))
        }$ANSI_RESET"
    }

    fun makeShapeString(color: Color, shade: Shade, number: Number): String =
        makeColor(color, shade).repeatOnLine(number, 9)
}

fun String.repeatOnLine(number: Number, padTo: Int): String {
    val str = this.split("\n")
    return when(number) {
        Number.ONE -> {
            "   ${str[0]}   \n   ${str[1]}   \n   ${str[2]}   \n"
        }
        Number.TWO -> {
            " ${str[0]}${str[0]}  \n ${str[1]}${str[1]}  \n ${str[2]}${str[2]}  \n"
        }
        Number.THREE -> {
            "${str[0].repeat(3)}\n${str[1].repeat(3)}\n${str[2].repeat(3)}\n"
        }
    }
}

fun List<String>.combineOnLine(): String {
    val splits = this.map {
        it.split("\n")
    }
    return splits.first().foldIndexed(""){i, acc, _ ->
        acc + splits.joinToString(separator = " ") { it[i] } + "\n"
    }
}

val shapes = Shape.values().toSet()

enum class Color(val colorCode: String, val backgroundColor: String) {
    GREEN(ANSI_GREEN, ANSI_GREEN_BACKGROUND),
    RED(ANSI_RED, ANSI_RED_BACKGROUND),
    PURPLE(ANSI_PURPLE, ANSI_PURPLE_BACKGROUND);
}

const val ANSI_RESET = "\u001B[0m"
const val ANSI_RED = "\u001B[31m";
const val ANSI_GREEN = "\u001B[32m";
const val ANSI_PURPLE = "\u001B[35m";
const val ANSI_RED_BACKGROUND = "\u001B[41m"
const val ANSI_GREEN_BACKGROUND = "\u001B[42m"
const val ANSI_PURPLE_BACKGROUND = "\u001B[45m"

val colors = Color.values().toSet()

enum class Number(val i: Int) {
    ONE(1),
    TWO(2),
    THREE(3)
}

val numbers = Number.values().toSet()

enum class Shade {
    OPEN,
    SHADED,
    FILLED;

    fun makeShadeString(color: Color): String =
        when (this) {
            OPEN -> " "
            SHADED -> "${color.colorCode}=$ANSI_RESET${color.colorCode}"
            FILLED -> "${color.backgroundColor} $ANSI_RESET${color.colorCode}"
        }
}

val shades = Shade.values().toSet()

fun <T> Set<T>.not(c1: T, c2: T): T =
    this.minus(setOf(c1, c2)).first()

class Card(
    val shape: Shape,
    val color: Color,
    val number: Number,
    val shade: Shade
) {


    fun toPrintString(): String =
        shape.makeShapeString(color, shade, number)

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Card

        if (shape != other.shape) return false
        if (color != other.color) return false
        if (number != other.number) return false
        if (shade != other.shade) return false

        return true
    }

    override fun hashCode(): Int {
        var result = shape.hashCode()
        result = 31 * result + color.hashCode()
        result = 31 * result + number.hashCode()
        result = 31 * result + shade.hashCode()
        return result
    }

    override fun toString(): String {
        return "Card(shape=$shape, color=$color, number=$number, shade=$shade)"
    }


}
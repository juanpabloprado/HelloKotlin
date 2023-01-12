import java.io.File
import kotlin.io.path.writeLines
import kotlin.random.Random

fun getRandom(max: Int): Int = Random.nextInt(max)

// Prompt the user to enter the name of the test scores file
// Read each line from the file
// Sort the scores from highest to lowest
// Pick the 3 highest scores
// Write those 3 userId/score pairs to a new file sorted.txt

fun main(args: Array<String>) {
    println("Enter the name of the file containing scores: ")
    val inputFilename = readlnOrNull()

    if (inputFilename.isNullOrEmpty()) {
        println("Not a valid filename")
        return
    }

    val inputFile = File(inputFilename)
    if(!inputFile.isFile) return

    val rawScores = inputFile.readLines()

    val parsedScores = rawScores.map {line ->
        val elements = line.split(":")
        elements[0] to elements[1]
    }

    val finalScores = parsedScores.sortedByDescending { it.second }.take(3)

    val outputPath = File("sorted.txt").toPath()
    val outputScores = finalScores.map {
        "${it.first}:${it.second}"
    }
    outputPath.writeLines(outputScores)


    // Using the provided test scores, identify the 3 students
    // with the lowest test scores
    testScores.toList()
        .sortedBy { pair -> pair.second } // Sort by score
        .map { pair -> pair.first } // Map to student id
        .take(3) // Take the first 3
        .forEach { println(it) }

    println(getOutput(null))
    println(getOutput(4))
    println(getOutput(3.2))
    println(getOutput("Hello Kotlin"))
    println(getOutput('a'))

    printFormattedName("Juan", "Prado", basicFormatter)
    printFormattedName("Juan", "Prado", fancyFormatter)
    printFormattedName("Juan", "Prado") { first, last -> "$last, $first" }

    // Try adding program arguments via Run/Debug configuration.
    // Learn more about running applications: https://www.jetbrains.com/help/idea/running-applications.html.
    println("Program arguments: ${args.joinToString()}")
}

fun getOutput(input: Any?): String = when (input) {
    is Number -> {
        if (input is Int) {
            "Input was an int"
        } else {
            "Input was a non-Int number"
        }
    }
    is String -> "Input was a string with length ${input.length}"
    null -> "Input was null"
    else -> "Input didn't match target inputs"
}

fun printFormattedName(first: String, last: String, formatter: (String, String) -> String) {
    println(formatter(first, last))
}

val basicFormatter: (String, String) -> String = { first, last -> "$first $last"}

val fancyFormatter: (String, String) -> String = { first, last -> "first name is $first and lastname is $last"}
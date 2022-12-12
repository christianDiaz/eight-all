const val SUCCESS_RESPONSE = "Check"
const val BAD_RESPONSE = "X"
const val DUBIOUS_RESPONSE = "?"

val responses = mapOf(
    "Yes" to SUCCESS_RESPONSE,
    "Is true" to SUCCESS_RESPONSE,
    "Totally" to SUCCESS_RESPONSE,
    "Definitely" to SUCCESS_RESPONSE,
    "Ask in other time" to DUBIOUS_RESPONSE,
    "I can't tell" to DUBIOUS_RESPONSE,
    "May be" to DUBIOUS_RESPONSE,
    "Not gonna happen" to BAD_RESPONSE,
    "Not count on that" to BAD_RESPONSE,
    "Definitely not" to BAD_RESPONSE,
    "I don't think so" to BAD_RESPONSE
)


fun main(args: Array<String>) {
    println("Hi, I'm your magic eight ball. Which of this options do you prefer?")
    println("1. Ask some question")
    println("2. Check the answers")
    println("3. Quit")

    when (readlnOrNull()) {
        "1" -> makeQuestion()
        "2" -> showAnswers()
        "3" -> quit()
        else -> showError()
    }
}

private fun makeQuestion() {
    println("Which questions do you want to use?")
    readlnOrNull()
    println("So, that's your question")
    val generatedAnswer = responses.keys.random()
    println(generatedAnswer)
}

private fun showAnswers() {
    println("Choose an answer")
    println("1. All answers")
    println("2. Just Success")
    println("3. Just Bad")
    println("4. Just Dubious")
    when (readlnOrNull()) {
        "1" -> responses.forEach { response -> println(response.key) }
        "2" -> responses.filterValues { value -> value === SUCCESS_RESPONSE }
            .also { response -> println(response.keys) }

        "3" -> responses.filterValues { value -> value === BAD_RESPONSE }.also { response -> println(response.keys) }
        "4" -> responses.filterValues { value -> value === DUBIOUS_RESPONSE }
            .also { response -> println(response.keys) }
    }

}

private fun quit() {
    println("See you later!!")
}

private fun showError() {
    println("wow! It seem like you choose a no valid option, Try again!!")
}
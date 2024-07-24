import kotlin.random.Random

fun main() {
    println("Welcome to Rock-Paper-Scissors! Let's start the game.")

    var roundsPlayed = 0
    var userScore = 0
    var computerScore = 0

    while (roundsPlayed < 3) {
        val userChoice = getUserChoice()
        val computerChoice = getComputerChoice()

        println("You chose: $userChoice")
        println("Computer chose: $computerChoice")

        val result = determineWinner(userChoice, computerChoice)
        when (result) {
            "Draw" -> println("It's a draw!")
            "User" -> {
                println("You win this round!")
                userScore++
            }
            "Computer" -> {
                println("Computer wins this round!")
                computerScore++
            }
        }

        roundsPlayed++
    }

    println("Game Over!")
    println("Your score: $userScore")
    println("Computer's score: $computerScore")

    if (userScore > computerScore) {
        println("Congratulations! You are the overall winner!")
    } else if (userScore < computerScore) {
        println("Sorry! The computer is the overall winner!")
    } else {
        println("It's a tie overall!")
    }
}

fun getUserChoice(): String {
    while (true) {
        print("Enter your choice (Rock, Paper, or Scissors): ")
        val userInput = readLine()?.toUpperCase()
        if (userInput == "ROCK" || userInput == "PAPER" || userInput == "SCISSORS") {
            return userInput
        } else {
            println("Invalid choice. Please enter Rock, Paper, or Scissors.")
        }
    }
}

fun getComputerChoice(): String {
    val choices = arrayOf("ROCK", "PAPER", "SCISSORS")
    return choices[Random.nextInt(choices.size)]
}

fun determineWinner(userChoice: String, computerChoice: String): String {
    return if (userChoice == computerChoice) {
        "Draw"
    } else if ((userChoice == "ROCK" && computerChoice == "SCISSORS") ||
        (userChoice == "PAPER" && computerChoice == "ROCK") ||
        (userChoice == "SCISSORS" && computerChoice == "PAPER")) {
        "User"
    } else {
        "Computer"
    }
}

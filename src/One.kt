fun main(args: Array<String>) {

    val firstPerson = Person("One Person", 22, "Developer")
    val secondPerson = Person("Second Person", 29, "Analyst")

    // Meios para manipular os objetos criados

    // Mais comum
    val olderPerson = if (firstPerson.age >= secondPerson.age ) firstPerson else secondPerson
    olderPerson.printPerson()

    // Utilizando run - O que é retornado, define seu tipo
    // A última linha será o retorno
    run {
        if (firstPerson.age <= secondPerson.age) firstPerson else secondPerson
    }.printPerson()

    // Utilizando with - Os parâmetros do objeto dentro do with, ficam expostos dentro das chaves
    // A ultima linha será o retorno
    with(firstPerson) {
        age += 1
        "Age is now $age"
    }.println()

    // Utilizando object run - Os parâmetros do objeto dentro das chaves, ficam expostos
    // A ultima linha será o retorno
    firstPerson.run {
        age += 1
        "Age is now $age"
    }.println()

    // Utilizando let - O objeto será o it
    // A ultima linha será o retorno
    firstPerson.let {
        it.age += 1
        "Age is now ${it.age}"
    }.println()

    // Utilizando let - O objeto será o it - Definindo nome para o it
    // A ultima linha será o retorno
    firstPerson.let { modifiedPErson ->
        modifiedPErson.age += 1
        "Age is now ${modifiedPErson.age}"
    }.println()

    // Utilizando apply - Manipula os parâmetros do objeto
    // O retorno será o objeto
    secondPerson.apply {
        age += 1
        job = "Hot-dog seller"
    }.printPerson()

    // Utilizando also - Manipula os parâmetros do objeto, que será o it
    // O retorno será o objeto
    secondPerson.also {
        it.age += 1
        it.job = "Youtuber"
    }.printPerson()

    // Utilizando also - Manipula os parâmetros do objeto, definindo nome
    // O retorno será o objeto
    secondPerson.also { person ->
        person.age += 1
        person.job = "Youtuber"
    }.printPerson()

}

data class Person(var name: String,
                  var age: Int,
                  var job: String) {
    fun printPerson() = println(this.toString())
}

// Criando um método personalizado para classe String
fun String.println() = println(this)
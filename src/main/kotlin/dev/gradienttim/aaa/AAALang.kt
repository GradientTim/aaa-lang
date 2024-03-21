package dev.gradienttim.aaa

import java.io.File

val aRegex = Regex("^A+\$")

fun main(args: Array<String>) {
    if (args.isEmpty()) {
        println("The first argument must be a file path")
        return
    }
    val file = File(args[0])
    if (file.exists().not() || file.isDirectory) {
        println("The file does not exist or it is a folder")
        return
    }
    if (file.name.endsWith(".aaa").not()) {
        println("The file must end with the name '.aaa'")
        return
    }
    println("Processing file ${file.name}...")
    val startTime = System.currentTimeMillis()
    file.readLines().forEachIndexed(::parse)
    println("Finished processing file ${file.name} (${System.currentTimeMillis() - startTime}ms)")
}

fun parse(line: Int, input: String) {
    if (input.isEmpty() || input.startsWith(";")) {
        return
    }
    val realLine = line + 1
    val inputs = input.split(" ")
    if (inputs.first() != "out") {
        println("Line $realLine could not be parsed. Each line must begin with 'out'")
        return
    }
    val values = inputs.subList(1, inputs.size)
    println(buildString {
        values.forEach {
            if (it.matches(aRegex).not()) {
                println("Error in line $realLine. No characters except 'A' allowed")
                return@buildString
            }
            append(it.length.toChar())
        }
    })
}
#!/usr/bin/python
import sys

welcomeMessage = "Welkom bij de bootcamp toelatings opdracht. Werk alsjeblieft zorgvuldig en netjes. Succes!!"

def printWelcomeText():
    welcome = welcomeMessage
    return welcome

def printExercise():
    return None

if len(welcomeMessage) != 91:
    sys.exit("Nice try, but not quite right :)")

print(printWelcomeText())

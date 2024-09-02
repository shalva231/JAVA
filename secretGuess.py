import random

secret_num = random.randint(1,10)
user_guess = int(input("Enter the secret number (you have 4 guesses): "))
guess = 0

while user_guess != secret_num and guess < 3:
    guess += 1
    print("wrong guess")
    user_guess = int(input("Enter the secret number (you have 4 guesses): "))
if guess >= 3:
    print("you ran out of guesses see you next time :D")
else:
    print("you guessed the secret number. it was: " + secret_num)
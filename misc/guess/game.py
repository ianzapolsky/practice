# game.py
# A simple number guessing game
# By Ian Zapolsky (12/08/13)

import random

def select_random_number():
    random_integer = random.randint(1, 100);
    return random_integer

def interpret_guess(random_integer):
    print 'please enter a guess: '
    guess = int(raw_input())
    if random_integer > guess:
        print 'too low'
        return False
    elif random_integer < guess:
        print 'too high'
        return False
    else:
        return True

if __name__ == '__main__':
    print 'welcome to the guessing game\n'
    num_to_guess = select_random_number()
    guesses = 1
    while not interpret_guess(num_to_guess):
        guesses += 1
    print 'you guessed the number in '+str(guesses)+' guesses'
    

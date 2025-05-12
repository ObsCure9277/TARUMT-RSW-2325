#!/usr/bin/env python
# coding: utf-8

# In[1]:


#Q1

import math

def volume(r, h):
    v = math.pi*r**2*h
    print("Volume is: ", v)


# In[2]:


volume(2, 5)


# In[7]:


#Q2

import time
import math

def simulated_mouse(start_x, start_y, end_x, end_y):
    start_time=time.time()
    distance = math.sqrt((end_x-start_x)**2+(end_y-start_y)**2)
    time.sleep(1)
    end_time=time.time()
    elapse_time = end_time-start_time
    speed = distance/elapse_time
    return speed

start_pos = (100, 500)
end_pos = (800, 1000)
speed =(simulated_mouse(start_pos[0], start_pos[1], end_pos[0], end_pos[1]))
print(speed)


# In[15]:


#Q3

import time
import math
import random

def generated_coordinate(num_pairs = 10):
    coordinateList = []
    for _ in range(num_pairs):
        start_x = random.randint(0,1920)
        start_y = random.randint(0, 1080)
        end_x = random.randint(0, 1920)
        end_y = random.randint(0,1080)
        coordinateList.append(((start_x, start_y,), (end_x, end_y)))
        time.sleep(1)
    return coordinateList

def calculate_distance(start_x, start_y, end_x, end_y):
    return math.sqrt((end_x - start_x)**2 + (end_y - start_y)**2)

def calculateMouseSpeed(coordinateList, duration):
    total_distance = sum(calculate_distance(start[0], start[1], end[0], end[1]) 
                         for start, end in coordinateList)
    average_speed = total_distance/duration
    return average_speed

start_time = time.time()

coordinateList = generated_coordinate(10)

end_time = time.time()
total_duration = end_time - start_time

average_speed = calculateMouseSpeed(coordinateList, total_duration)
print(f"Average speed: {average_speed} pixels/second")


# In[ ]:


#Question 4

import random

colors = ["red", "green", "blue", "yellow", "orange", "purple"]     #default colour
attempts_limit = 10                                                 #chance given to player

def generate_secret_code():                                         #function to randomly assign 4 colours into 4 positions
    return random.sample(colors, 4)

def get_player_guess():                                             #function for player to guess 4 colours
    while True:
        guess = input("Enter your guess (comma-separated colors): ").strip().lower().split(",")
        if len(guess) == 4 and all(color in colors for color in guess): #input validation to check if player input only 4 colours & within default colour
            return guess
        print("Invalid guess. Please enter exactly 4 colors from the available options.")

def get_feedback(secret_code, guess):                               #compare the actual answer with the player's guess
    exact_matches = sum(secret_code[i] == guess[i] for i in range(4)) #calculate how many exact match
    color_matches = len(set(secret_code) & set(guess)) - exact_matches #calculate how many colour match (wrong position)
    return exact_matches, color_matches

def play_game():      #main function
    secret_code = generate_secret_code()         #call function to assign 4 colours into different positions
    print("Welcome to Mastermind!")
    print("Available colors:", colors)
    print("Guess the secret code of 4 colors.")
    print("You have", attempts_limit, "attempts.")
    print()

    attempts = 0         #reset variable to 0
    while attempts < attempts_limit:
        guess = get_player_guess()   #call function to get user input
        exact_matches, color_matches = get_feedback(secret_code, guess)   #call function to get result after comparison
        attempts += 1
        print("Attempt", attempts)
        print("Exact matches:", exact_matches)
        print("Color matches (excluding exact matches):", color_matches)
        print()

        if guess == secret_code:    #win the game
            print("Congratulations! You guessed the secret code!")
            return

    print("Game over! You ran out of attempts.")  #lose the game
    print("The secret code was:", secret_code)

play_game()  #call main function


# In[ ]:





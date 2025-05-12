# -*- coding: utf-8 -*-
"""
Best-first search and A* Search

This code is modified from the following source:
@author: Ghazanfar Ali, 2012. 8-Puzzle solving using the A* algorithm using Python and PyGame. 
Available at http://www.codeproject.com/Articles/365553/Puzzle-solving-using-the-A-algorithm-using-Pytho

Algorithm
==========
Get the current state of the scenario (refers to the puzzle).
Find the available moves and their cost using best-first or A*.
Choose the move with the least cost and set it as the current state.
Check if it matches the goal state, if yes terminate, if no move to step 1.
"""
##-----------------------------------------------------------------------------
##setting up the puzzle
##----------------------------------------------------------------------------- 

import random

class Puzzle:
    def __init__(self):
        self.StartNode=['1','2','3','5','6','8','4','0','7'] #default, h(n) = 8
        self.GoalNode=['1','2','3','4','5','6','7','8','0'] #default, h(n) = 0
        self.PreviousNode=[] #to store the expanded nodes
        self.Fringe=[]  #to store the leaf nodes 
        self.Parent = []
      
        
    #this function is used to shuffle the puzzle when start
    def shuffler(self):
                
            while True:
                node=self.StartNode
                subNode=[]
                direct=random.randint(1,4)
                getZeroLocation=node.index('0')+1
                subNode.extend(node)
                boundary=self.boundaries(getZeroLocation)
                        
                #if the empty tile is at the top 2 rows, move the tile down
                if getZeroLocation+3<=9 and direct==1:
                    temp=subNode[node.index('0')]
                    subNode[node.index('0')]=subNzzode[node.index('0')+3]
                    subNode[node.index('0')+3]=temp
                    self.StartNode=subNode
                    return
                
                #if the empty tile is at the bottom 2 rows, move the tile up                                
                elif getZeroLocation-3>=1 and direct==2:
                    temp=subNode[node.index('0')]
                    subNode[node.index('0')]=subNode[node.index('0')-3]
                    subNode[node.index('0')-3]=temp
                    self.StartNode=subNode
                    return
                
                #if the empty tile is at the last 2 columns, move the tile left 
                elif getZeroLocation-1>=boundary[0] and direct==3:
                    temp=subNode[node.index('0')]
                    subNode[node.index('0')]=subNode[node.index('0')-1]
                    subNode[node.index('0')-1]=temp
                    self.StartNode=subNode
                    return

                #if the empty tile is at the first 2 columns, move the tile right 
                elif getZeroLocation+1<=boundary[1] and direct==4:
                    temp=subNode[node.index('0')]
                    subNode[node.index('0')]=subNode[node.index('0')+1]
                    subNode[node.index('0')+1]=temp
                    self.StartNode=subNode
                    return
    
    #to determine the left/right boundaries of the empty tile          
    def boundaries(self,location):
        lst=[[1,2,3],[4,5,6],[7,8,9]] #location of each tile in the puzzle
        low=0
        high=0
        for i in lst:  # for each row
            if location in i: #if the empty tile is on the row
                low=i[0]      #the left boundary
                high=i[2]     #the right boundary
        
        return [low,high]     #return the left and right boundary of the row
      
      
    #successor function
    def successor(self,node=[],search='sahc'): #node is [] by default
        subNode=[]
        p = []
        c = []
        
        getZeroLocation=node.index('0') + 1 #get the location of the empty tile
        subNode.extend(node[0:-1])  #to join node list to the subNode
        boundary=self.boundaries(getZeroLocation)
        p.extend(node)
        
        
        #best first or steepest ascent?
        if search == 'sahc':
            self.Fringe=[]  #without this line turns the search to best first search
        
        #now generate the successor states
        if getZeroLocation + 3 <= 9: #if the empty tile is at the top 2 rows
            #move the empty tile DOWN
            c = []
            temp=subNode[node.index('0')]
            #swap the location of 2 tiles 
            subNode[node.index('0')]=subNode[node.index('0')+3]
            subNode[node.index('0')+3]=temp
            c.extend(self.heuristic(subNode))
            self.Fringe.append(c)
            subNode=[]
            subNode.extend(node[0:-1])
            cp = (c,p)
            if(cp not in self.Parent):
                self.Parent.append(cp)
            #print "child-parent-pair: ", cp 
            
        if getZeroLocation-3>=1: #if the empty tile is at the bottom 2 rows
            #move the empty tile UP
            c = []
            temp=subNode[node.index('0')]
            #swap the location of 2 tiles
            subNode[node.index('0')]=subNode[node.index('0')-3]
            subNode[node.index('0')-3]=temp
            c.extend(self.heuristic(subNode))
            self.Fringe.append(c)
            subNode=[]
            subNode.extend(node[0:-1])
            cp = (c,p)
            if(cp not in self.Parent):
                self.Parent.append(cp)
            #print "child-parent-pair: ", cp 
            
        if getZeroLocation-1>=boundary[0]:  #if the empty tile is on the last 2 columns
            #move the empty tile LEFT
            c = []
            temp=subNode[node.index('0')]
            #swap the location of 2 tiles
            subNode[node.index('0')]=subNode[node.index('0')-1]
            subNode[node.index('0')-1]=temp
            c.extend(self.heuristic(subNode))
            self.Fringe.append(c)
            subNode=[]
            subNode.extend(node[0:-1])
            cp = (c,p)
            if(cp not in self.Parent):
                self.Parent.append(cp)
            #print "child-parent-pair: ", cp 
            
        if getZeroLocation+1<=boundary[1]: #if the empty tile is on the first 2 columns
            #move the empty tile RIGHT
            c = []
            temp=subNode[node.index('0')]
            subNode[node.index('0')]=subNode[node.index('0')+1]
            subNode[node.index('0')+1]=temp
            c.extend(self.heuristic(subNode))
            self.Fringe.append(c)
            subNode=[]
            subNode.extend(node[0:-1])
            cp = (c,p)
            if(cp not in self.Parent):
                self.Parent.append(cp)
            #print "child-parent-pair: ", cp 
            
        
        
    #heuristic function  
    def heuristic(self,node):
        misplacedTile=0
        
        for i in range(9):   #check all 9 tiles (including the '0')
            if node[i]!=self.GoalNode[i]:   #compare the tile on Current Node and Goal Node
                misplacedTile +=1  #if the tile is misplaced, add one; else remained
             
        node.append(misplacedTile) #append the heuristic cost to the last place of node
        return node

##----------------------------------------------------------------------------- 
##Steepest-ascent hill climbing
##----------------------------------------------------------------------------- 
    def steepestAscentHillClimbing(self):
        print ("STEEPEST ASCENT HILL CLIMBING\n" + "_"*60 + "\n")
        level = 0
        currentNode = self.heuristic(self.StartNode) #make the initial state as current state
        goalNode = self.heuristic(self.GoalNode) #append goal node heuristic cost

        if currentNode != goalNode:
            print ("\n---------", "\nLEVEL ", level, "\n---------")
            self.successor(currentNode)
            level += 1
  
        print ("\tCURRENT NODE: ", currentNode)
        print ("\tOPEN LIST: ", self.Fringe)

        nxNode=self.SAHC(currentNode[-1]) #pass the current heuristic cost
 
        while nxNode !=[] and currentNode!= goalNode and currentNode != nxNode:
            print ("\n---------", "\nLEVEL ", level, "\n---------")
            currentNode = nxNode
            self.successor(currentNode)       # to generate next successor states
            nxNode=self.SAHC(currentNode[-1])          #search next best node
            print ("\tCURRENT NODE: ", currentNode)
            print ("\tOPEN LIST: ", self.Fringe)
            level += 1
        
        print ("\n", "-"*60)
        print ("Initial State: ", self.StartNode)
        print ("Goal State: ", self.GoalNode)

        if nxNode != []:
            print ("\nGoal Path (the best path)")
            print ("-"*60)
            self.printSolution()
        else:
            print ("LOCAL MAXIMUM: There is no solution")
        
        



    def SAHC(self, hrCost):

        nxNode=[]   #next node
        isBetter = False
        
        while True:      

            for i in self.Fringe:  #for each open node in the fringe list

                if(i[-1]<hrCost):  #if the cost is better than the previous node

                    hrCost=i[-1]   #update
                    nxNode=i #set the best node
                    isBetter = True
                
            #if the nxNode is already in the PreviousNode list

            if nxNode in self.PreviousNode and nxNode in self.Fringe:
                self.Fringe.remove(nxNode) #remove the temporary node
            #else if it is not in the PreviousNode list
            elif nxNode!=[]:

                print ("selected: ", nxNode)
                self.PreviousNode.append(nxNode)
                return nxNode  #return the next node
            else:
                if isBetter == False:
                    print ("there is no better move")
                return nxNode
        
        
##-----------------------------------------------------------------------------               
##best first search
##----------------------------------------------------------------------------- 
    def bestFirstSolve(self):
        
        print ("GREEDY BEST FIRST SEARCH\n" + "_"*60 +"\n")
        count = 0
        currentNode = self.heuristic(self.StartNode)
        goalNode = self.heuristic(self.GoalNode)
        self.successor(currentNode,'bfs')   # to generate next successor states
        print ("\n---------", "\nSTEP: ", count, "\n---------")
        print ("\tCurrent Node: ", currentNode)
        print ("\tOpen List: ", self.Fringe) # to display open nodes
        
        nxNode=self.bestFirstSearch()
        count=1                         #count the number of steps
        
        while nxNode!=[] and nxNode!=goalNode and nxNode!=currentNode:    #Goal test
            currentNode = nxNode
            print ("\n---------", "\nSTEP: ", count, "\n---------")
            print ("\tCurrent Node: ", currentNode)
            print ("\tOpen List: ", self.Fringe) # to display open nodes
            self.successor(nxNode,'bfs')       # to generate next successor states
            nxNode=self.bestFirstSearch() #search next best node
            count+=1                    #go to next step
       
        print ("Final Goal: ", nxNode, "\n")    #print the final goal
        print ("-"*60, "\nHow the nodes are expanded\n", "-"*60)
        self.printSolutionSteps()
       
        
        print ("\n", "-"*60)
        
        print ("Initial State: ", self.StartNode)
        print ("Goal State: ", self.GoalNode)
        print ("\nGoal Path (the best path)")
        print ("-"*60)
        self.printSolution()


    #best first seach will select the lowest heuristic cost 
    #from the fringe nodes
    def bestFirstSearch(self):
        nxNode=[]   #next node
        while True:
            hrCost=100000   #default value of heuristic cost
            
            for i in self.Fringe:  #for each open node in the fringe list
                    if(i[-1]<hrCost):  #the heuristic cost is the last member
                        hrCost=i[-1]   #update heuristic cost
                        nxNode=i        #set the best node to temporary node
            
            #if the temporary node is already in the PreviousNode list
            if nxNode in self.PreviousNode and nxNode in self.Fringe:
                self.Fringe.remove(nxNode) #remove the temporary node from the open list

            #else if it is not in the PreviousNode list  
            else:
                self.PreviousNode.append(nxNode) #add the temporary node to PreviousNode list
                return nxNode  #return the next node
        
 


##functions to display output
    #to show how to yield the solution by observing the expanded nodes
    def printSolutionSteps(self):
        count = 1
        for i in self.PreviousNode:
            print ("step ", count, i[0:-1], "(", i[-1], ")")
            count += 1
        
    #to show the final path
    def printSolution(self):
        count = 0
        goal = self.GoalNode
        self.Parent.reverse() #reverse the Parent list
        pathList = [goal]
        
        for i in self.Parent:  
            child, parent = i #unpack the child-parent pair
            if(child == goal):#if the first node is the goal node
                goal = parent #get its parent and set it as new goal
                pathList.append(goal) #append the node to the path
            if parent == self.StartNode: #stop when reach the startNode
                break
                
        pathList.reverse() #reverse the path list to begin from the startNode
        for node in pathList:
            print ("LEVEL ", count, ": ", node[0:-1], "(", node[-1], ")")
            count += 1

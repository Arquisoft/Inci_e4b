# language: en
Feature: Agent login

Scenario: An agent logs into the system
Given a registered agent with name "paco@hotmail.com" and password "123456"
When the username "paco@hotmail.com" and  password "123456" are correct 
Then the agent can create an incidence in the url "http://localhost:8080/incidence/add"

# Listie User Guide

![Ui](Ui.png)

Ever wanted a to-do list in the form of a chatbot?

Maybe even one that lets you track items in the form of deadline and events?

Listie is here to solve your oddly specific problem!

## Quick Start
1. Check that java 17 is installed
2. Create an empty folder and install Listie.jar into it
3. Using `java -jar Listie.jar`, you run the application!

## Feature list
- todo: adds a todo item with description
- deadline: adds a deadline item with description and due date
- event: adds a event item with description and start date and end date
- list: returns a list of your items so far
- mark: marks an item in your list (we start counting from 1)
- unmark: unmarks an item in your list
- delete: deletes an item in your list
- find: returns a list of items with descriptions that contain a substring in them
- bye: exits the chatbot


- updateDesc: changes the description of an item in your list
- updateBy: changes the due date of an item (that is assumed to be a deadline item) in your list
- updateFrom: changes the start date of an item (that is assumed to be a event item) in your list
- updateTo: changes the end date of an item (that is assumed to be a event item) in your list

## Command guide

### Getting help: `help`
- Lists all supported commands in samples that illustrate how their formatting is done
- Format: `help`
- Example: `help`

### Getting all your tasks: `list`
- List all the tasks that you have
- Format: `list`
- Example: `list`

### Add todo: `todo`
- Adds a todo item with only a description
- Format: `todo <description>`
- Example: `todo read book` adds a todo item with description 'read book'

### Add deadline: `deadline`
- Adds a deadline item with a description and due date
- Format: `deadline <description> /by <Date>`
- Date format is `yyyy-mm-dd`
- Example: `deadline return book /by 2025-10-15` adds a deadline item 
with description 'return book' and due date on 15 Oct 2025


### Add event: `event`
- Adds an event item with a description, start date and end date
- Format: `event <description> /from <Date> /to <Date>`
- Date format is `yyyy-mm-dd`
- Example: `event project meeting /from 2025-10-15 /to 2025-10-16`
adds a event item with description 'project meeting' 
and start date 15 Oct 2025 and end date 16 Oct 2025

### Mark as done: `mark`
- Marks a task by index as done (we start counting from 1)
- Format: `mark <index>`
- Example: `mark 1` marks the first item in your list

### Unmark as not done: `unmark`
- Marks a task by index as done (we start counting from 1)
- Format: `unmark <index>`
- Example: `unmark 1` unmarks the first item in your list

### Delete task: `delete`
- Removes a task by index from the list (we start counting from 1)
- Format: `delete <index>`
- Example: `delete 5` deletes the fifth item in your list

### Find tasks with searched word: `find`
- Lists tasks that contain the searched word in their description
- Format: `find <keyword>`
- Example: `find book` returns a list of items with descriptions that contain 'book' in them

### bye to save and exit: `bye`
- Saves your tasks and exits
- Format: `bye`
- Example: `bye`

## FAQ
### Q: How can I transfer my date across devices?
### A: You just need to navigate to the folder that Listie is in, and copy over the
Listie.txt file to the same location when setting up

## Quick TL;DR

Before you start, remember to create an empty folder and put Listie inside!

You could ask Listie directly with `help`, but here are sample commands that work for ease of access:
Do note that formatting must be followed as below and commands are case-sensitive.
Dates for example are in the format yyyy-mm-dd.

- todo read book: adds a todo item with description 'read book'
- deadline return book /by 2025-10-15: adds a deadline item with description 'return book' and due date on 15 Oct 2025
- event project meeting /from 2025-10-15 /to 2025-10-16: adds a event item with description 'project meeting' and start date 15 Oct 2025 and end date 16 Oct 2025
- list: returns a list of your items so far
- mark 1: marks the first item in your list (we start counting from 1)
- unmark 2: unmarks the second item in your list
- delete 5: deletes the fifth item in your list
- find book: returns a list of items with descriptions that contain 'book' in them
- bye: exits the chatbot


- updateDesc 1 write summary: changes the description of the first item in your list to 'write summary'
- updateBy 1 2025-10-14: changes the due date of the first item (that is assumed to be a deadline item) to 14 Oct 2025
- updateFrom 1 2025-10-14: changes the start date of the first item (that is assumed to be a event item) to 14 Oct 2025
- updateTo 1 2025-10-14: changes the end date of the first item (that is assumed to be a event item) to 14 Oct 2025
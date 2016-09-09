# Palavr
Generates dummy logging output over SLF4J

[![Build Status](https://travis-ci.org/error418/palavr.svg?branch=master)](https://travis-ci.org/error418/palavr)

## Intention

This library suits you in case you need a way to generate meaningless log entries for testing purposes on runtime.

## Usage

Following snippet is a small example (in this case with Threads using the `PalavrRunnable` class)

```java
PalavrMessages messages = new DefaultPalavrMessages();

Thread t1 = new Thread(new PalavrRunnable("t1", messages, 1500));
Thread t2 = new Thread(new PalavrRunnable("t2", messages, 4100));
Thread t3 = new Thread(new PalavrRunnable("t3", messages, 7218));

t1.start();
t2.start();
t3.start();
```

### slf4j

Palavr utilizes [slf4j](http://www.slf4j.org/) for its logging. This enables you to use any slf4j-wrapped log implementation.

### Example log output

(In this case the `slf4j-simple` wrapper is used)

```
[Thread-1] INFO t1 - sending street
[Thread-2] INFO t1 - opening channel to office
[Thread-0] INFO t1 - cooling down forest
[Thread-0] ERROR t1 - searching for cupboard in cabinet
[Thread-0] INFO t1 - extracting the sea from forest
[Thread-2] ERROR t1 - working on the janitor
[Thread-1] INFO t1 - extracting street from log
[Thread-0] ERROR t1 - opening channel to script
[Thread-0] INFO t1 - working on wall
[Thread-0] INFO t1 - working on street
[Thread-0] ERROR t1 - cooling down car
[Thread-0] INFO t1 - searching for computer in window
[Thread-0] INFO t1 - linking pirate to desert
[Thread-0] INFO t1 - sending desert
[Thread-0] WARN t1 - searching for desert in script
[Thread-0] INFO t1 - opening channel to company
[Thread-0] INFO t1 - cooling down cabinet
[Thread-1] WARN t1 - sending pirate
[Thread-2] INFO t1 - extracting the janitor from ship
[Thread-1] INFO t1 - searching for ship in bus
[Thread-0] INFO t1 - searching for forest in window
```

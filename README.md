# Palavr
Generates dummy logging output over SLF4J

## Intention

This library suits you in case you need a way to generate meaningless log entries for testing purposes.

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
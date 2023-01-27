# Concurrency Challenge

## Exercise 3 - Getting Blocked, Dump it!

This is a simple class (totally stolen from [Heinz Kabutz](https://www.javaspecialists.eu/archive/Issue147.html)) causing a race condition.

Your task is to run this project, use a dump tool and analyse the outcome.

If you are using IntelliJ, you can use the built-in Profiler to achieve this.

Some other options below (useful for example if connecting to remote servers etc):

In your JDK you'll find jstack. Run the program, find the PID and execute the `jstack` command on that PID

    > ps -ef | grep concurrency.Blocking
    > jstack {pid.from.above}

To this point, it is mandatory for this exercise. You HAVE to understand the output! Check each and every thread and make sure you know what it is doing before you jump to next thread. And yes, [Heinz' chapter about the blocking](https://www.javaspecialists.eu/archive/Issue147.html) is old but still very valid. 

Everything below is a bonus. Way more interesting ways to check our processes so please try them.

Can we get the same information from the JDK tool `jconsole`?

[Arthas](https://github.com/alibaba/arthas) is a tool made by Alibaba. It will give as a "graphical" diagnosis in a console. By not running with a GUI it is very handy in server environments. Try it!



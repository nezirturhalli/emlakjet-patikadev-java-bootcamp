
#  Java 11 New Features
Java is one of the most popular including in programming languages in the world. Java has enhanced since its introduction in 1995. It takes a slightly longer work to keep up with the latest versions frequent social media release cycle in recent years.
We'll begin by discussing the changes in Java 11.
Let's get started.



![image](https://user-images.githubusercontent.com/32534565/170483483-19bede1f-8c33-4239-b01b-61945b01e757.png)

## Overview of New Features
## 1- HTTP API
 - The HTTP API is a Java package that allows you to make HTTP queries.
### purpose
HttpURLConnection, which was introduced with Java 1.1 in 1997 and is difficult to use and maintain, has been replaced.
### features
- HTTP/1.1 and HTTP/2 protocols are supported.
- Common HTTP methods such as GET, POST, PUT, and DELETE are supported.
- Can communicate in both synchronous and asynchronous modes
- ways to make advantage of
- HttpClient is created, initialized, and configured.
- Initiate and create HttpRequest
- HttpRequest is passed to HttpClient, which executes the request and returns HttpResponse.
- Handle HttpResponse according to your needs.
## 2- Launching Single-File Java Program
- Java 11 allows you to run a single Java program from a single command.
### details
- Allows for novice-friendly Java development and rapid prototyping.
- It must be a single-file application (with one or more classes).
- External dependencies aren't an option.
### how to use
- Let's say our file is called MyProgram.java, and all we have to do to run it is type java MyProgram.java.
## 3- New Library Methods for Strings, Collections and Files
- For the sake of convenience, Java 11 provided some handy methods for the aforementioned libraries.

### strings api
- Repeat a string: Repeat a string n times with String.repeat(Integer). Example: " ".repeat(10)
- Check empty/whitespace: Check if string is empty or whitespace only. String.isBlank(). It’ll throw NullPointerExceptionif the string is blank.
- Remove whitespaces: Remove leading String.stripLeading(), trailing String.stripTrailing() or both whitespaces String.strip()
- Process multiline string: Convert multiline /n string to stream of lines with String.lines()
### collections api
Convert collection to an array: This process made easier with Java 11. For example, converting a list of students to string array would be performed with students.toArray(String[]::new)
### Optional and predicate.
Negating a predicate : We can filter out the elements not having a certain condition with Predicate.not(myCustomPredicate).
### files api
Easier file read/write: Thanks to Files.readString(path) and Files.writeString(path, charSequence, options) we can achieve this operations.
## 4- Performance and Security Improvements
### performance Improvements
- G1 Garbage Collector Improvements: G1 was introduced in Java 7 and became the default GC in Java 9. With Java 11, G1 is improved for high performance. Java 11 improves pause times (client waiting for application response caused by GC) by up to 60% (source).
- ZGC: An experimental but scalable and low-latency GC. It guarantees maximum pause time of 10 ms. ZGC is great for applications memory consuming applications that handle a lot of data.
- Epsilon: An experimental but low-overhead GC. It’s a good fit for short living applications (executing a single command then closing).
security Improvements
- The recent Transport Layer Security (TLS) improved HTTPS performance and security. Java 11 supports the TLS 1.3 protocol.
## 5- Other Enhancements
- Using var in lambdas: We've met var with Java 10, now we can use it in lambdas. Advantage of this feature is now we can annotate lambda variables (eg. @NotNull)
- Adoption of Unicode 10: Java 11 uses Unicode 10, an upgrade from Java 10 with Unicode 8. That includes 16,018 new characters and 10 new scripts.
- Nested access control: Inner class can access all private variables and methods of Outer class (eg. Outer.name).
- Java Flight Recorder: JFR is a profiling and diagnostics (resource usage etc.) tool. We can also use Java Mission Control to visualize data provided by JFR.
## 6- Removed and Deprecated Features
### removed features
- Java 11 is backwards compatible with Java 8. So you can swiftly change from Java 8 to 11. If you use some of the packages below, all you need to do is add the replacement dependency to your project.
### deprecated features
- Nashorn JavaScript Engine: Since it’s hard to maintain compatibility with rapid changing of ECMAScript, it’s now deprecated.


#  Java 17 New Features
On September 13th, 2021, Oracle published their latest Long Term Support (LTS) release of java: Release 17. Oracle also released new licensing terms and conditions with this new edition, dubbed "Oracle — No Fee Terms and Conditions (NFTC)."

Java 17 is a long-term support version. Java 8 and Java 11 are two other LTS JDKs. Non-LTS JDKs are released every six months, while LTS JDKs are released every three years. In comparison, LTS versions have long-term support, but non-LTS JDKs have a six-month support period that ends when the next non-LTS is published.

Despite the fact that Java 17 is a long-term support version, there are no major changes. For any Java developer, JEP 406 and JEP 409 are extremely useful and important.
## JEP 406 : Pattern Matching for Switch (Preview)
- Expand the expressiveness and applicability of switch expressions by allowing patterns to appear in case labels.
- Allow the historical null-hostility of switch to be relaxed when desired.
- Introduced two new patterns : guarded and parenthesized patterns.
Before Java 17 :


![image](https://user-images.githubusercontent.com/32534565/170488928-c39cfa50-f3a3-40db-b5d1-2d34568d755f.png)


Now after Java 17 enhancements, we can refactor the above code like this :

![image](https://user-images.githubusercontent.com/32534565/170489002-2c1747c2-85b4-45b5-8ae7-97973b20ed8c.png)


Guarded Pattern : Uses pattern && boolean expression for further refinement of the pattern.


![image](https://user-images.githubusercontent.com/32534565/170489053-6b361531-c095-47e8-bdd0-9bd0fba732e6.png)


## JEP 409 : Sealed Classes
Enhance the java programming with sealed classes and interfaces. Sealed classes and interfaces restrict which other classes or interfaces may extend or implement them.

- Uses sealed modifier in declaration and the permits clause to specify classes that are allowed to extend sealed class.

![image](https://user-images.githubusercontent.com/32534565/170489264-46a6439f-9f1c-47d3-a617-bb6c01e9b9eb.png)

- The sub-class must be final, seal or non-sealed.
## JEP 306 : Restore Always-Strict Floating Point Semantics
Make floating-point operations consistently strict

## JEP 356 : Enhanced Pseudo-Random Number Generators
Provide new interface types and implementations for pseudo-random number generators(PRNGs) to make it easier to use various PRNG algorithms and to better support stream-based operations.

## JEP 403 : Strongly Encapsulate JDK Internals
Strongly encapsulate all non-critical internal elements of the JDK.

## JEP 412 : Foreign Function & Memory API (Incubator)
Introduce an API by which java programmers can interoperate with code and data outside of the java runtime.

## JEP 414 : Vector API (Second Incubator)
Introduce an API to express vector computations that reliably compile at runtime to optimal vector instructions.

## JEP 415 : Context-Specific Deserialization Filters
Allow applications to configure context-specific and dynamically-selected de-serialization filters.

## JEP 382 : New macOS Rendering Pipeline
Changed java 2D macOS rendering pipeline (which is used in Swing for example) for macOS to use the Apple Metal API instead of the deprecated Apple OpenGL API.

## JEP 398 : Deprecate the Applet API for Removal
Applet API will be removed. It was deprecated since JDK 9. Most browsers don’t support it anymore.

## JEP 407 : Remove RMI Activation
Although RMI is still used, RMI activation mechanism is obsolete with the web technology of the latest decade.

## JEP 410 : Remove the Experimental AOT and JIT Compiler
Remove the experimental java-based ahead-of-time (AOT) and just-in-time (JIT) compiler.
------------------------------------------------------
#Java 18 Features:
- UTF-8 by Default
- Simple Web Server
- Code Snippets in Java API Doc
- Reimplement Core Reflection with Method Handles
- Vector API
- Internet-Address Resolution SPI
- Foreign Function & Memory API
- Pattern Matching for switch

#Java 17 Features (Long Term Support) :
- Restore Always-Strict Floating-Point Semantics
- Enhanced Pseudo-Random Number Generators
- New macOS Rendering Pipeline
- macOS/AArch64 Port
- Deprecate the Applet API for Removal
- Strongly Encapsulate JDK Internals
- Pattern Matching for switch

#Java 16 Features:
- Vector API
- Enable C++14 Language Features
- Migrate from Mercurial to Git
- Migrate to GitHub
- Concurrent Thread-Stack Processing
- Unix-Domain Socket Channels
- Alpine Linux Port
- Elastic Metaspace
- Windows/AArch64 Port

#Java 15 Features
- Sealed Classes and Interfaces
- EdDSA Algorithm
- Hidden Classes
- Pattern Matching for instanceof
- Removed Nashorn JavaScript Engine
- Reimplement the Legacy DatagramSocket API
- Records (Second Preview)
- Text Blocks become a standard feature

#Java 14 Features
– Pattern Matching for instanceof
– Text Blocks
– Helpful NullPointerExceptions
– Records
– Switch Expressions
– Packaging Tool
– NUMA-Aware Memory Allocation for G1
– JFR Event Streaming
– Non-Volatile Mapped Byte Buffers
– Remove the Pack200 Tools and API

#Java 13 Features:
– Text Blocks (Preview)
– Switch Expressions Enhancements (Preview)
– Reimplement the Legacy Socket API
– Dynamic CDS Archive
– ZGC: Uncommit Unused Memory
– FileSystems.newFileSystem() Method
– DOM and SAX Factories with Namespace Support

#Java 12 Features:
- Collectors.teeing() in Stream API
- String API Changes
- Files.mismatch(Path, Path)
- Compact Number Formatting
- Support for Unicode 11
- Switch Expressions (Preview)

#Java 11 Features (Long Term Support):
- HTTP Client API
- Launch Single-File Programs Without Compilation
- String API Changes
- Collection.toArray(IntFunction)
- Files.readString() and Files.writeString()
- Optional.isEmpty()

#Java 10 Features:
- Local Variable Type Inference
- Time-Based Release Versioning
- Garbage-Collector Interface
- Parallel Full GC for G1
- Heap Allocation on Alternative Memory Devices
- Consolidate the JDK Forest into a Single Repository

#Java 9 Features:
- Java platform module system
- Interface Private Methods
- HTTP 2 Client
- JShell
- Platform and JVM Logging
- Process API Updates
- Collection API Updates
- Improvements in Stream API
- Multi-release JAR Files
- @Deprecated Tag Changes
- Stack Walking

#Java 8 Features (Long Term Support):
- Lambda expression
- Stream API
- Functional interface
- Default and static methods
- Optional class
- Nashorn – JavaScript runtime engine
- Unsigned Integer Arithmetic
- Repeating annotations
- New Date and Time API

## JEP 411 : Deprecate the Security Manager for Removal
Deprecate the Security Manager for removal in the future release. The Security Manager dates from java 1.0. It has not been the primary means of securing client-side of java code for many years.


# REFERENCES
- https://openjdk.java.net/projects/jdk/17/
- https://www.baeldung.com/java-11-new-features
- https://www.oracle.com/java/technologies/javase/11-relnote-issues.html
- https://medium.com/analytics-vidhya/java-11-in-a-nutshell-f3f452bf2951
- https://medium.com/geekculture/whats-new-in-java-17-1b4854fa9e9c

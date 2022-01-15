public class HelloWorld {
    public static void main(String[] args) {
        // System.out.println(90);
        Tools.say("Hello!");
        Tools.say("Hello again!", 7);
        String[] msgs;
        msgs = new String[3];
        msgs[0] = "Ma";
        msgs[1] = "Na";
        msgs[2] = "Jo";
        Tools.say(msgs);
    }
}

// When the semicolon is removed, the compiler returns the following error:
// HelloWorld.java:3: error: ';' expected

// When the class name is changed, the complier returns the following error:
// HelloWorld.java:1: error: class HelloWorldPrgm is public, should be declared in a file named HelloWorldPrgm.java

// When the openning bracket is removed, the complier returns the following errors:
// HelloWorld.java:1: error: '{' expected
// public class HelloWorld 
// ^
// HelloWorld.java:2: error: class, interface, enum, or record expected
// public static void main(String[] args) {
// ^

// When the closing quote is removed, the complier returns the following error:
// HelloWorld.java:3: error: unclosed string literal

// When an integer is printed, the complier does not return any errors